package view;

import controller.DanhSachBlogController;
import view.Buttons.Button_Chung;
import view.Panels.MyPanel;

import java.util.List;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

<<<<<<< HEAD:src/view/DanhSachTinTuc.java
public class DanhSachTinTuc extends TimKiemNFT {
	/**
	 * Create the panel.
	 */
	public DanhSachTinTuc() {
=======
import static view.Table.clearTable;

public class DanhSachBlog extends TimKiemNFT implements SortListener, SearchListener{
	private final DefaultTableModel tableModelNews;
	private final JTable tableNews;
	private TimKiem DSBL_TimKiem;
	public DanhSachBlog() {
		DanhSachBlogController controller = new DanhSachBlogController();
>>>>>>> d8879cf6210535b4aa43f05cb8cd4095fb90b184:src/view/DanhSachBlog.java
		setBackground(Colors.TrangDuc);
		setBorder(new LineBorder(Colors.Trang, 20, true));
		setPreferredSize(new Dimension(1085, 730));
		setLayout(new BorderLayout(20, 0));

		// Khu vực tìm kiếm
		String[] items_DSBL_TimKiem = {"Bài viết", "Tin tức"}; // Thêm phương pháp tìm kiếm vào đây
		String[] items_DSBL_Sapxep = {"Mới nhất", "Hot nhất"}; // Thêm phương pháp sắp xếp vào đây
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
		tableModelNews = new DefaultTableModel();
		tableNews = new JTable(tableModelNews);
		tableModelNews.addColumn("Chủ đề");
		JScrollPane scrollPane = Table.getScrollPane(tableModelNews);

		panel_DSBL_Content.add(scrollPane, BorderLayout.CENTER);

		// Thêm dữ liệu từ danh sách vào bảng
		List<String[]> data = controller.titleTodayNFTNewsData();
		controller.addDataToTableNews(data, tableNews);
		
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
	public void setData(String selectedSearch) {
		clearTable(tableModelNews);
		switch (selectedSearch) {
			case "Tin tức":
				tableModelNews.addColumn("Chủ đề");
				break;
			case "Bài viết":
				tableModelNews.addColumn("Mã tác giả");
				tableModelNews.addColumn("Tác giả");
				tableModelNews.addColumn("Hashtag");
				break;
			default:
				System.out.println("Không xác định nền tảng blog!");
		}
	}
	@Override
	public void searchPerformed(String selectedSearchMethod, String searchInput) {
		System.out.println("Search method: " + selectedSearchMethod + ", Search input: " + searchInput);
	}

	@Override
	public void sortPerformed(String selectedSortMethod) {
		System.out.println("Sort method: " + selectedSortMethod);
	}
}
