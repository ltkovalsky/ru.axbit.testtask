package ru.axbit.testtask.view;

import javax.swing.*;

import ru.axbit.testtask.controller.ButtonController;

import java.awt.*;

public class ButtonPanel extends JPanel {
	
	public ButtonPanel(int viewMode) {
		setLayout(new GridLayout(1, 3));
		JButton btnAdd = new JButton("Добавить");
		JButton btnDel = new JButton("Удалить");
		JButton btnEdit = new JButton("Редактировать");
		
		
		
		
		
		add(btnAdd);
		add(btnDel);
		add(btnEdit);
		
	}
}
