

package co.edu.uniminuto.proyectomvc.models;

import java.util.Objects;

public class Empleado  extends Persona{
    
    private String email;

    public Empleado(String email, String nombre, String cedula, int edad) {
        super(nombre, cedula, edad);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Empleado{" + "email=" + email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.email);
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
        final Empleado other = (Empleado) obj;
        return Objects.equals(this.email, other.email);
    }
    
    
    
    
}
