package view.ComboBox;

import java.awt.Font;

import javax.swing.JComboBox;

public class MyComboBox extends CustomizedComboBox{

	public MyComboBox(String[] items) {
		super(items);
	}

	protected void customizeComboBox() {
		setFont(new Font("Arial", Font.PLAIN, 16));
		setPrototypeDisplayValue("123456789012345");

	}

}