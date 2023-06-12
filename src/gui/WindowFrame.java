package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import manager.EmployeeManager;

public class WindowFrame extends JFrame {

	EmployeeManager employeeManager;
	MenuSelection menuSelection;
	EmployeeAddr employeeAddr;
	EmployeeViewer employeeViewer;
	
	
	public WindowFrame(EmployeeManager employeeManager) {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Frame");

		this.employeeManager = employeeManager;
		menuSelection = new MenuSelection(this);
		employeeAddr = new EmployeeAddr(this);
		employeeViewer = new EmployeeViewer(this, this.employeeManager);
	
		this.add(menuSelection);
		
		this.setVisible(true);
	}
	
	
	public void SetupPanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.revalidate();
		this.repaint();
	}
	
	public MenuSelection getMenuSelection() {
		return menuSelection;
	}

	public void setMenuSelection(MenuSelection menuSelection) {
		this.menuSelection = menuSelection;
	}

	public EmployeeAddr getEmployeeAddr() {
		return employeeAddr;
	}

	public void setEmployeeAddr(EmployeeAddr employeeAddr) {
		this.employeeAddr = employeeAddr;
	}

	public EmployeeViewer getEmployeeViewer() {
		return employeeViewer;
	}

	public void setEmployeeViewer(EmployeeViewer employeeViewer) {
		this.employeeViewer = employeeViewer;
	}
}
