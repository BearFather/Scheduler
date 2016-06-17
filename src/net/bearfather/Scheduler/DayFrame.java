package net.bearfather.Scheduler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.Toolkit;

class DayFrame extends JFrame implements ActionListener, MouseListener,WindowListener {
	private static final long serialVersionUID = 1L;
	JFrame frmEdit=new JFrame();
	private DefaultTableModel model = new DefaultTableModel(new Object[][]{{"ID", "Name","Category","Type","Hrs","Start Time"}},new Object[]{"ID", "Name","Cat","Type","Hrs","Start Time"}){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {return false;};
	}; 
	private JTable table = new JTable(model)	; 
	private JButton baddrem = new JButton("Add/Remove");
	private JButton btnOk = new JButton("Ok");
	private JButton btnAddWorkers = new JButton("Add/Remove");
	int pane=0;
	private final JLabel lblNewLabel = new JLabel("Day: ");
	private JLabel lday = new JLabel("");
	JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
	private final JLabel lblTotalHrs = new JLabel("Total Hrs per Worker: ");
	private JLabel lthr = new JLabel("");
	private int thrs=0;
	JTextPane tworkers = new JTextPane();
	private final JButton bnotes = new JButton("Notes");
	
	DayFrame(int pane) {
		this.pane=pane;
		setupPanel();
		setDay();
		fillWorkers();
	}
	private void fillWorkers(){
		int cnt=Scheduler.workers.get(pane).size();
		if (cnt>1){
			int c=0;
			String workers=tworkers.getText();
			for (String name:Scheduler.workers.get(pane)){
				if (c!=0){
					workers=workers+"\n"+name;
				}
				c++;
			}
			tworkers.setText(workers.trim());
		}
	}
	void fillRow(){
		thrs=0;
		model.setRowCount(1);
		for (Job job:Scheduler.jobs.get(pane)){
			String id=job.getId();
			String name=job.getName();
			String cat=job.sCat();
			String type=job.sType();
			int hrs=job.getLength();
			int time=0;
			if (job.getCat()==1){
				WorkOrder w=(WorkOrder)job;
				time=Data.pI(w.getStart(),0);
			}else{time=job.getDay(pane%10)[1];}
			model.addRow(new Object[]{id,name,cat,type,hrs,CalenderFrame.setTime(pane,time)});
			thrs=thrs+hrs;
			int sp=(int) spinner.getValue();
			int t=thrs/sp;
			lthr.setText(Integer.toString(t));
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object es=e.getSource();
		if (es.equals(baddrem)){
			frmEdit.setEnabled(false);
			Scheduler.arf=new AddRemFrame(pane,this);
		}else if(es.equals(btnOk)){
			int t=(int) spinner.getValue();
			Scheduler.workers.get(pane).set(0,Integer.toString(t) );
			frmEdit.dispose();
			Scheduler.cf.disPane(pane);
			Scheduler.closeCF();			

		}else if (es.equals(btnAddWorkers)){
			new AddWorkerFrame(this);
			frmEdit.setEnabled(false);
		}else if(es.equals(bnotes)){
			new NotesFrame(pane);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	private void setDay(){
		String date=Scheduler.cf.labels.get(pane).getText();
		int week=pane/10;
		int day=pane%10;
		String sday="";
		switch (day){
		case 1:
			sday="Sunday";
			break;
		case 2:
			sday="Monday";
			break;
		case 3:
			sday="Tuesday";
			break;
		case 4:
			sday="Wedensday";
			break;
		case 5:
			sday="Thursday";
			break;
		case 6:
			sday="Friday";
			break;
		case 7:
			sday="Saturday";
			break;
		}
		String msg="Week "+week+" "+sday+" the "+date+AddRemFrame.endsWith(Integer.parseInt(date));
		lday.setText(msg);
	}
	private int closeit(){
		Scheduler.closeCF();
		frmEdit.dispose();
		return 0;
	}
	private void setupPanel(){
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		frmEdit.getContentPane().add(table);
		frmEdit.getContentPane().setLayout(null);
		table.setBounds(10, 40, 523, 109);
		fillRow();
		table.getColumn("ID").setPreferredWidth(25);
		table.getColumn("Hrs").setPreferredWidth(15);
		table.getColumn("Start Time").setPreferredWidth(25);
		table.getColumn("Type").setPreferredWidth(30);
		table.getColumn("Cat").setPreferredWidth(40);
		table.getColumn("Name").setPreferredWidth(170);
		
		baddrem.setBounds(235, 160, 110, 23);
		frmEdit.getContentPane().add(baddrem);
		baddrem.addActionListener(this);
		
		btnOk.setBounds(10, 160, 64, 23);
		frmEdit.getContentPane().add(btnOk);
		lblNewLabel.setBounds(10, 15, 46, 14);
		String t=Scheduler.workers.get(pane).get(0);
		frmEdit.getContentPane().add(lblNewLabel);
		lday.setBounds(40, 15, 223, 14);
		
		frmEdit.getContentPane().add(lday);
		lblTotalHrs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalHrs.setBounds(531, 15, 128, 14);
		
		frmEdit.getContentPane().add(lblTotalHrs);
		lthr.setBounds(660, 15, 36, 14);
		
		frmEdit.getContentPane().add(lthr);
		
		JPanel panel = new JPanel();
		panel.setBounds(543, 40, 146, 157);
		frmEdit.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblWorkers_1 = new JLabel("Workers:");
		lblWorkers_1.setBounds(10, 0, 70, 14);
		panel.add(lblWorkers_1);
		
		tworkers.setBounds(11, 15, 118, 68);
		panel.add(tworkers);
		
		JLabel lblWorkers = new JLabel("Workers: ");
		lblWorkers.setBounds(0, 95, 64, 14);
		panel.add(lblWorkers);
		lblWorkers.setHorizontalAlignment(SwingConstants.RIGHT);
		spinner.setBounds(65, 92, 31, 20);
		panel.add(spinner);
		spinner.addChangeListener(new ChangeListener() {
			@Override
		    public void stateChanged(ChangeEvent e) {
				int sp=(int) spinner.getValue();
				int t=(thrs/sp)+(thrs % sp == 0 ? 0 : 1);;
				lthr.setText(Integer.toString(t));
				Scheduler.workers.get(pane).set(0, Integer.toString(sp));

		    }
		});
		spinner.setValue(Integer.parseInt(t));
		btnAddWorkers.setBounds(24, 120, 105, 23);
		panel.add(btnAddWorkers);
		bnotes.setBounds(462, 160, 71, 23);
		bnotes.addActionListener(this);
		frmEdit.getContentPane().add(bnotes);
		btnAddWorkers.addActionListener(this);
		btnOk.addActionListener(this);
		setDefaultCloseOperation(closeit());
		frmEdit.setIconImage(Toolkit.getDefaultToolkit().getImage(DayFrame.class.getResource("/res/icon.png")));
		frmEdit.setTitle("Edit");
		frmEdit.setLocation(Scheduler.setLoc(-140,0));
		frmEdit.addWindowListener(this);
		frmEdit.setSize(701,235);
		frmEdit.setVisible(true);
	}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {
		Scheduler.closeCF();
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
