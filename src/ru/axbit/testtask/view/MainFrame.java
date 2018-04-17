package ru.axbit.testtask.view;

import java.awt.*;

import javax.swing.*;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Система \"Книги\" ");
		setBounds(0, 0, 800, 600);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new ButtonPanel(ViewMode.AUTHOR), BorderLayout.PAGE_END);
		getContentPane().add(new TablePanel(ViewMode.AUTHOR), BorderLayout.CENTER);
		setVisible(true);
	}
	
	
}
