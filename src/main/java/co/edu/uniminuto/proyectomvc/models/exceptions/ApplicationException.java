/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniminuto.proyectomvc.models.exceptions;

/**
 *
 * @author henry
 */
public class ApplicationException  extends RuntimeException{
    
    public String msjUsuario;



    public ApplicationException(String msjUsuario, String message, Throwable cause) {
        super(message, cause);
        this.msjUsuario = msjUsuario;
    }
    
    
    
    
}
