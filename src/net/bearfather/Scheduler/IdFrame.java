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

class IdFrame extends JDialog implements ItemListener,WindowListener {
	private static final long serialVersionUID = 1L;
	private boolean cf=true;
	private @SuppressWarnings("rawtypes")
	JComboBox cbajobs = new JComboBox();
	private boolean del=false;
	@SuppressWarnings("unchecked") IdFrame(boolean del){
		this.del=del;
		cbajobs.addItem(" --- None --- ");
		for (Job job:Scheduler.availJobs.values()){
				cbajobs.addItem(job.getId()+" : "+job.getName());
		}
		setupPanel();
	}
	@SuppressWarnings("static-access")
	private void setupPanel(){
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		cbajobs.setBounds(10, 41, 185, 20);
		getContentPane().add(cbajobs);
		cbajobs.addItemListener(this);
		setTitle("Job List");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IdFrame.class.getResource("/res/icon.png")));
		
		JLabel lblPleaseChooseA = new JLabel("Please choose a job to edit.");
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
			String[] item=cbajobs.getSelectedItem().toString().split(":");
			if (!del){
				new JobFrame(item[0]);
				cf=false;
				this.setVisible(false);
			}else if(del){
				cbajobs.setPopupVisible(false);
				int rtn = JOptionPane.showConfirmDialog(this,"Are you sure you want to remove "+cbajobs.getSelectedItem().toString()+"?\n There is no undo!"
						,"DELETE?",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (rtn==0){
					int results=Data.delete("jobs", item[0].trim(), "jobs");
					if (results==1){
						JOptionPane.showMessageDialog(this, "Job was removed.");
						Scheduler.availJobs.remove(item[0].trim());
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
