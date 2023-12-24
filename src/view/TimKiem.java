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
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.MatteBorder;

public class TimKiem extends JPanel {
	private final JTextField textField_TK_Search_Input;
	private final MyComboBox comboBox_TK_Search_Input_TimTheo;
	private final MyComboBox comboBox_DSNFT_Filter_SapXep;

	private List<SearchListener> searchListeners = new ArrayList<>();
	private List<SortListener> sortListeners = new ArrayList<>();
	public TimKiem(String[] TimKiem, String[] SapXep) {

		setBackground(Colors.Trang);
		setPreferredSize(new Dimension(1085, 155));
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

		comboBox_TK_Search_Input_TimTheo = new MyComboBox(TimKiem);
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
		btn_TK_Search_Input_Confirm.setPreferredSize(new Dimension(120, 35));
		panel_TK_Search_Input_Confirm.add(btn_TK_Search_Input_Confirm);
		
		// Khu vực sắp xếp
		MyPanel panel_TK_Search_Sort = new MyPanel();
		panel_TK_Search_Sort.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panel_TK_Search.add(panel_TK_Search_Sort, BorderLayout.SOUTH);
		panel_TK_Search_Sort.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 10));
		
		MyLabelBold lbl_DSNFT_Filter_SapXep = new MyLabelBold("Sắp xếp theo: ");
		lbl_DSNFT_Filter_SapXep.setFont(new Font("Arial", Font.BOLD, 16));
		panel_TK_Search_Sort.add(lbl_DSNFT_Filter_SapXep);
		
		comboBox_DSNFT_Filter_SapXep = new MyComboBox(SapXep);
		panel_TK_Search_Sort.add(comboBox_DSNFT_Filter_SapXep);

		btn_TK_Search_Input_Confirm.addActionListener(e -> {
			String selectedSearchMethod = (String) comboBox_TK_Search_Input_TimTheo.getSelectedItem();
			String searchInput = textField_TK_Search_Input.getText();

			// Gọi phương thức kích hoạt sự kiện tìm kiếm cho tất cả các lắng nghe
			for (SearchListener listener : searchListeners) {
				listener.searchPerformed(selectedSearchMethod, searchInput);
			}
		});

		comboBox_DSNFT_Filter_SapXep.addActionListener(e -> {
			String selectedSortMethod = (String) comboBox_DSNFT_Filter_SapXep.getSelectedItem();

			// Gọi phương thức kích hoạt sự kiện sắp xếp cho tất cả các lắng nghe
			for (SortListener listener : sortListeners) {
				listener.sortPerformed(selectedSortMethod);
			}
		});
	}

	// Phương thức để đăng ký lắng nghe sự kiện tìm kiếm
	public void addSearchListener(SearchListener listener) {
		searchListeners.add(listener);
	}

	// Phương thức để hủy đăng ký lắng nghe sự kiện tìm kiếm
	public void removeSearchListener(SearchListener listener) {
		searchListeners.remove(listener);
	}

	// Phương thức để đăng ký lắng nghe sự kiện sắp xếp
	public void addSortListener(SortListener listener) {
		sortListeners.add(listener);
	}

	// Phương thức để hủy đăng ký lắng nghe sự kiện sắp xếp
	public void removeSortListener(SortListener listener) {
		sortListeners.remove(listener);
	}
}