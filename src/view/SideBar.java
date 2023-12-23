package view;

import view.Buttons.Button_Chung;
import view.Buttons.Button_SideBar;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

public class SideBar extends JPanel {
	private JButton buttonDanhSach;
	private JButton buttonTinTuc;
	private JButton buttonBaiViet;
	private JButton buttonThongKe;
	private JButton buttonTrangChu;
	private JPanel panel_buttonTrangChu;
	private JPanel panel_buttonDanhSach;
	private JPanel panel_buttonTinTuc;
	private JPanel panel_buttonBaiViet;
	private JPanel panel_buttonThongKe;
	private JPanel panel_buttonCapNhat;
	private Button_Chung buttonCapNhat;
	private Component verticalGlue;



	public SideBar() {
		setBackground(Colors.Vang);
		setPreferredSize(new Dimension(250, 730));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		panel_buttonTrangChu = new JPanel();
		add(panel_buttonTrangChu);
		panel_buttonTrangChu.setLayout(new GridLayout(1, 0, 0, 0));

		buttonTrangChu = new Button_SideBar("Trang chủ");
		panel_buttonTrangChu.add(buttonTrangChu);
//		buttonTrangChu.setPreferredSize(new Dimension(250, 60));

		panel_buttonDanhSach = new JPanel();
		add(panel_buttonDanhSach);
		panel_buttonDanhSach.setLayout(new GridLayout(1, 0, 0, 0));

		buttonDanhSach = new Button_SideBar("Danh sách NFT");
		panel_buttonDanhSach.add(buttonDanhSach);
//		buttonDanhSach.setPreferredSize(new Dimension(250, 60));

		panel_buttonTinTuc = new JPanel();
		add(panel_buttonTinTuc);
		panel_buttonTinTuc.setLayout(new GridLayout(0, 1, 0, 0));

		buttonTinTuc = new Button_SideBar("Danh sách tin tức");
		panel_buttonTinTuc.add(buttonTinTuc);
//		buttonTinTuc.setPreferredSize(new Dimension(250, 60));

		panel_buttonBaiViet = new JPanel();
		add(panel_buttonBaiViet);
		panel_buttonBaiViet.setLayout(new GridLayout(0, 1, 0, 0));

		buttonBaiViet = new Button_SideBar("Danh sách bài viết");
		panel_buttonBaiViet.add(buttonBaiViet);
//		buttonBaiViet.setPreferredSize(new Dimension(250, 60));

		panel_buttonThongKe = new JPanel();
		add(panel_buttonThongKe);
		panel_buttonThongKe.setLayout(new GridLayout(0, 1, 0, 0));

		buttonThongKe = new Button_SideBar("Thống kê dữ liệu");
		panel_buttonThongKe.add(buttonThongKe);
//		buttonThongKe.setPreferredSize(new Dimension(250, 60));

		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());

		panel_buttonCapNhat = new JPanel();
		panel_buttonCapNhat.setBackground(Colors.Vang);
		add(panel_buttonCapNhat);

		buttonCapNhat = new Button_Chung("Cập nhật dữ liệu");
		buttonCapNhat.setBackground(Colors.Den);
		buttonCapNhat.setForeground(Colors.Vang);
		buttonCapNhat.setPreferredSize(new Dimension(200, 60));
		panel_buttonCapNhat.add(buttonCapNhat);
	}

	public JButton getButtonDanhSach() {
		return buttonDanhSach;
	}

	public JButton getButtonThongKe() {
		return buttonThongKe;
	}
	public JButton getbuttonTinTuc(){return buttonTinTuc;}
	public JButton getbuttonBaiViet(){return buttonBaiViet;}
	public JButton getbuttonTrangChu(){return buttonTrangChu;}

}