package net.bearfather.Scheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

class Data {
	private final static String DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
	final private static String dfol="testmonth";
	final public static String CONNECTION="jdbc:derby:"+dfol;//TODO never used?
	public static int jobCnt=0;
	
	static void loadJobs(){
		jobCnt=0;
		try {
			ResultSet sql=pulltable("jobs","Jobs");
			while (sql.next()){
				String id=sql.getString("id");
				String name=sql.getString("name");
				int cat=sql.getInt("cat");
				int type=sql.getInt("type");
				int length=sql.getInt("length");
				int[] sun=stringToArray(sql.getString("sun"));
				int[] mon=stringToArray(sql.getString("mon"));
				int[] tue=stringToArray(sql.getString("tue"));
				int[] wed=stringToArray(sql.getString("wed"));
				int[] thu=stringToArray(sql.getString("thu"));
				int[] fri=stringToArray(sql.getString("fri"));
				int[] sat=stringToArray(sql.getString("sat"));
				int[] month=stringToArray(sql.getString("month"));
				Job cjob=new Job(name,id,cat,type,length,sun,mon,tue,wed,thu,fri,sat,month);
				Scheduler.availJobs.put(id,cjob);
				jobCnt++;
			}
			sql.close();
		} catch (InstantiationException | IllegalAccessException| ClassNotFoundException | SQLException e) {e.printStackTrace();}
	}
	static void loadWorkOrders(){
		try {
			ResultSet sql=pulltable("wo","Jobs");
			while (sql.next()){
				String id=sql.getString("id");
				String name=sql.getString("name");
				int type=sql.getInt("type");
				int length=sql.getInt("length");
				String owner=sql.getString("owner");
				String start=sql.getString("start");
				Date sdate=sql.getDate("sdate");
				Date edate=sql.getDate("edate");
				String notes=sql.getString("notes");
				WorkOrder cwo=new WorkOrder(name,id,1,type,length,null,null,null,null,null,null,null,null);
				cwo.WorkOrder2(name, id, type, length, owner, start, sdate, edate, notes);
				Scheduler.workorders.put(id,cwo);
				jobCnt++;
			}
			sql.close();
		} catch (InstantiationException | IllegalAccessException| ClassNotFoundException | SQLException e) {e.printStackTrace();}
	}
	static void loadInfo(){
		try {
			ResultSet set=pulltable("jobinfo","JobInfo");
			while (set.next()){
				JobInfo info=new JobInfo();
				//info.setAccName(set.getString("accname"));
				info.setAccAddress(set.getString("accaddress"));
				info.setAccContact(set.getString("acccontact"));
				info.setAccNum(set.getString("accnum"));
				info.setAccPhone(set.getString("accphone"));
				info.setAlarmComp(set.getString("alarmcomp"));
				info.setAlarmPhone(set.getString("alarmphone"));
				info.setCommLog(set.getString("commlog"));
				info.setLights(set.getString("lights"));
				info.setWater(set.getString("water"));
				info.setBreakers(set.getString("breakers"));
				info.setNotes(set.getString("notes"));
				info.setAlarm(set.getBoolean("alarm"));
				info.setConPhone(set.getString("ConPhone"));
				Scheduler.jobinfos.put(info.getAccNum(), info);
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {e.printStackTrace();}
	}
	private static ResultSet pulltable(String table,String fol)throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Connection connection=null;
		String CONN="jdbc:derby:"+fol;
		connection=DriverManager.getConnection(CONN);
		Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet sql=statement.executeQuery("select * from "+table);
		return sql;
	}
	static ResultSet pulltable(String table,String where,String what,String fol)throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Connection connection=null;
		String CONN="jdbc:derby:"+fol;
		connection=DriverManager.getConnection(CONN);
		Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet sql=statement.executeQuery("select * from "+table+" where "+where+"="+what+"");
		return sql;
	}
// TODO from UCDetector: Method "Data.cnttable(String,String,String,String)" has 0 references
	public static int cnttable(String table,String where,String what,String fol)throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{ // NO_UCD (unused code)
		Connection connection=null;
		String CONN="jdbc:derby:"+fol;
		connection=DriverManager.getConnection(CONN);
		Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet sql=statement.executeQuery("select count(*) from "+table+" where "+where+"="+what+"");
		sql.next();
		return sql.getInt("1");
	}
	static void updateJob(Job job,String fol){
		PreparedStatement pstatement=null;
		Connection connection=null;
		try {
			String CONN="jdbc:derby:"+fol;
			connection=DriverManager.getConnection(CONN);
			Class.forName(DRIVER).newInstance();
			pstatement = connection.prepareStatement("update jobs set id=?,name=?,cat=?,type=?,length=?,sun=?,mon=?,tue=?,wed=?,thu=?,fri=?,sat=?,month=? where id='"+job.getId()+"'");
			pstatement.setString(1,job.getId());
			pstatement.setString(2,job.getName());
			pstatement.setInt(3,job.getCat());
			pstatement.setInt(4,job.getType());
			pstatement.setInt(5,job.getLength());
			pstatement.setString(6,arrayToString(job.getSun()));
			pstatement.setString(7,arrayToString(job.getMon()));
			pstatement.setString(8,arrayToString(job.getTue()));
			pstatement.setString(9,arrayToString(job.getWed()));
			pstatement.setString(10,arrayToString(job.getThu()));
			pstatement.setString(11,arrayToString(job.getFri()));
			pstatement.setString(12,arrayToString(job.getSat()));
			pstatement.setString(13,arrayToString(job.getMonth()));

			pstatement.execute();
			connection.commit();
		} catch (InstantiationException | IllegalAccessException| ClassNotFoundException|SQLException e) {e.printStackTrace();}
		finally {
			if (pstatement != null) {try {pstatement.close();} catch (SQLException e) { /* ignored */}}
			if (connection != null) {try {connection.close();} catch (SQLException e) { /* ignored */}}
		}
	}
	static void insertJob(Job job,String fol){
		PreparedStatement pstatement=null;
		Connection connection=null;
		try {
			String CONN="jdbc:derby:"+fol;
			connection=DriverManager.getConnection(CONN);
			Class.forName(DRIVER).newInstance();
			pstatement = connection.prepareStatement("insert into jobs (id,name,cat,type,length,sun,mon,tue,wed,thu,fri,sat,month) values (?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			pstatement.setString(1,job.getId());
			pstatement.setString(2,job.getName());
			pstatement.setInt(3,job.getCat());
			pstatement.setInt(4,job.getType());
			pstatement.setInt(5,job.getLength());
			pstatement.setString(6,arrayToString(job.getSun()));
			pstatement.setString(7,arrayToString(job.getMon()));
			pstatement.setString(8,arrayToString(job.getTue()));
			pstatement.setString(9,arrayToString(job.getWed()));
			pstatement.setString(10,arrayToString(job.getThu()));
			pstatement.setString(11,arrayToString(job.getFri()));
			pstatement.setString(12,arrayToString(job.getSat()));
			pstatement.setString(13,arrayToString(job.getMonth()));
			pstatement.execute();
			connection.commit();
		} catch (InstantiationException | IllegalAccessException| ClassNotFoundException|SQLException e) {e.printStackTrace();}
		finally {
			if (pstatement != null) {try {pstatement.close();} catch (SQLException e) { /* ignored */}}
			if (connection != null) {try {connection.close();} catch (SQLException e) { /* ignored */}}
		}
	}
	static void updateWorkOrder(WorkOrder wo,String fol){
		PreparedStatement pstatement=null;
		Connection connection=null;
		try {
			String CONN="jdbc:derby:"+fol;
			connection=DriverManager.getConnection(CONN);
			Class.forName(DRIVER).newInstance();
			pstatement = connection.prepareStatement("update wo set id=?,name=?,type=?,length=?,owner=?,start=?,sdate=?,edate=?,notes=? where id='"+wo.getId()+"'");
			pstatement.setString(1,wo.getId());
			pstatement.setString(2,wo.getName());
			pstatement.setInt(3,wo.getType());
			pstatement.setInt(4,wo.getLength());
			pstatement.setString(5,wo.getOwner());
			pstatement.setString(6,wo.getStart());
			pstatement.setDate(7,new java.sql.Date(wo.getsDate().getTime()));
			pstatement.setDate(8,new java.sql.Date(wo.geteDate().getTime()));
			pstatement.setString(9,wo.getNotes());

			pstatement.execute();
			connection.commit();
		} catch (InstantiationException | IllegalAccessException| ClassNotFoundException|SQLException e) {e.printStackTrace();}
		finally {
			if (pstatement != null) {try {pstatement.close();} catch (SQLException e) { /* ignored */}}
			if (connection != null) {try {connection.close();} catch (SQLException e) { /* ignored */}}
		}
	}
	static void insertWorkOrder(WorkOrder wo,String fol){
		PreparedStatement pstatement=null;
		Connection connection=null;
		try {
			String CONN="jdbc:derby:"+fol;
			connection=DriverManager.getConnection(CONN);
			Class.forName(DRIVER).newInstance();
			pstatement = connection.prepareStatement("insert into wo (id,name,type,length,owner,start,sdate,edate,notes) values (?,?,?,?,?,?,?,?,?) ");
			pstatement.setString(1,wo.getId());
			pstatement.setString(2,wo.getName());
			pstatement.setInt(3,wo.getType());
			pstatement.setInt(4,wo.getLength());
			pstatement.setString(5,wo.getOwner());
			pstatement.setString(6,wo.getStart());
			pstatement.setDate(7,new java.sql.Date(wo.getsDate().getTime()));
			pstatement.setDate(8,new java.sql.Date(wo.geteDate().getTime()));
			pstatement.setString(9,wo.getNotes());
			pstatement.execute();
			connection.commit();
		} catch (InstantiationException | IllegalAccessException| ClassNotFoundException|SQLException e) {e.printStackTrace();}
		finally {
			if (pstatement != null) {try {pstatement.close();} catch (SQLException e) { /* ignored */}}
			if (connection != null) {try {connection.close();} catch (SQLException e) { /* ignored */}}
		}
	}
	static void updateJobInfo(JobInfo info,String fol){
		PreparedStatement pstatement=null;
		Connection connection=null;
		try {
			String CONN="jdbc:derby:"+fol;
			connection=DriverManager.getConnection(CONN);
			Class.forName(DRIVER).newInstance();
			pstatement = connection.prepareStatement("update JobInfo set accnum=?,accaddress=?,acccontact=?,accphone=?,conphone=?,alarm=?,alarmcomp=?,alarmphone=?,commlog=?,lights=?,water=?,breakers=?,notes=? where accnum='"+info.getAccNum()+"'");
			pstatement.setString(1,info.getAccNum());
			pstatement.setString(2,info.getAccAddress());
			pstatement.setString(3,info.getAccContact());
			pstatement.setString(4,info.getAccPhone());
			pstatement.setString(5,info.getConPhone());
			pstatement.setBoolean(6,info.isAlarm());
			pstatement.setString(7,info.getAlarmComp());
			pstatement.setString(8,info.getAlarmPhone());
			pstatement.setString(9,info.getCommLog());
			pstatement.setString(10,info.getLights());
			pstatement.setString(11,info.getWater());
			pstatement.setString(12,info.getBreakers());
			pstatement.setString(13,info.getNotes());

			pstatement.execute();
			connection.commit();
		} catch (InstantiationException | IllegalAccessException| ClassNotFoundException|SQLException e) {e.printStackTrace();}
		finally {
			if (pstatement != null) {try {pstatement.close();} catch (SQLException e) { /* ignored */}}
			if (connection != null) {try {connection.close();} catch (SQLException e) { /* ignored */}}
		}
	}
	static void insertJobInfo(JobInfo info,String fol){
		PreparedStatement pstatement=null;
		Connection connection=null;
		try {
			String CONN="jdbc:derby:"+fol;
			connection=DriverManager.getConnection(CONN);
			Class.forName(DRIVER).newInstance();
			pstatement = connection.prepareStatement("insert into JobInfo (accnum,accaddress,acccontact,accphone,conphone,alarm,alarmcomp,alarmphone,commlog,lights,water,breakers,notes) values (?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			pstatement.setString(1,info.getAccNum());
			pstatement.setString(2,info.getAccAddress());
			pstatement.setString(3,info.getAccContact());
			pstatement.setString(4,info.getAccPhone());
			pstatement.setString(5,info.getConPhone());
			pstatement.setBoolean(6,info.isAlarm());
			pstatement.setString(7,info.getAlarmComp());
			pstatement.setString(8,info.getAlarmPhone());
			pstatement.setString(9,info.getCommLog());
			pstatement.setString(10,info.getLights());
			pstatement.setString(11,info.getWater());
			pstatement.setString(12,info.getBreakers());
			pstatement.setString(13,info.getNotes());
			pstatement.execute();
			connection.commit();
		} catch (InstantiationException | IllegalAccessException| ClassNotFoundException|SQLException e) {e.printStackTrace();}
		finally {
			if (pstatement != null) {try {pstatement.close();} catch (SQLException e) { /* ignored */}}
			if (connection != null) {try {connection.close();} catch (SQLException e) { /* ignored */}}
		}
	}
	static void updateWeek(int week,String fol){
		PreparedStatement pstatement=null;
		Connection connection=null;
		try {
			String CONN="jdbc:derby:"+fol;
			connection=DriverManager.getConnection(CONN);
			Class.forName(DRIVER).newInstance();
			pstatement = connection.prepareStatement("update week set week=?,sun=?,mon=?,tue=?,wed=?,thu=?,fri=?,sat=?,times=?,dates=?,startt=?,workers=?,notes=? where week="+week);
			pstatement.setInt(1,week);
			pstatement.setString(2,buildDay(week,1));
			pstatement.setString(3,buildDay(week,2));
			pstatement.setString(4,buildDay(week,3));
			pstatement.setString(5,buildDay(week,4));
			pstatement.setString(6,buildDay(week,5));
			pstatement.setString(7,buildDay(week,6));
			pstatement.setString(8,buildDay(week,7));
			pstatement.setString(9,buildTimes(week));
			pstatement.setString(10,buildDates(week));
			pstatement.setString(11,buildStart(week));
			pstatement.setString(12,buildWorkers(week));
			pstatement.setString(13,buildNotes(week));

			pstatement.execute();
			connection.commit();
		} catch (InstantiationException | IllegalAccessException| ClassNotFoundException|SQLException e) {e.printStackTrace();}
		finally {
			if (pstatement != null) {try {pstatement.close();} catch (SQLException e) { /* ignored */}}
			if (connection != null) {try {connection.close();} catch (SQLException e) { /* ignored */}}
		}
	}
	static void insertWeek(int week,String fol){
		PreparedStatement pstatement=null;
		Connection connection=null;
		try {
			String CONN="jdbc:derby:"+fol;
			connection=DriverManager.getConnection(CONN);
			Class.forName(DRIVER).newInstance();
			pstatement = connection.prepareStatement("insert into week (week,sun,mon,tue,wed,thu,fri,sat,times,dates,startt,workers,notes) values (?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			pstatement.setInt(1,week);
			pstatement.setString(2,buildDay(week,1));
			pstatement.setString(3,buildDay(week,2));
			pstatement.setString(4,buildDay(week,3));
			pstatement.setString(5,buildDay(week,4));
			pstatement.setString(6,buildDay(week,5));
			pstatement.setString(7,buildDay(week,6));
			pstatement.setString(8,buildDay(week,7));
			pstatement.setString(9,buildTimes(week));
			pstatement.setString(10,buildDates(week));
			pstatement.setString(11,buildStart(week));
			pstatement.setString(12,buildWorkers(week));
			pstatement.setString(13,buildNotes(week));
			pstatement.execute();
			connection.commit();
		} catch (InstantiationException | IllegalAccessException| ClassNotFoundException|SQLException e) {e.printStackTrace();}
		finally {
			if (pstatement != null) {try {pstatement.close();} catch (SQLException e) { /* ignored */}}
			if (connection != null) {try {connection.close();} catch (SQLException e) { /* ignored */}}
		}
	}
	private static String buildDay(int week, int day){
		String rtn="";
		int fday = Integer.parseInt(Integer.toString(week) + Integer.toString(day));
		for (Job v:Scheduler.jobs.get(fday)){
			rtn=rtn+","+v.getId();
		}
		if (rtn.length()>0){rtn=rtn.substring(1);}
		return rtn;
		
	}
	private static String buildWorkers(int week){
		String rtn="";
		int c=1;
		while (c<8){
			rtn=rtn+","+buildWorkers(week,c);
			c++;
		}
		if (rtn.length()>0){rtn=rtn.substring(1);}
		return rtn;
	}
	private static String buildWorkers(int week, int day){
		String rtn=":";
		int fday = Integer.parseInt(Integer.toString(week) + Integer.toString(day));
		for (String v:Scheduler.workers.get(fday)){
			if (v.length()>1){v=v+"."+Scheduler.fnames.get(v);}
			rtn=rtn+":"+v;
		}
		if (rtn.length()>1){rtn=rtn.substring(1);}
		return rtn;
		
	}
	private static String buildTimes(int week){
		String rtn="";
		int c=1;
		while (c<8){
			rtn=rtn+","+Scheduler.times.get(Integer.parseInt(Integer.toString(week) + Integer.toString(c)));
			c++;
		}
		if (rtn.length()>0){rtn=rtn.substring(1);}
		return rtn;
	}
	private static String buildDates(int week){
		String rtn="";
		rtn=SetDateFrame.start+","+SetDateFrame.day30+","+Scheduler.cf.cbmonth.getSelectedIndex();
				return rtn;
	}
	private static String buildStart(int week){
		String rtn="";
		int c=1;
		while (c<8){
			rtn=rtn+","+Scheduler.startT.get(Integer.parseInt(Integer.toString(week) + Integer.toString(c)));
			c++;
		}
		if (rtn.length()>0){rtn=rtn.substring(1);}
		return rtn;
	}
	private static String buildNotes(int week){
		String rtn="";
		int c=1;
		while (c<8){
			rtn=rtn+","+Scheduler.notes.get(Integer.parseInt(Integer.toString(week) + Integer.toString(c)));
			c++;
		}
		if (rtn.length()>0){rtn=rtn.substring(1);}
		return rtn;
	}
	private static String arrayToString(int[] arr){
		String rtn="";
		for (int v:arr){
			rtn=rtn+","+v;
		}
		if (rtn.length()>0){
			rtn=rtn.substring(1);
		}
		return rtn;
	}
	private static int[] stringToArray(String arr){
		int[] rtn=null;
		String [] b=arr.split(",");
		rtn=new int[b.length];
		int c=0;
		for (String v:b){
			rtn[c]=pI(v,0);
			c++;
		}
		return rtn;
	}
	static int pI(String value,int rtn){
		try{return Integer.parseInt(value);} catch (NumberFormatException nfe) {return rtn;}
	}
// 	public static String pS(int value,String rtn){
// 		try{return Integer.toString(value);} catch (NumberFormatException nfe) {return rtn;}
// 	}
	//type 0==jobs, 1==days
	static void makedb(int type,String fol) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Class.forName(DRIVER).newInstance();
		String CONN="jdbc:derby:"+fol+";create=true";
		Connection con=DriverManager.getConnection(CONN);
		String line="";
		PreparedStatement pstatement = null;
		if (type==0){
			//(id,name,cat,type,length,sun,mon,tue,wed,thu,fri,sat)
			line="create table jobs(id varchar(15) not NULL primary key,"
					+ "name varchar(50),cat int,type int,length int,sun varchar(50),mon varchar(50),tue varchar(50),wed varchar(50),thu varchar(50),fri varchar(50),sat varchar(50))";
			pstatement = con.prepareStatement(line);
			pstatement.execute();
		}else if (type==1){
			line="create table week(week int not NULL primary key,"
					+"sun varchar(20),mon varchar(20),tue varchar(20),wed varchar(20),thu varchar(20),fri varchar(20),sat varchar(20),"
					+"times varchar(21),dates varchar(21),startt varchar(21),workers varchar(200),notes varchar(255))";
			pstatement = con.prepareStatement(line);
			pstatement.execute();
		}else if (type==3){
			line="create table jobinfo(accnum varchar(10) not NULL primary key,accaddress varchar(50),acccontact varchar(50),accphone varchar(50),conphone varchar(50),"
					+"alarm boolean,alarmcomp varchar(50),alarmphone varchar(50),commlog varchar(50),lights varchar(50),water varchar(50),breakers varchar(50),notes varchar(255))";
			pstatement = con.prepareStatement(line);
			pstatement.execute();
		}
		con.commit();
		con.close();
		pstatement.close();

	}
	static int delete(String table,String id,String fol){
		int rtn=0;
		PreparedStatement pstatement=null;
		Connection connection=null;
		try {
			String CONN="jdbc:derby:"+fol;
			connection=DriverManager.getConnection(CONN);
			Class.forName(DRIVER).newInstance();
			pstatement = connection.prepareStatement("delete from "+table+" where id='"+id+"'");
			pstatement.execute();
			connection.commit();
			rtn=pstatement.getUpdateCount();
		} catch (InstantiationException | IllegalAccessException| ClassNotFoundException|SQLException e) {e.printStackTrace();}
		finally {
			if (pstatement != null) {try {pstatement.close();} catch (SQLException e) { /* ignored */}}
			if (connection != null) {try {connection.close();} catch (SQLException e) { /* ignored */}}
		}
		return rtn;
	}
}
