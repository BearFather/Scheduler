package net.bearfather.Scheduler;
import java.util.Calendar;
import java.util.Date;
class WorkOrder extends Job {
	WorkOrder(String name, String id, int cat, int type, int length,
			int[] sun, int[] mon, int[] tue, int[] wed, int[] thu, int[] fri,
			int[] sat, int[] month) {
		super(name, id, cat, type, length, sun, mon, tue, wed, thu, fri, sat, month);
	}

	private String name;
	private String id;
	private int type; //0=floors,1=carpet,2=both,3=project
	private int length;
	private String owner;
	private String start;
	private Date sDate;
	private Date eDate;
	private String notes;
	
	void WorkOrder2(String name,String id,int type,int length,String owner,String start,Date sdate,Date edate,String notes){
		this.name=name;
		this.id=id;
		this.type=type;
		this.length=length;
		this.owner=owner;
		this.start=start;
		this.sDate=sdate;
		this.eDate=edate;
		this.setNotes(notes);
		buildMonth();
	}
	private void buildMonth(){
		Calendar sCal = Calendar.getInstance();
		Calendar eCal = Calendar.getInstance();
		sCal.setTime(sDate);
		eCal.setTime(eDate);
		int sMonth=sCal.get(Calendar.MONTH)+1;
		int eMonth=eCal.get(Calendar.MONTH)+1;
		int[] month=new int[13];
		int c=0;
		while (c<=eMonth){
			if (c>=sMonth){
				month[c]=1;
			}
			c++;
		}
		super.setMonth(month);
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
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
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	Date getsDate() {
		return sDate;
	}

// TODO from UCDetector: Method "WorkOrder.setsDate(Date)" has 0 references
	public void setsDate(Date sDate) { // NO_UCD (unused code)
		this.sDate = sDate;
	}

	Date geteDate() {
		return eDate;
	}

// TODO from UCDetector: Method "WorkOrder.seteDate(Date)" has 0 references
	public void seteDate(Date eDate) { // NO_UCD (unused code)
		this.eDate = eDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
