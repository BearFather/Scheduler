package net.bearfather.Scheduler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.border.EtchedBorder;

import java.awt.Toolkit;

class SetDateFrame extends JFrame implements ActionListener,WindowListener {
	private static final long serialVersionUID = 1L;
	private JFrame frame=new JFrame();
	private String[] days={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	private @SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox cbdays = new JComboBox(days);
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton r30 = new JRadioButton("30 days");
	private JRadioButton r31 = new JRadioButton("31 days");
	private JButton bset = new JButton("Set");
	private HashMap<Integer,JLabel> labels;

	static int start=11;
	static int day30=30;
	public CalenderFrame test;
	public SetDateFrame() {
		this.test=Scheduler.cf;
		labels=test.labels;
		setIconImage(Toolkit.getDefaultToolkit().getImage(SetDateFrame.class.getResource("/res/icon.png")));
		setTitle("Set Days");
		setupPanel();
		load();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object es=e.getSource();
		if (es.equals(bset)){
			int num=cbdays.getSelectedIndex()+11;
			start=num;
			if (r30.isSelected()){day30=30;}
			else{day30=31;}
			runit();
			this.setVisible(false);
			Scheduler.closeCF();
		}

	}
	void runit(){
		int c=start;
		int day=1;
		for (Entry<Integer, JLabel> label:labels.entrySet()){
			label.getValue().setText("");
		}
		if (c==16&&day30==31){
			labels.get(11).setBorder(new EtchedBorder(EtchedBorder.LOWERED,Color.white,Color.RED));
			labels.get(11).setText("31");
		}
		else if(c==17){
			labels.get(11).setText("30");
			labels.get(11).setBorder(new EtchedBorder(EtchedBorder.LOWERED,Color.white,Color.RED));
			if (day30==31){
				labels.get(12).setText("31");
				labels.get(12).setBorder(new EtchedBorder(EtchedBorder.LOWERED,Color.white,Color.RED));
			}
		}
		while (c<=57){
			if (c%10<8&&c%10>0&&day<=day30){
				String t=Integer.toString(day);
				labels.get(c).setText(t);
				day++;
			}
			c++;
		}
	}
	private void load(){
		labels.put(11, test.l11d);
		labels.put(12, test.l12d);
		labels.put(13, test.l13d);
		labels.put(14, test.l14d);
		labels.put(15, test.l15d);
		labels.put(16, test.l16d);
		labels.put(17, test.l17d);
		labels.put(21, test.l21d);
		labels.put(22, test.l22d);
		labels.put(23, test.l23d);
		labels.put(24, test.l24d);
		labels.put(25, test.l25d);
		labels.put(26, test.l26d);
		labels.put(27, test.l27d);
		labels.put(31, test.l31d);
		labels.put(32, test.l32d);
		labels.put(33, test.l33d);
		labels.put(34, test.l34d);
		labels.put(35, test.l35d);
		labels.put(36, test.l36d);
		labels.put(37, test.l37d);
		labels.put(41, test.l41d);
		labels.put(42, test.l42d);
		labels.put(43, test.l43d);
		labels.put(44, test.l44d);
		labels.put(45, test.l45d);
		labels.put(46, test.l46d);
		labels.put(47, test.l47d);
		labels.put(51, test.l51d);
		labels.put(52, test.l52d);
		labels.put(53, test.l53d);
		labels.put(54, test.l54d);
		labels.put(55, test.l55d);
		labels.put(56, test.l56d);
		labels.put(57, test.l57d);
	}
	@SuppressWarnings("static-access")
	private void setupPanel(){
		getContentPane().setLayout(null);
		setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		
		cbdays.setBounds(36, 11, 122, 20);
		getContentPane().add(cbdays);
		
		r30.setSelected(true);
		buttonGroup.add(r30);
		r30.setBounds(10, 38, 89, 23);
		getContentPane().add(r30);
		
		buttonGroup.add(r31);
		r31.setBounds(101, 38, 89, 23);
		getContentPane().add(r31);
		
		bset.setBounds(51, 68, 89, 23);
		getContentPane().add(bset);
		bset.addActionListener(this);
		this.setLocation(Scheduler.setLoc());
		this.addWindowListener(this);
		this.setSize(200,152);
		this.setVisible(true);
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
