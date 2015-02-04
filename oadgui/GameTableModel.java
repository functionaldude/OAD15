package oadgui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import oad.game;

public class GameTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	public static String[] columnNames = {"ID", "Name", "UserName", "Rating", "Privacy"};
	private List<game> gamelist;
	
	public GameTableModel(List<game> input){
		gamelist = input;
	}
	
	@Override
	public int getRowCount() {
		return gamelist.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		game gm = gamelist.get(rowIndex);
		
		switch (columnIndex){
		case 0: return gm.getID();
		case 1: return gm.getName();
		case 2: return gm.getUserName();
		case 3: 
			try {
				return gm.getRating();
			} catch (Exception e) {
				return "Not Enough Rating";
			}
		case 4: return gm.getPrivacy();
		default: return null;
		}
	}

}
