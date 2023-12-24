package view.home;

import crawler.RunCrawlerAll;
import view.definitions.Button_Chung;
import view.definitions.Button_SideBar;
import view.definitions.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SideBar extends JPanel {
	private final JButton buttonDanhSach;
	private final JButton buttonTinTuc;
	private final JButton buttonBaiViet;
	private final JButton buttonThongKe;
	private final JButton buttonTrangChu;

    public SideBar() {
		setBackground(Colors.Vang);
		setPreferredSize(new Dimension(250, 730));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panel_buttonTrangChu = new JPanel();
		add(panel_buttonTrangChu);
		panel_buttonTrangChu.setLayout(new GridLayout(1, 0, 0, 0));

		buttonTrangChu = new Button_SideBar("Trang chủ");
		panel_buttonTrangChu.add(buttonTrangChu);
//		buttonTrangChu.setPreferredSize(new Dimension(250, 60));

        JPanel panel_buttonDanhSach = new JPanel();
		add(panel_buttonDanhSach);
		panel_buttonDanhSach.setLayout(new GridLayout(1, 0, 0, 0));

		buttonDanhSach = new Button_SideBar("Danh sách NFT");
		panel_buttonDanhSach.add(buttonDanhSach);
//		buttonDanhSach.setPreferredSize(new Dimension(250, 60));

        JPanel panel_buttonTinTuc = new JPanel();
		add(panel_buttonTinTuc);
		panel_buttonTinTuc.setLayout(new GridLayout(0, 1, 0, 0));

		buttonTinTuc = new Button_SideBar("Danh sách tin tức");
		panel_buttonTinTuc.add(buttonTinTuc);
//		buttonTinTuc.setPreferredSize(new Dimension(250, 60));

        JPanel panel_buttonBaiViet = new JPanel();
		add(panel_buttonBaiViet);
		panel_buttonBaiViet.setLayout(new GridLayout(0, 1, 0, 0));

		buttonBaiViet = new Button_SideBar("Danh sách bài viết");
		panel_buttonBaiViet.add(buttonBaiViet);
//		buttonBaiViet.setPreferredSize(new Dimension(250, 60));

        JPanel panel_buttonThongKe = new JPanel();
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

        JPanel panel_buttonCapNhat = new JPanel();
		panel_buttonCapNhat.setBackground(Colors.Vang);
		add(panel_buttonCapNhat);

        Button_Chung buttonCapNhat = new Button_Chung("Cập nhật dữ liệu");
		buttonCapNhat.setBackground(Colors.Den);
		buttonCapNhat.setForeground(Colors.Vang);
		buttonCapNhat.setPreferredSize(new Dimension(200, 60));
		panel_buttonCapNhat.add(buttonCapNhat);
		buttonCapNhat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                try {
                    RunCrawlerAll.main(new String[]{});
                } catch (IOException | InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
		});
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