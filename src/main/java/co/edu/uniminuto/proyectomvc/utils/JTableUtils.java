package co.edu.uniminuto.proyectomvc.utils;

import co.edu.uniminuto.proyectomvc.models.Cliente;
import java.util.List;
import javax.swing.JTable;

public class JTableUtils {

    public static String[][] convertClients(List<Cliente> list, int columnsSize) {
        String[][] out = new String[list.size()][columnsSize];

        int count = 0;
        for (Cliente s : list) {
            out[count][0] = String.valueOf(s.getTelefono());
            out[count][1] = s.getCedula();
            out[count][2] = s.getNombre();
            out[count][3] = String.valueOf(s.getEdad());
            count++;
        }
        return out;

    }

  
    
        public static Cliente selectClienteDataJtable(JTable table) {
        int[] selectedRow = table.getSelectedRows();
        Cliente c = null;
        for (int i = 0; i < selectedRow.length; i++) {
            c = new Cliente(
                    (String) table.getValueAt(selectedRow[i],0), 
                    (String) table.getValueAt(selectedRow[i],2), 
                    (String) table.getValueAt(selectedRow[i],1),        
                    Integer.parseInt( (String)table.getValueAt(selectedRow[i],3)) );
            //selectedData = (String) table.getValueAt(selectedRow[i], 2);
        }
        return c;
    }

  

   

}
