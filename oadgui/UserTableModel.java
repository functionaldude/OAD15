package oadgui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import oad.User;

public class UserTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private String[] columnNames = {"ID", "Username", "PW", "E-Mail"};
	private List<User> userlist;
	
	public UserTableModel(List<User> input){
		userlist = input;
	}

	@Override
	public int getRowCount() {
		return userlist.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		User usr = userlist.get(rowIndex);
		
		switch (columnIndex){
		case 0: return usr.getID();
		case 1: return usr.getUserName();
		case 2: return usr.getPW();
		case 3: return usr.getEmail();
		default: return null;
		}
	}
	
}
