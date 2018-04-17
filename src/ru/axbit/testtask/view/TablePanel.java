package ru.axbit.testtask.view;

import java.awt.*;

import javax.swing.*;

public class TablePanel extends JPanel {
	private JTable table;
	public TablePanel() {
		
		setLayout(new BorderLayout());
		
		
		
		table = new JTable(new Object[][] {{"123","222"},{"12","31"}}, new String[] {"ISBN", "Theme"} );	//TODO: fix this shit
		
		table.getTableHeader().setReorderingAllowed(false);	//disable possibility to reorder columns with mouse drag
		table.setDragEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		add(scrollPane);
		
		
	}
	//public fillTable()
}
