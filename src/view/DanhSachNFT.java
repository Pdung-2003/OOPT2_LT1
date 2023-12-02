package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class DanhSachNFT extends JPanel {

	/**
	 * Create the panel.
	 */
	public DanhSachNFT() {
		// Set Thong tin chung
		setBackground(Colors.TrangDuc);
		setBorder(new LineBorder(Colors.Trang, 20, true));
		setPreferredSize(new Dimension(1085, 730));
		setLayout(new BorderLayout(20, 0));

		// Khu vuc filter
		MyPanel panel_DS_Filter = new MyPanel();
		panel_DS_Filter.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		add(panel_DS_Filter, BorderLayout.NORTH);
		panel_DS_Filter.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

		// Chon nen tang muon xem danh sach
		MyLabelBold lbl_DS_Filter_NenTang = new MyLabelBold("Chọn nền tảng: ");
		lbl_DS_Filter_NenTang.setFont(new Font("Arial", Font.BOLD, 16));
		panel_DS_Filter.add(lbl_DS_Filter_NenTang);

		String[] items_DS_NenTang = {"Tên NFT", "Chủ bộ sưu tập", "Ngày tạo", "Giá"};
		MyComboBox comboBox_DS_Filter_NenTang = new MyComboBox(items_DS_NenTang);
		panel_DS_Filter.add(comboBox_DS_Filter_NenTang);

		// Chon cach sap xep du lieu in ra man hinh
		MyLabelBold lbl_DS_Filter_SapXep = new MyLabelBold("Sắp xếp theo: ");
		lbl_DS_Filter_SapXep.setFont(new Font("Arial", Font.BOLD, 16));
		panel_DS_Filter.add(lbl_DS_Filter_SapXep);

		String[] items_DS_SapXep = {"Tên NFT", "Chủ bộ sưu tập", "Ngày tạo", "Giá"};
		MyComboBox comboBox_DS_Filter_SapXep = new MyComboBox(items_DS_SapXep);
		panel_DS_Filter.add(comboBox_DS_Filter_SapXep);

		// Nut confirm duyet de in du lieu ra man hinh
		Button_Chung btn_DS_CF_Filter = new Button_Chung("Xem Danh Sách");
		panel_DS_Filter.add(btn_DS_CF_Filter);

		// Khu vuc chinh dung de in du lieu
		MyPanel panel_DS_Content = new MyPanel();
		add(panel_DS_Content, BorderLayout.CENTER);
		panel_DS_Content.setLayout(new BorderLayout(0, 0));

	}

}