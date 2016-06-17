package net.bearfather.Scheduler;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
@SuppressWarnings("rawtypes") class AddRemFrame extends JFrame implements ActionListener,WindowListener{
	private JLabel lday = new JLabel("");
	private static final long serialVersionUID = 1L;
	private JTextField tatime;
	private JTextField tatype;
	private JTextField trtime;
	private JTextField trtype;
	private JComboBox cbajobs;
	private JComboBox cbrjobs = new JComboBox();
	private JButton badd = new JButton("Add");
	private JButton brem = new JButton("Remove");
	private static JFrame frame=new JFrame();
	private int pane;
	private DayFrame par;
	AddRemFrame(int pane, DayFrame par) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddRemFrame.class.getResource("/res/icon.png")));
		setTitle("Add/Remove");
		this.par=par;
		this.pane=pane;
		buildCbs();
		setupPanel();
		setDay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object es=e.getSource();
		if (es.equals(cbajobs)){
			String sel=(String) cbajobs.getSelectedItem();
			String[] b=sel.split(" : ");
			for (Job job:Scheduler.availJobs.values()){
				if (job.getId().equals(b[0])&&job.getName().equals(b[1])){
					tatime.setText(Integer.toString(job.getLength()));
					int type=job.getType();
					if (type==0){tatype.setText("Floors");}
					else if (type==1){tatype.setText("Carpets");}
					else if (type==2){tatype.setText("Both");}
					else if (type==3){tatype.setText("Project");}
					
				}
			}
		}
		else if (es.equals(cbrjobs)){
			String sel=(String) cbrjobs.getSelectedItem();
			String[] b=sel.split(" : ");
			for (Job job:Scheduler.jobs.get(pane)){
				if (job.getId().equals(b[0])&&job.getName().equals(b[1])){
					trtime.setText(Integer.toString(job.getLength()));
					int type=job.getType();
					if (type==0){trtype.setText("Floors");}
					else if (type==1){trtype.setText("Carpets");}
					else if (type==2){trtype.setText("Both");}
					else if (type==3){trtype.setText("Project");}
					
				}
			}
		}
		else if (es.equals(badd)){
			String sel=(String) cbajobs.getSelectedItem();
			String[] b=sel.split(" : ");
			for (Job job:Scheduler.workorders.values()){
				if (job.getId().equals(b[0])&&job.getName().equals(b[1].replace(" W/O", ""))){
					Scheduler.cf.addJob(pane,job);
				}
			}
			for (Job job:Scheduler.availJobs.values()){
				if (job.getId().equals(b[0])&&job.getName().equals(b[1])){
					Scheduler.cf.addJob(pane,job);
				}
			}
			par.fillRow();
			this.setVisible(false);
			Scheduler.cf.setVisible(true);
			Scheduler.df.frmEdit.setVisible(true);
			Scheduler.df.frmEdit.setEnabled(true);
		}
		else if (es.equals(brem)){
			String sel=(String) cbrjobs.getSelectedItem();
			String[] b=sel.split(" : ");
			int c=0;
			ArrayList<Integer> rem=new ArrayList<Integer>();
			for (Job job:Scheduler.jobs.get(pane)){
				if (job.getId().equals(b[0])&&job.getName().equals(b[1])){rem.add(c);}
				c++;
			}
			if (rem.size()>0){
				for (int value:rem){Scheduler.cf.remJob(pane,Scheduler.jobs.get(pane).get(value));}
			}
			par.fillRow();
			this.setVisible(false);
			Scheduler.cf.setVisible(true);
			Scheduler.df.frmEdit.setVisible(true);
			Scheduler.df.frmEdit.setEnabled(true);
		}
	}
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
		String msg="Week "+week+" "+sday+" the "+date+endsWith(Integer.parseInt(date));
		lday.setText(msg);
	}
	
	static String endsWith(int day){
		String rtn="th";
		if (day>3&&day<21){
			return "th";
		}else if (day==1||day%10==1){
			return "st";
		}else if (day==2||day%10==2){
			return "nd";
		}else if (day==3||day%10==3){
			return "rd";
		}
		return rtn;
	}
	@SuppressWarnings("unchecked")
	private void buildCbs(){
		cbajobs = new JComboBox();
		cbajobs.addItem(" --- None --- ");
		for (WorkOrder job:Scheduler.workorders.values()){
			int m=Scheduler.cf.cbmonth.getSelectedIndex();
			int day=Integer.parseInt(Scheduler.cf.labels.get(pane).getText());
			if (job.getMonth()[Scheduler.cf.cbmonth.getSelectedIndex()]==1&&chkDate(m,day,job)){
				cbajobs.addItem(job.getId()+" : "+job.getName()+" W/O");
			}
		}
		for (Job job:Scheduler.availJobs.values()){
			if (chkDay(pane%10,job)==1&&job.getMonth()[Scheduler.cf.cbmonth.getSelectedIndex()]==1){
				cbajobs.addItem(job.getId()+" : "+job.getName());
			}
		}
		cbrjobs = new JComboBox();
		cbrjobs.addItem(" --- None --- ");
		for (Job job:Scheduler.jobs.get(pane)){
			cbrjobs.addItem(job.getId()+" : "+job.getName());
		}
	}
	private boolean chkDate(int month, int day,WorkOrder wo){
		boolean rtn=false;
		String string = month+" "+day+", 2016";
		try {
			DateFormat format = new SimpleDateFormat("MM dd, yyyy", Locale.ENGLISH);
			Date date = format.parse(string);
			if (date.after(wo.getsDate())&&date.before(wo.geteDate())||date.equals(wo.getsDate())||date.equals(wo.geteDate())){
				return true;
			}

		} catch (ParseException e) {return false;}
		return rtn;
	}
	private int chkDay(int day,Job job){
		int rtn=0;
		switch (day){
		case 1:
			rtn=job.getSun()[0];
			break;
		case 2:
			rtn=job.getMon()[0];
			break;
		case 3:
			rtn=job.getTue()[0];
			break; 
		case 4:
			rtn=job.getWed()[0];
			break;
		case 5:
			rtn=job.getThu()[0];
			break;
		case 6:
			rtn=job.getFri()[0];
			break;
		}
		return rtn;
	}
	@SuppressWarnings("static-access")
	private void setupPanel(){
		getContentPane().setLayout(null);
		setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);

		JLabel lblDay = new JLabel("Day: ");
		lblDay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDay.setBounds(10, 11, 37, 14);
		getContentPane().add(lblDay);
		
		lday.setBounds(53, 11, 240, 14);
		getContentPane().add(lday);
		
		JPanel panel_add = new JPanel();
		panel_add.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Add Job", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_add.setBounds(4, 32, 319, 81);
		getContentPane().add(panel_add);
		panel_add.setLayout(null);
		
		JLabel lblJobs = new JLabel("Jobs: ");
		lblJobs.setBounds(6, 20, 37, 14);
		panel_add.add(lblJobs);
		lblJobs.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cbajobs.setBounds(49, 17, 166, 20);
		panel_add.add(cbajobs);
		cbajobs.addActionListener(this);
		
		JLabel lblTime = new JLabel("Time: ");
		lblTime.setBounds(6, 57, 37, 14);
		panel_add.add(lblTime);
		lblTime.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tatime = new JTextField();
		tatime.setEditable(false);
		tatime.setForeground(Color.BLACK);
		tatime.setBounds(49, 54, 31, 20);
		panel_add.add(tatime);
		tatime.setColumns(10);
		
		JLabel lblType = new JLabel("Type: ");
		lblType.setBounds(90, 57, 46, 14);
		panel_add.add(lblType);
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tatype = new JTextField();
		tatype.setForeground(Color.BLACK);
		tatype.setBounds(146, 54, 69, 20);
		panel_add.add(tatype);
		tatype.setEditable(false);
		tatype.setColumns(10);
		
		badd.setBounds(231, 16, 69, 23);
		panel_add.add(badd);
		badd.addActionListener(this);
		
		JPanel panel_rem = new JPanel();
		panel_rem.setLayout(null);
		panel_rem.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Remove Job", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_rem.setBounds(6, 123, 317, 81);
		getContentPane().add(panel_rem);
		
		JLabel label = new JLabel("Jobs: ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(6, 20, 37, 14);
		panel_rem.add(label);
		
		cbrjobs.setBounds(49, 17, 166, 20);
		panel_rem.add(cbrjobs);
		cbrjobs.addActionListener(this);
		
		JLabel label_1 = new JLabel("Time: ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(6, 57, 37, 14);
		panel_rem.add(label_1);
		
		trtime = new JTextField();
		trtime.setEditable(false);
		trtime.setColumns(10);
		trtime.setBounds(49, 54, 31, 20);
		panel_rem.add(trtime);
		
		JLabel label_2 = new JLabel("Type: ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(90, 57, 46, 14);
		panel_rem.add(label_2);
		
		trtype = new JTextField();
		trtype.setEditable(false);
		trtype.setColumns(10);
		trtype.setBounds(146, 54, 69, 20);
		panel_rem.add(trtype);
		
		brem.setBounds(225, 16, 84, 23);
		panel_rem.add(brem);
		brem.addActionListener(this);
		this.setLocation(Scheduler.setLoc());
		this.addWindowListener(this);
		this.setSize(344,248);
		this.setVisible(true);
	}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {
		Scheduler.cf.setVisible(true);
		Scheduler.df.frmEdit.setVisible(true);
		Scheduler.df.frmEdit.setEnabled(true);
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
