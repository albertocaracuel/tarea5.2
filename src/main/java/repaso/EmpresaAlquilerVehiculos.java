/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author isaac
 */
public class EmpresaAlquilerVehiculos {
// Atributos de la empresa

    private String cif;
    private String nombre;
    private String paginaWeb;

    /* Atributos para controlar el total de clientes que tiene la empresa y array de almacenamiento para los objetos Cliente */
  
    private ArrayList<String> clientes;

    /* Atributos para controlar el total de vehiculos disponibles en 
 alquiler que tiene la empresa y array de almacenamiento para los objetos Vehiculo */
   
    private ArrayList<String> vehiculos;

    /* Atributos para controlar el histórico de alquileres: total de alquileres realizados y array de almacenamiento para los objetos VehiculoAlquilado */
    
    private ArrayList<String> alquileres;

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    

    

    public ArrayList<String> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<String>  clientes) {
        this.clientes = clientes;
    }

    

    

    public ArrayList<String> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<String> vehiculos) {
        this.vehiculos = vehiculos;
    }

   
    

    public ArrayList<String> getAlquileres() {
        return alquileres;
    }

// incluir métodos ‘get’,‘set’
    public void setAlquileres(ArrayList<String>alquileres) {
        this.alquileres = alquileres;
    }

    /* Constructor parametrizado donde se establece que el total de clientes será 50, igual que el total de vehiculos disponibles. El histórico de vehiculos puede contener hasta 100 elementos */
    EmpresaAlquilerVehiculos(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
// Incialmente no hay clientes creados en la empresa
        
        this.clientes = new  ArrayList<String> (); // apuntan a null
// Incialmente no hay vehiculos creados en la empresa
        
        this.vehiculos = new ArrayList<String> (); // apuntan a null
// Incialmente no hay histórico de alquileres en la empresa
       
        this.alquileres = new ArrayList<String>(); // apuntan a null
    }

    public void registrarCliente(Cliente nuevo) {
        this.clientes.add(Cliente nuevo);
        

    }
    

    public Integer buscarCliente(String nif) {

        for (int i = 0; i < this.totalClientes; i++) {

            if (!this.clientes.get(i).equals(nif)) {
            } else {
                return this.clientes.get(i);
            }
        }

        return null;
    }

    public void imprimirClientes() {
        System.out.println("NIF cliente\tNombre\n");

        for (int i = 0; i < this.totalClientes; i++) {
            System.out.println(clientes.get(i));
        }

    }

    public  void registrarVehiculo(Vehiculo nuevo ) {
        
        this.totalVehiculos++;
    }

    public Integer buscarVehiculo(String matricula) {

        for (int i = 0; i < this.totalVehiculos; i++) {

            if (this.vehiculos.get(i).equals(matricula)) {
                return this.vehiculos.get(i);
            }
        }

        return null;
    }

    public void imprimirVehiculos() {
        System.out.println("Matricula\tModelo\tColor\tImporte\tDisponible\n");

        // Uso de bucle foreach
        for (Integer v : vehiculos) {
            System.out.println(v);
        }
    }

    public boolean alquilarVehiculo(String matricula, String nif, int dias) {
        // busca el cliente a partir del nif 
        Cliente cliente = getCliente(nif);
        // busca el vehículo a partir de la matrícula
        Vehiculo vehiculo = getVehiculo(matricula);
        VehiculoAlquilado nuevo=new VehiculoAlquilado(cliente, vehiculo, LocalDate.now(), dias);
        if (cliente != null && vehiculo != null) {
            if (vehiculo.isDisponible()) {
                vehiculo.setDisponible(false);
               
                this.totalAlquileres++;
                return true; // El alquiler se realiza correctamente
            }
        }
        return false; // No se puede alquilar el vehiculo por el cliente
    }

    public void recibirVehiculo(String matricula) {

// busca el vehículo con la matrícula dada en el
// array vehiculos y modifica su disponibilidad
// para que se pueda alquilar de nuevo
        Integer vehiculo = buscarVehiculo(matricula);

        if (vehiculo != null) {
            vehiculo(true);
        }

    }

    private Cliente getCliente(String nif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Vehiculo getVehiculo(String matricula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "EmpresaAlquilerVehiculos{" + "cif=" + cif + ", nombre=" + nombre + ", paginaWeb=" + paginaWeb + ", totalClientes=" + totalClientes + ", clientes=" + clientes + ", totalVehiculos=" + totalVehiculos + ", vehiculos=" + vehiculos + ", totalAlquileres=" + totalAlquileres + ", alquileres=" + alquileres + '}';
    }

    private void vehiculo(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.cif);
        hash = 61 * hash + Objects.hashCode(this.nombre);
        hash = 61 * hash + Objects.hashCode(this.paginaWeb);
        hash = 61 * hash + this.totalClientes;
        hash = 61 * hash + Objects.hashCode(this.clientes);
        hash = 61 * hash + this.totalVehiculos;
        hash = 61 * hash + Objects.hashCode(this.vehiculos);
        hash = 61 * hash + this.totalAlquileres;
        hash = 61 * hash + Objects.hashCode(this.alquileres);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmpresaAlquilerVehiculos other = (EmpresaAlquilerVehiculos) obj;
        if (this.totalClientes != other.totalClientes) {
            return false;
        }
        if (this.totalVehiculos != other.totalVehiculos) {
            return false;
        }
        if (this.totalAlquileres != other.totalAlquileres) {
            return false;
        }
        if (!Objects.equals(this.cif, other.cif)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.paginaWeb, other.paginaWeb)) {
            return false;
        }
        if (!Objects.equals(this.clientes, other.clientes)) {
            return false;
        }
        if (!Objects.equals(this.vehiculos, other.vehiculos)) {
            return false;
        }
        if (!Objects.equals(this.alquileres, other.alquileres)) {
            return false;
        }
        return true;
    }
    
    
    

}
