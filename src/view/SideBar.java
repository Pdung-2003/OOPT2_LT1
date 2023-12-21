package view;

import view.Buttons.Button_SideBar;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;

public class SideBar extends JPanel {
	private JButton buttonDanhSach;
	private JButton buttonTinTuc;
	private JButton buttonBaiViet;
	private JButton buttonThongKe;


	public SideBar() {
		setBackground(Colors.Vang);
		setPreferredSize(new Dimension(250, 730));
		setLayout(new GridLayout(10, 1, 3, 3));

		buttonDanhSach = new Button_SideBar("Danh sách NFT");
		add(buttonDanhSach);

		buttonTinTuc = new Button_SideBar("Danh sách tin tức");
		add(buttonTinTuc);

		buttonBaiViet = new Button_SideBar("Danh sách bài viết");
		add(buttonBaiViet);

		buttonThongKe = new Button_SideBar("Thống kê dữ liệu");
		add(buttonThongKe);
	}

	public JButton getButtonDanhSach() {
		return buttonDanhSach;
	}

	public JButton getButtonThongKe() {
		return buttonThongKe;
	}
	public JButton getbuttonTinTuc(){return buttonTinTuc;}
	public JButton getbuttonBaiViet(){return buttonBaiViet;}

}
