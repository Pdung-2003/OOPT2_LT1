package view;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {
    private DanhSachNFT panel_DanhSach;
    private ThongKeNFT panel_ThongKe;
    private DanhSachTinTuc panel_TinTuc;
    private DanhSachBaiViet panel_BaiViet;
    private JLabel lbl_Content_Title;

    public ContentPanel() throws Exception {
        setLayout(new CardLayout());

        panel_DanhSach = new DanhSachNFT();
        panel_ThongKe = new ThongKeNFT();
        panel_TinTuc = new DanhSachTinTuc();
        panel_BaiViet = new DanhSachBaiViet();
        lbl_Content_Title = new JLabel("Danh sách NFT", SwingConstants.CENTER);
        lbl_Content_Title.setFont(new Font("Arial", Font.BOLD, 20));

        add(panel_DanhSach, "Danh sách NFT");
        add(panel_ThongKe, "Thống kê dữ liệu");
        add(panel_TinTuc,"Danh sách tin tức");
        add(panel_BaiViet,"Danh sách bài viết");

        CardLayout cardLayout = (CardLayout) getLayout();
        cardLayout.show(this, "Danh sách NFT");
    }


    public void showCard(String cardName, JLabel title ,String title_content) {
        title.setText(title_content);
        CardLayout cardLayout = (CardLayout) getLayout();
        cardLayout.show(this, cardName);
    }
}
