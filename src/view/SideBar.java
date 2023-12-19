package view;

import view.Buttons.Button_SideBar;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;

public class SideBar extends JPanel {
	private JButton buttonDanhSach;
	private JButton buttonTimKiem;
	private JButton buttonThongKe;
	private JButton buttonBlog;


	public SideBar() {
		setBackground(Colors.Vang);
		setPreferredSize(new Dimension(250, 730));
		setLayout(new GridLayout(10, 1, 3, 3));

		buttonDanhSach = new Button_SideBar("Danh sách NFT");
		add(buttonDanhSach);

		buttonBlog = new Button_SideBar("Danh sách blog");
		add(buttonBlog);

		buttonTimKiem = new Button_SideBar("Tìm kiếm dữ liệu");
		add(buttonTimKiem);

		buttonThongKe = new Button_SideBar("Thống kê dữ liệu");
		add(buttonThongKe);
	}

	public JButton getButtonDanhSach() {
		return buttonDanhSach;
	}

	public JButton getButtonTimKiem() {
		return buttonTimKiem;
	}

	public JButton getButtonThongKe() {
		return buttonThongKe;
	}
	public JButton getButtonBlog(){return buttonBlog;}
}
