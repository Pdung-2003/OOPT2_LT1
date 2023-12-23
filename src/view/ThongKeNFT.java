package view;

import controller.ThongKeController;
import view.Buttons.Button_Chung;
import view.Labels.MyLabel;
import view.Labels.MyLabelBold;
import view.Panels.MyPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ScrollPane.MyScrollPane;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class ThongKeNFT extends JPanel {
	private final DefaultTableModel tableModel;
	private final JTable table;
	private JTextField textField_TKe_Filter_Title_TenNFT;
	private ThongKeController controller;

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

		// Tạo DefaultTableModel với một cột "title"
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Title");

		// Tạo bảng với DefaultTableModel
		table = new JTable(tableModel);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);

		// Tạo bảng cho twitter
		DefaultTableModel tableModelTwitter = new DefaultTableModel();
		tableModelTwitter.addColumn("Author");
		JTable tableTwitter = new JTable(tableModelTwitter);
		tableTwitter.setBackground(Color.WHITE);
		tableTwitter.setForeground(Color.BLACK);

		// Tạo bảng cho news
		DefaultTableModel tableModelNews = new DefaultTableModel();
		tableModelNews.addColumn("Title");
		JTable tableNews = new JTable(tableModelNews);
		tableNews.setBackground(Color.WHITE);
		tableNews.setForeground(Color.BLACK);

		// Đặt phông chữ và màu sắc cho header
		JTableHeader header = table.getTableHeader();
		JTableHeader headerTwitter = tableTwitter.getTableHeader();
		JTableHeader headerNews = tableNews.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 14));
		header.setBackground(Color.black);
		header.setForeground(Colors.Vang);

		headerTwitter.setFont(new Font("Arial", Font.BOLD, 14));
		headerTwitter.setBackground(Color.black);
		headerTwitter.setForeground(Colors.Vang);

		headerNews.setFont(new Font("Arial", Font.BOLD, 14));
		headerNews.setBackground(Color.black);
		headerNews.setForeground(Colors.Vang);
		table.setRowHeight(40);
		tableTwitter.setRowHeight(40);
		tableNews.setRowHeight(40);

		// Đặt phông chữ cho bảng
		Font tableFont = new Font("Arial", Font.PLAIN, 14);
		table.setFont(tableFont);
		tableTwitter.setFont(tableFont);
		tableNews.setFont(tableFont);
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
		tableTwitter.setDefaultRenderer(Object.class, renderer);
		tableNews.setDefaultRenderer(Object.class, renderer);

		// Tạo MyScrollPane để chứa bảng
		MyScrollPane scrollPane = new MyScrollPane();
		MyScrollPane scrollPaneNews = new MyScrollPane();
		MyScrollPane scrollPaneTwitter = new MyScrollPane();
		scrollPane.setViewportView(table);

		scrollPaneTwitter.setViewportView(tableTwitter);
		scrollPaneNews.setViewportView(tableNews);

		// Thêm MyScrollPane chứa bảng vào panel_TKe_Filter_Result
		panel_TKe_Filter_Result.add(scrollPane, BorderLayout.CENTER);

		controller = new ThongKeController();
		controller.addNFTTitlesToTable(table);


		// In tổng vào label này
		MyLabel lbl_TKe_Content_Total = new MyLabel("Tổng: " + table.getRowCount());
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
		panel_TKe_Content_Twitter.add(scrollPaneTwitter, BorderLayout.CENTER);

		// Tiêu đề twitter
		MyPanel panel_TKe_Content_Twitter_Title = new MyPanel();
		panel_TKe_Content_Twitter.add(panel_TKe_Content_Twitter_Title, BorderLayout.NORTH);

		MyLabelBold lbl_TKe_Content_Twitter_Title = new MyLabelBold("Twitter");
		panel_TKe_Content_Twitter_Title.add(lbl_TKe_Content_Twitter_Title);

		// Tổng số lượng
		MyLabel lbl_TKe_Content_Twitter_Total = new MyLabel("Tổng: ");
		lbl_TKe_Content_Twitter_Total.setPreferredSize(new Dimension(150, 40));
		panel_TKe_Content_Twitter.add(lbl_TKe_Content_Twitter_Total, BorderLayout.SOUTH);

		// Blog
		MyPanel panel_TKe_Content_Blog = new MyPanel();
		panel_TKe_Content.add(panel_TKe_Content_Blog);
		panel_TKe_Content_Blog.setLayout(new BorderLayout(0, 0));
		panel_TKe_Content_Blog.add(scrollPaneNews, BorderLayout.CENTER);

		// Tiêu đề blog
		MyPanel panel_TKe_Content_Blog_Title = new MyPanel();
		panel_TKe_Content_Blog.add(panel_TKe_Content_Blog_Title, BorderLayout.NORTH);

		MyLabelBold lbl_TKe_Content_Blog_Title = new MyLabelBold("Blog");
		panel_TKe_Content_Blog_Title.add(lbl_TKe_Content_Blog_Title);

		// Tổng số lượng
		MyLabel lbl_TKe_Content_Blog_Total = new MyLabel("Tổng: ");
		lbl_TKe_Content_Blog_Total.setPreferredSize(new Dimension(150, 40));
		panel_TKe_Content_Blog.add(lbl_TKe_Content_Blog_Total, BorderLayout.SOUTH);

		// Listener cho button
		btn_TKe_Filter_Confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableModel.setRowCount(0);
				String input = textField_TKe_Filter_Title_TenNFT.getText();
				controller.addInfoSearch(table, controller.searchNFTTitles(input));
				lbl_TKe_Content_Total.setText("Tổng: " + table.getRowCount());
			}
		});
		// Listener cho Table
		table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					tableModelNews.setRowCount(0);
					tableModelTwitter.setRowCount(0);

					System.out.println((String) table.getValueAt(selectedRow, 0));
					controller.addInfoSearch(tableTwitter, controller.searchTwitter((String) table.getValueAt(selectedRow, 0)));
					System.out.println(controller.searchTwitter((String) table.getValueAt(selectedRow, 0)));
					controller.addInfoSearch(tableNews, controller.searchNews((String) table.getValueAt(selectedRow, 0)));
					lbl_TKe_Content_Blog_Total.setText("Tổng: " + tableNews.getRowCount());
					lbl_TKe_Content_Twitter_Total.setText("Tổng: " + tableTwitter.getRowCount());
				}
			}
		});
		tableTwitter.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				BlogDetail blogDetail = new BlogDetail();
				blogDetail.setLocationRelativeTo(null);
				blogDetail.setVisible(true);
				int selectedRow = tableTwitter.getSelectedRow();
				System.out.println((String) tableTwitter.getValueAt(selectedRow, 0));
				blogDetail.updateBlogTwitter((String) tableNews.getValueAt(selectedRow, 0),
						controller.searchTwitterAuthor((String) tableTwitter.getValueAt(selectedRow, 0)).getImages(),
						controller.searchTwitterAuthor((String) tableTwitter.getValueAt(selectedRow, 0)).getAuthor(),
						controller.searchTwitterAuthor((String) tableTwitter.getValueAt(selectedRow, 0)).getDate(),
						controller.searchTwitterAuthor((String) tableTwitter.getValueAt(selectedRow, 0)).getHashtag(),
						controller.searchTwitterAuthor((String) tableTwitter.getValueAt(selectedRow, 0)).getContent());
				blogDetail.updateUI();
			}
		});
		tableNews.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				BlogDetail blogDetail = new BlogDetail();
				blogDetail.setLocationRelativeTo(null);
				blogDetail.setVisible(true);
				int selectedRow = tableNews.getSelectedRow();
				blogDetail.updateBlogDetail((String) tableNews.getValueAt(selectedRow, 0),
						controller.searchByTitle((String) tableNews.getValueAt(selectedRow, 0)).getImageUrl(),
						controller.searchByTitle((String) tableNews.getValueAt(selectedRow, 0)).getAuthor(),
						controller.searchByTitle((String) tableNews.getValueAt(selectedRow, 0)).getDate(),
						controller.searchByTitle((String) tableNews.getValueAt(selectedRow, 0)).getHashtag(),
						controller.searchByTitle((String) tableNews.getValueAt(selectedRow, 0)).getContent());
				blogDetail.updateUI();
			}
		});
	}

}
