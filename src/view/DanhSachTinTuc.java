package view;

import view.Buttons.Button_Chung;
import view.Panels.MyPanel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class DanhSachTinTuc extends TimKiemNFT {
	/**
	 * Create the panel.
	 */
	public DanhSachTinTuc() {
		setBackground(Colors.TrangDuc);
		setBorder(new LineBorder(Colors.Trang, 20, true));
		setPreferredSize(new Dimension(1085, 730));
		setLayout(new BorderLayout(20, 0));

		// Khu vực tìm kiếm
		String[] items_DSBL_TimKiem = {"Tên NFT", "Chủ bộ sưu tập", "Ngày tạo", "Giá"}; // Thêm phương pháp tìm kiếm vào đây
		String[] items_DSBL_Sapxep = {"Item1", "Item2;"}; // Thêm phương pháp sắp xếp vào đây
		TimKiem DSBL_TimKiem = new TimKiem(items_DSBL_TimKiem, items_DSBL_Sapxep);
		add(DSBL_TimKiem, BorderLayout.NORTH);

		// Khu vực điền bảng thông tin
		MyPanel panel_DSBL_Content = new MyPanel();
		add(panel_DSBL_Content, BorderLayout.CENTER);
		panel_DSBL_Content.setLayout(new BorderLayout(0, 0));
		panel_DSBL_Content.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

		// Tạo một bảng với một cột
		String[] columnNames = {"Tên NFT"}; // Tên cột
		String[][] data = {{"Dữ liệu 1"}, {"Dữ liệu 2"}, {"Dữ liệu 3"}}; // Dữ liệu cho cột

		JTable table = new JTable(data, columnNames);
		table.setRowHeight(40); // Tăng độ cao của các hàng
		table.setShowGrid(true); // Hiển thị sọc giữa các hàng
		table.setGridColor(Color.BLACK); // Màu sọc giữa các hàng
		JScrollPane scrollPane = new JScrollPane(table);

		table.setTableHeader(null);
		Font font = table.getFont().deriveFont(Font.PLAIN, 16); // Có thể thay đổi size và style theo mong muốn
		table.setFont(font);

		panel_DSBL_Content.add(scrollPane, BorderLayout.CENTER);

		// Khu vực dành cho button xem chi tiết
		MyPanel panel_DSBL_Content_Detail = new MyPanel();
		panel_DSBL_Content.add(panel_DSBL_Content_Detail, BorderLayout.EAST);
		panel_DSBL_Content_Detail.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));

		Button_Chung btn_DSBL_Content_Detail = new Button_Chung("Xem Chi Tiết");
		panel_DSBL_Content_Detail.add(btn_DSBL_Content_Detail);

		// Khu vực action của nút Xem chi tiết
		btn_DSBL_Content_Detail.addActionListener(e -> {
			// Hiển thị ra panel thông tin chi tiết blog
			BlogDetail Blog_Detail = new BlogDetail();
			Blog_Detail.setLocationRelativeTo(null);
			Blog_Detail.setVisible(true);
		});
	}

}
