package net.bearfather.Scheduler;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

class LoadSave {
	static void saveMonth(String file){
		if (file!=null&&!file.equals("")){
			try {
				if (!new File(file).exists()){
					Data.makedb(1, file);
					Data.insertWeek(1, file);
					Data.insertWeek(2, file);
					Data.insertWeek(3, file);
					Data.insertWeek(4, file);
					Data.insertWeek(5, file);
				}else {
					Data.updateWeek(1, file);
					Data.updateWeek(2, file);
					Data.updateWeek(3, file);
					Data.updateWeek(4, file);
					Data.updateWeek(5, file);
					}
			} catch (InstantiationException | IllegalAccessException| ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
	static void buildMonth(String file){
		int c=1;
		while (c<6){
			try {
				ResultSet sql=Data.pulltable("week","week",Integer.toString(c),file);
				while (sql.next()){
					String[] dates=sql.getString("dates").split(",");
					if (c==1){
						int month=Integer.parseInt(dates[2]);
						Scheduler.showFrame(month);
						SetDateFrame.start=Integer.parseInt(dates[0]);
						SetDateFrame.day30=Integer.parseInt(dates[1]);
						SetDateFrame sd=new SetDateFrame();
						sd.runit();
						sd.dispose();
					}
					String[] sun=sql.getString("sun").split(",");
					String[] mon=sql.getString("mon").split(",");
					String[] tue=sql.getString("tue").split(",");
					String[] wed=sql.getString("wed").split(",");
					String[] thu=sql.getString("thu").split(",");
					String[] fri=sql.getString("fri").split(",");
					String[] sat=sql.getString("sat").split(",");
					String[] times=sql.getString("times").split(",");
					String[] startt=sql.getString("startt").split(",");
					String[] workers=sql.getString("workers").split(",");
					String[] notes=sql.getString("notes").split(",");
					loadJobs(sun,Integer.parseInt(Integer.toString(c) + Integer.toString(1)));
					loadJobs(mon,Integer.parseInt(Integer.toString(c) + Integer.toString(2)));
					loadJobs(tue,Integer.parseInt(Integer.toString(c) + Integer.toString(3)));
					loadJobs(wed,Integer.parseInt(Integer.toString(c) + Integer.toString(4)));
					loadJobs(thu,Integer.parseInt(Integer.toString(c) + Integer.toString(5)));
					loadJobs(fri,Integer.parseInt(Integer.toString(c) + Integer.toString(6)));
					loadJobs(sat,Integer.parseInt(Integer.toString(c) + Integer.toString(7)));
					int cnt=0;
					while (cnt<7){
						Scheduler.times.put(Integer.parseInt(Integer.toString(c) + Integer.toString(cnt+1)),Integer.parseInt(times[cnt]));
						Scheduler.notes.put(Integer.parseInt(Integer.toString(c) + Integer.toString(cnt+1)),notes[cnt]);
						Scheduler.startT.put(Integer.parseInt(Integer.toString(c) + Integer.toString(cnt+1)),Integer.parseInt(startt[cnt]));
						loadWorkers(workers[cnt],Integer.parseInt(Integer.toString(c) + Integer.toString(cnt+1)));
						cnt++;
					}
					
				}
				sql.close();
				for (Integer pane:Scheduler.cf.panes.keySet()){
					Scheduler.cf.disPane(pane);
				}
			} catch (InstantiationException | IllegalAccessException| ClassNotFoundException | SQLException e) {
				e.printStackTrace();}

			c++; 
		}
	}
	private static void loadJobs(String[] data,int day){
		Scheduler.jobs.get(day).clear();
		for (String id:data){
			for (Job job:Scheduler.availJobs.values()){
				if (job.getId().equals(id)){Scheduler.jobs.get(day).add(job);break;}
			}
			for (Job job:Scheduler.workorders.values()){
				if (job.getId().equals(id)){Scheduler.jobs.get(day).add(job);break;}
			}
		}
	}
	
	private static void loadWorkers(String data,int day){
		Scheduler.workers.get(day).clear();
		String[] b=data.split(":");
		for (String name:b){
			if (!name.equals("")){
				String[] tname=name.split("[.]");
				Scheduler.workers.get(day).add(tname[0]);}
		}
	}
}
