package net.niko.gui;

import lombok.Getter;
import net.niko.ByteCodeViewer;

import javax.swing.*;

@Getter
public class Gui
{

    private Window window;
    private JFrame frame;

    public Gui(){
        window = new Window(ByteCodeViewer.TITLE, ByteCodeViewer.WIDTH, ByteCodeViewer.HEIGHT);
        frame = window.createWindow();


        frame.setVisible(true);
    }

}
