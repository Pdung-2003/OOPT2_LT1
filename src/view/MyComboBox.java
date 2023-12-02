package view;

import java.awt.Font;

import javax.swing.JComboBox;

public class MyComboBox extends JComboBox<String>{
	
	 public MyComboBox(String[] items) {
		 super(items);
		 customizeMyComboBox();
	 }
	 
	 private void customizeMyComboBox() {
		 setFont(new Font("Arial", Font.PLAIN, 16));
		 setPrototypeDisplayValue("123456789012345");

	 }
	 
}
