package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.CardLayout;

public class ManHinhChinh extends JPanel {

	/**
	 * Create the panel.
	 */
	public ManHinhChinh() {
		
		setPreferredSize(new Dimension(1335, 780));
		setLayout(new BorderLayout(0, 0));
		
		DanhSachNFT panel_DanhSach = new DanhSachNFT();
		
		TimKiemNFT panel_TimKiem = new TimKiemNFT();
		
		ThongKeNFT panel_ThongKe = new ThongKeNFT();
		
		SideBar sidebar = new SideBar();
		add(sidebar, BorderLayout.WEST);
		
		JPanel content = new JPanel();;
		add(content, BorderLayout.CENTER);
		content.setLayout(new BorderLayout(20, 5));
		
		JPanel panel_Content_Title = new JPanel();
		content.add(panel_Content_Title, BorderLayout.NORTH);
		panel_Content_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));
		
		JLabel lbl_Content_Title = new JLabel("New label"); // ten chuc nang (Danh Sach NFT, Tim Kiem Du Lieu, Thong Ke Du Lieu)
		lbl_Content_Title.setFont(new Font("Arial", Font.BOLD, 20));
		panel_Content_Title.add(lbl_Content_Title);
		
		JPanel panel_Dem_01 = new JPanel();
		content.add(panel_Dem_01, BorderLayout.WEST);
		
		JPanel panel_Dem_02 = new JPanel();
		content.add(panel_Dem_02, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		content.add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_Content_Main = new JPanel();
		content.add(panel_Content_Main, BorderLayout.CENTER);
		panel_Content_Main.setLayout(new CardLayout(0, 0));
		panel_Content_Main.add(panel_DanhSach);
		panel_Content_Main.add(panel_TimKiem);
		panel_Content_Main.add(panel_ThongKe);
		
		
		
		
	}

}
