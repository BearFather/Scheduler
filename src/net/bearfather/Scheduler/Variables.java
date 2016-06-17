package net.bearfather.Scheduler;

import java.util.ArrayList;
import java.util.HashMap;


class Variables {
	// J=jobs
	// T=total time
	// W=workers  0=amt,1=worker 1, 2=worker 2, etc
	// D=day of the month
	// S=start time
	// N=Notes
	
	//  WEEK1
	private ArrayList<Job> w1sunJ=new ArrayList<Job>();
	private int w1sunT=0;
	private ArrayList<String> w1sunW=new ArrayList<String>();
	public int w1sund=0;
	public int w1suns=0;
	private String w1sunn="0";
	
	private ArrayList<Job> w1monJ=new ArrayList<Job>();
	private int w1monT=0;
	private ArrayList<String> w1monW=new ArrayList<String>();
	public int w1mond=0;
	public int w1mons=0;
	private String w1monn="0";
	
	private ArrayList<Job> w1tueJ=new ArrayList<Job>();
	private int w1tueT=0;
	private ArrayList<String> w1tueW=new ArrayList<String>();
	public int w1tued=0; // NO_UCD (unused code)
	public int w1tues=0;
	private String w1tuen="0";

	private ArrayList<Job> w1wedJ=new ArrayList<Job>();
	private int w1wedT=0; // NO_UCD (unused code)
	private ArrayList<String> w1wedW=new ArrayList<String>();
	public int w1wedd=0; // NO_UCD (unused code)
	public int w1weds=0; // NO_UCD (unused code)
	private String w1wedn="0";

	private ArrayList<Job> w1thuJ=new ArrayList<Job>();
	private int w1thuT=0;
	private ArrayList<String> w1thuW=new ArrayList<String>();
	public int w1thud=0; // NO_UCD (unused code)
	public int w1thus=0; // NO_UCD (unused code)
	private String w1thun="0";

	private ArrayList<Job> w1friJ=new ArrayList<Job>();
	private int w1friT=0;
	private ArrayList<String> w1friW=new ArrayList<String>();
	public int w1frid=0; // NO_UCD (unused code)
	public int w1fris=0; // NO_UCD (unused code)
	private String w1frin="0";

	private ArrayList<Job> w1satJ=new ArrayList<Job>();
	private int w1satT=0;
	private ArrayList<String> w1satW=new ArrayList<String>();
	public int w1satd=0; // NO_UCD (unused code)
	public int w1sats=0; // NO_UCD (unused code)
	private String w1satn="0";

	
	//  WEEK2
	private ArrayList<Job> w2sunJ=new ArrayList<Job>();
	private int w2sunT=0;
	private ArrayList<String> w2sunW=new ArrayList<String>();
	public int w2sund=0; // NO_UCD (unused code)
	public int w2suns=0; // NO_UCD (unused code)
	private String w2sunn="0";

	private ArrayList<Job> w2monJ=new ArrayList<Job>();
	private int w2monT=0;
	private ArrayList<String> w2monW=new ArrayList<String>();
	public int w2mond=0; // NO_UCD (unused code)
	public int w2mons=0; // NO_UCD (unused code)
	private String w2monn="0";
	
	private ArrayList<Job> w2tueJ=new ArrayList<Job>();
	private int w2tueT=0;
	private ArrayList<String> w2tueW=new ArrayList<String>();
	public int w2tued=0; // NO_UCD (unused code)
	public int w2tues=0; // NO_UCD (unused code)
	private String w2tuen="0";
	
	private ArrayList<Job> w2wedJ=new ArrayList<Job>();
	private int w2wedT=0;
	private ArrayList<String> w2wedW=new ArrayList<String>();
	public int w2wedd=0; // NO_UCD (unused code)
	public int w2weds=0; // NO_UCD (unused code)
	private String w2wedn="0";
	
	private ArrayList<Job> w2thuJ=new ArrayList<Job>();
	private int w2thuT=0;
	private ArrayList<String> w2thuW=new ArrayList<String>();
	public int w2thud=0; // NO_UCD (unused code)
	public int w2thus=0; // NO_UCD (unused code)
	private String w2thun="0";
	
	private ArrayList<Job> w2friJ=new ArrayList<Job>();
	private int w2friT=0;
	private ArrayList<String> w2friW=new ArrayList<String>();
	public int w2frid=0; // NO_UCD (unused code)
	public int w2fris=0; // NO_UCD (unused code)
	private String w2frin="0";
	
	private ArrayList<Job> w2satJ=new ArrayList<Job>();
	private int w2satT=0;
	private ArrayList<String> w2satW=new ArrayList<String>();
	public int w2satd=0; // NO_UCD (unused code)
	public int w2sats=0; // NO_UCD (unused code)
	private String w2satn="0";
	
	//  WEEK3
	private ArrayList<Job> w3sunJ=new ArrayList<Job>();
	private int w3sunT=0;
	private ArrayList<String> w3sunW=new ArrayList<String>();
	public int w3sund=0; // NO_UCD (unused code)
	public int w3suns=0; // NO_UCD (unused code)
	private String w3sunn="0";
	
	private ArrayList<Job> w3monJ=new ArrayList<Job>();
	private int w3monT=0;
	private ArrayList<String> w3monW=new ArrayList<String>();
	public int w3mond=0; // NO_UCD (unused code)
	public int w3mons=0; // NO_UCD (unused code)
	private String w3monn="0";
	
	private ArrayList<Job> w3tueJ=new ArrayList<Job>();
	private int w3tueT=0;
	private ArrayList<String> w3tueW=new ArrayList<String>();
	public int w3tued=0; // NO_UCD (unused code)
	public int w3tues=0; // NO_UCD (unused code)
	private String w3tuen="0";
	
	private ArrayList<Job> w3wedJ=new ArrayList<Job>();
	private int w3wedT=0;
	private ArrayList<String> w3wedW=new ArrayList<String>();
	public int w3wedd=0; // NO_UCD (unused code)
	public int w3weds=0; // NO_UCD (unused code)
	private String w3wedn="0";
	
	private ArrayList<Job> w3thuJ=new ArrayList<Job>();
	private int w3thuT=0;
	private ArrayList<String> w3thuW=new ArrayList<String>();
	public int w3thud=0; // NO_UCD (unused code)
	public int w3thus=0; // NO_UCD (unused code)
	private String w3thun="0";
	
	private ArrayList<Job> w3friJ=new ArrayList<Job>();
	private int w3friT=0;
	private ArrayList<String> w3friW=new ArrayList<String>();
	public int w3frid=0; // NO_UCD (unused code)
	public int w3fris=0; // NO_UCD (unused code)
	private String w3frin="0";
	
	private ArrayList<Job> w3satJ=new ArrayList<Job>();
	private int w3satT=0;
	private ArrayList<String> w3satW=new ArrayList<String>();
	public int w3satd=0; // NO_UCD (unused code)
	public int w3sats=0; // NO_UCD (unused code)
	private String w3satn="0";
	
	//  WEEK4
	private ArrayList<Job> w4sunJ=new ArrayList<Job>();
	private int w4sunT=0;
	private ArrayList<String> w4sunW=new ArrayList<String>();
	public int w4sund=0; // NO_UCD (unused code)
	public int w4suns=0; // NO_UCD (unused code)
	private String w4sunn="0";
	
	private ArrayList<Job> w4monJ=new ArrayList<Job>();
	private int w4monT=0;
	private ArrayList<String> w4monW=new ArrayList<String>();
	public int w4mond=0; // NO_UCD (unused code)
	public int w4mons=0; // NO_UCD (unused code)
	private String w4monn="";
	
	private ArrayList<Job> w4tueJ=new ArrayList<Job>();
	private int w4tueT=0;
	private ArrayList<String> w4tueW=new ArrayList<String>();
	public int w4tued=0; // NO_UCD (unused code)
	public int w4tues=0; // NO_UCD (unused code)
	private String w4tuen="0";
	
	private ArrayList<Job> w4wedJ=new ArrayList<Job>();
	private int w4wedT=0;
	private ArrayList<String> w4wedW=new ArrayList<String>();
	public int w4wedd=0; // NO_UCD (unused code)
	public int w4weds=0; // NO_UCD (unused code)
	private String w4wedn="0";
	
	private ArrayList<Job> w4thuJ=new ArrayList<Job>();
	private int w4thuT=0;
	private ArrayList<String> w4thuW=new ArrayList<String>();
	public int w4thud=0; // NO_UCD (unused code)
	public int w4thus=0; // NO_UCD (unused code)
	private String w4thun="0";
	
	private ArrayList<Job> w4friJ=new ArrayList<Job>();
	private int w4friT=0;
	private ArrayList<String> w4friW=new ArrayList<String>();
	public int w4frid=0; // NO_UCD (unused code)
	public int w4fris=0; // NO_UCD (unused code)
	private String w4frin="0";
	
	private ArrayList<Job> w4satJ=new ArrayList<Job>();
	private int w4satT=0;
	private ArrayList<String> w4satW=new ArrayList<String>();
	public int w4satd=0; // NO_UCD (unused code)
	public int w4sats=0; // NO_UCD (unused code)
	private String w4satn="0";
	
	
	//  WEEK5
	private ArrayList<Job> w5sunJ=new ArrayList<Job>();
	private int w5sunT=0;
	private ArrayList<String> w5sunW=new ArrayList<String>();
	public int w5sund=0; // NO_UCD (unused code)
	public int w5suns=0; // NO_UCD (unused code)
	private String w5sunn="0";
	
	private ArrayList<Job> w5monJ=new ArrayList<Job>();
	private int w5monT=0;
	private ArrayList<String> w5monW=new ArrayList<String>();
	public int w5mond=0; // NO_UCD (unused code)
	public int w5mons=0; // NO_UCD (unused code)
	private String w5monn="0";
	
	private ArrayList<Job> w5tueJ=new ArrayList<Job>();
	private int w5tueT=0;
	private ArrayList<String> w5tueW=new ArrayList<String>();
	public int w5tued=0; // NO_UCD (unused code)
	public int w5tues=0; // NO_UCD (unused code)
	private String w5tuen="0";
	
	private ArrayList<Job> w5wedJ=new ArrayList<Job>();
	private int w5wedT=0;
	private ArrayList<String> w5wedW=new ArrayList<String>();
	public int w5wedd=0; // NO_UCD (unused code)
	public int w5weds=0; // NO_UCD (unused code)
	private String w5wedn="0";
	
	private ArrayList<Job> w5thuJ=new ArrayList<Job>();
	private int w5thuT=0;
	private ArrayList<String> w5thuW=new ArrayList<String>();
	public int w5thud=0; // NO_UCD (unused code)
	public int w5thus=0; // NO_UCD (unused code)
	private String w5thun="0";
	
	private ArrayList<Job> w5friJ=new ArrayList<Job>();
	private int w5friT=0;
	private ArrayList<String> w5friW=new ArrayList<String>();
	public int w5frid=0; // NO_UCD (unused code)
	public int w5fris=0; // NO_UCD (unused code)
	private String w5frin="0";
	
	private ArrayList<Job> w5satJ=new ArrayList<Job>();
	private int w5satT=0;
	private ArrayList<String> w5satW=new ArrayList<String>();
	public int w5satd=0; // NO_UCD (unused code)
	public int w5sats=0; // NO_UCD (unused code)
	private String w5satn="0";
	
	public Variables(){
		// Load the jobs hashmap
		HashMap<Integer,ArrayList<Job>> jobs=Scheduler.jobs;
		jobs.put(11, w1sunJ);
		jobs.put(12, w1monJ);
		jobs.put(13, w1tueJ);
		jobs.put(14, w1wedJ);
		jobs.put(15, w1thuJ);
		jobs.put(16, w1friJ);
		jobs.put(17, w1satJ);
		jobs.put(21, w2sunJ);
		jobs.put(22, w2monJ);
		jobs.put(23, w2tueJ);
		jobs.put(24, w2wedJ);
		jobs.put(25, w2thuJ);
		jobs.put(26, w2friJ);
		jobs.put(27, w2satJ);
		jobs.put(31, w3sunJ);
		jobs.put(32, w3monJ);
		jobs.put(33, w3tueJ);
		jobs.put(34, w3wedJ);
		jobs.put(35, w3thuJ);
		jobs.put(36, w3friJ);
		jobs.put(37, w3satJ);
		jobs.put(41, w4sunJ);
		jobs.put(42, w4monJ);
		jobs.put(43, w4tueJ);
		jobs.put(44, w4wedJ);
		jobs.put(45, w4thuJ);
		jobs.put(46, w4friJ);
		jobs.put(47, w4satJ);
		jobs.put(51, w5sunJ);
		jobs.put(52, w5monJ);
		jobs.put(53, w5tueJ);
		jobs.put(54, w5wedJ);
		jobs.put(55, w5thuJ);
		jobs.put(56, w5friJ);
		jobs.put(57, w5satJ);
		
		// Load times hashmap
		HashMap<Integer,Integer> times=Scheduler.times;
		times.put(11, w1sunT);
		times.put(12, w1monT);
		times.put(13, w1tueT);
		times.put(14, w1wedT);
		times.put(15, w1thuT);
		times.put(16, w1friT);
		times.put(17, w1satT);
		times.put(21, w2sunT);
		times.put(22, w2monT);
		times.put(23, w2tueT);
		times.put(24, w2wedT);
		times.put(25, w2thuT);
		times.put(26, w2friT);
		times.put(27, w2satT);
		times.put(31, w3sunT);
		times.put(32, w3monT);
		times.put(33, w3tueT);
		times.put(34, w3wedT);
		times.put(35, w3thuT);
		times.put(36, w3friT);
		times.put(37, w3satT);
		times.put(41, w4sunT);
		times.put(42, w4monT);
		times.put(43, w4tueT);
		times.put(44, w4wedT);
		times.put(45, w4thuT);
		times.put(46, w4friT);
		times.put(47, w4satT);
		times.put(51, w5sunT);
		times.put(52, w5monT);
		times.put(53, w5tueT);
		times.put(54, w5wedT);
		times.put(55, w5thuT);
		times.put(56, w5friT);
		times.put(57, w5satT);
		
		// load workers hashmap
		w1sunW.add(0,"1");
		w1monW.add(0,"1");
		w1tueW.add(0,"1");
		w1wedW.add(0,"1");
		w1thuW.add(0,"1");
		w1friW.add(0,"1");
		w1satW.add(0,"1");
		w2sunW.add(0,"1");
		w2monW.add(0,"1");
		w2tueW.add(0,"1");
		w2wedW.add(0,"1");
		w2thuW.add(0,"1");
		w2friW.add(0,"1");
		w2satW.add(0,"1");
		w3sunW.add(0,"1");
		w3monW.add(0,"1");
		w3tueW.add(0,"1");
		w3wedW.add(0,"1");
		w3thuW.add(0,"1");
		w3friW.add(0,"1");
		w3satW.add(0,"1");
		w4sunW.add(0,"1");
		w4monW.add(0,"1");
		w4tueW.add(0,"1");
		w4wedW.add(0,"1");
		w4thuW.add(0,"1");
		w4friW.add(0,"1");
		w4satW.add(0,"1");
		w5sunW.add(0,"1");
		w5monW.add(0,"1");
		w5tueW.add(0,"1");
		w5wedW.add(0,"1");
		w5thuW.add(0,"1");
		w5friW.add(0,"1");
		w5satW.add(0,"1");
		HashMap<Integer,ArrayList<String>> workers=Scheduler.workers;
		workers.put(11, w1sunW);
		workers.put(12, w1monW);
		workers.put(13, w1tueW);
		workers.put(14, w1wedW);
		workers.put(15, w1thuW);
		workers.put(16, w1friW);
		workers.put(17, w1satW);
		workers.put(21, w2sunW);
		workers.put(22, w2monW);
		workers.put(23, w2tueW);
		workers.put(24, w2wedW);
		workers.put(25, w2thuW);
		workers.put(26, w2friW);
		workers.put(27, w2satW);
		workers.put(31, w3sunW);
		workers.put(32, w3monW);
		workers.put(33, w3tueW);
		workers.put(34, w3wedW);
		workers.put(35, w3thuW);
		workers.put(36, w3friW);
		workers.put(37, w3satW);
		workers.put(41, w4sunW);
		workers.put(42, w4monW);
		workers.put(43, w4tueW);
		workers.put(44, w4wedW);
		workers.put(45, w4thuW);
		workers.put(46, w4friW);
		workers.put(47, w4satW);
		workers.put(51, w5sunW);
		workers.put(52, w5monW);
		workers.put(53, w5tueW);
		workers.put(54, w5wedW);
		workers.put(55, w5thuW);
		workers.put(56, w5friW);
		workers.put(57, w5satW);

		// load start times hashmap
		HashMap<Integer,Integer> startT=Scheduler.startT;
		startT.put(11, 0);
		startT.put(12, 0);
		startT.put(13, 0);
		startT.put(14, 0);
		startT.put(15, 0);
		startT.put(16, 0);
		startT.put(17, 0);
		startT.put(21, 0);
		startT.put(22, 0);
		startT.put(23, 0);
		startT.put(24, 0);
		startT.put(25, 0);
		startT.put(26, 0);
		startT.put(27, 0);
		startT.put(31, 0);
		startT.put(32, 0);
		startT.put(33, 0);
		startT.put(34, 0);
		startT.put(35, 0);
		startT.put(36, 0);
		startT.put(37, 0);
		startT.put(41, 0);
		startT.put(42, 0);
		startT.put(43, 0);
		startT.put(44, 0);
		startT.put(45, 0);
		startT.put(46, 0);
		startT.put(47, 0);
		startT.put(51, 0);
		startT.put(52, 0);
		startT.put(53, 0);
		startT.put(54, 0);
		startT.put(55, 0);
		startT.put(56, 0);
		startT.put(57, 0);
		
		//load notes hashmap
		HashMap<Integer,String> notes=Scheduler.notes;
		notes.put(11, w1sunn);
		notes.put(12, w1monn);
		notes.put(13, w1tuen);
		notes.put(14, w1wedn);
		notes.put(15, w1thun);
		notes.put(16, w1frin);
		notes.put(17, w1satn);
		notes.put(21, w2sunn);
		notes.put(22, w2monn);
		notes.put(23, w2tuen);
		notes.put(24, w2wedn);
		notes.put(25, w2thun);
		notes.put(26, w2frin);
		notes.put(27, w2satn);
		notes.put(31, w3sunn);
		notes.put(32, w3monn);
		notes.put(33, w3tuen);
		notes.put(34, w3wedn);
		notes.put(35, w3thun);
		notes.put(36, w3frin);
		notes.put(37, w3satn);
		notes.put(41, w4sunn);
		notes.put(42, w4monn);
		notes.put(43, w4tuen);
		notes.put(44, w4wedn);
		notes.put(45, w4thun);
		notes.put(46, w4frin);
		notes.put(47, w4satn);
		notes.put(51, w5sunn);
		notes.put(52, w5monn);
		notes.put(53, w5tuen);
		notes.put(54, w5wedn);
		notes.put(55, w5thun);
		notes.put(56, w5frin);
		notes.put(57, w5satn);
		
		//load months hashmap
		HashMap<Integer,CalenderFrame> months=Scheduler.months;
		months.put(1, new CalenderFrame());
		months.put(2, new CalenderFrame());
		months.put(3, new CalenderFrame());
		months.put(4, new CalenderFrame());
		months.put(5, new CalenderFrame());
		months.put(6, new CalenderFrame());
		months.put(7, new CalenderFrame());
		months.put(8, new CalenderFrame());
		months.put(9, new CalenderFrame());
		months.put(10, new CalenderFrame());
		months.put(11, new CalenderFrame());
		months.put(12, new CalenderFrame());
	}
	
}
