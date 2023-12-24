package view.home;

import view.definitions.MyLabel;
import view.definitions.MyPanel;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;

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

		// Kiểm tra xem tệp ảnh có tồn tại không
		File file = new File(avturl);
		if (file.exists()) {
			ImageIcon icon = new ImageIcon(avturl);

			Image originalImage = icon.getImage();
			Image resizedImage = originalImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			ImageIcon resizedIcon = new ImageIcon(resizedImage);

			panel_Avt.setLayout(new BorderLayout(0, 0));
			JLabel lbl_Avt = new JLabel(resizedIcon);
			panel_Avt.add(lbl_Avt);
		} else {
			System.out.println("Tệp ảnh không tồn tại: " + avturl);
			// Xử lý khi tệp ảnh không tồn tại, ví dụ: hiển thị ảnh mặc định hoặc thông báo lỗi.
		}

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