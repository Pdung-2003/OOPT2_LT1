package view;

import controller.NFTController;
import view.Buttons.Button_Chung;
import view.ComboBox.MyComboBox;
import view.Labels.MyLabelBold;
import view.Panels.MyPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class DanhSachNFT extends JPanel {
    private final DefaultTableModel tableModel;
    private final MyPanel panel_DSNFT_Content;
    private JTable table;
    private final JScrollPane scrollPane;
    private NFTController nftController;

    public DanhSachNFT() {
        this.nftController = new NFTController();
        setBackground(Colors.TrangDuc);
        setBorder(new LineBorder(Colors.Trang, 20, true));
        setPreferredSize(new Dimension(1085, 730));
        setLayout(new BorderLayout(20, 0));

        // Khu vực filter
        MyPanel panel_DSNFT_Filter = new MyPanel();
        panel_DSNFT_Filter.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        add(panel_DSNFT_Filter, BorderLayout.NORTH);
        panel_DSNFT_Filter.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

        // Chọn nền tảng muốn xem thông tin
        MyLabelBold lbl_DSNFT_Filter_NenTang = new MyLabelBold("Chọn nền tảng: ");
        lbl_DSNFT_Filter_NenTang.setFont(new Font("Arial", Font.BOLD, 16));
        panel_DSNFT_Filter.add(lbl_DSNFT_Filter_NenTang);

        String[] items_DSNFT_NenTang = {"Nifty Gateway", "Binance", "Opensea"};
        MyComboBox comboBox_DSNFT_Filter_NenTang = new MyComboBox(items_DSNFT_NenTang);
        panel_DSNFT_Filter.add(comboBox_DSNFT_Filter_NenTang);

        // Nút confirm duyệt dữ liệu để in ra màn hình
        Button_Chung btn_DSNFT_CF_Filter = new Button_Chung("Xem Danh Sách");
        panel_DSNFT_Filter.add(btn_DSNFT_CF_Filter);

        // Khu vực chính dùng để in dữ liệu
        panel_DSNFT_Content = new MyPanel();
        add(panel_DSNFT_Content, BorderLayout.CENTER);
        panel_DSNFT_Content.setLayout(new BorderLayout(0, 0));

        // Khu vực tìm kiếm
        String[] items_DSNFT_TimKiem = {"Tên NFT", "Chủ bộ sưu tập", "Ngày tạo", "Giá"}; // Thêm phương pháp tìm kiếm vào đây
        String[] items_DSNFT_SapXep = {"Tên NFT", "Chủ bộ sưu tập", "Ngày tạo", "Giá"}; // Thêm phương pháp sắp xếp vào đây
        TimKiem DSNFT_TimKiem = new TimKiem(items_DSNFT_TimKiem, items_DSNFT_SapXep);
        panel_DSNFT_Content.add(DSNFT_TimKiem, BorderLayout.NORTH);
        // Tạo bảng và scrollPane một lần
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        scrollPane = Table.getScrollPane(tableModel);

        // Thêm scrollPane vào panel_DSNFT_Content
        panel_DSNFT_Content.add(scrollPane, BorderLayout.CENTER);

        btn_DSNFT_CF_Filter.addActionListener(e -> {
            String selectedNenTang = (String) comboBox_DSNFT_Filter_NenTang.getSelectedItem();
            assert selectedNenTang != null;

            // Tạo bảng với các cột tương ứng cho từng sàn
            setTableColumns(selectedNenTang);

            // Lấy dữ liệu từ Controller và thêm vào bảng
			switch (selectedNenTang) {
				case "Nifty Gateway":
                    try {
                        nftController.addDataToTableNifty(table);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
					break;
                case "Binance":
                    try {
                        nftController.addDataToTableBinance(table);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "Opensea":
                    try {
                        nftController.addDataToTableOpensea(table);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
			}
        });
    }

    private void setTableColumns(String selectedNenTang) {
        clearTable();
        // Thêm các cột mới tùy thuộc vào giá trị được chọn
        switch (selectedNenTang) {
            case "Binance":
                tableModel.addColumn("Collection Title");
                tableModel.addColumn("Collection ID");
                tableModel.addColumn("Display Image");
                tableModel.addColumn("Number of Owners");
                tableModel.addColumn("Total Supply");
                tableModel.addColumn("Floor Price");
                tableModel.addColumn("Floor Price Rate");
                tableModel.addColumn("Total Volume");
                break;
            case "Nifty Gateway":
                tableModel.addColumn("Collection Title");
                tableModel.addColumn("Display Image");
                tableModel.addColumn("Average Sale Price");
                tableModel.addColumn("Total Number of Primary Sales");
                tableModel.addColumn("Total Volume");
                tableModel.addColumn("Nifty Type");
                tableModel.addColumn("Floor Price");
                break;
            case "Opensea":
                tableModel.addColumn("Title");
                tableModel.addColumn("Display Image");
                tableModel.addColumn("Discount");
                tableModel.addColumn("Number of Sales");
                tableModel.addColumn("Volume");
                tableModel.addColumn("Floor Price");
                break;
            default:
                System.out.println("Không xác định được nền tảng.");
        }
//        tableModel.fireTableStructureChanged();
    }

    public void clearTable() {
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        tableModel.fireTableStructureChanged();
    }
}