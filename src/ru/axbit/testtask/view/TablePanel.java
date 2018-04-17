package ru.axbit.testtask.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ru.axbit.testtask.controller.TableController;

public class TablePanel extends JPanel {
	
	private JTable table;
	public TablePanel(int viewMode) {
		
		setLayout(new BorderLayout());
		
		DefaultTableModel tModel = new DefaultTableModel();
		
		if(viewMode == ViewMode.BOOK) {			
			tModel.addColumn("ISBN");
			tModel.addColumn("Theme");
			
		} else if(viewMode == ViewMode.AUTHOR) {
			tModel.addColumn("Name");
			tModel.addColumn("Second Name");
			tModel.addColumn("Last Name");
			tModel.addColumn("Birth Date");
		}
		
		table = new JTable(tModel);		
		
		table.getTableHeader().setReorderingAllowed(false);	//disable possibility to reorder columns with mouse drag
		table.setDragEnabled(false);
		
		//TODO: add table filling
		TableController.fillTable(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(scrollPane);
		
	}
	
}
