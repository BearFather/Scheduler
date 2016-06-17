package net.bearfather.Scheduler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSpinner;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings({ "unchecked", "rawtypes" }) 
class AddWorkerFrame extends JFrame implements ActionListener,WindowListener {
	private HashMap<String,String> fnames=Scheduler.fnames;
	private String[] names;
	private static final long serialVersionUID = 1L;
	private JFrame frmWorkers=new JFrame();
	private JComboBox cbnames;
	private JButton btnAdd = new JButton("Add");
	private JButton btnRem = new JButton("Remove");
	private DayFrame par;
	AddWorkerFrame(DayFrame par) {
		this.par=par;
		String[] snames=Scheduler.prop.getProperty("workers").split(",");
		names=new String[snames.length];
		int c=0;
		for (String name:snames){
			String[] sname=name.split("[.]");
			names[c]=sname[0];
			c++;
		}
		cbnames=new JComboBox(names);
		setupPanel();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object es=e.getSource();
		if (es.equals(btnAdd)){
			String workers=par.tworkers.getText();
			String name=(String) cbnames.getSelectedItem();
			String iname=fnames.get(name);
			String iworkers=Scheduler.cf.wrks.get(par.pane).getText();
			if (workers.length()>1){
				par.tworkers.setText(workers+"\n"+name);
				Scheduler.cf.wrks.get(par.pane).setText(iworkers+","+iname);
			}
			else {
				par.tworkers.setText(name);
				Scheduler.cf.wrks.get(par.pane).setText(iname);
			}
			addWorker(par.pane,name,par.spinner);
			frmWorkers.dispose();
			Scheduler.cf.setVisible(true);
			Scheduler.df.frmEdit.setEnabled(true);
			Scheduler.df.frmEdit.setVisible(true);
		}else if (es.equals(btnRem)){
			//name
			String names=par.tworkers.getText();
			String[] b=names.split("\n");
			String chk=(String) cbnames.getSelectedItem();
			String fin="";
			int c=0;
			for (String name:b){
				if (name.equals(chk)){
					int c2=0;
					for (String v:b){
						if (c2!=c){
							fin=fin+v+"\n";
						}
						c2++;
					}
					
				}
				c++;
			}
			par.tworkers.setText(fin.trim());
			//initals 
			String inames=Scheduler.cf.wrks.get(par.pane).getText();
			String[] ib=inames.split(",");
			String ifin="";
			c=0;
			for (String iname:ib){
				if (iname.equals(fnames.get(chk))){
					int c2=0;
					for (String v:ib){
						if (c2!=c){
							ifin=ifin+v+",";
						}
						c2++;
					}
					
				}
				c++;
			}
			ifin=ifin.trim();
			if (ifin.endsWith(",")){ifin=ifin.substring(0, ifin.length()-1);}
			Scheduler.cf.wrks.get(par.pane).setText(ifin);
			
			
			remWorker(par.pane,chk,par.spinner);
			frmWorkers.setVisible(false);
			Scheduler.cf.setVisible(true);
			par.frmEdit.setEnabled(true);
			par.frmEdit.setVisible(true);
		}
	}
	private static void addWorker(int pane,String name,JSpinner spinner){
		
		ArrayList<String> workers=Scheduler.workers.get(pane);
		int cnt=workers.size()-1;
		if (!workers.contains(name)){
			workers.add(name);
			cnt++;
			if (cnt<1){cnt=1;}
			workers.set(0,Integer.toString(cnt));
			if (spinner!=null){spinner.setValue(cnt);}
		}
	}
	private static void remWorker(int pane,String name,JSpinner spinner){
		
		ArrayList<String> workers=Scheduler.workers.get(pane);
		int cnt=workers.size()-1;
		if (workers.contains(name)){
			workers.remove(name);
			cnt--;
			if (cnt<1){cnt=1;}
			workers.set(0,Integer.toString(cnt));
			if (spinner!=null){spinner.setValue(cnt);}
		}
	}
	@SuppressWarnings("static-access")
	
	private void setupPanel(){
		setDefaultCloseOperation(frmWorkers.DISPOSE_ON_CLOSE);
		frmWorkers.getContentPane().setLayout(null);
		cbnames.setBounds(10, 11, 160, 20);
		frmWorkers.getContentPane().add(cbnames);
		btnAdd.setBounds(10, 42, 69, 23);
		frmWorkers.getContentPane().add(btnAdd);
		btnAdd.addActionListener(this);
		btnRem.setBounds(89, 42, 81, 23);
		frmWorkers.getContentPane().add(btnRem);
		btnRem.addActionListener(this);
		frmWorkers.setIconImage(Toolkit.getDefaultToolkit().getImage(AddWorkerFrame.class.getResource("/res/icon.png")));
		frmWorkers.addWindowListener(this);
		frmWorkers.setTitle("Workers");
		frmWorkers.setLocation(Scheduler.setLoc());
		frmWorkers.setSize(196,113);
		frmWorkers.setVisible(true);
	}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {
		Scheduler.cf.setVisible(true);
		Scheduler.df.frmEdit.setEnabled(true);
		Scheduler.df.frmEdit.setVisible(true);
	}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowOpened(WindowEvent e) {}
}
