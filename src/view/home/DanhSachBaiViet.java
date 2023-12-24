package view.home;

import controller.DanhSachBlogController;
import view.definitions.Colors;
import view.definitions.Button_Chung;
import view.definitions.MyPanel;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class DanhSachBaiViet extends JPanel implements SortListener, SearchListener {
    private final DefaultTableModel tableModelPost;
    private final JTable tablePost;
    private TimKiem DSBL_TimKiem;
    private List<String[]> data;
    private List<String[]> searchResult;
    private DanhSachBlogController controller;
    private String[] selectedRowData;
    public DanhSachBaiViet() throws Exception {
        controller = new DanhSachBlogController();
        setBackground(Colors.TrangDuc);
        setBorder(new LineBorder(Colors.Trang, 20, true));
        setPreferredSize(new Dimension(1085, 730));
        setLayout(new BorderLayout(20, 0));

        // Khu vực tìm kiếm
        String[] items_DSBL_TimKiem = {"Tác giả", "Hashtag"}; // Thêm phương pháp tìm kiếm vào đây
        String[] items_DSBL_Sapxep = {"Trending", "Tác giả", "Hashtag"}; // Thêm phương pháp sắp xếp vào đây
        DSBL_TimKiem = new TimKiem(items_DSBL_TimKiem, items_DSBL_Sapxep);
        add(DSBL_TimKiem, BorderLayout.NORTH);
        DSBL_TimKiem.addSearchListener(this);
        DSBL_TimKiem.addSortListener(this);

        // Khu vực điền bảng thông tin
        MyPanel panel_DSBL_Content = new MyPanel();
        add(panel_DSBL_Content, BorderLayout.CENTER);
        panel_DSBL_Content.setLayout(new BorderLayout(0, 0));
        panel_DSBL_Content.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        // Tạo một bảng với một cột
        tableModelPost = new DefaultTableModel();
        tablePost = new JTable(tableModelPost);
        tableModelPost.addColumn("Tác giả");
        tableModelPost.addColumn("Hashtag");
        JScrollPane scrollPane = new JScrollPane(tablePost);
        tablePost.setBackground(Color.WHITE);
        tablePost.setForeground(Color.BLACK);

        // Đặt phông chữ và màu sắc cho header
        JTableHeader header = tablePost.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setBackground(Color.black);
        header.setForeground(Colors.Vang);
        tablePost.setRowHeight(40);
        // Đặt phông chữ cho bảng
        Font tableFont = new Font("Arial", Font.PLAIN, 14);
        tablePost.setFont(tableFont);
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
        tablePost.setDefaultRenderer(Object.class, renderer);

        tablePost.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tablePost.getSelectedRow();
                if (selectedRow != -1) {
                    if (searchResult.isEmpty()) {
                        selectedRowData = data.get(selectedRow);
                    } else {
                        selectedRowData = searchResult.get(selectedRow);
                    }
                    System.out.println(Arrays.toString(selectedRowData));
                }
            }
        });

        panel_DSBL_Content.add(scrollPane, BorderLayout.CENTER);

        // Thêm dữ liệu từ danh sách vào bảng
        searchResult = new ArrayList<>();
        data = controller.twitterData();
        controller.addDataToTableTwitter(data, tablePost);

        // Khu vực dành cho button xem chi tiết
        MyPanel panel_DSBL_Content_Detail = new MyPanel();
        panel_DSBL_Content.add(panel_DSBL_Content_Detail, BorderLayout.EAST);
        panel_DSBL_Content_Detail.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));

        Button_Chung btn_DSBL_Content_Detail = new Button_Chung("Xem Chi Tiết");
        panel_DSBL_Content_Detail.add(btn_DSBL_Content_Detail);

        // Khu vực action của nút Xem chi tiết
        btn_DSBL_Content_Detail.addActionListener(e -> {
            // Hiển thị ra panel thông tin chi tiết blog
            BlogDetail blogDetail = new BlogDetail();
            blogDetail.setLocationRelativeTo(null);
            blogDetail.setVisible(true);
            blogDetail.updateBlogTwitter(Arrays.toString(selectedRowData),
                    controller.searchByAuthorHashtag(Arrays.toString(selectedRowData)).getImages(),
                    controller.searchByAuthorHashtag(Arrays.toString(selectedRowData)).getAuthor(),
                    controller.searchByAuthorHashtag(Arrays.toString(selectedRowData)).getDate(),
                    controller.searchByAuthorHashtag(Arrays.toString(selectedRowData)).getHashtag(),
                    controller.searchByAuthorHashtag(Arrays.toString(selectedRowData)).getContent());
        });
    }

    @Override
    public void searchPerformed(String selectedSearchMethod, String searchInput) {
        searchResult.clear();
        if (searchInput.isEmpty()) {
            searchResult = controller.twitterData();
        } else{
            for (String[] array : data) {
                String author = array[0];
                String hashtag = array[1];

                if (selectedSearchMethod.equalsIgnoreCase("Tác giả") && author != null && author.toLowerCase().contains(searchInput.toLowerCase())) {
                    searchResult.add(array);
                } else if (selectedSearchMethod.equalsIgnoreCase("Hashtag") && hashtag != null && hashtag.toLowerCase().contains(searchInput.toLowerCase())) {
                    searchResult.add(array);
                }
            }
        }
        tableModelPost.setRowCount(0);
        controller.addDataToTableNews(searchResult, tablePost);
    }
    @Override
    public void sortPerformed(String selectedSortMethod) {
        switch (selectedSortMethod) {
            case "Trending":
                if (searchResult.isEmpty()) {
                    data = controller.twitterData();
                } else {
                    data = new ArrayList<>(searchResult);
                }
                break;
            case "Tác giả":
                if (searchResult.isEmpty()) {
                    data = controller.twitterData();
                } else {
                    data = new ArrayList<>(searchResult);
                }
                data.sort((row1, row2) -> {
                    return row1[0].compareTo(row2[0]);
                });
                break;
            case "Hashtag":
                if (searchResult.isEmpty()) {
                    data = controller.twitterData();
                } else {
                    data = new ArrayList<>(searchResult);
                }
                data.sort((row1, row2) -> Objects.compare(
                        row1[1],
                        row2[1],
                        Comparator.nullsFirst(Comparator.naturalOrder())
                ));
                break;
        }
        // Cập nhật dữ liệu trong bảng
        tableModelPost.setRowCount(0);
        controller.addDataToTableNews(data, tablePost);
    }
}
