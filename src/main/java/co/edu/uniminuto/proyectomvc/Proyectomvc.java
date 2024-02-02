/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.edu.uniminuto.proyectomvc;

import co.edu.uniminuto.proyectomvc.hilos.NotificacionHilo;
import co.edu.uniminuto.proyectomvc.models.PrincipalModel;


public class Proyectomvc {
    
    private static PrincipalModel p;
  

  
    
    
    
    
    public static void main(String[] args) {
         p = new PrincipalModel();
         p.start();
    }

 
}
