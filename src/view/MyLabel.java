package view;

import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel{
	
	 public MyLabel(String item) {
		 super("   "+item+" ");
		 customizeMyLabel();
	 }
	 
	 private void customizeMyLabel() {
		 setFont(new Font("Arial", Font.PLAIN, 16));

	 }

}
