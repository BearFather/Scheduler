package net.bearfather.Scheduler;

class Job {
	private String name;
	private String id;
	private int cat;//0=contract,1=w/o,2=other
	private int type; //0=floors,1=carpet,2=both,3=project
	private int length;
	// sun[0]=yes/no sun[1]=start time
	private int[] sun;
	private int[] mon;
	private int[] tue;
	private int[] wed;
	private int[] thu;
	private int[] fri;
	private int[] sat;
	private int[] month;
	
	
	Job(String name,String id,int cat,int type,int length,int[] sun,int[] mon,int[] tue,int[] wed,int[] thu,int[] fri,int[] sat,int[] month){
		this.name=name;
		this.id=id;
		this.cat=cat;
		this.type=type;
		this.length=length;
		this.sun=sun;
		this.mon=mon;
		this.tue=tue;
		this.wed=wed;
		this.thu=thu;
		this.fri=fri;
		this.sat=sat;
		this.month=month;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCat() {
		return cat;
	}
	public void setCat(int cat) {
		this.cat = cat;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int[] getSun() {
		return sun;
	}
	public void setSun(int[] sun) {
		this.sun = sun;
	}
	public int[] getMon() {
		return mon;
	}
	public void setMon(int[] mon) {
		this.mon = mon;
	}
	public int[] getTue() {
		return tue;
	}
	public void setTue(int[] tue) {
		this.tue = tue;
	}
	public int[] getWed() {
		return wed;
	}
	public void setWed(int[] wed) {
		this.wed = wed;
	}
	public int[] getThu() {
		return thu;
	}
	public void setThu(int[] thu) {
		this.thu = thu;
	}
	public int[] getFri() {
		return fri;
	}
	public void setFri(int[] fri) {
		this.fri = fri;
	}
	public int[] getSat() {
		return sat;
	}
	public void setSat(int[] sat) {
		this.sat = sat;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	int[] getDay(int day){
		int[] rtn=new int[2];
		switch (day){
		case 1:
			return sun;
		case 2:
			return mon;
		case 3:
			return tue;
		case 4:
			return wed;
		case 5:
			return thu;
		case 6:
			return fri;
		case 7:
			return sat;
		}
		return rtn;
		
	}
	public String sType(){
		String rtn="Unknown";
		if (type==0){
			rtn="Floors";
		}else if (type==1){
			rtn="Carpet";
		}else if (type==2){
			rtn="Both";
		}else if (type==3){
			rtn="Project";
		}
		return rtn;
	}
	String sCat(){
		String rtn="Unknown";
		if (cat==0){
			rtn="Contract";
		}else if (cat==1){
			rtn="Work Order";
		}else if (cat==2){
			rtn="Other";
		}
		return rtn;
		
	}
	public int[] getMonth() {
		return month;
	}
	public void setMonth(int[] month) {
		this.month = month;
	}
}
