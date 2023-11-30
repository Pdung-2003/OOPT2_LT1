package view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;

public class SideBar extends JPanel {

	/**
	 * Create the panel.
	 */
	public SideBar() {
		setBackground(Colors.Vang);
		setPreferredSize(new Dimension(250, 730));
		setLayout(new GridLayout(10, 1, 3, 3));
		
		Button_SideBar btn_SIdeBar_DanhSach = new Button_SideBar("Danh sách NFT");
		add(btn_SIdeBar_DanhSach);
		
		Button_SideBar btn_SIdeBar_TimKiem = new Button_SideBar("Tìm kiếm dữ liệu");
		add(btn_SIdeBar_TimKiem);
		
		Button_SideBar btn_SIdeBar_ThongKe = new Button_SideBar("Thống kê dữ liệu     ");
		add(btn_SIdeBar_ThongKe);

	}

}
