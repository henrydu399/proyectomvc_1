package co.edu.uniminuto.proyectomvc.utils;

import co.edu.uniminuto.proyectomvc.models.Cliente;
import java.util.List;
import javax.swing.JTable;

public class JTableUtils {

    public static String[][] convertClients(List<Cliente> list, int columnsSize) {
        String[][] out = new String[list.size()][columnsSize];

        int count = 0;
        for (Cliente s : list) {
            out[count][0] = String.valueOf(s.getId());
            out[count][1] = s.getCedula();
            out[count][2] = s.getNombre();
            out[count][3] = s.getTelefono();
            count++;
        }
        return out;

    }

    public static String selectDataJtable(JTable table) {
        String selectedData = "";
        int[] selectedRow = table.getSelectedRows();
        int[] selectedColumns = table.getSelectedColumns();
        for (int i = 0; i < selectedRow.length; i++) {
            for (int j = 0; j < selectedColumns.length; j++) {
                selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
            }
        }
        return selectedData;
    }

    public static String selectEmailDataJtable(JTable table) {
        String selectedData = "";
        int[] selectedRow = table.getSelectedRows();
        int[] selectedColumns = table.getSelectedColumns();
        for (int i = 0; i < selectedRow.length; i++) {
            selectedData = (String) table.getValueAt(selectedRow[i], 2);
        }
        return selectedData;
    }

    public static String selectIdDataJtable(JTable table) {
        String selectedData = "";
        int[] selectedRow = table.getSelectedRows();
        int[] selectedColumns = table.getSelectedColumns();
        for (int i = 0; i < selectedRow.length; i++) {
            selectedData = (String) table.getValueAt(selectedRow[i], 0);
        }
        return selectedData;
    }

}
