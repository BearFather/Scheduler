package net.bearfather.Scheduler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

import java.awt.Toolkit;
import java.io.File;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;

import javax.swing.JComboBox;

class CalenderFrame extends JFrame implements ActionListener,MouseListener{
	private static final long serialVersionUID = 1L;
	public JLayeredPane panel = new JLayeredPane();
	private JLabel lhrs = new JLabel("");
	private JTextPane t1sun = new JTextPane();
	private JTextPane t1mon = new JTextPane();
	private JTextPane t1tue = new JTextPane();
	private JTextPane t1wed = new JTextPane();
	private JTextPane t1thu = new JTextPane();
	private JTextPane t1fri = new JTextPane();
	private JTextPane t1sat = new JTextPane();
	private JTextPane t2sat = new JTextPane();
	private JTextPane t2fri = new JTextPane();
	private JTextPane t2thu = new JTextPane();
	private JTextPane t2wed = new JTextPane();
	private JTextPane t2tue = new JTextPane();
	private JTextPane t2mon = new JTextPane();
	private JTextPane t2sun = new JTextPane();
	private JTextPane t3sat = new JTextPane();
	private JTextPane t3fri = new JTextPane();
	private JTextPane t3thu = new JTextPane();
	private JTextPane t3wed = new JTextPane();
	private JTextPane t3tue = new JTextPane();
	private JTextPane t3mon = new JTextPane();
	private JTextPane t3sun = new JTextPane();
	private JTextPane t4sun = new JTextPane();
	private JTextPane t4mon = new JTextPane();
	private JTextPane t4tue = new JTextPane();
	private JTextPane t4wed = new JTextPane();
	private JTextPane t4thu = new JTextPane();
	private JTextPane t4fri = new JTextPane();
	private JTextPane t4sat = new JTextPane();
	private JTextPane t5sun = new JTextPane();
	private JTextPane t5mon = new JTextPane();
	private JTextPane t5tue = new JTextPane();
	private JTextPane t5wed = new JTextPane();
	private JTextPane t5thu = new JTextPane();
	private JTextPane t5fri = new JTextPane();
	private JTextPane t5sat = new JTextPane();
	JLabel l11d = new JLabel("");
	JLabel l12d = new JLabel("");
	JLabel l13d = new JLabel("");
	JLabel l14d = new JLabel("");
	JLabel l15d = new JLabel("");
	JLabel l16d = new JLabel("");
	JLabel l17d = new JLabel("");
	JLabel l21d = new JLabel("");
	JLabel l22d = new JLabel("");
	JLabel l23d = new JLabel("");
	JLabel l24d = new JLabel("");
	JLabel l25d = new JLabel("");
	JLabel l26d = new JLabel("");
	JLabel l27d = new JLabel("");
	JLabel l31d = new JLabel("");
	JLabel l32d = new JLabel("");
	JLabel l33d = new JLabel("");
	JLabel l34d = new JLabel("");
	JLabel l35d = new JLabel("");
	JLabel l36d = new JLabel("");
	JLabel l37d = new JLabel("");
	JLabel l41d = new JLabel("");
	JLabel l42d = new JLabel("");
	JLabel l43d = new JLabel("");
	JLabel l44d = new JLabel("");
	JLabel l45d = new JLabel("");
	JLabel l46d = new JLabel("");
	JLabel l47d = new JLabel("");
	JLabel l51d = new JLabel("");
	JLabel l52d = new JLabel("");
	JLabel l53d = new JLabel("");
	JLabel l54d = new JLabel("");
	JLabel l55d = new JLabel("");
	JLabel l56d = new JLabel("");
	JLabel l57d = new JLabel("");
	private JLabel l11s = new JLabel("");
	private JLabel l57s = new JLabel("");
	private JLabel l13s = new JLabel("");
	private JLabel l34s = new JLabel("");
	private JLabel l15s = new JLabel("");
	private JLabel l35s = new JLabel("");
	private JLabel l53s = new JLabel("");
	private JLabel l36s = new JLabel("");
	private JLabel l26s = new JLabel("");
	private JLabel l56s = new JLabel("");
	private JLabel l41s = new JLabel("");
	private JLabel l46s = new JLabel("");
	private JLabel l42s = new JLabel("");
	private JLabel l43s = new JLabel("");
	private JLabel l27s = new JLabel("");
	private JLabel l32s = new JLabel("");
	private JLabel l45s = new JLabel("");
	private JLabel l12s = new JLabel("");
	private JLabel l54s = new JLabel("");
	private JLabel l21s = new JLabel("");
	private JLabel l22s = new JLabel("");
	private JLabel l55s = new JLabel("");
	private JLabel l52s = new JLabel("");
	private JLabel l33s = new JLabel("");
	private JLabel l37s = new JLabel("");
	private JLabel l31s = new JLabel("");
	private JLabel l25s = new JLabel("");
	private JLabel l24s = new JLabel("");
	private JLabel l51s = new JLabel("");
	private JLabel l17s = new JLabel("");
	private JLabel l16s = new JLabel("");
	private JLabel l44s = new JLabel("");
	private JLabel l14s = new JLabel("");
	private JLabel l23s = new JLabel("");
	private JLabel l47s = new JLabel("");
	private JLabel l11h = new JLabel("");
	private JLabel l12h = new JLabel("");
	private JLabel l13h = new JLabel("");
	private JLabel l14h = new JLabel("");
	private JLabel l15h = new JLabel("");
	private JLabel l16h = new JLabel("");
	private JLabel l17h = new JLabel("");
	private JLabel l22h = new JLabel("");
	private JLabel l23h = new JLabel("");
	private JLabel l24h = new JLabel("");
	private JLabel l25h = new JLabel("");
	private JLabel l26h = new JLabel("");
	private JLabel l27h = new JLabel("");
	private JLabel l21h = new JLabel("");
	private JLabel l32h = new JLabel("");
	private JLabel l33h = new JLabel("");
	private JLabel l34h = new JLabel("");
	private JLabel l35h = new JLabel("");
	private JLabel l36h = new JLabel("");
	private JLabel l37h = new JLabel("");
	private JLabel l31h = new JLabel("");
	private JLabel l42h = new JLabel("");
	private JLabel l43h = new JLabel("");
	private JLabel l44h = new JLabel("");
	private JLabel l45h = new JLabel("");
	private JLabel l46h = new JLabel("");
	private JLabel l47h = new JLabel("");
	private JLabel l41h = new JLabel("");
	private JLabel l52h = new JLabel("");
	private JLabel l53h = new JLabel("");
	private JLabel l54h = new JLabel("");
	private JLabel l55h = new JLabel("");
	private JLabel l56h = new JLabel("");
	private JLabel l57h = new JLabel("");
	private JLabel l51h = new JLabel("");
	private JLabel l43w = new JLabel("");
	private JLabel l21w = new JLabel("");
	private JLabel l11w = new JLabel("");
	private JLabel l25w = new JLabel("");
	private JLabel l47w = new JLabel("");
	private JLabel l36w = new JLabel("");
	private JLabel l41w = new JLabel("");
	private JLabel l26w = new JLabel("");
	private JLabel l35w = new JLabel("");
	private JLabel l23w = new JLabel("");
	private JLabel l13w = new JLabel("");
	private JLabel l45w = new JLabel("");
	private JLabel l16w = new JLabel("");
	private JLabel l14w = new JLabel("");
	private JLabel l27w = new JLabel("");
	private JLabel l31w = new JLabel("");
	private JLabel l44w = new JLabel("");
	private JLabel l24w = new JLabel("");
	private JLabel l32w = new JLabel("");
	private JLabel l54w = new JLabel("");
	private JLabel l22w = new JLabel("");
	private JLabel l55w = new JLabel("");
	private JLabel l56w = new JLabel("");
	private JLabel l53w = new JLabel("");
	private JLabel l15w = new JLabel("");
	private JLabel l33w = new JLabel("");
	private JLabel l12w = new JLabel("");
	private JLabel l34w = new JLabel("");
	private JLabel l51w = new JLabel("");
	private JLabel l17w = new JLabel("");
	private JLabel l52w = new JLabel("");
	private JLabel l42w = new JLabel("");
	private JLabel l46w = new JLabel("");
	private JLabel l57w = new JLabel("");
	private JLabel l37w = new JLabel("");
	
	HashMap<Integer,JTextPane> panes=new HashMap<Integer,JTextPane>();
	private HashMap<Integer,JLabel> start=new HashMap<Integer,JLabel>();
	HashMap<Integer,JLabel> labels= new HashMap<Integer,JLabel>();
	private HashMap<Integer,JLabel> hrs= new HashMap<Integer,JLabel>();
	HashMap<Integer,JLabel> wrks= new HashMap<Integer,JLabel>();
	private final JMenuBar menuBar = new JMenuBar();
	private JMenu mnJobs=new JMenu();
	private final JMenuItem mjadd = new JMenuItem("Add");
	private JMenuItem mjedit = new JMenuItem("Edit");
	private JMenuItem mwadd = new JMenuItem("W/O Add");
	private JMenuItem mwedit = new JMenuItem("W/O Edit");
	private JMenuItem mwdel = new JMenuItem("W/O Delete");
	private final JMenu mFile = new JMenu("File");
	private final JMenuItem mfsave = new JMenuItem("Save");
	private final JMenuItem mfload = new JMenuItem("Load");
	private final JMenuItem mjdel = new JMenuItem("Delete");
	private final JMenuItem mfexit = new JMenuItem("Exit");
	JMenuItem mnTest = new JMenuItem("test");
	private JMenuItem mprint = new JMenuItem("Print");
	private final JMenu mnDate = new JMenu("Date");
	private final JMenuItem mddate = new JMenuItem("Set Date");
	private JMenuItem mlist = new JMenuItem("Month List");
	private final JLabel lwarn = new JLabel("SAVING.....");
	private static String[] smonths={"Select Month","January","February","March","April","May","June","July","August","September","October","November","December"};
	@SuppressWarnings({ "unchecked", "rawtypes" }) 
	JComboBox cbmonth = new JComboBox(smonths);

	
	public CalenderFrame() {
		setupPanel();
		loadMap();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object event=e.getSource();
		if (event.equals(mfsave)){
			lwarn.setText("SAVING...");
			lwarn.setVisible(true);
			JFileChooser fc = new JFileChooser();
		    fc.setCurrentDirectory(new java.io.File("."));
		    fc.setDialogTitle("Please choose a folder.");
		    //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    fc.setSelectedFile(new File(cbmonth.getSelectedItem().toString().trim()));
			int returnVal = fc.showSaveDialog(this);
			this.setEnabled(false);
			this.setVisible(true);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
				LoadSave.saveMonth(file.toString());
				lwarn.setVisible(false);
				JOptionPane.showMessageDialog(this,"Save is Complete!");
				
			} else {
	        	
	        }
			lwarn.setVisible(false);
			this.setVisible(true);
			this.setEnabled(true);
		}else if (event.equals(mfload)){
			lwarn.setText("LOADING...");
			lwarn.setVisible(true);
			JFileChooser fc = new JFileChooser();
		    fc.setCurrentDirectory(new java.io.File("."));
		    fc.setDialogTitle("Please choose a folder.");
		    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showOpenDialog(this);
			this.setEnabled(false);
			this.setVisible(true);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
				LoadSave.buildMonth(file.toString());
	            //try {JarPack.unPack(file.getName(), file.getPath().substring(0, file.getPath().length()-3));} catch (IOException e1) {e1.printStackTrace();}
				lwarn.setVisible(false);
				//JOptionPane.showMessageDialog(this,"Load is Complete!");
	        } else {
	        	
	        }
			lwarn.setVisible(false);
			this.setEnabled(true);
		}else if (event.equals(mddate)){
			new SetDateFrame();
			this.setEnabled(false);
		}else if(event.equals(mjadd)){
			new JobFrame(null);
			this.setEnabled(false);
		}else if(event.equals(mjedit)){
			new IdFrame(false);
			this.setEnabled(false);
		}else if(event.equals(mjdel)){
			new IdFrame(true);
			this.setEnabled(false);
		}else if(event.equals(mfexit)){
			System.exit(0);
		}else if(event.equals(mlist)){
			new MonthFrame();
		}else if(event.equals(mprint)){
			new PrintForm(panel);
		}else if(event.equals(mwadd)){
			new WorkOrderFrame(null);
			this.setEnabled(false);
		}else if(event.equals(mwdel)){
			new IdWFrame(true);
			this.setEnabled(false);
		}else if(event.equals(mwedit)){
			new IdWFrame(false);
			this.setEnabled(false);
		}else if (event.equals(mnTest)){
			for (WorkOrder job:Scheduler.workorders.values()){
				String s="";
				for (int v:job.getMonth()){
					s=s+v;
				}
				System.out.println(s);
			}
		
		}else if (event.equals(cbmonth)){
			Scheduler.showFrame(cbmonth.getSelectedIndex());
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object es=e.getSource();
		if (panes.containsValue(es)){
			for (Entry<Integer, JTextPane> v:panes.entrySet()){
				if (v.getValue().equals(es)){
					String date=labels.get(v.getKey()).getText();
					if (date!=null&&!date.equals("")){
						Scheduler.df=new DayFrame(v.getKey());
						this.setEnabled(false);
					}else{break;}
				}
				
			}
		}else if (es.equals(cbmonth)){
			System.out.println("boo");
		}
	}
	void addJob(int pane,Job job){
		if (!Scheduler.jobs.get(pane).contains(job)){
			int jtime=job.getLength();
			Scheduler.jobs.get(pane).add(job);
			Scheduler.times.put(pane, Scheduler.times.get(pane)+jtime);
			disPane(pane);
		}
	}
	void remJob(int pane,Job job){
		if (Scheduler.jobs.get(pane).contains(job)){
			int num=Scheduler.jobs.get(pane).indexOf(job);
			Scheduler.jobs.get(pane).remove(num);
			Scheduler.times.put(pane,Scheduler.times.get(pane)-job.getLength());
			disPane(pane);
			int chk=chkTimeR(pane);
			start.get(pane).setText(setTime(pane,chk));
		}
	}
	void disPane(int pane){
		JTextPane tf=panes.get(pane);
		//Time
		int time=Scheduler.times.get(pane);
		int workers=Integer.parseInt(Scheduler.workers.get(pane).get(0));
		time=(time/workers)+(time % workers == 0 ? 0 : 1);
		if (time>0){hrs.get(pane).setText(Integer.toString(time)+"h");}
		else{hrs.get(pane).setText("");}
		if (time>6){changeBg(tf,Color.red);}
		else if (time<7&&time>4){changeBg(tf,Color.yellow);}
		else if (time<5&&time>0){changeBg(tf,Color.green);}
		else if (time<1){changeBg(tf,new Color(248,248,255));}

		//Name,Type,Cat
		ArrayList<String> name=new ArrayList<String>();
		String title="";
		int type=0;
		boolean frun=true;
		for (Job value:Scheduler.jobs.get(pane)){
			//type
			if (frun){
				type=value.getType();
				frun=false;
			}else{
				if (type!=value.getType()){type=2;}
			}
			//name and cat
			String tname=value.getName();
			if (value.getCat()==1){tname=tname+" W/O";}
			name.add(tname);
			//start time
			int stime;
			if (value.getCat()==1){
				WorkOrder w=(WorkOrder)value;
				stime=Data.pI(w.getStart(),0);
				}
			else {stime=chkTime(pane,value.getDay(pane%10)[1]);}
			start.get(pane).setText(setTime(pane,stime));

		}
		
		for (String value:Scheduler.workers.get(pane)){
			if (Scheduler.fnames.containsKey(value)){
				String iname=Scheduler.fnames.get(value);
				String iworkers=wrks.get(pane).getText();
				if (iworkers.length()>0&&!iworkers.contains(iname)){
					wrks.get(pane).setText(iworkers+","+iname);
				}
				else {
					wrks.get(pane).setText(iname);
				}
			}
		}
		if (type==0){changeFg(tf,Color.blue);}
		else if(type==1){changeFg(tf,Color.gray);}
		for (String v:name){title=title+v+"\n";}
		setText(tf,title);
		totTime();
		
	}
	private static int chkTimeR(int pane){
		int chk=2359;
		for (Job v:Scheduler.jobs.get(pane)){
			if (v.getDay(pane%10)[1]<chk){
				chk=v.getDay(pane%10)[1];
			}
		}
		if (chk==2359){chk=0;}
		return chk;
	}
	private static int chkTime(int num,int time){
		int rtn=time;
		int ctime=Scheduler.startT.get(num);
		if (time>ctime&&ctime!=0){
			return ctime;
		}
		
		return rtn;
		
	}
	static String setTime(int num,int time){
		String rtn="";
		Scheduler.startT.put(num, time);
		if (time!=0){
			int hr=time/100;
			int min=time%100;
			String pm="am";
			if (hr>12){
				pm="pm";
				hr=hr-12;
			}
			String smin="00";
			if (min!=0){
				smin=Integer.toString(min);
			}
			String stime=Integer.toString(hr)+":"+smin+" "+pm;
			rtn=stime;
		}else if(time==0&&Scheduler.jobs.get(num).size()>0){
			rtn="any";
		}
		return rtn;
	}
	private static void setText(JTextPane tf,String msg){
		tf.setText(msg);
	}
	private static void changeBg(JTextPane tf, Color color){
		tf.setBackground(color);
	}
	private void changeFg(JTextPane tf, Color color){
		tf.setDisabledTextColor(color);
	}
// TODO from UCDetector: Method "CalenderFrame.addText(JTextPane,String)" has 0 references
	public void addText(JTextPane tf,String msg){ // NO_UCD (unused code)
			String temp=tf.getText();
			tf.setText(temp+msg);
	}
	private void totTime(){
		int end=0;
		for (int v:Scheduler.times.values()){
			end=end+v;
		}
		lhrs.setText(Integer.toString(end));
	}
	private void loadMap(){
		panes.put(11, t1sun);
		panes.put(12, t1mon);
		panes.put(13, t1tue);
		panes.put(14, t1wed);
		panes.put(15, t1thu);
		panes.put(16, t1fri);
		panes.put(17, t1sat);
		panes.put(21, t2sun);
		panes.put(22, t2mon);
		panes.put(23, t2tue);
		panes.put(24, t2wed);
		panes.put(25, t2thu);
		panes.put(26, t2fri);
		panes.put(27, t2sat);
		panes.put(31, t3sun);
		panes.put(32, t3mon);
		panes.put(33, t3tue);
		panes.put(34, t3wed);
		panes.put(35, t3thu);
		panes.put(36, t3fri);
		panes.put(37, t3sat);
		panes.put(41, t4sun);
		panes.put(42, t4mon);
		panes.put(43, t4tue);
		panes.put(44, t4wed);
		panes.put(45, t4thu);
		panes.put(46, t4fri);
		panes.put(47, t4sat);
		panes.put(51, t5sun);
		panes.put(52, t5mon);
		panes.put(53, t5tue);
		panes.put(54, t5wed);
		panes.put(55, t5thu);
		panes.put(56, t5fri);
		panes.put(57, t5sat);
		start.put(11, l11s);
		start.put(12, l12s);
		start.put(13, l13s);
		start.put(14, l14s);
		start.put(15, l15s);
		start.put(16, l16s);
		start.put(17, l17s);
		start.put(21, l21s);
		start.put(22, l22s);
		start.put(23, l23s);
		start.put(24, l24s);
		start.put(25, l25s);
		start.put(26, l26s);
		start.put(27, l27s);
		start.put(31, l31s);
		start.put(32, l32s);
		start.put(33, l33s);
		start.put(34, l34s);
		start.put(35, l35s);
		start.put(36, l36s);
		start.put(37, l37s);
		start.put(41, l41s);
		start.put(42, l42s);
		start.put(43, l43s);
		start.put(44, l44s);
		start.put(45, l45s);
		start.put(46, l46s);
		start.put(47, l47s);
		start.put(51, l51s);
		start.put(52, l52s);
		start.put(53, l53s);
		start.put(54, l54s);
		start.put(55, l55s);
		start.put(56, l56s);
		start.put(57, l57s);
		hrs.put(11, l11h);
		hrs.put(12, l12h);
		hrs.put(13, l13h);
		hrs.put(14, l14h);
		hrs.put(15, l15h);
		hrs.put(16, l16h);
		hrs.put(17, l17h);
		hrs.put(21, l21h);
		hrs.put(22, l22h);
		hrs.put(23, l23h);
		hrs.put(24, l24h);
		hrs.put(25, l25h);
		hrs.put(26, l26h);
		hrs.put(27, l27h);
		hrs.put(31, l31h);
		hrs.put(32, l32h);
		hrs.put(33, l33h);
		hrs.put(34, l34h);
		hrs.put(35, l35h);
		hrs.put(36, l36h);
		hrs.put(37, l37h);
		hrs.put(41, l41h);
		hrs.put(42, l42h);
		hrs.put(43, l43h);
		hrs.put(44, l44h);
		hrs.put(45, l45h);
		hrs.put(46, l46h);
		hrs.put(47, l47h);
		hrs.put(51, l51h);
		hrs.put(52, l52h);
		hrs.put(53, l53h);
		hrs.put(54, l54h);
		hrs.put(55, l55h);
		hrs.put(56, l56h);
		hrs.put(57, l57h);
		wrks.put(11, l11w);
		wrks.put(12, l12w);
		wrks.put(13, l13w);
		wrks.put(14, l14w);
		wrks.put(15, l15w);
		wrks.put(16, l16w);
		wrks.put(17, l17w);
		wrks.put(21, l21w);
		wrks.put(22, l22w);
		wrks.put(23, l23w);
		wrks.put(24, l24w);
		wrks.put(25, l25w);
		wrks.put(26, l26w);
		wrks.put(27, l27w);
		wrks.put(31, l31w);
		wrks.put(32, l32w);
		wrks.put(33, l33w);
		wrks.put(34, l34w);
		wrks.put(35, l35w);
		wrks.put(36, l36w);
		wrks.put(37, l37w);
		wrks.put(41, l41w);
		wrks.put(42, l42w);
		wrks.put(43, l43w);
		wrks.put(44, l44w);
		wrks.put(45, l45w);
		wrks.put(46, l46w);
		wrks.put(47, l47w);
		wrks.put(51, l51w);
		wrks.put(52, l52w);
		wrks.put(53, l53w);
		wrks.put(54, l54w);
		wrks.put(55, l55w);
		wrks.put(56, l56w);
		wrks.put(57, l57w);
		
	}
	
	private void setupPanel(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(CalenderFrame.class.getResource("/res/icon.png")));
		setTitle("Scheduler");
	    cbmonth.addActionListener(this);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		JLabel lblMonth = new JLabel("Month: ");
		lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonth.setBounds(32, 44, 46, 14);
		getContentPane().add(lblMonth);
		
		JLabel lblHrs = new JLabel("Total Hrs: ");
		lblHrs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHrs.setBounds(304, 46, 74, 14);
		getContentPane().add(lblHrs);
		
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(6, 87, 842, 650);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		l43w.setHorizontalAlignment(SwingConstants.RIGHT);
		l43w.setBounds(246, 481, 108, 14);
		panel.add(l43w);
		
		l21w.setHorizontalAlignment(SwingConstants.RIGHT);
		l21w.setBounds(10, 226, 108, 14);
		panel.add(l21w);
		
		l11w.setHorizontalAlignment(SwingConstants.RIGHT);
		l11w.setBounds(10, 98, 108, 14);
		panel.add(l11w);
		
		l25w.setHorizontalAlignment(SwingConstants.RIGHT);
		l25w.setBounds(482, 226, 108, 14);
		panel.add(l25w);
		
		l47w.setHorizontalAlignment(SwingConstants.RIGHT);
		l47w.setBounds(718, 481, 108, 14);
		panel.add(l47w);
		
		l36w.setHorizontalAlignment(SwingConstants.RIGHT);
		l36w.setBounds(600, 354, 108, 14);
		panel.add(l36w);
		
		l41w.setHorizontalAlignment(SwingConstants.RIGHT);
		l41w.setBounds(10, 481, 108, 14);
		panel.add(l41w);
		
		l26w.setHorizontalAlignment(SwingConstants.RIGHT);
		l26w.setBounds(600, 226, 108, 14);
		panel.add(l26w);
		
		l35w.setHorizontalAlignment(SwingConstants.RIGHT);
		l35w.setBounds(482, 354, 108, 14);
		panel.add(l35w);
		
		l23w.setHorizontalAlignment(SwingConstants.RIGHT);
		l23w.setBounds(246, 226, 108, 14);
		panel.add(l23w);
		
		l13w.setHorizontalAlignment(SwingConstants.RIGHT);
		l13w.setBounds(246, 98, 108, 14);
		panel.add(l13w);
		
		l45w.setHorizontalAlignment(SwingConstants.RIGHT);
		l45w.setBounds(482, 481, 108, 14);
		panel.add(l45w);
		
		l16w.setHorizontalAlignment(SwingConstants.RIGHT);
		l16w.setBounds(600, 98, 108, 14);
		panel.add(l16w);
		
		l14w.setHorizontalAlignment(SwingConstants.RIGHT);
		l14w.setBounds(364, 98, 108, 14);
		panel.add(l14w);
		
		l27w.setHorizontalAlignment(SwingConstants.RIGHT);
		l27w.setBounds(718, 226, 108, 14);
		panel.add(l27w);
		
		l31w.setHorizontalAlignment(SwingConstants.RIGHT);
		l31w.setBounds(10, 354, 108, 14);
		panel.add(l31w);
		
		l44w.setHorizontalAlignment(SwingConstants.RIGHT);
		l44w.setBounds(364, 481, 108, 14);
		panel.add(l44w);
		
		l24w.setHorizontalAlignment(SwingConstants.RIGHT);
		l24w.setBounds(364, 226, 108, 14);
		panel.add(l24w);
		
		l32w.setHorizontalAlignment(SwingConstants.RIGHT);
		l32w.setBounds(128, 354, 108, 14);
		panel.add(l32w);
		
		l54w.setHorizontalAlignment(SwingConstants.RIGHT);
		l54w.setBounds(364, 607, 108, 14);
		panel.add(l54w);
		
		l22w.setHorizontalAlignment(SwingConstants.RIGHT);
		l22w.setBounds(128, 226, 108, 14);
		panel.add(l22w);
		
		l55w.setHorizontalAlignment(SwingConstants.RIGHT);
		l55w.setBounds(482, 607, 108, 14);
		panel.add(l55w);
		
		l56w.setHorizontalAlignment(SwingConstants.RIGHT);
		l56w.setBounds(600, 607, 108, 14);
		panel.add(l56w);
		
		l53w.setHorizontalAlignment(SwingConstants.RIGHT);
		l53w.setBounds(246, 607, 108, 14);
		panel.add(l53w);
		
		l15w.setHorizontalAlignment(SwingConstants.RIGHT);
		l15w.setBounds(482, 98, 108, 14);
		panel.add(l15w);
		
		l33w.setHorizontalAlignment(SwingConstants.RIGHT);
		l33w.setBounds(246, 354, 108, 14);
		panel.add(l33w);
		
		l12w.setHorizontalAlignment(SwingConstants.RIGHT);
		l12w.setBounds(128, 98, 108, 14);
		panel.add(l12w);
		
		l34w.setHorizontalAlignment(SwingConstants.RIGHT);
		l34w.setBounds(364, 354, 108, 14);
		panel.add(l34w);
		
		l51w.setHorizontalAlignment(SwingConstants.RIGHT);
		l51w.setBounds(10, 607, 108, 14);
		panel.add(l51w);
		
		l17w.setHorizontalAlignment(SwingConstants.RIGHT);
		l17w.setBounds(718, 98, 108, 14);
		panel.add(l17w);
		
		l52w.setHorizontalAlignment(SwingConstants.RIGHT);
		l52w.setBounds(128, 607, 108, 14);
		panel.add(l52w);
		
		l42w.setHorizontalAlignment(SwingConstants.RIGHT);
		l42w.setBounds(128, 481, 108, 14);
		panel.add(l42w);
		
		l46w.setHorizontalAlignment(SwingConstants.RIGHT);
		l46w.setBounds(600, 481, 108, 14);
		panel.add(l46w);
		
		l57w.setHorizontalAlignment(SwingConstants.RIGHT);
		l57w.setBounds(718, 607, 108, 14);
		panel.add(l57w);
		
		l37w.setHorizontalAlignment(SwingConstants.RIGHT);
		l37w.setBounds(718, 354, 108, 14);

		panel.add(l37w);
		l37h.setHorizontalAlignment(SwingConstants.CENTER);
		l37h.setBounds(718, 367, 32, 14);
		
		panel.add(l37h);
		l21h.setHorizontalAlignment(SwingConstants.CENTER);
		l21h.setBounds(10, 240, 32, 14);
		
		panel.add(l21h);
		l47h.setHorizontalAlignment(SwingConstants.CENTER);
		l47h.setBounds(718, 494, 32, 14);
		
		panel.add(l47h);
		l51h.setHorizontalAlignment(SwingConstants.CENTER);
		l51h.setBounds(10, 621, 32, 14);
		
		panel.add(l51h);
		l31h.setHorizontalAlignment(SwingConstants.CENTER);
		l31h.setBounds(10, 367, 32, 14);
		
		panel.add(l31h);
		l32h.setHorizontalAlignment(SwingConstants.CENTER);
		l32h.setBounds(128, 367, 32, 14);
		
		panel.add(l32h);
		l53h.setHorizontalAlignment(SwingConstants.CENTER);
		l53h.setBounds(246, 621, 32, 14);
		
		panel.add(l53h);
		l45h.setHorizontalAlignment(SwingConstants.CENTER);
		l45h.setBounds(482, 494, 32, 14);
		
		panel.add(l45h);
		l54h.setHorizontalAlignment(SwingConstants.CENTER);
		l54h.setBounds(364, 621, 32, 14);
		
		panel.add(l54h);
		l33h.setHorizontalAlignment(SwingConstants.CENTER);
		l33h.setBounds(246, 367, 32, 14);
		
		panel.add(l33h);
		l34h.setHorizontalAlignment(SwingConstants.CENTER);
		l34h.setBounds(364, 367, 32, 14);
		
		panel.add(l34h);
		l56h.setHorizontalAlignment(SwingConstants.CENTER);
		l56h.setBounds(600, 621, 32, 14);
		
		panel.add(l56h);
		l35h.setHorizontalAlignment(SwingConstants.CENTER);
		l35h.setBounds(482, 367, 32, 14);
		
		panel.add(l35h);
		l25h.setHorizontalAlignment(SwingConstants.CENTER);
		l25h.setBounds(482, 240, 32, 14);
		
		panel.add(l25h);
		l23h.setHorizontalAlignment(SwingConstants.CENTER);
		l23h.setBounds(246, 240, 32, 14);
		
		panel.add(l23h);
		l36h.setHorizontalAlignment(SwingConstants.CENTER);
		l36h.setBounds(600, 367, 32, 14);
		
		panel.add(l36h);
		l24h.setHorizontalAlignment(SwingConstants.CENTER);
		l24h.setBounds(364, 240, 32, 14);
		
		panel.add(l24h);
		l27h.setHorizontalAlignment(SwingConstants.CENTER);
		l27h.setBounds(718, 240, 32, 14);
		
		panel.add(l27h);
		l42h.setHorizontalAlignment(SwingConstants.CENTER);
		l42h.setBounds(128, 494, 32, 14);
		
		panel.add(l42h);
		l57h.setHorizontalAlignment(SwingConstants.CENTER);
		l57h.setBounds(718, 621, 32, 14);
		
		panel.add(l57h);
		l43h.setHorizontalAlignment(SwingConstants.CENTER);
		l43h.setBounds(246, 494, 32, 14);
		
		panel.add(l43h);
		l41h.setHorizontalAlignment(SwingConstants.CENTER);
		l41h.setBounds(10, 494, 32, 14);
		
		panel.add(l41h);
		l22h.setHorizontalAlignment(SwingConstants.CENTER);
		l22h.setBounds(128, 240, 32, 14);
		
		panel.add(l22h);
		l52h.setHorizontalAlignment(SwingConstants.CENTER);
		l52h.setBounds(128, 621, 32, 14);
		
		panel.add(l52h);
		l46h.setHorizontalAlignment(SwingConstants.CENTER);
		l46h.setBounds(600, 494, 32, 14);
		
		panel.add(l46h);
		l55h.setHorizontalAlignment(SwingConstants.CENTER);
		l55h.setBounds(482, 621, 32, 14);
		
		panel.add(l55h);
		l26h.setHorizontalAlignment(SwingConstants.CENTER);
		l26h.setBounds(600, 240, 32, 14);
		
		panel.add(l26h);
		l44h.setHorizontalAlignment(SwingConstants.CENTER);
		l44h.setBounds(364, 494, 32, 14);
		
		panel.add(l44h);
		l14h.setHorizontalAlignment(SwingConstants.CENTER);
		l14h.setBounds(364, 113, 32, 14);
		
		panel.add(l14h);
		l12h.setHorizontalAlignment(SwingConstants.CENTER);
		l12h.setBounds(128, 113, 32, 14);
		
		panel.add(l12h);
		l13h.setHorizontalAlignment(SwingConstants.CENTER);
		l13h.setBounds(246, 113, 32, 14);
		
		panel.add(l13h);
		l17h.setHorizontalAlignment(SwingConstants.CENTER);
		l17h.setBounds(718, 113, 32, 14);
		
		panel.add(l17h);
		l16h.setHorizontalAlignment(SwingConstants.CENTER);
		l16h.setBounds(600, 113, 32, 14);
		
		panel.add(l16h);
		l15h.setHorizontalAlignment(SwingConstants.CENTER);
		l15h.setBounds(482, 113, 32, 14);
		
		panel.add(l15h);
		l11h.setHorizontalAlignment(SwingConstants.CENTER);
		l11h.setBounds(10, 113, 32, 14);
		
		panel.add(l11h);
		
		l54s.setHorizontalAlignment(SwingConstants.RIGHT);
		l54s.setBounds(399, 621, 74, 14);
		panel.add(l54s);
		
		l21s.setHorizontalAlignment(SwingConstants.RIGHT);
		l21s.setBounds(44, 240, 74, 14);
		panel.add(l21s);
		
		l22s.setHorizontalAlignment(SwingConstants.RIGHT);
		l22s.setBounds(162, 240, 74, 14);
		panel.add(l22s);
		
		l55s.setHorizontalAlignment(SwingConstants.RIGHT);
		l55s.setBounds(516, 621, 74, 14);
		panel.add(l55s);
		
		l52s.setHorizontalAlignment(SwingConstants.RIGHT);
		l52s.setBounds(162, 621, 74, 14);
		panel.add(l52s);
		
		l33s.setHorizontalAlignment(SwingConstants.RIGHT);
		l33s.setBounds(280, 367, 74, 14);
		panel.add(l33s);
		
		l37s.setHorizontalAlignment(SwingConstants.RIGHT);
		l37s.setBounds(752, 367, 74, 14);
		panel.add(l37s);
		
		l31s.setHorizontalAlignment(SwingConstants.RIGHT);
		l31s.setBounds(44, 367, 74, 14);
		panel.add(l31s);
		
		l25s.setHorizontalAlignment(SwingConstants.RIGHT);
		l25s.setBounds(516, 240, 74, 14);
		panel.add(l25s);
		
		l24s.setHorizontalAlignment(SwingConstants.RIGHT);
		l24s.setBounds(399, 240, 74, 14);
		panel.add(l24s);
		
		l51s.setHorizontalAlignment(SwingConstants.RIGHT);
		l51s.setBounds(44, 621, 74, 14);
		panel.add(l51s);
		
		l17s.setHorizontalAlignment(SwingConstants.RIGHT);
		l17s.setBounds(752, 113, 74, 14);
		panel.add(l17s);
		
		l16s.setHorizontalAlignment(SwingConstants.RIGHT);
		l16s.setBounds(634, 113, 74, 14);
		panel.add(l16s);
		
		l44s.setHorizontalAlignment(SwingConstants.RIGHT);
		l44s.setBounds(399, 494, 74, 14);
		panel.add(l44s);
		
		l14s.setHorizontalAlignment(SwingConstants.RIGHT);
		l14s.setBounds(399, 113, 74, 14);
		panel.add(l14s);
		
		l23s.setHorizontalAlignment(SwingConstants.RIGHT);
		l23s.setBounds(280, 240, 74, 14);
		panel.add(l23s);
		
		l12s.setHorizontalAlignment(SwingConstants.RIGHT);
		l12s.setBounds(162, 113, 74, 14);
		panel.add(l12s);
		
		l45s.setHorizontalAlignment(SwingConstants.RIGHT);
		l45s.setBounds(516, 494, 74, 14);
		panel.add(l45s);
		
		l32s.setHorizontalAlignment(SwingConstants.RIGHT);
		l32s.setBounds(162, 367, 74, 14);
		panel.add(l32s);
		
		l47s.setHorizontalAlignment(SwingConstants.RIGHT);
		l47s.setBounds(752, 494, 74, 14);
		panel.add(l47s);
		
		l27s.setHorizontalAlignment(SwingConstants.RIGHT);
		l27s.setBounds(752, 240, 74, 14);
		panel.add(l27s);
		
		l43s.setHorizontalAlignment(SwingConstants.RIGHT);
		l43s.setBounds(280, 494, 74, 14);
		panel.add(l43s);
		
		l42s.setHorizontalAlignment(SwingConstants.RIGHT);
		l42s.setBounds(162, 494, 74, 14);
		panel.add(l42s);
		
		l46s.setHorizontalAlignment(SwingConstants.RIGHT);
		l46s.setBounds(634, 494, 74, 14);
		panel.add(l46s);
		
		l41s.setHorizontalAlignment(SwingConstants.RIGHT);
		l41s.setBounds(44, 494, 74, 14);
		panel.add(l41s);
		
		l56s.setHorizontalAlignment(SwingConstants.RIGHT);
		l56s.setBounds(634, 621, 74, 14);
		panel.add(l56s);
		
		l26s.setHorizontalAlignment(SwingConstants.RIGHT);
		l26s.setBounds(634, 240, 74, 14);
		panel.add(l26s);
		
		l36s.setHorizontalAlignment(SwingConstants.RIGHT);
		l36s.setBounds(634, 367, 74, 14);
		panel.add(l36s);
		
		l53s.setHorizontalAlignment(SwingConstants.RIGHT);
		l53s.setBounds(280, 621, 74, 14);
		panel.add(l53s);
		
		l35s.setHorizontalAlignment(SwingConstants.RIGHT);
		l35s.setBounds(516, 367, 74, 14);
		panel.add(l35s);
		
		l15s.setHorizontalAlignment(SwingConstants.RIGHT);
		l15s.setBounds(516, 113, 74, 14);
		panel.add(l15s);
		
		l34s.setHorizontalAlignment(SwingConstants.RIGHT);
		l34s.setBounds(398, 367, 74, 14);
		panel.add(l34s);
		
		l13s.setHorizontalAlignment(SwingConstants.RIGHT);
		l13s.setBounds(280, 113, 74, 14);
		panel.add(l13s);
		
		l57s.setHorizontalAlignment(SwingConstants.RIGHT);
		l57s.setBounds(752, 621, 74, 14);
		panel.add(l57s);
		l11s.setBackground(new Color(220, 220, 220));
		
		l11s.setHorizontalAlignment(SwingConstants.RIGHT);
		l11s.setBounds(44, 113, 74, 14);
		panel.add(l11s);
		l51d.setHorizontalAlignment(SwingConstants.RIGHT);
		l51d.setForeground(Color.BLACK);
		l51d.setBounds(99, 519, 19, 14);
		
		panel.add(l51d);
		l21d.setHorizontalAlignment(SwingConstants.RIGHT);
		l21d.setForeground(Color.BLACK);
		l21d.setBounds(99, 138, 19, 14);
		
		panel.add(l21d);
		l14d.setHorizontalAlignment(SwingConstants.RIGHT);
		l14d.setForeground(Color.BLACK);
		l14d.setBounds(454, 11, 19, 14);
		
		panel.add(l14d);
		l34d.setHorizontalAlignment(SwingConstants.RIGHT);
		l34d.setForeground(Color.BLACK);
		l34d.setBounds(453, 265, 19, 14);
		
		panel.add(l34d);
		l42d.setHorizontalAlignment(SwingConstants.RIGHT);
		l42d.setForeground(Color.BLACK);
		l42d.setBounds(217, 392, 19, 14);
		
		panel.add(l42d);
		l12d.setHorizontalAlignment(SwingConstants.RIGHT);
		l12d.setForeground(Color.BLACK);
		l12d.setBounds(217, 11, 19, 14);
		
		panel.add(l12d);
		l45d.setHorizontalAlignment(SwingConstants.RIGHT);
		l45d.setForeground(Color.BLACK);
		l45d.setBounds(571, 392, 19, 14);
		
		panel.add(l45d);
		l13d.setHorizontalAlignment(SwingConstants.RIGHT);
		l13d.setForeground(Color.BLACK);
		l13d.setBounds(335, 11, 19, 14);
		
		panel.add(l13d);
		l31d.setHorizontalAlignment(SwingConstants.RIGHT);
		l31d.setForeground(Color.BLACK);
		l31d.setBounds(99, 265, 19, 14);
		
		panel.add(l31d);
		l26d.setHorizontalAlignment(SwingConstants.RIGHT);
		l26d.setForeground(Color.BLACK);
		l26d.setBounds(689, 138, 19, 14);
		
		panel.add(l26d);
		l41d.setHorizontalAlignment(SwingConstants.RIGHT);
		l41d.setForeground(Color.BLACK);
		l41d.setBounds(99, 392, 19, 14);
		
		panel.add(l41d);
		l44d.setHorizontalAlignment(SwingConstants.RIGHT);
		l44d.setForeground(Color.BLACK);
		l44d.setBounds(453, 392, 19, 14);
		
		panel.add(l44d);
		l15d.setHorizontalAlignment(SwingConstants.RIGHT);
		l15d.setForeground(Color.BLACK);
		l15d.setBounds(571, 11, 19, 14);
		
		panel.add(l15d);
		l53d.setHorizontalAlignment(SwingConstants.RIGHT);
		l53d.setForeground(Color.BLACK);
		l53d.setBounds(335, 519, 19, 14);
		
		panel.add(l53d);
		l25d.setHorizontalAlignment(SwingConstants.RIGHT);
		l25d.setForeground(Color.BLACK);
		l25d.setBounds(571, 138, 19, 14);
		
		panel.add(l25d);
		l32d.setHorizontalAlignment(SwingConstants.RIGHT);
		l32d.setForeground(Color.BLACK);
		l32d.setBounds(217, 265, 19, 14);
		
		panel.add(l32d);
		l17d.setHorizontalAlignment(SwingConstants.RIGHT);
		l17d.setForeground(Color.BLACK);
		l17d.setBounds(807, 11, 19, 14);
		
		panel.add(l17d);
		
		l54d.setHorizontalAlignment(SwingConstants.RIGHT);
		l54d.setForeground(Color.BLACK);
		l54d.setBounds(453, 519, 19, 14);
		panel.add(l54d);
		
		l57d.setHorizontalAlignment(SwingConstants.RIGHT);
		l57d.setForeground(Color.BLACK);
		l57d.setBounds(807, 519, 19, 14);
		panel.add(l57d);
		l23d.setHorizontalAlignment(SwingConstants.RIGHT);
		l23d.setForeground(Color.BLACK);
		l23d.setBounds(335, 138, 19, 14);
		
		panel.add(l23d);
		l27d.setHorizontalAlignment(SwingConstants.RIGHT);
		l27d.setForeground(Color.BLACK);
		l27d.setBounds(807, 138, 19, 14);
		
		panel.add(l27d);
		l33d.setHorizontalAlignment(SwingConstants.RIGHT);
		l33d.setForeground(Color.BLACK);
		l33d.setBounds(335, 265, 19, 14);
		
		panel.add(l33d);
		
		l55d.setHorizontalAlignment(SwingConstants.RIGHT);
		l55d.setForeground(Color.BLACK);
		l55d.setBounds(571, 519, 19, 14);
		panel.add(l55d);
		l52d.setHorizontalAlignment(SwingConstants.RIGHT);
		l52d.setForeground(Color.BLACK);
		l52d.setBounds(217, 519, 19, 14);
		
		panel.add(l52d);
		l36d.setHorizontalAlignment(SwingConstants.RIGHT);
		l36d.setForeground(Color.BLACK);
		l36d.setBounds(689, 265, 19, 14);
		
		panel.add(l36d);
		l24d.setHorizontalAlignment(SwingConstants.RIGHT);
		l24d.setForeground(Color.BLACK);
		l24d.setBounds(453, 138, 19, 14);
		
		panel.add(l24d);
		l35d.setHorizontalAlignment(SwingConstants.RIGHT);
		l35d.setForeground(Color.BLACK);
		l35d.setBounds(571, 265, 19, 14);
		
		panel.add(l35d);
		l22d.setHorizontalAlignment(SwingConstants.RIGHT);
		l22d.setForeground(Color.BLACK);
		l22d.setBounds(217, 138, 19, 14);
		
		panel.add(l22d);
		l47d.setHorizontalAlignment(SwingConstants.RIGHT);
		l47d.setForeground(Color.BLACK);
		l47d.setBounds(807, 392, 19, 14);
		
		panel.add(l47d);
		
		l56d.setHorizontalAlignment(SwingConstants.RIGHT);
		l56d.setForeground(Color.BLACK);
		l56d.setBounds(689, 519, 19, 14);
		panel.add(l56d);
		l37d.setHorizontalAlignment(SwingConstants.RIGHT);
		l37d.setForeground(Color.BLACK);
		l37d.setBounds(807, 265, 19, 14);
		
		panel.add(l37d);
		l46d.setHorizontalAlignment(SwingConstants.RIGHT);
		l46d.setForeground(Color.BLACK);
		l46d.setBounds(689, 392, 19, 14);
		
		panel.add(l46d);
		l16d.setHorizontalAlignment(SwingConstants.RIGHT);
		l16d.setForeground(Color.BLACK);
		l16d.setBounds(689, 11, 19, 14);
		
		panel.add(l16d);
		l43d.setHorizontalAlignment(SwingConstants.RIGHT);
		l43d.setForeground(Color.BLACK);
		l43d.setBounds(335, 392, 19, 14);
		
		panel.add(l43d);
		
		l11d.setForeground(Color.black);
		l11d.setHorizontalAlignment(SwingConstants.RIGHT);
		l11d.setBounds(99, 11, 19, 14);
		panel.add(l11d,new Integer(2), 0);
		
		lhrs.setBounds(377, 46, 46, 14);
		getContentPane().add(lhrs);
		
		t1thu.setEnabled(false);
		t1thu.setEditable(false);
		t1thu.setBackground(new Color(248, 248, 255));
		t1thu.setBounds(482, 11, 108, 116);
		panel.add(t1thu);
		
		t1sat.setEnabled(false);
		t1sat.setEditable(false);
		t1sat.setBackground(new Color(248, 248, 255));
		t1sat.setBounds(718, 11, 108, 116);
		panel.add(t1sat);
		
		t1tue.setEnabled(false);
		t1tue.setEditable(false);
		t1tue.setBackground(new Color(248, 248, 255));
		t1tue.setBounds(246, 11, 108, 116);
		panel.add(t1tue);
		
		t1fri.setEnabled(false);
		t1fri.setEditable(false);
		t1fri.setBackground(new Color(248, 248, 255));
		t1fri.setBounds(600, 11, 108, 116);
		panel.add(t1fri);
		
		t1wed.setEnabled(false);
		t1wed.setEditable(false);
		t1wed.setBackground(new Color(248, 248, 255));
		t1wed.setBounds(364, 11, 108, 116);
		panel.add(t1wed);
		
		t1mon.setEnabled(false);
		t1mon.setEditable(false);
		t1mon.setBackground(new Color(248, 248, 255));
		t1mon.setBounds(128, 11, 108, 116);
		panel.add(t1mon);
		
		t3sat.setEnabled(false);
		t3sat.setEditable(false);
		t3sat.setBackground(new Color(248, 248, 255));
		t3sat.setBounds(718, 265, 108, 116);
		panel.add(t3sat);
		
		t5sun.setEnabled(false);
		t5sun.setEditable(false);
		t5sun.setBackground(new Color(248, 248, 255));
		t5sun.setBounds(10, 519, 108, 116);
		panel.add(t5sun);
		
		t2thu.setEnabled(false);
		t2thu.setEditable(false);
		t2thu.setBackground(new Color(248, 248, 255));
		t2thu.setBounds(482, 138, 108, 116);
		panel.add(t2thu);
		
		t5fri.setEnabled(false);
		t5fri.setEditable(false);
		t5fri.setBackground(new Color(248, 248, 255));
		t5fri.setBounds(600, 519, 108, 116);
		panel.add(t5fri);
		
		t5thu.setEnabled(false);
		t5thu.setEditable(false);
		t5thu.setBackground(new Color(248, 248, 255));
		t5thu.setBounds(482, 519, 108, 116);
		panel.add(t5thu);
		
		t4thu.setEnabled(false);
		t4thu.setEditable(false);
		t4thu.setBackground(new Color(248, 248, 255));
		t4thu.setBounds(482, 392, 108, 116);
		panel.add(t4thu);
		
		t4sat.setEnabled(false);
		t4sat.setEditable(false);
		t4sat.setBackground(new Color(248, 248, 255));
		t4sat.setBounds(718, 392, 108, 116);
		panel.add(t4sat);
		
		t2sat.setEnabled(false);
		t2sat.setEditable(false);
		t2sat.setBackground(new Color(248, 248, 255));
		t2sat.setBounds(718, 138, 108, 116);
		panel.add(t2sat);
		
		t4tue.setEnabled(false);
		t4tue.setEditable(false);
		t4tue.setBackground(new Color(248, 248, 255));
		t4tue.setBounds(246, 392, 108, 116);
		panel.add(t4tue);
		
		t3fri.setEnabled(false);
		t3fri.setEditable(false);
		t3fri.setBackground(new Color(248, 248, 255));
		t3fri.setBounds(600, 265, 108, 116);
		panel.add(t3fri);
		
		t3thu.setEnabled(false);
		t3thu.setEditable(false);
		t3thu.setBackground(new Color(248, 248, 255));
		t3thu.setBounds(482, 265, 108, 116);
		panel.add(t3thu);
		
		t2mon.setEnabled(false);
		t2mon.setEditable(false);
		t2mon.setBackground(new Color(248, 248, 255));
		t2mon.setBounds(128, 138, 108, 116);
		panel.add(t2mon);
		
		t3sun.setEnabled(false);
		t3sun.setEditable(false);
		t3sun.setBackground(new Color(248, 248, 255));
		t3sun.setBounds(10, 265, 108, 116);
		panel.add(t3sun);
		
		t2wed.setEnabled(false);
		t2wed.setEditable(false);
		t2wed.setBackground(new Color(248, 248, 255));
		t2wed.setBounds(364, 138, 108, 116);
		panel.add(t2wed);
		
		t2tue.setEnabled(false);
		t2tue.setEditable(false);
		t2tue.setBackground(new Color(248, 248, 255));
		t2tue.setBounds(246, 138, 108, 116);
		panel.add(t2tue);
		
		t4sun.setEnabled(false);
		t4sun.setEditable(false);
		t4sun.setBackground(new Color(248, 248, 255));
		t4sun.setBounds(10, 392, 108, 116);
		panel.add(t4sun);
		
		t4mon.setEnabled(false);
		t4mon.setEditable(false);
		t4mon.setBackground(new Color(248, 248, 255));
		t4mon.setBounds(128, 392, 108, 116);
		panel.add(t4mon);
		
		t2sun.setEnabled(false);
		t2sun.setEditable(false);
		t2sun.setBackground(new Color(248, 248, 255));
		t2sun.setBounds(10, 138, 108, 116);
		panel.add(t2sun);
		
		t3mon.setEnabled(false);
		t3mon.setEditable(false);
		t3mon.setBackground(new Color(248, 248, 255));
		t3mon.setBounds(128, 265, 108, 116);
		panel.add(t3mon);
		
		t5mon.setEnabled(false);
		t5mon.setEditable(false);
		t5mon.setBackground(new Color(248, 248, 255));
		t5mon.setBounds(128, 519, 108, 116);
		panel.add(t5mon);
		
		t3tue.setEnabled(false);
		t3tue.setEditable(false);
		t3tue.setBackground(new Color(248, 248, 255));
		t3tue.setBounds(246, 265, 108, 116);
		panel.add(t3tue);
		
		t2fri.setEnabled(false);
		t2fri.setEditable(false);
		t2fri.setBackground(new Color(248, 248, 255));
		t2fri.setBounds(600, 138, 108, 116);
		panel.add(t2fri);
		
		t4wed.setEnabled(false);
		t4wed.setEditable(false);
		t4wed.setBackground(new Color(248, 248, 255));
		t4wed.setBounds(364, 392, 108, 116);
		panel.add(t4wed);
		
		t4fri.setEnabled(false);
		t4fri.setEditable(false);
		t4fri.setBackground(new Color(248, 248, 255));
		t4fri.setBounds(600, 392, 108, 116);
		panel.add(t4fri);
		
		t3wed.setEnabled(false);
		t3wed.setEditable(false);
		t3wed.setBackground(new Color(248, 248, 255));
		t3wed.setBounds(364, 265, 108, 116);
		panel.add(t3wed);
		
		t5sat.setEnabled(false);
		t5sat.setEditable(false);
		t5sat.setBackground(new Color(248, 248, 255));
		t5sat.setBounds(718, 519, 108, 116);
		panel.add(t5sat);
		
		t5tue.setEnabled(false);
		t5tue.setEditable(false);
		t5tue.setBackground(new Color(248, 248, 255));
		t5tue.setBounds(246, 519, 108, 116);
		panel.add(t5tue);
		
		t5wed.setEnabled(false);
		t5wed.setEditable(false);
		t5wed.setBackground(new Color(248, 248, 255));
		t5wed.setBounds(364, 519, 108, 116);
		panel.add(t5wed);
		t1sun.setBackground(new Color(248, 248, 255));
		t1sun.setEnabled(false);
		
		t1sun.setEditable(false);
		t1sun.setBounds(10, 11, 108, 116);
		panel.add(t1sun);
		t1sun.addMouseListener(this);
		t5wed.addMouseListener(this);
		t5tue.addMouseListener(this);
		t5sat.addMouseListener(this);
		t3wed.addMouseListener(this);
		t4fri.addMouseListener(this);
		t4wed.addMouseListener(this);
		t2fri.addMouseListener(this);
		t3tue.addMouseListener(this);
		t5mon.addMouseListener(this);
		t3mon.addMouseListener(this);
		t2sun.addMouseListener(this);
		t4mon.addMouseListener(this);
		t4sun.addMouseListener(this);
		t2tue.addMouseListener(this);
		t2wed.addMouseListener(this);
		t3sun.addMouseListener(this);
		t2mon.addMouseListener(this);
		t3thu.addMouseListener(this);
		t3fri.addMouseListener(this);
		t4tue.addMouseListener(this);
		t2sat.addMouseListener(this);
		t4sat.addMouseListener(this);
		t4thu.addMouseListener(this);
		t5thu.addMouseListener(this);
		t5fri.addMouseListener(this);
		t2thu.addMouseListener(this);
		t5sun.addMouseListener(this);
		t3sat.addMouseListener(this);
		t1mon.addMouseListener(this);
		t1wed.addMouseListener(this);
		t1fri.addMouseListener(this);
		t1tue.addMouseListener(this);
		t1sat.addMouseListener(this);
		t1thu.addMouseListener(this);
		
		menuBar.add(mFile);
		mFile.add(mfsave);
		mfsave.addActionListener(this);
		mFile.add(mfload);
		mfload.addActionListener(this);
		
		mFile.add(mprint);
		mprint.addActionListener(this);
		mFile.addSeparator();
		mFile.add(mfexit);
		mfexit.addActionListener(this);
		mnJobs.setText("Jobs");
		menuBar.add(mnJobs);
		mnJobs.add(mjadd);
		mjadd.addActionListener(this);
		mnJobs.add(mjedit);
		mjedit.addActionListener(this);
		mnJobs.add(mjdel);
		mnJobs.addSeparator();
		mnJobs.add(mwadd);
		mwadd.addActionListener(this);
		
		mnJobs.add(mwedit);
		mwedit.addActionListener(this);
		
		mnJobs.add(mwdel);
		mwdel.addActionListener(this);
		mnJobs.addSeparator();
		mnJobs.add(mlist);
		mjdel.addActionListener(this);
		menuBar.setBounds(0, 0, 855, 29);
		getContentPane().add(menuBar);
		menuBar.add(mnDate);
		mnDate.add(mddate);
		
		menuBar.add(mnTest);
		mnTest.addActionListener(this);
		mnTest.setVisible(true);// TODO set to false for release
		
		lwarn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lwarn.setHorizontalAlignment(SwingConstants.CENTER);
		lwarn.setToolTipText("");
		lwarn.setOpaque(true);
		lwarn.setBackground(Color.RED);
		lwarn.setBounds(505, 41, 232, 20);
		lwarn.setVisible(false);
		
		getContentPane().add(lwarn);
		
		cbmonth.setBounds(77, 41, 95, 20);
		getContentPane().add(cbmonth);
		mlist.addActionListener(this);
		mddate.addActionListener(this);

		this.setSize(871, 782);
		this.setLocationRelativeTo(null);
		//this.setVisible(true);

	}


	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
