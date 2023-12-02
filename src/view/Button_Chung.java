package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Button_Chung extends JButton {
	
    public Button_Chung(String text) {
        super(text);
        customizeButton_SideBar();
    }

    private void customizeButton_SideBar() {
        setBackground(Colors.Den);
        setForeground(Colors.Vang);
        setFont(new Font("Arial", Font.BOLD, 16));
        setHorizontalAlignment(SwingConstants.CENTER);
    }
    
}