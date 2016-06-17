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
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
@SuppressWarnings({ "unchecked", "rawtypes" }) class JobFrame extends JFrame implements ActionListener,WindowListener {
	private JFrame frame=new JFrame();
	private JButton badd = new JButton("Add");
	private JButton bcancel = new JButton("Cancel");
	private JButton bInfo = new JButton("Show Info");
	private static final long serialVersionUID = 1L;
	private JTextField tname;
	private JTextField tid;
	private JTextField tlen;
	private JTextField tsun;
	private JTextField tmon;
	private JTextField ttue;
	private JTextField tthu;
	private JTextField tfri;
	private JTextField tsat;
	private JTextField twed;
	private JPanel panel = new JPanel();
	private JCheckBox csun = new JCheckBox("");
	private JCheckBox cmon = new JCheckBox("");
	private JCheckBox ctue = new JCheckBox("");
	private JCheckBox cthu = new JCheckBox("");
	private JCheckBox cfri = new JCheckBox("");
	private JCheckBox csat = new JCheckBox("");
	private JCheckBox cwed = new JCheckBox("");
	private JRadioButton rjan = new JRadioButton("January");
	private JRadioButton rfeb = new JRadioButton("February");
	private JRadioButton rmar = new JRadioButton("March");
	private JRadioButton rmay = new JRadioButton("May");
	private JRadioButton rjun = new JRadioButton("June");
	private JRadioButton rjul = new JRadioButton("July");
	private JRadioButton raug = new JRadioButton("August");
	private JRadioButton rsep = new JRadioButton("September");
	private JRadioButton roct = new JRadioButton("October");
	private JRadioButton rnov = new JRadioButton("November");
	private JRadioButton rapr = new JRadioButton("April");
	private JRadioButton rdec = new JRadioButton("December");
	private String[] scat={"Contract","WorkOrder","Other"};
	private String[] stype={"Floors","Carpets","Both","Project"};
	private JComboBox cbcat = new JComboBox(scat);
	private JComboBox cbtype = new JComboBox(stype);
	private String id=null;

	JobFrame(String id) {
		setupPanel();

		if (id!=null&&!id.equals("")){
			for (Job job:Scheduler.availJobs.values()){
				if (id.trim().equals(job.getId())){
					this.id=id;
					popJob(job);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object es=e.getSource();
		if (es.equals(badd)){
			Job job=getJob();
			if (Scheduler.availJobs.containsKey(job.getId())){
				Data.updateJob(job, "jobs");
			}else {
				Data.insertJob(job, "jobs");
			}
			Scheduler.availJobs.put(job.getId(),job);
			this.setVisible(false);
			Scheduler.closeCF();
		}else if (es.equals(bcancel)){
			this.setVisible(false);
			Scheduler.closeCF();
		}else if (es.equals(bInfo)){
			Scheduler.jf=this;
			new JobInfoFrame(id.trim());
		}
		
	}
	private void popJob(Job job){
		tname.setText(job.getName());
		tid.setText(job.getId());
		cbcat.setSelectedIndex(job.getCat());
		cbtype.setSelectedIndex(job.getType());
		tlen.setText(Integer.toString(job.getLength()));
		if (job.getSun()[0]==1){
			csun.setSelected(true);
			tsun.setText(Integer.toString(job.getSun()[1]));
		}
		if (job.getMon()[0]==1){
			cmon.setSelected(true);
			tmon.setText(Integer.toString(job.getMon()[1]));
		}
		if (job.getTue()[0]==1){
			ctue.setSelected(true);
			ttue.setText(Integer.toString(job.getTue()[1]));
		}
		if (job.getWed()[0]==1){
			cwed.setSelected(true);
			twed.setText(Integer.toString(job.getWed()[1]));
		}
		if (job.getThu()[0]==1){
			cthu.setSelected(true);
			tthu.setText(Integer.toString(job.getThu()[1]));
		}
		if (job.getFri()[0]==1){
			cfri.setSelected(true);
			tfri.setText(Integer.toString(job.getFri()[1]));
		}
		if (job.getSat()[0]==1){
			csat.setSelected(true);
			tsat.setText(Integer.toString(job.getSat()[1]));
		}
		int[] month=job.getMonth();
		if (month[1]==1){
			rjan.setSelected(true);
		}
		if (month[2]==1){
			rfeb.setSelected(true);
		}
		if (month[3]==1){
			rmar.setSelected(true);
		}
		if (month[4]==1){
			rapr.setSelected(true);
		}
		if (month[5]==1){
			rmay.setSelected(true);
		}
		if (month[6]==1){
			rjun.setSelected(true);
		}
		if (month[7]==1){
			rjul.setSelected(true);
		}
		if (month[8]==1){
			raug.setSelected(true);
		}
		if (month[9]==1){
			rsep.setSelected(true);
		}
		if (month[10]==1){
			roct.setSelected(true);
		}
		if (month[11]==1){
			rnov.setSelected(true);
		}
		if (month[12]==1){
			rdec.setSelected(true);
		}
		badd.setText("Edit");
	}
	public Job getJob(){
		Job rtn=null;
		String name=tname.getText();
		String id=tid.getText();
		Scheduler.getId(true);
		int cat=cbcat.getSelectedIndex();
		int type=cbtype.getSelectedIndex();
		int length=Integer.parseInt(tlen.getText());
		int[] sun=new int[2];
		int[] mon=new int[2];
		int[] tue=new int[2];
		int[] wed=new int[2];
		int[] thu=new int[2];
		int[] fri=new int[2];
		int[] sat=new int[2];
		int[] month=new int[13];
		if (csun.isSelected()){
			sun[0]=1;
			sun[1]=Integer.parseInt(tsun.getText());
		}
		if (cmon.isSelected()){
			mon[0]=1;
			mon[1]=Integer.parseInt(tmon.getText());
		}
		if (ctue.isSelected()){
			tue[0]=1;
			tue[1]=Integer.parseInt(ttue.getText());
		}
		if (cwed.isSelected()){
			wed[0]=1;
			wed[1]=Integer.parseInt(twed.getText());
		}
		if (cthu.isSelected()){
			thu[0]=1;
			thu[1]=Integer.parseInt(tthu.getText());
		}
		if (cfri.isSelected()){
			fri[0]=1;
			fri[1]=Integer.parseInt(tfri.getText());
		}
		if (csat.isSelected()){
			sat[0]=1;
			sat[1]=Integer.parseInt(tsat.getText());
		}
		if (rjan.isSelected()){
			month[1]=1;
		}
		if (rfeb.isSelected()){
			month[2]=1;
		}
		if (rmar.isSelected()){
			month[3]=1;
		}
		if (rapr.isSelected()){
			month[4]=1;
		}
		if (rmay.isSelected()){
			month[5]=1;
		}
		if (rjun.isSelected()){
			month[6]=1;
		}
		if (rjul.isSelected()){
			month[7]=1;
		}
		if (raug.isSelected()){
			month[8]=1;
		}
		if (rsep.isSelected()){
			month[9]=1;
		}
		if (roct.isSelected()){
			month[10]=1;
		}
		if (rnov.isSelected()){
			month[11]=1;
		}
		if (rdec.isSelected()){
			month[12]=1;
		}
		rtn=new Job(name,id,cat,type,length,sun,mon,tue,wed,thu,fri,sat,month);
		return rtn;
	}
	@SuppressWarnings("static-access")
	private void setupPanel(){
		this.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		rjan.setBounds(437, 11, 74, 23);
		getContentPane().add(rjan);
		
		rfeb.setBounds(437, 37, 88, 23);
		getContentPane().add(rfeb);
		
		rmar.setBounds(437, 63, 74, 23);
		getContentPane().add(rmar);
		
		rmay.setBounds(437, 115, 74, 23);
		getContentPane().add(rmay);
		
		rjun.setBounds(437, 141, 74, 23);
		getContentPane().add(rjun);
		
		rjul.setBounds(527, 11, 74, 23);
		getContentPane().add(rjul);
		
		raug.setBounds(527, 35, 74, 23);
		getContentPane().add(raug);
		
		rsep.setBounds(527, 63, 88, 23);
		getContentPane().add(rsep);
		
		roct.setBounds(527, 89, 74, 23);
		getContentPane().add(roct);
		
		rnov.setBounds(527, 115, 88, 23);
		getContentPane().add(rnov);
		
		rapr.setBounds(437, 89, 74, 23);
		getContentPane().add(rapr);
		
		rdec.setBounds(527, 141, 88, 23);
		getContentPane().add(rdec);
		badd.setBounds(33, 202, 89, 23);
		getContentPane().add(badd);
		badd.addActionListener(this);
		bcancel.setBounds(486, 202, 89, 23);
		getContentPane().add(bcancel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(20, 11, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(164, 11, 46, 14);
		getContentPane().add(lblId);
		
		tname = new JTextField();
		tname.setText("NEW");
		tname.setBounds(76, 8, 86, 20);
		getContentPane().add(tname);
		tname.setColumns(10);
		
		tid = new JTextField();
		tid.setBounds(220, 8, 86, 20);
		getContentPane().add(tid);
		tid.setColumns(10);
		
		JLabel lblCatorgory = new JLabel("Category:");
		lblCatorgory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCatorgory.setBounds(10, 60, 56, 14);
		getContentPane().add(lblCatorgory);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setBounds(164, 60, 46, 14);
		getContentPane().add(lblType);
		
		cbcat.setBounds(76, 57, 86, 20);
		getContentPane().add(cbcat);
		
		cbtype.setBounds(220, 57, 86, 20);
		getContentPane().add(cbtype);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTime.setBounds(333, 11, 46, 14);
		getContentPane().add(lblTime);
		
		tlen = new JTextField();
		tlen.setText("0");
		tlen.setBounds(343, 36, 46, 20);
		getContentPane().add(tlen);
		tlen.setColumns(10);
		
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sunday", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 98, 104, 46);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		csun.setBounds(20, 17, 21, 23);
		panel.add(csun);
		csun.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tsun = new JTextField();
		tsun.setText("0");
		tsun.setBounds(47, 17, 46, 20);
		panel.add(tsun);
		tsun.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Monday", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(116, 98, 104, 46);
		getContentPane().add(panel_1);
		
		cmon.setHorizontalAlignment(SwingConstants.RIGHT);
		cmon.setBounds(20, 17, 21, 23);
		panel_1.add(cmon);
		
		tmon = new JTextField();
		tmon.setText("0");
		tmon.setColumns(10);
		tmon.setBounds(47, 17, 46, 20);
		panel_1.add(tmon);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "TuesDay", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(222, 98, 104, 46);
		getContentPane().add(panel_2);
		
		ctue.setHorizontalAlignment(SwingConstants.RIGHT);
		ctue.setBounds(20, 17, 21, 23);
		panel_2.add(ctue);
		
		ttue = new JTextField();
		ttue.setText("0");
		ttue.setColumns(10);
		ttue.setBounds(47, 17, 46, 20);
		panel_2.add(ttue);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thursday", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(45, 145, 104, 46);
		getContentPane().add(panel_3);
		
		cthu.setHorizontalAlignment(SwingConstants.RIGHT);
		cthu.setBounds(20, 17, 21, 23);
		panel_3.add(cthu);
		
		tthu = new JTextField();
		tthu.setText("0");
		tthu.setColumns(10);
		tthu.setBounds(47, 17, 46, 20);
		panel_3.add(tthu);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Friday", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(159, 145, 104, 46);
		getContentPane().add(panel_4);
		
		cfri.setHorizontalAlignment(SwingConstants.RIGHT);
		cfri.setBounds(20, 17, 21, 23);
		panel_4.add(cfri);
		
		tfri = new JTextField();
		tfri.setText("0");
		tfri.setColumns(10);
		tfri.setBounds(47, 17, 46, 20);
		panel_4.add(tfri);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Saturday", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(273, 145, 104, 46);
		getContentPane().add(panel_5);
		
		csat.setHorizontalAlignment(SwingConstants.RIGHT);
		csat.setBounds(20, 17, 21, 23);
		panel_5.add(csat);
		
		tsat = new JTextField();
		tsat.setText("0");
		tsat.setColumns(10);
		tsat.setBounds(47, 17, 46, 20);
		panel_5.add(tsat);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Wednesday", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(327, 98, 104, 46);
		getContentPane().add(panel_6);
		
		cwed.setHorizontalAlignment(SwingConstants.RIGHT);
		cwed.setBounds(20, 17, 21, 23);
		panel_6.add(cwed);
		
		twed = new JTextField();
		twed.setText("0");
		twed.setColumns(10);
		twed.setBounds(47, 17, 46, 20);
		panel_6.add(twed);
		bcancel.addActionListener(this);
		this.setLocation(Scheduler.setLoc());
		this.addWindowListener(this);
		setTitle("Job Editor");
		setIconImage(Toolkit.getDefaultToolkit().getImage(JobFrame.class.getResource("/res/icon.png")));
		tid.setText(Integer.toString(Scheduler.getId(false)));
		bInfo.setBounds(342, 202, 89, 23);
		getContentPane().add(bInfo);
		bInfo.addActionListener(this);
		this.setSize(633,276);
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
