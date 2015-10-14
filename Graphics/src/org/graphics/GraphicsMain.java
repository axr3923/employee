package org.graphics;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.*;

public class GraphicsMain extends JFrame{
	
	public GraphicsMain(){
	
	}
	public void Main(){
		setTitle("Employee Time Management System");
		setSize(400,200);
		setLocation(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container=getContentPane();
		container.add(new OptionGui());
		
	}
	
	public static void main(String[] args) {
		GraphicsMain frame=new GraphicsMain();
		frame.Main();
		frame.show();
	}

}
