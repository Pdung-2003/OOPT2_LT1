package view.home;

import controller.NFTController;
import models.Binance;
import models.NiftyGateway;
import models.Opensea;
import view.definitions.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;
import java.util.Objects;

import static view.definitions.Table.clearTable;

public class DanhSachNFT extends JPanel implements SortListener, SearchListener {

    private final DefaultTableModel tableModel;
    private final MyComboBox comboBox_DSNFT_Filter_NenTang;
    private final JTable table;
    private final NFTController nftController;

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
        comboBox_DSNFT_Filter_NenTang = new MyComboBox(items_DSNFT_NenTang);
        panel_DSNFT_Filter.add(comboBox_DSNFT_Filter_NenTang);

        // Nút confirm duyệt dữ liệu để in ra màn hình
        Button_Chung btn_DSNFT_CF_Filter = new Button_Chung("Xem Danh Sách");
        panel_DSNFT_Filter.add(btn_DSNFT_CF_Filter);

        // Khu vực chính dùng để in dữ liệu
        MyPanel panel_DSNFT_Content = new MyPanel();
        add(panel_DSNFT_Content, BorderLayout.CENTER);
        panel_DSNFT_Content.setLayout(new BorderLayout(0, 0));

        // Khu vực tìm kiếm
        String[] items_DSNFT_TimKiem = {"Tên NFT", "Giá bán nhỏ hơn", "Số lượng giao dịch nhỏ hơn"}; // Thêm phương pháp tìm kiếm vào đây
        String[] items_DSNFT_SapXep = {"Tên NFT", "Volume", "Giá"}; // Thêm phương pháp sắp xếp vào đây
        TimKiem DSNFT_TimKiem = new TimKiem(items_DSNFT_TimKiem, items_DSNFT_SapXep);
        DSNFT_TimKiem.addSearchListener(this); // Lắng nghe sự kiện tìm kiếm từ TimKiem
        DSNFT_TimKiem.addSortListener(this); // Lắng nghe sự kiện sắp xếp từ TimKiem
        panel_DSNFT_Content.add(DSNFT_TimKiem, BorderLayout.NORTH);
        // Tạo bảng và scrollPane một lần
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
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

        // Thêm scrollPane vào panel_DSNFT_Content
        panel_DSNFT_Content.add(scrollPane, BorderLayout.CENTER);

        btn_DSNFT_CF_Filter.addActionListener(e -> {
            String selectedNenTang = (String) comboBox_DSNFT_Filter_NenTang.getSelectedItem();
            assert selectedNenTang != null;

            // Tạo bảng với các cột tương ứng cho từng sàn
            setTableColumns(selectedNenTang);

            // Lấy dữ liệu từ NFTController
            List<?> nftData = null;
            switch (selectedNenTang) {
                case "Nifty Gateway" -> {
                    try {
                        nftData = nftController.getNiftyGatewayData();
                        nftController.addDataToTableNifty(table, (List<NiftyGateway>) nftData);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                case "Binance" -> {
                    try {
                        nftData = nftController.getBinanceData();
                        nftController.addDataToTableBinance(table, (List<Binance>) nftData);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                case "Opensea" -> {
                    try {
                        nftData = nftController.getOpenseaData();
                        nftController.addDataToTableOpensea(table, (List<Opensea>) nftData);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    private void setTableColumns(String selectedNenTang) {
        clearTable(tableModel);
        // Thêm các cột mới tùy thuộc vào giá trị được chọn
        switch (selectedNenTang) {
            case "Binance" -> {
                tableModel.addColumn("Collection Title");
                tableModel.addColumn("Collection ID");
                tableModel.addColumn("Display Image");
                tableModel.addColumn("Number of Owners");
                tableModel.addColumn("Total Volume");
                tableModel.addColumn("Floor Price");
                tableModel.addColumn("Floor Price Rate");
                tableModel.addColumn("Total Supply");
            }
            case "Nifty Gateway" -> {
                tableModel.addColumn("Collection Title");
                tableModel.addColumn("Display Image");
                tableModel.addColumn("Average Sale Price");
                tableModel.addColumn("Total Number of Primary Sales");
                tableModel.addColumn("Total Volume");
                tableModel.addColumn("Floor Price");
                tableModel.addColumn("Nifty Type");
            }
            case "Opensea" -> {
                tableModel.addColumn("Title");
                tableModel.addColumn("Display Image");
                tableModel.addColumn("Discount");
                tableModel.addColumn("Number of Sales");
                tableModel.addColumn("Volume");
                tableModel.addColumn("Floor Price");
            }
            default -> System.out.println("Không xác định được nền tảng.");
        }
    }

    @Override
    public void searchPerformed(String selectedSearchMethod, String searchInput) {
        try {
            String selectedNenTang = (String) comboBox_DSNFT_Filter_NenTang.getSelectedItem(); // Lấy nền tảng đã chọn từ combobox

            List<?> searchData = null;
            switch (Objects.requireNonNull(selectedNenTang)) {
                case "Nifty Gateway" ->
                        searchData = nftController.searchNiftyGateway(selectedSearchMethod, searchInput);
                case "Binance" -> searchData = nftController.searchBinance(selectedSearchMethod, searchInput);
                case "Opensea" -> searchData = nftController.searchOpensea(selectedSearchMethod, searchInput);
                default -> System.out.println("Nền tảng không hợp lệ.");
            }

            // Hiển thị kết quả tìm kiếm trên bảng DanhSachNFT
            if (searchData != null) {
                switch (selectedNenTang) {
                    case "Nifty Gateway" -> nftController.addDataToTableNifty(table, (List<NiftyGateway>) searchData);
                    case "Binance" -> nftController.addDataToTableBinance(table, (List<Binance>) searchData);
                    case "Opensea" -> nftController.addDataToTableOpensea(table, (List<Opensea>) searchData);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void sortPerformed(String selectedSortMethod) {
        String selectedNenTang = (String) comboBox_DSNFT_Filter_NenTang.getSelectedItem(); // Lấy nền tảng đã chọn từ combobox
        switch (selectedSortMethod) {
            case "Tên NFT" -> nftController.sortTableByTitle(table);
            case "Volume" -> {if (selectedNenTang.equals("Opensea") )nftController.sortOpenseaByVolume(table);
            else nftController.sortTableByVolume(table);}
            case "Giá" -> {if (selectedNenTang.equals("Opensea") )nftController.sortOpenseaByPrice(table);
            else nftController.sortTableByPrice(table);}
        }
    }
}