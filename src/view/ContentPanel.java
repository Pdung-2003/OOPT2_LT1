package view;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {
    private DanhSachNFT panel_DanhSach;
    private TimKiemNFT panel_TimKiem;
    private ThongKeNFT panel_ThongKe;
    private DanhSachBlog panel_Blog;
    private JLabel lbl_Content_Title;

    public ContentPanel() {
        setLayout(new CardLayout());

        panel_DanhSach = new DanhSachNFT();
        panel_TimKiem = new TimKiemNFT();
        panel_ThongKe = new ThongKeNFT();
        panel_Blog = new DanhSachBlog();
        lbl_Content_Title = new JLabel("Danh sách NFT", SwingConstants.CENTER);
        lbl_Content_Title.setFont(new Font("Arial", Font.BOLD, 20));

        add(panel_DanhSach, "Danh sách NFT");
        add(panel_TimKiem, "Tìm kiếm dữ liệu");
        add(panel_ThongKe, "Thống kê dữ liệu");
        add(panel_Blog,"Danh sách blog");

        CardLayout cardLayout = (CardLayout) getLayout();
        cardLayout.show(this, "Danh sách NFT");
    }


    public void showCard(String cardName, JLabel title ,String title_content) {
        title.setText(title_content);
        CardLayout cardLayout = (CardLayout) getLayout();
        cardLayout.show(this, cardName);
    }
}
