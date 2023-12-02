package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ManHinhChinh extends JFrame {

	/**
	 * Create the panel.
	 */
	public ManHinhChinh() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setPreferredSize(new Dimension(1335, 780));
        setLayout(new BorderLayout(0, 0));

        DanhSachNFT panel_DanhSach = new DanhSachNFT();

        TimKiemNFT panel_TimKiem = new TimKiemNFT();

        ThongKeNFT panel_ThongKe = new ThongKeNFT();

        SideBar sidebar = new SideBar();
        add(sidebar, BorderLayout.WEST);

        JPanel content = new JPanel();
        ;
        add(content, BorderLayout.CENTER);
        content.setLayout(new BorderLayout(20, 5));

        JPanel panel_Content_Title = new JPanel();
        content.add(panel_Content_Title, BorderLayout.NORTH);
        panel_Content_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

        JLabel lbl_Content_Title = new JLabel("Danh sách NFT"); // ten chuc nang (Danh Sach NFT, Tim Kiem Du Lieu, Thong Ke Du Lieu)
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
        CardLayout cardLayout = new CardLayout(0,0);
        panel_Content_Main.setLayout(cardLayout);
        panel_Content_Main.add(panel_DanhSach,"1");
        panel_Content_Main.add(panel_TimKiem,"2");
        panel_Content_Main.add(panel_ThongKe,"3");

        Component componentAtIndex = sidebar.getComponent(0);
        JButton buttonDanhSach = null, buttonTimKiem = null, buttonThongKe = null;
        if (componentAtIndex instanceof JButton) {
			buttonDanhSach = (JButton) componentAtIndex;
        }

        Component componentAtIndex1 = sidebar.getComponent(1);
        if (componentAtIndex instanceof JButton) {
			buttonTimKiem = (JButton) componentAtIndex1;
        }

        Component componentAtIndex2 = sidebar.getComponent(2);
        if (componentAtIndex instanceof JButton) {
			buttonThongKe = (JButton) componentAtIndex2;
        }

        buttonDanhSach.addActionListener(e -> showCard(panel_Content_Main, "1",lbl_Content_Title,"Danh sách NFT"));
        buttonTimKiem.addActionListener(e -> showCard(panel_Content_Main, "2",lbl_Content_Title,"Tìm kiếm dữ liệu"));
        buttonThongKe.addActionListener(e -> showCard(panel_Content_Main, "3",lbl_Content_Title,"Thống kê dữ liệu"));
    }

    private static void showCard(Container container, String cardName, JLabel lbl_Content_Title, String title) {
            lbl_Content_Title.setText(title);
            CardLayout cardLayout = (CardLayout) container.getLayout();
            cardLayout.show(container, cardName);
    }
}