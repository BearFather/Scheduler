package net.bearfather.Scheduler;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import javax.swing.JFrame;
class Scheduler {
	static HashMap<String,JobInfo> jobinfos=new HashMap<String,JobInfo>();
	static HashMap<Integer,ArrayList<Job>> jobs=new HashMap<Integer,ArrayList<Job>>();
	static HashMap<String,WorkOrder> workorders=new HashMap<String,WorkOrder>();
	static HashMap<Integer,Integer> times=new HashMap<Integer,Integer>();
	static HashMap<Integer,ArrayList<String>> workers=new HashMap<Integer,ArrayList<String>>();
	static HashMap<Integer,Integer> startT=new HashMap<Integer,Integer>();
	static HashMap<Integer,String> notes=new HashMap<Integer,String>();
	static HashMap<Integer,CalenderFrame> months=new HashMap<Integer,CalenderFrame>();

	static Variables vari=new Variables();
	static CalenderFrame cf;
	static DayFrame df;
// TODO from UCDetector: Field "Scheduler.arf" is never read
	public static AddRemFrame arf; // NO_UCD (unused code)
	static HashMap<String,Job> availJobs=new HashMap<String,Job>();
	static Properties prop = new Properties();
	static HashMap<String,String> fnames;
	private static int nextid=5434;
	static JFrame jf;
	static{
		InputStream input = null;
		try {
			input = new FileInputStream("Scheduler.props");
			prop.load(input);
		} catch (IOException ex) {
			prop.setProperty("nextid", Integer.toString(nextid));
			saveProps();
		} finally {if (input != null) {try {
					input.close();
					nextid=Integer.parseInt(prop.getProperty("nextid"));
				} catch (IOException e) {e.printStackTrace();}
			}
		}
 }
	public static void main(String[] args) {
		Data.loadInfo();
		Data.loadJobs();
		Data.loadWorkOrders();
		loadFnames();
		Date date=new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    int month=cal.get(Calendar.MONTH)+1;
		showFrame(month);
	}
	private static void saveProps(){
		FileWriter fw=null;
		try {
			fw=new FileWriter("Scheduler.props");
			prop.store(fw, null);
		} catch (IOException io) {} finally {if (fw != null){try {fw.close();} catch (IOException e) {}}}
	}
	static int getId(boolean advance){
		int rtn=nextid;
		if (advance){
			nextid++;
			prop.setProperty("nextid", Integer.toString(nextid));
			saveProps();
		}
		return rtn;
	}
	private static void loadFnames(){
		String[] snames=Scheduler.prop.getProperty("workers").split(",");
		fnames=new HashMap<String,String>();
		for (String name:snames){
			String[] sname=name.split("[.]");
			fnames.put(sname[0], sname[1]);
		}
	}
	static Point setLoc(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return new Point((screenSize.width / 2) -200, (screenSize.height / 2)-150);
	}
	static Point setLoc(int x,int y){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return new Point(((screenSize.width / 2) -200)+x, ((screenSize.height / 2)-150)+y);
	}
	static void closeCF(){
		cf.setVisible(true);
		cf.setEnabled(true);
	}
// TODO from UCDetector: Method "Scheduler.openCF()" has 0 references
	public static void openCF(){ // NO_UCD (unused code)
		cf.setEnabled(false);
		cf.setVisible(false);
	}
	static void showFrame(int num){
		if (num!=0){
			for (Entry<Integer, CalenderFrame> v:months.entrySet()){
				if (v.getKey()==num){
					v.getValue().setVisible(true);
					v.getValue().cbmonth.setSelectedIndex(num);
					cf=Scheduler.months.get(num);
				}
				else{v.getValue().setVisible(false);}
			}
		}
	}
}
