
package co.edu.uniminuto.proyectomvc.models;

import java.util.Objects;



public class Cliente  extends Persona{
    

    private String telefono;



    public Cliente(String telefono, String nombre, String cedula, int edad) {
        super(nombre, cedula, edad);
        this.telefono = telefono;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    
    
    
    
}
