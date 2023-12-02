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

public class TimKiemNFT extends JPanel {
	private JTextField textField_TK_Search_Input;

	/**
	 * Create the panel.
	 */
	public TimKiemNFT() {
		
		setBackground(Colors.TrangDuc);
		setBorder(new LineBorder(Colors.Trang, 20, true));
		setPreferredSize(new Dimension(1085, 730));
		setLayout(new BorderLayout(20, 0));
		
		MyPanel panel_TK_Search = new MyPanel();
		add(panel_TK_Search, BorderLayout.NORTH);
		panel_TK_Search.setLayout(new BorderLayout(0, 0));
		
		MyPanel panel_TK_Search_TimTheo = new MyPanel();
		panel_TK_Search.add(panel_TK_Search_TimTheo, BorderLayout.NORTH);
		panel_TK_Search_TimTheo.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));
		
		JLabel lbl_TK_Search_Input_TimTheo_CachTim = new JLabel("Tìm theo: ");
		lbl_TK_Search_Input_TimTheo_CachTim.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TK_Search_TimTheo.add(lbl_TK_Search_Input_TimTheo_CachTim);
		
		String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};
		JComboBox comboBox_TK_Search_Input_TimTheo_CachTim = new JComboBox(items);
		panel_TK_Search_TimTheo.add(comboBox_TK_Search_Input_TimTheo_CachTim);
	
		MyPanel panel_TK_Search_Input = new MyPanel();
		panel_TK_Search.add(panel_TK_Search_Input, BorderLayout.CENTER);
		panel_TK_Search_Input.setLayout(new BorderLayout(10, 10));
		
		textField_TK_Search_Input = new JTextField();
		panel_TK_Search_Input.add(textField_TK_Search_Input, BorderLayout.CENTER);
		textField_TK_Search_Input.setColumns(10);
		
		MyPanel panel_TK_Search_Input_Title = new MyPanel();
		panel_TK_Search_Input.add(panel_TK_Search_Input_Title, BorderLayout.WEST);
		panel_TK_Search_Input_Title.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 5));
		
		JLabel lbl_TK_Search_Input_Title = new JLabel("Nhập thông tin:");
		panel_TK_Search_Input_Title.add(lbl_TK_Search_Input_Title);
		lbl_TK_Search_Input_Title.setFont(new Font("Arial", Font.BOLD, 16));
		
		MyPanel panel_TK_Search_Input_Confirm = new MyPanel();
		panel_TK_Search_Input.add(panel_TK_Search_Input_Confirm, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("Tìm kiếm\r\n");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_TK_Search_Input_Confirm.add(btnNewButton);
		
		MyPanel panel_TK_Content = new MyPanel();
		add(panel_TK_Content, BorderLayout.CENTER);
		panel_TK_Content.setLayout(new BorderLayout(0, 0));
		
		MyPanel panel_TK_Content_Sort = new MyPanel();
		panel_TK_Content_Sort.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_TK_Content.add(panel_TK_Content_Sort, BorderLayout.NORTH);
		panel_TK_Content_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 5));
		
		JLabel lbl_TK_Content_Sort = new JLabel("Sắp xếp theo:");
		lbl_TK_Content_Sort.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TK_Content_Sort.add(lbl_TK_Content_Sort);
		
		JComboBox comboBox_TK_Content_Sort = new JComboBox();
		panel_TK_Content_Sort.add(comboBox_TK_Content_Sort);
		
		MyPanel panel_TK_Content_NoiDung = new MyPanel();
		panel_TK_Content.add(panel_TK_Content_NoiDung, BorderLayout.CENTER);
		panel_TK_Content_NoiDung.setLayout(new BorderLayout(0, 0));
		
	}

}
