package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class Table {
    public static JScrollPane getScrollPane(DefaultTableModel tableModel) {
        JTable table = getjTable(tableModel);

        // Tạo renderer để đặt màu xen kẽ cho hàng
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row % 2 == 0) {
                    c.setBackground(new Color(0xE3E3DB)); // Màu vàng nhạt cho hàng chẵn
                } else {
                    c.setBackground(Color.WHITE); // Màu trắng cho hàng lẻ
                }
                return c;
            }
        };

        // Áp dụng renderer cho tất cả các cột và hàng
        table.setDefaultRenderer(Object.class, renderer);

        // Tạo scrollPane ngang và dọc cho bảng
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Đặt màu nền cho scrollPane
        scrollPane.setBackground(Color.LIGHT_GRAY);

        return scrollPane;
    }

    private static JTable getjTable(DefaultTableModel tableModel) {
        JTable table = new JTable(tableModel);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);

        // Đặt phông chữ và màu sắc cho header
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setBackground(Color.black);
        header.setForeground(Colors.Vang);

        table.setRowHeight(40);

        // Đặt phông chữ cho bảng
        Font tableFont = new Font("Arial", Font.PLAIN, 14);
        table.setFont(tableFont);
        return table;
    }
    public static void clearTable(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        tableModel.fireTableStructureChanged();
    }
}
