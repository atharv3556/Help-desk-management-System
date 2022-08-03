/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author athar
 */
public class Helpdesk {
	private long Q_No;
	private String Date;
	private String Name;
	private long Mobile;
	private String Email;
	private String Gender;
	private String Complaint;
	private String Solution;
	public long getQ_No() {
		return Q_No;
	}
	public void setQ_No(long Q_No) {
		this.Q_No = Q_No;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String Date) {
		this.Date = Date;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public long getMobile() {
		return Mobile;
	}
	public void setMobile(long Mobile) {
		this.Mobile = Mobile;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
        public String getGender() {
		return Gender;
	}
	public void setGender(String Gender) {
		this.Gender = Gender;
	}
        public String getComplaint() {
		return Complaint;
	}
	public void setComplaint(String Complaint) {
		this.Complaint = Complaint;
	}
        public String getSolution() {
		return Solution;
	}
	public void setSolution(String Solution) {
		this.Solution = Solution;
	}
	public Helpdesk(long Q_No, String Date,String Name,int Mobile, String Email,String Gender,String DOB,String Complaint,String Solution) {
		super();
		this.Q_No = Q_No;
		this.Date = Date;
		this.Name = Name;
		this.Mobile = Mobile;
		this.Email = Email;
		this.Gender = Gender;
		this.Complaint =Complaint;
		this.Solution = Solution;
	}
	public Helpdesk() {
		super();
	}
	@Override
	public String toString() {
		return "Helpdesk [Q_No=" + Q_No + ", Date=" + Date + ", Name="
				+ Name + ", Mobile=" + Mobile + ", Email=" + Email + ",Gender=" + Gender + ",Complaint=" + Complaint + ",Solution=" + Solution + ",]";
	}
	
}