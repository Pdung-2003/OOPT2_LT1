package view;

import view.Labels.MyLabel;
import view.Panels.MyPanel;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Profile extends JPanel {
	public Profile(String avturl, String name, String MSSV) {
		// Khu vực đặt thông tin chung
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(350, 250));
		
		// Khu vực avatar
		MyPanel panel_Avt = new MyPanel();
		add(panel_Avt);
		
//		String[] img = "a.jpg";
		ImageIcon icon = new ImageIcon("a.jpg");

		
		Image originalImage = icon.getImage();
        Image resizedImage = originalImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        panel_Avt.setLayout(new BorderLayout(0, 0));
        JLabel lbl_Avt = new JLabel(resizedIcon);
		panel_Avt.add(lbl_Avt);
		
		MyPanel panel_Avt_dem = new MyPanel();
		panel_Avt.add(panel_Avt_dem, BorderLayout.WEST);
		
		MyPanel panel_Avt_dem_1 = new MyPanel();
		panel_Avt.add(panel_Avt_dem_1, BorderLayout.NORTH);
		
		MyPanel panel_Avt_dem_2 = new MyPanel();
		panel_Avt.add(panel_Avt_dem_2, BorderLayout.EAST);
		
		MyPanel panel_Avt_dem_3 = new MyPanel();
		panel_Avt.add(panel_Avt_dem_3, BorderLayout.SOUTH);
		
		// Khu vực tên
		MyPanel panel_Ten = new MyPanel();
		add(panel_Ten);
		panel_Ten.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		MyLabel lbl_Ten = new MyLabel(name);
		panel_Ten.add(lbl_Ten);
		
		// Khu vực Mã sinh viên
		MyPanel panel_MSSV = new MyPanel();
		add(panel_MSSV);
		panel_MSSV.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		MyLabel lbl_MSSV = new MyLabel(MSSV);
		panel_MSSV.add(lbl_MSSV);
	}

}
