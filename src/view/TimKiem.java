package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class TimKiem extends JPanel {
	private JTextField textField_TK_Search_Input;

	/**
	 * Create the panel.
	 */
	public TimKiem(String[] items_TK_TimTheo) {

		setBackground(Colors.Trang);
		setPreferredSize(new Dimension(1085, 110));
		setLayout(new BorderLayout(20, 0));

		MyPanel panel_TK_Search = new MyPanel();
		add(panel_TK_Search, BorderLayout.NORTH);
		panel_TK_Search.setLayout(new BorderLayout(0, 0));

		MyPanel panel_TK_Search_TimTheo = new MyPanel();
		panel_TK_Search.add(panel_TK_Search_TimTheo, BorderLayout.NORTH);
		panel_TK_Search_TimTheo.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));

		MyLabelBold lbl_TK_Search_Input_TimTheo_CachTim = new MyLabelBold("Tìm theo: ");
		lbl_TK_Search_Input_TimTheo_CachTim.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TK_Search_TimTheo.add(lbl_TK_Search_Input_TimTheo_CachTim);

		// Chon cac cach tim kiem du lieu
		MyComboBox comboBox_TK_Search_Input_TimTheo_CachTim = new MyComboBox(items_TK_TimTheo);
		panel_TK_Search_TimTheo.add(comboBox_TK_Search_Input_TimTheo_CachTim);

		MyPanel panel_TK_Search_Input = new MyPanel();
		panel_TK_Search.add(panel_TK_Search_Input, BorderLayout.CENTER);
		panel_TK_Search_Input.setLayout(new BorderLayout(10, 10));

		textField_TK_Search_Input = new JTextField();
		textField_TK_Search_Input.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_TK_Search_Input.add(textField_TK_Search_Input, BorderLayout.CENTER);
		textField_TK_Search_Input.setColumns(10);

		MyPanel panel_TK_Search_Input_Title = new MyPanel();
		panel_TK_Search_Input.add(panel_TK_Search_Input_Title, BorderLayout.WEST);
		panel_TK_Search_Input_Title.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 10));

		MyLabelBold lbl_TK_Search_Input_Title = new MyLabelBold("Nhập thông tin:");
		panel_TK_Search_Input_Title.add(lbl_TK_Search_Input_Title);
		lbl_TK_Search_Input_Title.setFont(new Font("Arial", Font.BOLD, 16));

		MyPanel panel_TK_Search_Input_Confirm = new MyPanel();
		panel_TK_Search_Input.add(panel_TK_Search_Input_Confirm, BorderLayout.EAST);

		Button_Chung btnNewButton = new Button_Chung("Tìm Kiếm");
		panel_TK_Search_Input_Confirm.add(btnNewButton);
		
		MyPanel panel_TK_Search_Margin = new MyPanel();
		panel_TK_Search_Margin.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TK_Search.add(panel_TK_Search_Margin, BorderLayout.SOUTH);
		panel_TK_Search_Margin.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 5));

		// Chon cach sap xep thong tin out put
		String[] items_TK_SapXep = {"item1", "item2", "item3", "item4"};

	}
}