package view;

import controller.NFTController;
import models.NiftyGateway;
import view.Buttons.Button_Chung;
import view.ComboBox.MyComboBox;
import view.Labels.MyLabelBold;
import view.Panels.MyPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class DanhSachNFT extends JPanel {

	private final DefaultTableModel tableModel;
	private final MyPanel panel_DS_Content;
	private final JTable table;
	private final JScrollPane scrollPane;
	private final NFTController nftController;

	public DanhSachNFT() {
		setBackground(Colors.TrangDuc);
		setBorder(new LineBorder(Colors.Trang, 20, true));
		setPreferredSize(new Dimension(1085, 730));
		setLayout(new BorderLayout(20, 0));

		nftController = new NFTController();

		// Khu vuc filter
		MyPanel panel_DS_Filter = new MyPanel();
		panel_DS_Filter.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
		add(panel_DS_Filter, BorderLayout.NORTH);
		panel_DS_Filter.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));

		// Chon nen tang muon xem danh sach
		MyLabelBold lbl_DS_Filter_NenTang = new MyLabelBold("Chọn nền tảng: ");
		lbl_DS_Filter_NenTang.setFont(new Font("Arial", Font.BOLD, 16));
		panel_DS_Filter.add(lbl_DS_Filter_NenTang);

		String[] items_DS_NenTang = {"Nifty Gateway", "Binance", "Opensea", "Twitter"};
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
		panel_DS_Content = new MyPanel();
		add(panel_DS_Content, BorderLayout.CENTER);
		panel_DS_Content.setLayout(new BorderLayout(0, 0));

		// Tạo bảng và scrollPane một lần
		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		scrollPane = getjScrollPane();

		// Thêm scrollPane vào panel_DS_Content
		panel_DS_Content.add(scrollPane, BorderLayout.CENTER);

		btn_DS_CF_Filter.addActionListener(e -> {
			String selectedNenTang = (String) comboBox_DS_Filter_NenTang.getSelectedItem();
			assert selectedNenTang != null;

			// Tạo bảng với các cột tương ứng cho từng sàn
			setTableColumns(selectedNenTang);

			// Lấy dữ liệu từ Controller và thêm vào bảng
//			switch (selectedNenTang) {
//				case "Nifty Gateway":
//					List<NiftyGateway> niftyData = nftController.getNiftyData(); // Lấy dữ liệu từ Controller
//					nftController.addDataToTableNifty(niftyData); // Thêm thông tin vào bảng từ dữ liệu NiftyGateway
//					break;
				// Các trường hợp khác
//			}
		});
	}

	private JScrollPane getjScrollPane() {
		JTable table = new JTable(tableModel);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		// Đặt phông chữ và màu sắc cho header
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 14)); // Thay đổi phông chữ theo ý muốn
		header.setBackground(Color.black);
		header.setForeground(Colors.Vang);
		// Đặt độ cao của các hàng
		table.setRowHeight(40); // Đặt độ cao của các hàng là 30 pixels (thay đổi theo ý muốn)

		// Đặt phông chữ cho bảng
		Font tableFont = new Font("Arial", Font.PLAIN, 14); // Thay đổi phông chữ theo ý muốn
		table.setFont(tableFont);

		// Tạo scrollPane ngang và dọc cho bảng
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Đặt màu nền cho scrollPane
		scrollPane.setBackground(Color.LIGHT_GRAY);
		return scrollPane;
	}

	public void clearTable() {
		tableModel.setRowCount(0);
		tableModel.setColumnCount(0);
		tableModel.fireTableStructureChanged();
	}

	private void setTableColumns(String selectedNenTang) {
		tableModel.setRowCount(0);
		tableModel.setColumnCount(0);

		// Thêm các cột mới tùy thuộc vào giá trị được chọn
		switch (selectedNenTang) {
			case "Nifty Gateway":
				tableModel.addColumn("Collection Title");
				tableModel.addColumn("Collection Type");
				tableModel.addColumn("Contract Address");
				tableModel.addColumn("Display Image");
				tableModel.addColumn("Total Market Cap");
				tableModel.addColumn("Number of Owners");
				tableModel.addColumn("Total Supply");
				tableModel.addColumn("Floor Price");
				tableModel.addColumn("Day Total Volume");
				tableModel.addColumn("Day Change");
				tableModel.addColumn("Total Volume");
				tableModel.addColumn("Average Sale");
				break;
			case "Binance":
				tableModel.addColumn("ID");
				tableModel.addColumn("Cover Url");
				tableModel.addColumn("Title");
				tableModel.addColumn("Network");
				tableModel.addColumn("Volume");
				tableModel.addColumn("Volume Rate");
				tableModel.addColumn("Owners Count");
				tableModel.addColumn("Items Count");
				tableModel.addColumn("Listed Count");
				tableModel.addColumn("Floor Price");
				tableModel.addColumn("Floor Price Rate");
				tableModel.addColumn("Verified");
				break;
			case "Opensea":
				tableModel.addColumn("hello");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				break;
			case "Twitter":
				tableModel.addColumn("hi");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				tableModel.addColumn("");
				break;
			default:
				System.out.println("Không xác định được nền tảng.");
		}
		tableModel.fireTableStructureChanged();
	}
}