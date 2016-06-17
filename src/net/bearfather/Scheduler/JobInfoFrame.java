package net.bearfather.Scheduler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.Color;
import javax.swing.JTextArea;

class JobInfoFrame extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JobInfo info=new JobInfo();
	private JDialog frame=new JDialog(Scheduler.jf,true);
	private JTextField tAcctName;
	private JTextField tAcctAddy;
	private JTextField tAcctCont;
	private JTextField tAlarm;
	private JTextField tAlrmCode;
	private JTextField tAcctNum;
	private JTextField tAcctPhone;
	private JTextField tContPhone;
	private JTextField tAlrmPhone;
	private JTextField tServType;
	private JTextField tCommLog;
	private JTextField tLights;
	private JTextField tWater;
	private JTextField tBreakers;
	private JPanel mainPanel = new JPanel();
	private JTextArea tServNotes = new JTextArea();
	private JLabel lOwner = new JLabel("");
	private JButton bOk = new JButton("Ok");
	private JButton bCancel = new JButton("Cancel");
	private JButton bPrint = new JButton("Print");
	private JTextField tCat;
	
	JobInfoFrame(String id) {
		setupPanel(id.trim());
	}

	@Override
	public void actionPerformed(ActionEvent es) {
		Object e=es.getSource();
		if (e.equals(bCancel)){frame.dispose();}
		else if (e.equals(bOk)){
			JobInfo rtn=savePanel();
			if (Scheduler.jobinfos.containsKey(rtn.getAccNum())){Data.updateJobInfo(rtn, ".\\JobInfo");}
			else{Data.insertJobInfo(rtn, ".\\JobInfo");}
			Scheduler.jobinfos.put(rtn.getAccNum(), rtn);
			frame.dispose();
		}else if (e.equals(bPrint)){
			new PrintForm(mainPanel);
		}
	}
	private JobInfo savePanel(){
		JobInfo info=new JobInfo();
		info.setAccName(tAcctName.getText());
		info.setAccAddress(tAcctAddy.getText());
		info.setAccContact(tAcctCont.getText());
		info.setAccNum(tAcctNum.getText());
		info.setAccPhone(tAcctPhone.getText());
		info.setConPhone(tContPhone.getText());
		info.setCommLog(tCommLog.getText());
		info.setLights(tLights.getText());
		info.setWater(tWater.getText());
		info.setBreakers(tBreakers.getText());
		info.setNotes(tServNotes.getText());
		String ta=tAlarm.getText().toLowerCase().trim();
		if (ta.equals("yes")||ta.equals("true")){info.setAlarm(true);}
		else{info.setAlarm(false);}
		info.setAlarmComp(tAlrmCode.getText());
		info.setAlarmPhone(tAlrmPhone.getText());
		return info;		
	}
	private void popPanel(){
		tAcctName.setText(info.getAccName());
		tAcctAddy.setText(info.getAccAddress());
		tAcctCont.setText(info.getAccContact());
		tAcctNum.setText(info.getAccNum());
		tAcctPhone.setText(info.getAccPhone());
		tContPhone.setText(info.getConPhone());
		tCommLog.setText(info.getCommLog());
		tLights.setText(info.getLights());
		tWater.setText(info.getWater());
		tBreakers.setText(info.getBreakers());
		tServNotes.setText(info.getNotes());
		if (info.isAlarm()){
			tAlarm.setText("Yes");
			tAlrmCode.setText(info.getAlarmComp());
			tAlrmPhone.setText(info.getAlarmPhone());
		}
		addextra();
	}
	@SuppressWarnings("unused")
	private void addextra(){
		String type="";
		String cat="";
		String owner="none";
		String notes="";
		int length=0;
		Job job=null;
		if (Scheduler.availJobs.containsKey(info.getAccNum())){
			job=Scheduler.availJobs.get(info.getAccNum());
		}else if (Scheduler.workorders.containsKey(info.getAccNum())){
			job=Scheduler.workorders.get(info.getAccNum());
			lOwner.setText(Scheduler.workorders.get(info.getAccNum()).getOwner());
			tServNotes.setText(tServNotes.getText());
		}
		if (job!=null){
			tAcctName.setText(job.getName());
			switch (job.getType()){
			case 0:
				type="Floors";
				break;
			case 1:
				type="Carpets";
				break;
			case 2:
				type="Floors & Carpets";
				break;
			case 3:
				type="Project";
				break;
			}
			length=job.getLength();
			tServType.setText(type+" at "+length+"hrs");
			switch (job.getCat()){
			case 0:
				cat="Contract";
				break;
			case 1:
				cat="WorkOrder";
				break;
			case 2:
				cat="Other";
				break;
			}
			tCat.setText(cat);
		}
		
	}
	private void setupPanel(String id){
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		mainPanel.setBorder(null);
		mainPanel.setBounds(10, 11, 611, 365);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		JPanel pMainInfo = new JPanel();
		pMainInfo.setBounds(0, 0, 601, 121);
		mainPanel.add(pMainInfo);
		pMainInfo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Main Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pMainInfo.setLayout(null);
		
		JLabel lblAcctName = new JLabel("Acct Name:");
		lblAcctName.setBounds(6, 19, 81, 14);
		pMainInfo.add(lblAcctName);
		lblAcctName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblAcctAddress = new JLabel("Acct Address:");
		lblAcctAddress.setBounds(16, 47, 71, 14);
		pMainInfo.add(lblAcctAddress);
		lblAcctAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblAcctContact = new JLabel("Acct Contact:");
		lblAcctContact.setBounds(6, 72, 81, 14);
		pMainInfo.add(lblAcctContact);
		lblAcctContact.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblAlarm = new JLabel("Alarm:");
		lblAlarm.setBounds(6, 97, 81, 14);
		pMainInfo.add(lblAlarm);
		lblAlarm.setHorizontalAlignment(SwingConstants.TRAILING);
		
		tAcctName = new JTextField();
		tAcctName.setEditable(false);
		tAcctName.setBounds(97, 16, 261, 20);
		pMainInfo.add(tAcctName);
		tAcctName.setColumns(10);
		
		tAcctAddy = new JTextField();
		tAcctAddy.setBounds(97, 42, 261, 20);
		pMainInfo.add(tAcctAddy);
		tAcctAddy.setColumns(10);
		
		tAcctCont = new JTextField();
		tAcctCont.setBounds(97, 68, 261, 20);
		pMainInfo.add(tAcctCont);
		tAcctCont.setColumns(10);
		
		tAlarm = new JTextField("NO");
		tAlarm.setBounds(97, 94, 56, 20);
		pMainInfo.add(tAlarm);
		tAlarm.setColumns(10);
		
		JLabel lblAlarmComp = new JLabel("Alarm Code:");
		lblAlarmComp.setBounds(163, 97, 71, 14);
		pMainInfo.add(lblAlarmComp);
		lblAlarmComp.setHorizontalAlignment(SwingConstants.TRAILING);
		
		tAlrmCode = new JTextField();
		tAlrmCode.setBounds(244, 94, 114, 20);
		pMainInfo.add(tAlrmCode);
		tAlrmCode.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Acct #:");
		lblNewLabel.setBounds(405, 19, 56, 14);
		pMainInfo.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblNewLabel_1 = new JLabel("Acct Phone:");
		lblNewLabel_1.setBounds(368, 47, 93, 14);
		pMainInfo.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblAcctPhone = new JLabel("Contact Phone:");
		lblAcctPhone.setBounds(368, 69, 93, 20);
		pMainInfo.add(lblAcctPhone);
		lblAcctPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblAlarmPhone = new JLabel("Alarm Phone:");
		lblAlarmPhone.setBounds(368, 94, 93, 20);
		pMainInfo.add(lblAlarmPhone);
		lblAlarmPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		
		tAcctNum = new JTextField();
		tAcctNum.setBounds(471, 16, 114, 20);
		pMainInfo.add(tAcctNum);
		tAcctNum.setColumns(10);
		
		tAcctPhone = new JTextField();
		tAcctPhone.setBounds(471, 44, 114, 20);
		pMainInfo.add(tAcctPhone);
		tAcctPhone.setColumns(10);
		
		tContPhone = new JTextField();
		tContPhone.setBounds(471, 69, 114, 20);
		pMainInfo.add(tContPhone);
		tContPhone.setColumns(10);
		
		tAlrmPhone = new JTextField();
		tAlrmPhone.setBounds(471, 94, 114, 20);
		pMainInfo.add(tAlrmPhone);
		tAlrmPhone.setColumns(10);
		
		JPanel pServive = new JPanel();
		pServive.setBounds(1, 130, 600, 161);
		mainPanel.add(pServive);
		pServive.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pServive.setLayout(null);
		
		JLabel lblServiceType = new JLabel("Service Type:");
		lblServiceType.setBounds(6, 19, 80, 14);
		pServive.add(lblServiceType);
		lblServiceType.setHorizontalAlignment(SwingConstants.TRAILING);
		
		tServType = new JTextField();
		tServType.setEditable(false);
		tServType.setBounds(96, 16, 173, 20);
		pServive.add(tServType);
		tServType.setColumns(10);
		
		JPanel pNotes = new JPanel();
		pNotes.setBounds(10, 42, 580, 112);
		pServive.add(pNotes);
		pNotes.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Service Notes:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pNotes.setLayout(null);
		
		tServNotes.setBounds(10, 22, 560, 79);
		pNotes.add(tServNotes);
		
		tCat = new JTextField();
		tCat.setEditable(false);
		tCat.setBackground(new Color(240,240,240));
		tCat.setBounds(366, 16, 120, 20);
		pServive.add(tCat);
		tCat.setColumns(10);
		lOwner.setHorizontalAlignment(SwingConstants.CENTER);
		
		lOwner.setBounds(496, 19, 88, 14);
		pServive.add(lOwner);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 297, 601, 68);
		mainPanel.add(panel);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Misc Info:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		
		JLabel lblCommLog = new JLabel("Comm Log:");
		lblCommLog.setBounds(6, 19, 87, 14);
		panel.add(lblCommLog);
		lblCommLog.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblLights = new JLabel("Lights:");
		lblLights.setBounds(25, 44, 68, 14);
		panel.add(lblLights);
		lblLights.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblWater = new JLabel("Water:");
		lblWater.setBounds(318, 19, 68, 14);
		panel.add(lblWater);
		lblWater.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblBreakers = new JLabel("Breakers:");
		lblBreakers.setBounds(318, 44, 68, 14);
		panel.add(lblBreakers);
		lblBreakers.setHorizontalAlignment(SwingConstants.TRAILING);
		
		tCommLog = new JTextField();
		tCommLog.setBounds(103, 16, 189, 20);
		panel.add(tCommLog);
		tCommLog.setColumns(10);
		
		tLights = new JTextField();
		tLights.setBounds(103, 41, 189, 20);
		panel.add(tLights);
		tLights.setColumns(10);
		
		tWater = new JTextField();
		tWater.setBounds(396, 16, 189, 20);
		panel.add(tWater);
		tWater.setColumns(10);
		
		tBreakers = new JTextField();
		tBreakers.setBounds(396, 41, 189, 20);
		panel.add(tBreakers);
		tBreakers.setColumns(10);
		
		bOk.setBounds(395, 387, 89, 23);
		frame.getContentPane().add(bOk);
		bOk.addActionListener(this);
		
		bCancel.setBounds(516, 387, 89, 23);
		frame.getContentPane().add(bCancel);
		bCancel.addActionListener(this);
		
		bPrint.setBounds(11, 387, 89, 23);
		frame.getContentPane().add(bPrint);
		bPrint.addActionListener(this);
		frame.setSize(637,459);
		if (Scheduler.jobinfos.containsKey(id)){
			info=Scheduler.jobinfos.get(id);
			popPanel();
		}else if(Scheduler.workorders.containsKey(id)){
			info=Scheduler.jobinfos.get(id);
			popPanel();
		}else{JOptionPane.showMessageDialog(this,"Can't Find Job Info!\nPlease create a new one.");}

		frame.setVisible(true);
	}
}
