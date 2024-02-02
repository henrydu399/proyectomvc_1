/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniminuto.proyectomvc.utils;

import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author henry
 */
public class ViewUtil {
    
    public static void fullrepaint(javax.swing.JFrame frame ){
        frame.pack();
        frame.revalidate();
        frame.repaint();
    }
    
       public static void fullrepaint(javax.swing.JPanel panel ){
        panel.revalidate();
        panel.repaint();
    }
       
        public static void fullrepaint(javax.swing.JInternalFrame intealFrame ){
        intealFrame.revalidate();
        intealFrame.repaint();
    }
       
       
       
    public static  Font getTITLEPRINCIPAL(){
          return new Font("Mandali", 1, 18); // NOI18N
    }
    
      public static  Font getTITLESECUNDARIO(){
          return new Font("Mandali", 1, 16); // NOI18N
    }
      
       public static  Font getTEXTNORMAL(){
          return new Font("Mandali", 0, 14); // NOI18N
    }
    
}
