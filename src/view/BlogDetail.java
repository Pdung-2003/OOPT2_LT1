package view;

import java.awt.EventQueue;
import view.Panels.*;
import view.Labels.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class BlogDetail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlogDetail frame = new BlogDetail();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BlogDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lbl_BlogDetail_Title = new JLabel("Tiêu đề blog để ở đây"); // Điền tiêu đề blog vào đây
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
		
		JLabel lbl_BlogDetail_Content_Img = new JLabel();
		lbl_BlogDetail_Content_Img.setPreferredSize(new Dimension(70, 70));
		lbl_BlogDetail_Content_Img.setMaximumSize(new Dimension(100, 100));
		lbl_BlogDetail_Content_Img.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(BlogDetail.class.getResource("a.jpg"))));
		lbl_BlogDetail_Content_Img.setHorizontalAlignment(SwingConstants.CENTER);
		panel_BlogDetail_Content_Img.add(lbl_BlogDetail_Content_Img);
		
//		JLabel lbl_BlogDetail_Content_Img = new JLabel("Ảnh in ở đây"); // In ảnh vào đay
//		panel_BlogDetail_Content_Img.add(lbl_BlogDetail_Content_Img);
		
		MyPanel panel_BlogDetail_Content_Main = new MyPanel();
		panel_BlogDetail_Content.add(panel_BlogDetail_Content_Main);
		panel_BlogDetail_Content_Main.setLayout(new BoxLayout(panel_BlogDetail_Content_Main, BoxLayout.Y_AXIS));
		
		// Khu vực userid blog
		MyPanel panel_BlogDetail_Content_Main_UserId = new MyPanel();
		panel_BlogDetail_Content_Main.add(panel_BlogDetail_Content_Main_UserId);
		panel_BlogDetail_Content_Main_UserId.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		MyLabel lbl_BlogDetail_Content_Main_UserId = new MyLabel("User ID: "); // Điền user id vào đây
		panel_BlogDetail_Content_Main_UserId.add(lbl_BlogDetail_Content_Main_UserId);
		
		// Khu vực tên tác giả blog
		MyPanel panel_BlogDetail_Content_Main_Author = new MyPanel();
		panel_BlogDetail_Content_Main.add(panel_BlogDetail_Content_Main_Author);
		panel_BlogDetail_Content_Main_Author.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		MyLabel lbl_BlogDetail_Content_Main_Author = new MyLabel("Tác giả: "); // Điền tác giả vào đây
		panel_BlogDetail_Content_Main_Author.add(lbl_BlogDetail_Content_Main_Author);
		
		// Khu vực ngày xuất bản blog
		MyPanel panel_BlogDetail_Content_Main_Date = new MyPanel();
		panel_BlogDetail_Content_Main.add(panel_BlogDetail_Content_Main_Date);
		panel_BlogDetail_Content_Main_Date.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		MyLabel lbl_BlogDetail_Content_Main_Date = new MyLabel("Ngày xuất bản: "); // Điền ngày xuất bản vào đây
		panel_BlogDetail_Content_Main_Date.add(lbl_BlogDetail_Content_Main_Date);
		
		// Khu vực hashtag blog
		MyPanel panel_BlogDetail_Content_Main_Hashtag = new MyPanel();
		panel_BlogDetail_Content_Main_Hashtag.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_BlogDetail_Content_Main.add(panel_BlogDetail_Content_Main_Hashtag);
		panel_BlogDetail_Content_Main_Hashtag.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		MyLabel lbl_BlogDetail_Content_Main_Hashtag = new MyLabel("hehe"); // Điền hashtag vào đây
		panel_BlogDetail_Content_Main_Hashtag.add(lbl_BlogDetail_Content_Main_Hashtag);
		
		// Khu vực nội dung chính của blog
		MyPanel panel_BlogDetail_Content_Main_Text = new MyPanel();
		panel_BlogDetail_Content_Main.add(panel_BlogDetail_Content_Main_Text);
		panel_BlogDetail_Content_Main_Text.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JTextArea textArea_BlogDetail_Content_Main_Text = new JTextArea();
		textArea_BlogDetail_Content_Main_Text.setFont(new Font("Arial", Font.PLAIN, 14));
		textArea_BlogDetail_Content_Main_Text.setSelectionStart(0);
		textArea_BlogDetail_Content_Main_Text.setText("Điền content blog vào đây"); // Điền nội dung chính cần hiển thị vào đây

		// Xử lý kích cỡ của TextArea
		FontMetrics fontMetrics = textArea_BlogDetail_Content_Main_Text.getFontMetrics(textArea_BlogDetail_Content_Main_Text.getFont());
        int textHeight = fontMetrics.getHeight() * textArea_BlogDetail_Content_Main_Text.getLineCount() + 20;
		textArea_BlogDetail_Content_Main_Text.setPreferredSize(new Dimension(630, textHeight));
		textArea_BlogDetail_Content_Main_Text.setEditable(false);
		panel_BlogDetail_Content_Main_Text.add(textArea_BlogDetail_Content_Main_Text);
		
		panel_BlogDetail_Content.add(Box.createVerticalGlue());
	}

}
