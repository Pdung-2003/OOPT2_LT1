package view;

import view.Buttons.Button_Chung;
import view.ComboBox.MyComboBox;
import view.Labels.MyLabel;
import view.Labels.MyLabelBold;
import view.Panels.MyPanel;
import view.ScrollPane.MyScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Component;

public class ThongKeNFT extends JPanel {

	/**
	 * Create the panel.
	 */
	public ThongKeNFT() {
		// Đặt thuộc tính ban đầu
		setBackground(Colors.TrangDuc);
		setBorder(new LineBorder(Colors.Trang, 20, true));
		setPreferredSize(new Dimension(1085, 730));
		setLayout(new BorderLayout(0, 0));

		// Khu vực đặt lưới thống kê
		MyPanel panel_TKe_Filter = new MyPanel();
		add(panel_TKe_Filter, BorderLayout.WEST);
		panel_TKe_Filter.setLayout(new BorderLayout(0, 0));

		// Thống ke theo tên NFT
		MyPanel panel_TKe_Filter_Title = new MyPanel();
		panel_TKe_Filter.add(panel_TKe_Filter_Title, BorderLayout.WEST);
		panel_TKe_Filter_Title.setLayout(new BoxLayout(panel_TKe_Filter_Title, BoxLayout.Y_AXIS));

		MyPanel panel_TKe_Filter_Title_TenNFT = new MyPanel();
		panel_TKe_Filter_Title.add(panel_TKe_Filter_Title_TenNFT);

		MyLabel lbl_TKe_Filter_Title_TenNFT = new MyLabel("Tên NFT: ");
		lbl_TKe_Filter_Title_TenNFT.setPreferredSize(new Dimension(150, 20));
		panel_TKe_Filter_Title_TenNFT.add(lbl_TKe_Filter_Title_TenNFT);

		String[] items_TKe_ThongTin4 = {"Tên NFT", "Chủ bộ sưu tập", "Ngày tạo", "Giá"}; // Điền tên các NFT vào đây
		MyComboBox comboBox_TKe_Filter_Title_TenNFT = new MyComboBox(items_TKe_ThongTin4);
		comboBox_TKe_Filter_Title_TenNFT.setPreferredSize(new Dimension(180, 30));
		panel_TKe_Filter_Title_TenNFT.add(comboBox_TKe_Filter_Title_TenNFT);

		// Thống kê theo thời gian xuất bản
		MyPanel panel_TKe_Filter_Title_ThoiGian = new MyPanel();
		panel_TKe_Filter_Title.add(panel_TKe_Filter_Title_ThoiGian);

		MyLabel lbl_TKe_Filter_Title_ThoiGian = new MyLabel("Thời gian xuất bản:");
		panel_TKe_Filter_Title_ThoiGian.add(lbl_TKe_Filter_Title_ThoiGian);
		lbl_TKe_Filter_Title_ThoiGian.setPreferredSize(new Dimension(150, 20));

		String[] items_TKe_ThongTin5 = {"1 tháng", "3 tháng", "6 tháng", "--"}; // Điền tên các NFT vào đây (có thể là 1 tháng trở lại, 3 tháng, 6 tháng, 1 năm, --)
		MyComboBox comboBox_TKe_Filter_Title_ThoiGian = new MyComboBox(items_TKe_ThongTin5);
		comboBox_TKe_Filter_Title_ThoiGian.setPreferredSize(new Dimension(180, 30));
		panel_TKe_Filter_Title_ThoiGian.add(comboBox_TKe_Filter_Title_ThoiGian);

		// Thống kê theo Hashtag
		MyPanel panel_TKe_Filter_Title_Hashtag = new MyPanel();
		panel_TKe_Filter_Title.add(panel_TKe_Filter_Title_Hashtag);

		MyLabel lbl_TKe_Filter_Title_Hashtag = new MyLabel("Hashtag:");
		lbl_TKe_Filter_Title_Hashtag.setPreferredSize(new Dimension(150, 20));
		panel_TKe_Filter_Title_Hashtag.add(lbl_TKe_Filter_Title_Hashtag);

		String[] items_TKe_ThongTin2 = {"Tên NFT", "Chủ bộ sưu tập", "Ngày tạo", "Giá"}; // Điền hashtag vào đây
		MyComboBox comboBox_TKe_Filter_Title_Hashtag = new MyComboBox(items_TKe_ThongTin2);
		comboBox_TKe_Filter_Title_Hashtag.setPreferredSize(new Dimension(180, 30));
		panel_TKe_Filter_Title_Hashtag.add(comboBox_TKe_Filter_Title_Hashtag);

		// Khu vực nút confirm duyệt thông tin
		MyPanel panel_TKe_Filter_Confirm = new MyPanel();
		panel_TKe_Filter_Title.add(panel_TKe_Filter_Confirm);

		Button_Chung btn_TKe_Filter_Confirm = new Button_Chung("Duyệt");
		panel_TKe_Filter_Confirm.add(btn_TKe_Filter_Confirm);
		panel_TKe_Filter_Title.add(Box.createVerticalGlue());
		panel_TKe_Filter_Title.add(Box.createVerticalGlue());
		panel_TKe_Filter_Title.add(Box.createVerticalGlue());

		MyPanel panel_TKe_Dem = new MyPanel();
		panel_TKe_Filter.add(panel_TKe_Dem, BorderLayout.EAST);

		MyPanel panel_TKe_Dem_2 = new MyPanel();
		panel_TKe_Filter.add(panel_TKe_Dem_2, BorderLayout.NORTH);

		// Khu vực thông tin chính hiển thị
		MyPanel panel_TKe_Content = new MyPanel();
		add(panel_TKe_Content, BorderLayout.CENTER);
		panel_TKe_Content.setLayout(new GridLayout(1, 2, 10, 0));

		// Twitter
		MyPanel panel_TKe_Content_Twitter = new MyPanel();
		panel_TKe_Content.add(panel_TKe_Content_Twitter);
		panel_TKe_Content_Twitter.setLayout(new BorderLayout(0, 0));

		// Tiêu đề twitter
		MyPanel panel_TKe_Content_Twitter_Title = new MyPanel();
		panel_TKe_Content_Twitter.add(panel_TKe_Content_Twitter_Title, BorderLayout.NORTH);

		MyLabelBold lbl_TKe_Content_Twitter_Title = new MyLabelBold("Twitter");
		panel_TKe_Content_Twitter_Title.add(lbl_TKe_Content_Twitter_Title);

		// Thông tin hiển thị in vào panel này
		JScrollPane scrollPane_TKe_Content_Twitter = new JScrollPane();
		panel_TKe_Content_Twitter.add(scrollPane_TKe_Content_Twitter, BorderLayout.CENTER);

		// Tổng số lượng
		MyLabel lbl_TKe_Content_Twitter_Total = new MyLabel("Tổng: ");
		lbl_TKe_Content_Twitter_Total.setPreferredSize(new Dimension(150, 40));
		panel_TKe_Content_Twitter.add(lbl_TKe_Content_Twitter_Total, BorderLayout.SOUTH);

		// Blog
		MyPanel panel_TKe_Content_Blog = new MyPanel();
		panel_TKe_Content.add(panel_TKe_Content_Blog);
		panel_TKe_Content_Blog.setLayout(new BorderLayout(0, 0));

		// Tiêu đề blog
		MyPanel panel_TKe_Content_Blog_Title = new MyPanel();
		panel_TKe_Content_Blog.add(panel_TKe_Content_Blog_Title, BorderLayout.NORTH);

		MyLabelBold lbl_TKe_Content_Blog_Title = new MyLabelBold("Blog");
		panel_TKe_Content_Blog_Title.add(lbl_TKe_Content_Blog_Title);

		// Thông tin hiển thị in vào panel này
		JScrollPane scrollPane_TKe_Content_Blog = new JScrollPane();
		panel_TKe_Content_Blog.add(scrollPane_TKe_Content_Blog, BorderLayout.CENTER);

		// Tổng số lượng
		MyLabel lbl_TKe_Content_Blog_Total = new MyLabel("Tổng: ");
		lbl_TKe_Content_Blog_Total.setPreferredSize(new Dimension(150, 40));
		panel_TKe_Content_Blog.add(lbl_TKe_Content_Blog_Total, BorderLayout.SOUTH);


	}

}