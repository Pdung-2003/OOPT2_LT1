package view;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

import view.Panels.*;
import view.Labels.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.List;

import javax.swing.border.MatteBorder;

public class BlogDetail extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_BlogDetail_Title;
	private MyLabel lbl_BlogDetail_Content_Main_UserId;
	private MyLabel lbl_BlogDetail_Content_Main_Author;
	private MyLabel lbl_BlogDetail_Content_Main_Date;
	private MyLabel lbl_BlogDetail_Content_Main_Hashtag;
	private JLabel lbl_BlogDetail_Content_Img;
	private JTextArea textArea_BlogDetail_Content_Main_Text;
	public BlogDetail() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 710, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// Khu vực tiêu đề blog
		JPanel panel_BlogDetail_Title = new JPanel();
		panel_BlogDetail_Title.setBackground(Colors.Den);
		contentPane.add(panel_BlogDetail_Title, BorderLayout.NORTH);
		panel_BlogDetail_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		lbl_BlogDetail_Title = new JLabel(); // Điền tiêu đề blog vào đây
		lbl_BlogDetail_Title.setForeground(Colors.Vang);
		lbl_BlogDetail_Title.setFont(new Font("Arial", Font.BOLD, 22));
		panel_BlogDetail_Title.add(lbl_BlogDetail_Title);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		// Khu vực thông tin chính của blog
		MyPanel panel_BlogDetail_Content = new MyPanel();
		scrollPane.setViewportView(panel_BlogDetail_Content);
		panel_BlogDetail_Content.setLayout(new BoxLayout(panel_BlogDetail_Content, BoxLayout.Y_AXIS));

		// Khu vực in ảnh
		MyPanel panel_BlogDetail_Content_Img = new MyPanel();
		panel_BlogDetail_Content.add(panel_BlogDetail_Content_Img);
		panel_BlogDetail_Content_Img.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));

		lbl_BlogDetail_Content_Img = new JLabel();
		lbl_BlogDetail_Content_Img.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BlogDetail_Content_Img.add(lbl_BlogDetail_Content_Img);

		MyPanel panel_BlogDetail_Content_Main = new MyPanel();
		panel_BlogDetail_Content.add(panel_BlogDetail_Content_Main);
		panel_BlogDetail_Content_Main.setLayout(new BoxLayout(panel_BlogDetail_Content_Main, BoxLayout.Y_AXIS));
		
		// Khu vực userid blog
		MyPanel panel_BlogDetail_Content_Main_UserId = new MyPanel();
		panel_BlogDetail_Content_Main.add(panel_BlogDetail_Content_Main_UserId);
		panel_BlogDetail_Content_Main_UserId.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		lbl_BlogDetail_Content_Main_UserId = new MyLabel(""); // Điền user id vào đây
		panel_BlogDetail_Content_Main_UserId.add(lbl_BlogDetail_Content_Main_UserId);
		
		// Khu vực tên tác giả blog
		MyPanel panel_BlogDetail_Content_Main_Author = new MyPanel();
		panel_BlogDetail_Content_Main.add(panel_BlogDetail_Content_Main_Author);
		panel_BlogDetail_Content_Main_Author.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		lbl_BlogDetail_Content_Main_Author = new MyLabel(""); // Điền tác giả vào đây
		panel_BlogDetail_Content_Main_Author.add(lbl_BlogDetail_Content_Main_Author);
		
		// Khu vực ngày xuất bản blog
		MyPanel panel_BlogDetail_Content_Main_Date = new MyPanel();
		panel_BlogDetail_Content_Main.add(panel_BlogDetail_Content_Main_Date);
		panel_BlogDetail_Content_Main_Date.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		lbl_BlogDetail_Content_Main_Date = new MyLabel(""); // Điền ngày xuất bản vào đây
		panel_BlogDetail_Content_Main_Date.add(lbl_BlogDetail_Content_Main_Date);
		
		// Khu vực hashtag blog
		MyPanel panel_BlogDetail_Content_Main_Hashtag = new MyPanel();
		panel_BlogDetail_Content_Main_Hashtag.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_BlogDetail_Content_Main.add(panel_BlogDetail_Content_Main_Hashtag);
		panel_BlogDetail_Content_Main_Hashtag.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		lbl_BlogDetail_Content_Main_Hashtag = new MyLabel(""); // Điền hashtag vào đây
		panel_BlogDetail_Content_Main_Hashtag.add(lbl_BlogDetail_Content_Main_Hashtag);

		// Khu vực nội dung chính của blog
		MyPanel panel_BlogDetail_Content_Main_Text = new MyPanel();
		panel_BlogDetail_Content_Main.add(panel_BlogDetail_Content_Main_Text);
		panel_BlogDetail_Content_Main_Text.setLayout(new BoxLayout(panel_BlogDetail_Content_Main_Text, BoxLayout.Y_AXIS));

		// Định nghĩa TextArea
		textArea_BlogDetail_Content_Main_Text = new JTextArea();
		textArea_BlogDetail_Content_Main_Text.setFont(new Font("Arial", Font.PLAIN, 14));
		textArea_BlogDetail_Content_Main_Text.setSelectionStart(1);
		textArea_BlogDetail_Content_Main_Text.setLineWrap(true);
		textArea_BlogDetail_Content_Main_Text.setWrapStyleWord(true);
		textArea_BlogDetail_Content_Main_Text.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
		textArea_BlogDetail_Content_Main_Text.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Nội dung text area
		textArea_BlogDetail_Content_Main_Text.setText(""); // Điền nội dung chính cần hiển thị vào đây
		textArea_BlogDetail_Content_Main_Text.setEditable(false);
		panel_BlogDetail_Content_Main_Text.add(textArea_BlogDetail_Content_Main_Text);
		
		panel_BlogDetail_Content.add(Box.createVerticalGlue());
		setVisible(true);
	}

	public void updateBlogDetail(String rowData, String img, String author, String date, String hashtag, String content) {
		SwingUtilities.invokeLater(() -> {
			System.out.println("Updating title: " + rowData);
			lbl_BlogDetail_Title.setText(rowData);
			lbl_BlogDetail_Content_Main_Author.setText("Tác giả: " + author);
			lbl_BlogDetail_Content_Main_Date.setText("Thời gian: " + date);
			lbl_BlogDetail_Content_Main_Hashtag.setText("Hashtag: " + hashtag);
			textArea_BlogDetail_Content_Main_Text.setText("Nội dung: \n" + content);

			// Xử lý hiển thị hình ảnh
			try {
				URL imageUrl = new URL(img);
				Image image = ImageIO.read(imageUrl);
				Image scaledImage = image.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
				ImageIcon imageIcon = new ImageIcon(scaledImage);
				lbl_BlogDetail_Content_Img.setIcon(imageIcon);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	public void updateBlogTwitter(String rowData, List<String> imgList, String author, String date, String hashtag, String content) {
		SwingUtilities.invokeLater(() -> {
			System.out.println("Updating title: " + rowData);
			lbl_BlogDetail_Title.setText(rowData);
			lbl_BlogDetail_Content_Main_Author.setText("Tác giả: " + author);
			lbl_BlogDetail_Content_Main_Date.setText("Thời gian: " + date);
			lbl_BlogDetail_Content_Main_Hashtag.setText("Hashtag: " + hashtag);
			textArea_BlogDetail_Content_Main_Text.setText("Nội dung: \n" + content);

			// Xử lý hiển thị hình ảnh
			if (!imgList.isEmpty()) {
				try {
					String imageUrl = imgList.get(0);
					URL url = new URL(imageUrl);
					Image image = ImageIO.read(url);
					Image scaledImage = image.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
					ImageIcon imageIcon = new ImageIcon(scaledImage);
					lbl_BlogDetail_Content_Img.setIcon(imageIcon);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Thêm một phương thức để cập nhật giao diện
	public void updateUI() {
		revalidate();
		repaint();
	}
}
