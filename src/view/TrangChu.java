package view;

import view.Buttons.Button_Chung;
import view.ComboBox.MyComboBox;
import view.Labels.MyLabelBold;
import view.Panels.MyPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TrangChu extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrangChu() {
		// Đặt thông tin chung
		setBackground(Colors.TrangDuc);
		setBorder(new LineBorder(Colors.Trang, 20, true));
		setPreferredSize(new Dimension(1085, 730));
		setLayout(new BorderLayout(20, 0));

		// Phần header
		MyPanel panel_TrangChu_Header = new MyPanel();
		add(panel_TrangChu_Header, BorderLayout.NORTH);
		panel_TrangChu_Header.setLayout(new GridLayout(2, 2, 0, 0));
		
		MyLabelBold lbl_TrangChu_Header_GiangVien = new MyLabelBold("Giảng viên hướng dẫn: TS.Trịnh Tuấn Đạt");
		lbl_TrangChu_Header_GiangVien.setPreferredSize(new Dimension(300, 40));
		lbl_TrangChu_Header_GiangVien.setHorizontalAlignment(SwingConstants.LEFT);
		panel_TrangChu_Header.add(lbl_TrangChu_Header_GiangVien);
		
		MyLabelBold lbl_TrangChu_Header_MaLop = new MyLabelBold("Mã lớp: 143578");
		lbl_TrangChu_Header_MaLop.setPreferredSize(new Dimension(300, 40));
		lbl_TrangChu_Header_MaLop.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_TrangChu_Header.add(lbl_TrangChu_Header_MaLop);
		
		MyLabelBold lbl_TrangChu_Header_Nhom = new MyLabelBold("Nhóm 21");
		lbl_TrangChu_Header_Nhom.setPreferredSize(new Dimension(300, 40));
		panel_TrangChu_Header.add(lbl_TrangChu_Header_Nhom);
		
		MyLabelBold lbl_TrangChu_Header_MaMonHoc = new MyLabelBold("Mã môn học: IT3103");
		lbl_TrangChu_Header_MaMonHoc.setPreferredSize(new Dimension(300, 40));
		lbl_TrangChu_Header_MaMonHoc.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_TrangChu_Header.add(lbl_TrangChu_Header_MaMonHoc);
		
		// Phần nội dung
		MyPanel panel_TrangChu_Content = new MyPanel();
		add(panel_TrangChu_Content, BorderLayout.CENTER);
		panel_TrangChu_Content.setLayout(new BorderLayout(0, 0));
		
		// Phần tên phần mềm
		MyPanel panel_TrangChu_Content_Title = new MyPanel();
		panel_TrangChu_Content.add(panel_TrangChu_Content_Title, BorderLayout.NORTH);
		panel_TrangChu_Content_Title.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));
		
		JLabel lbl_TrangChu_Content_Title = new JLabel("PHẦN MỀM THU THẬP TỔNG HỢP THÔNG TIN NFT");
		lbl_TrangChu_Content_Title.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_TrangChu_Content_Title.add(lbl_TrangChu_Content_Title);
		
		// Phần tiêu đề nội dung
		MyPanel panel_TC_Content_DanhSach = new MyPanel();
		panel_TrangChu_Content.add(panel_TC_Content_DanhSach, BorderLayout.CENTER);
		panel_TC_Content_DanhSach.setLayout(new BorderLayout(0, 0));
		
		MyLabelBold lbl_TC_Content_DanhSach_Title = new MyLabelBold("Thành viên nhóm:");

		lbl_TC_Content_DanhSach_Title.setPreferredSize(new Dimension(300, 40));
		panel_TC_Content_DanhSach.add(lbl_TC_Content_DanhSach_Title, BorderLayout.NORTH);
		
		// Danh sách thành viên
		JPanel panel_TC_Content_DanhSach_Grid = new JPanel();
		panel_TC_Content_DanhSach.add(panel_TC_Content_DanhSach_Grid, BorderLayout.CENTER);
		panel_TC_Content_DanhSach_Grid.setLayout(new GridLayout(2, 3, 0, 0));
		
		// Phần thông tin Mạnh
		JPanel panel_TC_Content_DanhSach_Manh = new JPanel();
		panel_TC_Content_DanhSach_Grid.add(panel_TC_Content_DanhSach_Manh);
		Profile PF_Manh = new Profile("haha","Vũ Đức Mạnh",202152+"");
		panel_TC_Content_DanhSach_Manh.add(PF_Manh);
		
		// Phần thông tin Nghĩa
		JPanel panel_TC_Content_DanhSach_Nghia = new JPanel();
		panel_TC_Content_DanhSach_Grid.add(panel_TC_Content_DanhSach_Nghia);
		Profile PF_Nghia = new Profile("haha","Trần Trung Nghĩa",202103+"");
		panel_TC_Content_DanhSach_Nghia.add(PF_Nghia);
		
		// Phần thông tin Hưng
		JPanel panel_TC_Content_DanhSach_Hung = new JPanel();
		panel_TC_Content_DanhSach_Grid.add(panel_TC_Content_DanhSach_Hung);
		Profile PF_Hung = new Profile("haha","Lê Phúc Hưng",202152+"");
		panel_TC_Content_DanhSach_Hung.add(PF_Hung);
		
		// Phần thông tin Khánh
		JPanel panel_TC_Content_DanhSach_Khanh = new JPanel();
		panel_TC_Content_DanhSach_Grid.add(panel_TC_Content_DanhSach_Khanh);
		Profile PF_Khanh = new Profile("haha","Đặng Trần Nam Khánh",202152+"");
		panel_TC_Content_DanhSach_Khanh.add(PF_Khanh);
		
		// Phần thông tin Dũng
		JPanel panel_TC_Content_DanhSach_Dung = new JPanel();
		panel_TC_Content_DanhSach_Grid.add(panel_TC_Content_DanhSach_Dung);
		Profile PF_Dung = new Profile("haha","Phạm Đức Dũng",202152+"");
		panel_TC_Content_DanhSach_Dung.add(PF_Dung);
		
		// Phần thông tin Thành
		JPanel panel_TC_Content_DanhSach_Thanh = new JPanel();
		panel_TC_Content_DanhSach_Grid.add(panel_TC_Content_DanhSach_Thanh);
		Profile PF_Thanh = new Profile("haha","Nguyễn Công Thành",202152+"");
		panel_TC_Content_DanhSach_Thanh.add(PF_Thanh);
		
		

	}

}