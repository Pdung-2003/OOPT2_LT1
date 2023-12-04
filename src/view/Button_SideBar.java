package view;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class Button_SideBar extends JButton {

    public Button_SideBar(String text) {
        super(text);
        customizeButton_SideBar();
    }

    private void customizeButton_SideBar() {
        setBackground(Colors.Vang);
        setForeground(Colors.Chu);
        setFont(new Font("Arial", Font.BOLD, 16));
        setHorizontalAlignment(SwingConstants.LEFT);
    }

}