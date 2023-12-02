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
		setBackground(Colors.TrangDuc);
		setBorder(new LineBorder(Colors.Trang, 20, true));
		setPreferredSize(new Dimension(1085, 730));
		setLayout(new BorderLayout(20, 0));

		JPanel panel_DS_Filter = new JPanel();
		panel_DS_Filter.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_DS_Filter.setBackground(Colors.Trang);
		add(panel_DS_Filter, BorderLayout.NORTH);
		panel_DS_Filter.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

		JLabel lbl_DS_Filter_NenTang = new JLabel("Chọn nền tảng: ");
		lbl_DS_Filter_NenTang.setFont(new Font("Arial", Font.BOLD, 16));
		panel_DS_Filter.add(lbl_DS_Filter_NenTang);

		JComboBox comboBox_DS_Filter_NenTang = new JComboBox();
		panel_DS_Filter.add(comboBox_DS_Filter_NenTang);

		// Chon cach sap xep du lieu in ra man hinh
		JLabel lbl_DS_Filter_SapXep = new JLabel("Sắp xếp theo: ");
		lbl_DS_Filter_SapXep.setFont(new Font("Arial", Font.BOLD, 16));
		panel_DS_Filter.add(lbl_DS_Filter_SapXep);

		JComboBox comboBox_DS_Filter_SapXep = new JComboBox();
		panel_DS_Filter.add(comboBox_DS_Filter_SapXep);

		// Nut confirm duyet de in du lieu ra man hinh
		JButton btn_DS_CF_Filter = new JButton("Xem Danh Sách");
		panel_DS_Filter.add(btn_DS_CF_Filter);

		// Khu vuc chinh dung de in du lieu
		JPanel panel_DS_Content = new JPanel();
		panel_DS_Content.setBackground(Colors.Trang);
		add(panel_DS_Content, BorderLayout.CENTER);
		panel_DS_Content.setLayout(new BorderLayout(0, 0));

	}

}