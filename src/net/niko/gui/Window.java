package net.niko.gui;

import lombok.AllArgsConstructor;

import javax.swing.*;
import java.awt.*;

@AllArgsConstructor
public class Window
{

    private String title;
    private int width;
    private int height;

    public JFrame createWindow(){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){};

        JFrame frame = new JFrame(this.title);
        frame.setSize(width, height);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        return frame;
    }

}
