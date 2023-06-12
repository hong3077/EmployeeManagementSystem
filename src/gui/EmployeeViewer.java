package gui;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import employee.EmployeeInput;
import manager.EmployeeManager;

public class EmployeeViewer extends JPanel {
	WindowFrame frame;
	EmployeeManager employeeManager;
	
	public EmployeeViewer(WindowFrame frame, EmployeeManager employeeManager) {
		this.frame = frame;
		this.employeeManager = employeeManager;
		System.out.println("***" + employeeManager.size() + "***");
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("E-mail");
		model.addColumn("Contact Info.");
		
		for (int i=0; i<employeeManager.size(); i++) {
			Vector row = new Vector();
			EmployeeInput ei = employeeManager.get(i);
			row.add(ei.getStaffId());
			row.add(ei.getStaffName());
			row.add(ei.getStaffEmail());
			row.add(ei.getStaffPhone());
			model.addRow(row);
			
		}
		
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
		
		this.add(sp);
	}
}
