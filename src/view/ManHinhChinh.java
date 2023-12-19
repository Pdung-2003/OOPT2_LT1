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

                sidebar = new SideBar();
                add(sidebar, BorderLayout.WEST);

                contentPanel = new ContentPanel();
                add(contentPanel, BorderLayout.CENTER);

                JButton buttonDanhSach = sidebar.getButtonDanhSach();
                JButton buttonTimKiem = sidebar.getButtonTimKiem();
                JButton buttonThongKe = sidebar.getButtonThongKe();

                buttonDanhSach.addActionListener(e -> contentPanel.showCard("Danh sách NFT", "Danh sách NFT"));
                buttonTimKiem.addActionListener(e -> contentPanel.showCard("Tìm kiếm dữ liệu", "Tìm kiếm dữ liệu"));
                buttonThongKe.addActionListener(e -> contentPanel.showCard("Thống kê dữ liệu", "Thống kê dữ liệu"));

        }
}
