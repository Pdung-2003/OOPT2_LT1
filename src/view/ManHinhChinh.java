package view;

import java.awt.*;
import javax.swing.*;

public class ManHinhChinh extends JFrame {
        private ContentPanel contentPanel;
        private SideBar sidebar;

        public ManHinhChinh() {
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                setPreferredSize(new Dimension(1335, 780));
                setLayout(new BorderLayout());

                JPanel main_content = new JPanel(new BorderLayout(20,5));
                add(main_content,BorderLayout.CENTER);

                JPanel panel_Content_Title = new JPanel();
                main_content.add(panel_Content_Title, BorderLayout.NORTH);
                panel_Content_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

                JLabel lbl_Content_Title = new JLabel("Danh sách NFT"); // ten chuc nang (Danh Sach NFT, Tim Kiem Du Lieu, Thong Ke Du Lieu)
                lbl_Content_Title.setFont(new Font("Arial", Font.BOLD, 20));
                panel_Content_Title.add(lbl_Content_Title);

                JPanel panel_Dem_01 = new JPanel();
                main_content.add(panel_Dem_01, BorderLayout.WEST);

                JPanel panel_Dem_02 = new JPanel();
                main_content.add(panel_Dem_02, BorderLayout.EAST);

                JPanel panel_3 = new JPanel();
                main_content.add(panel_3, BorderLayout.SOUTH);

                sidebar = new SideBar();
                add(sidebar, BorderLayout.WEST);

                contentPanel = new ContentPanel();
                main_content.add(contentPanel, BorderLayout.CENTER);

                JButton buttonDanhSach = sidebar.getButtonDanhSach();
                JButton buttonTimKiem = sidebar.getButtonTimKiem();
                JButton buttonThongKe = sidebar.getButtonThongKe();
                JButton buttonBlog = sidebar.getButtonBlog();

                buttonDanhSach.addActionListener(e -> contentPanel.showCard("Danh sách NFT", lbl_Content_Title,"Danh sách NFT"));
                buttonTimKiem.addActionListener(e -> contentPanel.showCard("Tìm kiếm dữ liệu", lbl_Content_Title,"Tìm kiếm dữ liệu"));
                buttonThongKe.addActionListener(e -> contentPanel.showCard("Thống kê dữ liệu", lbl_Content_Title,"Thống kê dữ liệu"));
                buttonBlog.addActionListener(e -> contentPanel.showCard("Danh sách blog", lbl_Content_Title,"Danh sách blog"));
        }
}
