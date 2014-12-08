package oadgui;

import java.util.Enumeration;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import oad.User;

public class UserTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	public String[] columnNames = {"ID", "Username", "PW", "E-Mail"};
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
	
	public String[][] getData(){
		String[][] retval = new String[getRowCount()][getColumnCount()];
		for (int i = 0; i < getRowCount(); i++){
			retval[i][0] = new String(getValueAt(i,0).toString());
			retval[i][1] = new String(getValueAt(i,1).toString());
			retval[i][2] = new String(getValueAt(i,2).toString());
			retval[i][3] = new String(getValueAt(i,3).toString());
		}
		return retval;
	}
}
