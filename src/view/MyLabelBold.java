package view;

import java.awt.Font;

import javax.swing.JLabel;

public class MyLabelBold extends JLabel{

	 public MyLabelBold(String item) {
		 super(item);
		 customizeMyLabel();
	 }
	 
	 private void customizeMyLabel() {
		 setFont(new Font("Arial", Font.BOLD, 16));
	 }
	
}
