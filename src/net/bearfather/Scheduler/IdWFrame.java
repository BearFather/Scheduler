package net.bearfather.Scheduler;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Toolkit;

class IdWFrame extends JDialog implements ItemListener,WindowListener {
	private static final long serialVersionUID = 1L;
	private boolean cf=true;
	private @SuppressWarnings("rawtypes")
	JComboBox cbawo = new JComboBox();
	private boolean del=false;
	@SuppressWarnings("unchecked") IdWFrame(boolean del){
		this.del=del;
		cbawo.addItem(" --- None --- ");
		for (WorkOrder wo:Scheduler.workorders.values()){
				cbawo.addItem(wo.getId()+" : "+wo.getName());
		}
		setupPanel();
	}
	@SuppressWarnings("static-access")
	private void setupPanel(){
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		cbawo.setBounds(10, 41, 185, 20);
		getContentPane().add(cbawo);
		cbawo.addItemListener(this);
		setTitle("WorkOrder List");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IdWFrame.class.getResource("/res/icon.png")));
		
		JLabel lblPleaseChooseA = new JLabel("Please choose a work order to edit.");
		lblPleaseChooseA.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseChooseA.setBounds(10, 16, 185, 14);
		getContentPane().add(lblPleaseChooseA);
		this.addWindowListener(this);
		this.setLocation(Scheduler.setLoc());
		this.setSize(234,130);
		this.setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED){
			String[] item=cbawo.getSelectedItem().toString().split(":");
			if (!del){
				new WorkOrderFrame(item[0]);
				cf=false;
				this.setVisible(false);
			}else if(del){
				cbawo.setPopupVisible(false);
				int rtn = JOptionPane.showConfirmDialog(this,"Are you sure you want to remove "+cbawo.getSelectedItem().toString()+"?\n There is no undo!"
						,"DELETE?",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (rtn==0){
					int results=Data.delete("wo", item[0].trim(), "jobs");
					if (results==1){
						JOptionPane.showMessageDialog(this, "Job was removed.");
						Scheduler.workorders.remove(item[0].trim());
						Scheduler.closeCF();
						this.setVisible(false);
					}else if (results==0){JOptionPane.showMessageDialog(this,"Unable to delete the record.\nTry reopening the window to refresh");}
				}
			}
		}
	}
	@Override
	public void windowActivated(WindowEvent arg0) {}
	@Override
	public void windowClosed(WindowEvent arg0) {
		if (cf){Scheduler.closeCF();}
	}
	@Override
	public void windowClosing(WindowEvent arg0) {}
	@Override
	public void windowDeactivated(WindowEvent arg0) {}
	@Override
	public void windowDeiconified(WindowEvent arg0) {}
	@Override
	public void windowIconified(WindowEvent arg0) {}
	@Override
	public void windowOpened(WindowEvent arg0) {}
}
