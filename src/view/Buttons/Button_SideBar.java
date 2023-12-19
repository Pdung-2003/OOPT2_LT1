package view.Buttons;

import view.Colors;

import javax.swing.*;
import java.awt.Font;

public class Button_SideBar extends CustomizedButton {

    public Button_SideBar(String text) {
        super(text);
    }

    protected void customizeButton() {
        setBackground(Colors.Vang);
        setForeground(Colors.Chu);
        setFont(new Font("Arial", Font.BOLD, 16));
        setHorizontalAlignment(SwingConstants.LEFT);
    }

}