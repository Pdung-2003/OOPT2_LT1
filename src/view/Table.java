package view;

import javax.swing.table.DefaultTableModel;

public class Table {
    public static void clearTable(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        //tableModel.fireTableStructureChanged();
    }
}