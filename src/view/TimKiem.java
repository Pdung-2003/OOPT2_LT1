package view;

import view.Buttons.Button_Chung;
import view.ComboBox.MyComboBox;
import view.Labels.MyLabelBold;
import view.Panels.MyPanel;

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
	public TimKiem(String[] TimKiem, String[] SapXep) {

		setBackground(Colors.Trang);
		setPreferredSize(new Dimension(1085, 145));
		setLayout(new BorderLayout(20,0));

		// Panel tổng thể
		MyPanel panel_TK_Search = new MyPanel();
		add(panel_TK_Search, BorderLayout.NORTH);
		panel_TK_Search.setLayout(new BorderLayout(0, 10));

		// Panel chọn phương pháp tìm kiếm
		MyPanel panel_TK_Search_TimTheo = new MyPanel();
		panel_TK_Search.add(panel_TK_Search_TimTheo, BorderLayout.NORTH);
		panel_TK_Search_TimTheo.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));

		MyLabelBold lbl_TK_Search_Input_TimTheo = new MyLabelBold("Tìm theo: ");
		lbl_TK_Search_Input_TimTheo.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TK_Search_TimTheo.add(lbl_TK_Search_Input_TimTheo);

		MyComboBox comboBox_TK_Search_Input_TimTheo = new MyComboBox(TimKiem);
		panel_TK_Search_TimTheo.add(comboBox_TK_Search_Input_TimTheo);

		// Panel chứa thanh tìm kiếm và nút tìm kiếm
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

		Button_Chung btn_TK_Search_Input_Confirm = new Button_Chung("Tìm Kiếm");
		panel_TK_Search_Input_Confirm.add(btn_TK_Search_Input_Confirm);
		
		// Khu vực sắp xếp
		MyPanel panel_TK_Search_Sort = new MyPanel();
		panel_TK_Search_Sort.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panel_TK_Search.add(panel_TK_Search_Sort, BorderLayout.SOUTH);
		panel_TK_Search_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 10));
		
		MyLabelBold lbl_DSNFT_Filter_SapXep = new MyLabelBold("Sắp xếp theo: ");
		lbl_DSNFT_Filter_SapXep.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TK_Search_Sort.add(lbl_DSNFT_Filter_SapXep);
		
		MyComboBox comboBox_DSNFT_Filter_SapXep = new MyComboBox(SapXep);
		panel_TK_Search_Sort.add(comboBox_DSNFT_Filter_SapXep);

	}
}