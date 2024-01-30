
package co.edu.uniminuto.proyectomvc.models;

import java.util.Objects;



public class Cliente  extends Persona{
    
    private Long id;
    private String telefono;

    public Cliente(Long id, String telefono, String nombre, String cedula, int edad) {
        super(nombre, cedula, edad);
        this.id = id;
        this.telefono = telefono;
    }

    public Cliente(String telefono, String nombre, String cedula, int edad) {
        super(nombre, cedula, edad);
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    
    
    
    
}
