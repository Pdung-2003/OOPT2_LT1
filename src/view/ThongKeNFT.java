package view;

import view.Buttons.Button_Chung;
import view.Labels.MyLabel;
import view.Labels.MyLabelBold;
import view.Panels.MyPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import view.ScrollPane.MyScrollPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Font;


public class ThongKeNFT extends JPanel {
	private JTextField textField_TKe_Filter_Title_TenNFT;

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

		// Thống kê theo tên NFT
		MyPanel panel_TKe_Filter_Title = new MyPanel();
		panel_TKe_Filter.add(panel_TKe_Filter_Title, BorderLayout.WEST);
		panel_TKe_Filter_Title.setLayout(new BoxLayout(panel_TKe_Filter_Title, BoxLayout.Y_AXIS));

		MyPanel panel_TKe_Filter_Title_TenNFT = new MyPanel();
		panel_TKe_Filter_Title.add(panel_TKe_Filter_Title_TenNFT);

		MyLabel lbl_TKe_Filter_Title_TenNFT = new MyLabel("Tên NFT: ");
		lbl_TKe_Filter_Title_TenNFT.setPreferredSize(new Dimension(100, 20));
		panel_TKe_Filter_Title_TenNFT.add(lbl_TKe_Filter_Title_TenNFT);

		// Khu vực tìm kiếm tên NFT
		textField_TKe_Filter_Title_TenNFT = new JTextField();
		textField_TKe_Filter_Title_TenNFT.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TKe_Filter_Title_TenNFT.add(textField_TKe_Filter_Title_TenNFT);
		textField_TKe_Filter_Title_TenNFT.setColumns(10);

		// Khu vực nút confirm duyệt thông tin
		MyPanel panel_TKe_Filter_Confirm = new MyPanel();
		panel_TKe_Filter_Title.add(panel_TKe_Filter_Confirm);

		Button_Chung btn_TKe_Filter_Confirm = new Button_Chung("Duyệt");
		panel_TKe_Filter_Confirm.add(btn_TKe_Filter_Confirm);

		// Khu vực hiển thị thông tin duyệt
		MyPanel panel_TKe_Filter_Result = new MyPanel();
		panel_TKe_Filter_Title.add(panel_TKe_Filter_Result);
		panel_TKe_Filter_Result.setLayout(new BorderLayout(0, 0));

		// In kết quả trong panel này
		MyScrollPane scrollPane_TKe_Filter_Result = new MyScrollPane();
		panel_TKe_Filter_Result.add(scrollPane_TKe_Filter_Result, BorderLayout.CENTER);

		// In tổng vào label này
		MyLabel lbl_TKe_Content_Total = new MyLabel("Tổng: ");
		lbl_TKe_Content_Total.setPreferredSize(new Dimension(150, 40));
		panel_TKe_Filter.add(lbl_TKe_Content_Total, BorderLayout.SOUTH);

		// Khu vực đệm phụ
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
		MyScrollPane scrollPane_TKe_Content_Twitter = new MyScrollPane();
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
		MyScrollPane scrollPane_TKe_Content_Blog = new MyScrollPane();
		panel_TKe_Content_Blog.add(scrollPane_TKe_Content_Blog, BorderLayout.CENTER);

		// Tổng số lượng
		MyLabel lbl_TKe_Content_Blog_Total = new MyLabel("Tổng: ");
		lbl_TKe_Content_Blog_Total.setPreferredSize(new Dimension(150, 40));
		panel_TKe_Content_Blog.add(lbl_TKe_Content_Blog_Total, BorderLayout.SOUTH);


	}

}
