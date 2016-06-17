package net.bearfather.Scheduler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import org.jdesktop.swingx.JXDatePicker;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextArea;



@SuppressWarnings({ "unchecked", "rawtypes" }) class WorkOrderFrame extends JFrame implements ActionListener,WindowListener {
	private JFrame frame=new JFrame();
	private JButton badd = new JButton("Add");
	private JButton bcancel = new JButton("Cancel");
	private static final long serialVersionUID = 1L;
	private JTextField tname = new JTextField();
	private JTextField tid = new JTextField();
	private JTextField tlen = new JTextField();
	private String[] stype={"Floors","Carpets","Both","Project"};
	private JComboBox cbtype = new JComboBox(stype);
	private String id=null;
	private JXDatePicker sPicker = new JXDatePicker();
	private JXDatePicker ePicker = new JXDatePicker();
	private final JLabel lblStart = new JLabel("Start:");
	private final JLabel lblEnd = new JLabel("End:");
	private final JLabel lblOwner = new JLabel("Owner:");
	private final JTextField tfowner = new JTextField();
	private JTextField 	tstart = new JTextField();
	private JTextArea tnotes = new JTextArea();
	
	JButton test = new JButton("Show Info");

	WorkOrderFrame(String id) {
		setupPanel();
		if (id!=null&&!id.equals("")){
			for (WorkOrder wo:Scheduler.workorders.values()){
				if (id.trim().equals(wo.getId())){
					this.id=id;
					popWO(wo);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object es=e.getSource();
		if (es.equals(badd)){
			WorkOrder wo=getJob();
			if (Scheduler.workorders.containsKey(wo.getId())){
				Data.updateWorkOrder(wo, "jobs");
			}else {
				Data.insertWorkOrder(wo, "jobs");
			}
			Scheduler.workorders.put(wo.getId(),wo);
			//Scheduler.availJobs.put(wo.getId(),wo);
			this.setVisible(false);
			Scheduler.closeCF();
		}else if (es.equals(bcancel)){
			this.setVisible(false);
			Scheduler.closeCF();
		}else if(es.equals(test)){
			Scheduler.jf=this;
			new JobInfoFrame(id);
		}
		
	}
	private void popWO(WorkOrder wo){
		tname.setText(wo.getName());
		tid.setText(wo.getId());
		cbtype.setSelectedIndex(wo.getType());
		tlen.setText(Integer.toString(wo.getLength()));
		tfowner.setText(wo.getOwner());
		tstart.setText(wo.getStart());
		sPicker.setDate(wo.getsDate());
		ePicker.setDate(wo.geteDate());
		tnotes.setText(wo.getNotes());
		badd.setText("Edit");
	}
	public WorkOrder getJob(){
		WorkOrder rtn=null;
		String name=tname.getText();
		String id=tid.getText();
		Scheduler.getId(true);
		int type=cbtype.getSelectedIndex();
		int length=Integer.parseInt(tlen.getText());
		String owner=tfowner.getText();
		String start=tstart.getText();
		Date sdate=sPicker.getDate();
		Date edate=ePicker.getDate();
		String notes=tnotes.getText();
		rtn=new WorkOrder(name,id,1,type,length,null,null,null,null,null,null,null,null);
		rtn.WorkOrder2(name, id, type, length, owner, start, sdate, edate, notes);
		return rtn;
	}
	@SuppressWarnings("static-access")
	private void setupPanel(){
		this.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		badd.setBounds(23, 207, 89, 23);
		getContentPane().add(badd);
		badd.addActionListener(this);
		bcancel.setBounds(476, 207, 89, 23);
		getContentPane().add(bcancel);
		tfowner.setBounds(330, 11, 54, 20);
		tfowner.setColumns(10);
		setTitle("WorkOrder Editor");
		setIconImage(Toolkit.getDefaultToolkit().getImage(WorkOrderFrame.class.getResource("/res/icon.png")));
		tid.setText(Integer.toString(Scheduler.getId(false)));
		lblStart.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStart.setBounds(394, 14, 46, 14);
		
		getContentPane().add(lblStart);
		lblEnd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnd.setBounds(407, 43, 33, 14);
		
		getContentPane().add(lblEnd);
		lblOwner.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOwner.setBounds(266, 14, 54, 14);
		
		getContentPane().add(lblOwner);
		
		getContentPane().add(tfowner);
		
		tnotes.setBounds(23, 92, 542, 83);
		getContentPane().add(tnotes);
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNotes.setBounds(10, 67, 46, 14);
		getContentPane().add(lblNotes);
		
		JLabel lblStartTime = new JLabel("Start Time:");
		lblStartTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStartTime.setBounds(255, 43, 65, 14);
		getContentPane().add(lblStartTime);
		
		tstart.setBounds(330, 40, 54, 20);
		getContentPane().add(tstart);
		tstart.setColumns(10);
		
	    sPicker.setDate(Calendar.getInstance().getTime());
	    sPicker.setFormats(new SimpleDateFormat("MM/dd/yyyy"));
	    sPicker.setBounds(443, 11, 122, 23);
	    getContentPane().add(sPicker);
	    ePicker.setDate(Calendar.getInstance().getTime());
	    ePicker.setFormats(new SimpleDateFormat("MM/dd/yyyy"));
		ePicker.setBounds(443, 39, 122, 22);
		getContentPane().add(ePicker);
	    


		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(10, 16, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(154, 16, 46, 14);
		getContentPane().add(lblId);
		
		tname.setText("NEW");
		tname.setBounds(66, 13, 86, 20);
		getContentPane().add(tname);
		tname.setColumns(10);
		
		tid.setBounds(210, 13, 46, 20);
		getContentPane().add(tid);
		tid.setColumns(10);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setBounds(10, 44, 46, 14);
		getContentPane().add(lblType);
		
		cbtype.setBounds(66, 41, 86, 20);
		getContentPane().add(cbtype);
		
		JLabel lblTime = new JLabel("Hours:");
		lblTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTime.setBounds(154, 44, 46, 14);
		getContentPane().add(lblTime);
		
		tlen.setText("0");
		tlen.setBounds(210, 41, 46, 20);
		getContentPane().add(tlen);
		tlen.setColumns(10);
		
		test.setBounds(196, 207, 89, 23);
		getContentPane().add(test);
		test.addActionListener(this);
		bcancel.addActionListener(this);
		this.setLocation(Scheduler.setLoc());
		this.addWindowListener(this);
		this.setSize(601,276);
		this.setVisible(true);
	}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {Scheduler.closeCF();}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowOpened(WindowEvent e) {}
}
