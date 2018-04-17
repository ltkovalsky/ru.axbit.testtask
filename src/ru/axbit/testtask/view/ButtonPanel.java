package ru.axbit.testtask.view;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
	public ButtonPanel() {
		setLayout(new GridLayout(1, 3));
		JButton btnAdd = new JButton("Добавить");
		JButton btnDel = new JButton("Удалить");
		JButton btnEdit = new JButton("Редактировать");
		
		btnAdd.setName("add");
		btnDel.setName("del");
		btnEdit.setName("edit");
		
		
		
		add(btnAdd);
		add(btnDel);
		add(btnEdit);
		
	}
}
