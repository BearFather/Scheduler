package net.bearfather.Scheduler;

class JobInfo {
	private String accName="";
	private String accAddress="";
	private String accContact="";
	private String accNum="";
	private String accPhone="";
	private String conPhone="";
	private boolean alarm=false;
	private String alarmComp=""; // THIS IS USED AS ALARM CODE
	private String alarmPhone="";
	private String commLog="";
	private String lights="";
	private String water="";
	private String breakers="";
	private String notes="";
	
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getAccAddress() {
		return accAddress;
	}
	public void setAccAddress(String accAddress) {
		this.accAddress = accAddress;
	}
	public String getAccContact() {
		return accContact;
	}
	public void setAccContact(String accContact) {
		this.accContact = accContact;
	}
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public String getAccPhone() {
		return accPhone;
	}
	public void setAccPhone(String accPhone) {
		this.accPhone = accPhone;
	}
	public String getConPhone() {
		return conPhone;
	}
	public void setConPhone(String conPhone) {
		this.conPhone = conPhone;
	}
	public boolean isAlarm() {
		return alarm;
	}
	public void setAlarm(boolean alarm) {
		this.alarm = alarm;
	}
	public String getAlarmComp() {
		return alarmComp;
	}
	public void setAlarmComp(String alarmComp) {
		this.alarmComp = alarmComp;
	}
	public String getAlarmPhone() {
		return alarmPhone;
	}
	public void setAlarmPhone(String alarmPhone) {
		this.alarmPhone = alarmPhone;
	}
	public String getCommLog() {
		return commLog;
	}
	public void setCommLog(String commLog) {
		this.commLog = commLog;
	}
	public String getLights() {
		return lights;
	}
	public void setLights(String lights) {
		this.lights = lights;
	}
	public String getWater() {
		return water;
	}
	public void setWater(String water) {
		this.water = water;
	}
	public String getBreakers() {
		return breakers;
	}
	public void setBreakers(String breakers) {
		this.breakers = breakers;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
