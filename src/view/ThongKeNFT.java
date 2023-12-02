package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ThongKeNFT extends JPanel {

	/**
	 * Create the panel.
	 */
	public ThongKeNFT() {
		
		setBackground(Colors.TrangDuc);
		setBorder(new LineBorder(Colors.Trang, 20, true));
		setPreferredSize(new Dimension(1085, 730));
		setLayout(new BorderLayout(0, 0));
		
		MyPanel panel_TKe_Filter = new MyPanel();
		add(panel_TKe_Filter, BorderLayout.NORTH);
		
		MyPanel panel_TKe_Content = new MyPanel();
		add(panel_TKe_Content, BorderLayout.CENTER);
		
	}

}
