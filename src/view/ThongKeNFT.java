package view;

import view.Buttons.Button_Chung;
import view.ComboBox.MyComboBox;
import view.Labels.MyLabel;
import view.Panels.MyPanel;
import view.ScrollPane.MyScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;

public class ThongKeNFT extends JPanel {

	/**
	 * Create the panel.
	 */
	public ThongKeNFT() {

		setBackground(Colors.TrangDuc);
		setBorder(new LineBorder(Colors.Trang, 20, true));
		setPreferredSize(new Dimension(1085, 730));
		setLayout(new BorderLayout(0, 0));

		MyPanel panel_TKe_Filter = new MyPanel();
		add(panel_TKe_Filter, BorderLayout.WEST);
		panel_TKe_Filter.setLayout(new BorderLayout(0, 0));

		MyPanel panel_TKe_Filter_Title = new MyPanel();
		panel_TKe_Filter.add(panel_TKe_Filter_Title, BorderLayout.WEST);
		panel_TKe_Filter_Title.setLayout(new GridLayout(10, 1, 10, 30));

		MyLabel lblNewLabel = new MyLabel("New label");
		panel_TKe_Filter_Title.add(lblNewLabel);

		MyLabel lblNewLabel_1 = new MyLabel("New label");
		panel_TKe_Filter_Title.add(lblNewLabel_1);

		MyLabel lblNewLabel_2 = new MyLabel("New label");
		panel_TKe_Filter_Title.add(lblNewLabel_2);

		MyLabel lblNewLabel_3 = new MyLabel("New label");
		panel_TKe_Filter_Title.add(lblNewLabel_3);

		MyPanel panel_TKe_Filter_Option = new MyPanel();
		panel_TKe_Filter.add(panel_TKe_Filter_Option, BorderLayout.CENTER);
		panel_TKe_Filter_Option.setLayout(new GridLayout(10, 1, 10, 30));

		// Chon thong ke ve thong tin 1
		String[] items_TKe_ThongTin4 = {"Tên NFT", "Chủ bộ sưu tập", "Ngày tạo", "Giá"};
		MyComboBox comboBox = new MyComboBox(items_TKe_ThongTin4);
		panel_TKe_Filter_Option.add(comboBox);

		String[] items_TKe_TimTheo = {"Tên NFT", "Chủ bộ sưu tập", "Ngày tạo", "Giá"};
		MyComboBox comboBox_1 = new MyComboBox(items_TKe_TimTheo);
		panel_TKe_Filter_Option.add(comboBox_1);

		String[] items_TKe_ThongTin2 = {"Tên NFT", "Chủ bộ sưu tập", "Ngày tạo", "Giá"};
		MyComboBox comboBox_2 = new MyComboBox(items_TKe_ThongTin2);
		panel_TKe_Filter_Option.add(comboBox_2);

		String[] items_TKe_ThongTin3 = {"Tên NFT", "Chủ bộ sưu tập", "Ngày tạo", "Giá"};
		MyComboBox comboBox_3 = new MyComboBox(items_TKe_ThongTin3);
		panel_TKe_Filter_Option.add(comboBox_3);

		Button_Chung btnNewButton = new Button_Chung("Duyệt");
		panel_TKe_Filter_Option.add(btnNewButton);

		MyPanel panel_TKe_Dem = new MyPanel();
		panel_TKe_Filter.add(panel_TKe_Dem, BorderLayout.EAST);

		MyPanel panel_TKe_Dem_2 = new MyPanel();
		panel_TKe_Filter.add(panel_TKe_Dem_2, BorderLayout.NORTH);

		MyPanel panel_TKe_Content = new MyPanel();
		add(panel_TKe_Content, BorderLayout.CENTER);
		panel_TKe_Content.setLayout(new BorderLayout(0, 0));

		MyScrollPane scrollPane = new MyScrollPane();
		panel_TKe_Content.add(scrollPane, BorderLayout.CENTER);

	}

}