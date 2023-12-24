package view.home;

import view.definitions.Colors;
import view.definitions.MyLabelBold;
import view.definitions.MyPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Font;
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
		
		MyLabelBold lbl_TrangChu_Header_Nhom = new MyLabelBold("Nhóm 22");
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
		MyPanel panel_TC_Content_DanhSach_Grid = new MyPanel();
		panel_TC_Content_DanhSach.add(panel_TC_Content_DanhSach_Grid, BorderLayout.CENTER);
		panel_TC_Content_DanhSach_Grid.setLayout(new GridLayout(2, 3, 0, 0));
		
		// Phần thông tin Mạnh
		MyPanel panel_TC_Content_DanhSach_Manh = new MyPanel();
		panel_TC_Content_DanhSach_Grid.add(panel_TC_Content_DanhSach_Manh);
		Profile PF_Manh = new Profile("images/Manh.jpg","Vũ Đức Mạnh",20215282+"");
		panel_TC_Content_DanhSach_Manh.add(PF_Manh);
		
		// Phần thông tin Nghĩa
		MyPanel panel_TC_Content_DanhSach_Nghia = new MyPanel();
		panel_TC_Content_DanhSach_Grid.add(panel_TC_Content_DanhSach_Nghia);
		Profile PF_Nghia = new Profile("images/Nghia.jpg","Trần Trung Nghĩa",20213581+"");
		panel_TC_Content_DanhSach_Nghia.add(PF_Nghia);
		
		// Phần thông tin Hưng
		MyPanel panel_TC_Content_DanhSach_Hung = new MyPanel();
		panel_TC_Content_DanhSach_Grid.add(panel_TC_Content_DanhSach_Hung);
		Profile PF_Hung = new Profile("images/Hung.jpg","Lê Phúc Hưng",20215276+"");
		panel_TC_Content_DanhSach_Hung.add(PF_Hung);
		
		// Phần thông tin Khánh
		MyPanel panel_TC_Content_DanhSach_Khanh = new MyPanel();
		panel_TC_Content_DanhSach_Grid.add(panel_TC_Content_DanhSach_Khanh);
		Profile PF_Khanh = new Profile("images/Khanh.jpg","Đặng Trần Nam Khánh",20215278+"");
		panel_TC_Content_DanhSach_Khanh.add(PF_Khanh);
		
		// Phần thông tin Dũng
		MyPanel panel_TC_Content_DanhSach_Dung = new MyPanel();
		panel_TC_Content_DanhSach_Grid.add(panel_TC_Content_DanhSach_Dung);
		Profile PF_Dung = new Profile("images/Dung.jpg","Phạm Đức Dũng",20215265+"");
		panel_TC_Content_DanhSach_Dung.add(PF_Dung);
		
		// Phần thông tin Thành
		MyPanel panel_TC_Content_DanhSach_Thanh = new MyPanel();
		panel_TC_Content_DanhSach_Grid.add(panel_TC_Content_DanhSach_Thanh);
		Profile PF_Thanh = new Profile("images/Thanh.jpg","Nguyễn Công Thành",20215290+"");
		panel_TC_Content_DanhSach_Thanh.add(PF_Thanh);
		
		

	}

}