package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class DanhSachBlog extends TimKiemNFT {
	/**
	 * Create the panel.
	 */
	public DanhSachBlog() {
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
		
		
		// Khu vực thông tin chính
		MyPanel panel_DSBL_Content_Table = new MyPanel();
		panel_DSBL_Content.add(panel_DSBL_Content_Table, BorderLayout.CENTER);
		
		// Khu vực dành cho button xem chi tiết
		MyPanel panel_DSBL_Content_Detail = new MyPanel();
		panel_DSBL_Content.add(panel_DSBL_Content_Detail, BorderLayout.EAST);
		panel_DSBL_Content_Detail.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));
		
		Button_Chung btn_DSBL_Content_Detail = new Button_Chung("Xem Chi Tiết");
		panel_DSBL_Content_Detail.add(btn_DSBL_Content_Detail);
		
		// Khu vực action của nút Xem chi tiết
		btn_DSBL_Content_Detail.addActionListener(e -> {
            // Tạo panel nội dung blog
            JPanel panel_Blog_Detail = new JPanel();
            JTextArea textArea_Blog_Detail = new JTextArea("Đây là một đoạn văn bản dài hơn để hiển thị.");
            textArea_Blog_Detail.setEditable(false);
            panel_Blog_Detail.add(textArea_Blog_Detail);

            // Hiển thị ra panel thông tin chi tiết blog
            JFrame Blog_Detail = new JFrame();
            Blog_Detail.setTitle("Thông tin"); // Điền title của blog vô đây
            Blog_Detail.getContentPane().add(panel_Blog_Detail);
            Blog_Detail.setSize(300, 200);
            Blog_Detail.setLocationRelativeTo(null);
            Blog_Detail.setVisible(true);
        });
	}

}
