package com.leave.dto;
import java.util.TimerTask;
import java.util.Date;

public class Scheduler {
	private Date CurrentDate;
	private Date NextDate;
	public Date getCurrentDate() {
		return CurrentDate;
	}
	public void setCurrentDate(Date currentDate) {
		CurrentDate = currentDate;
	}
	public Date getNextDate() {
		return NextDate;
	}
	public void setNextDate(Date nextDate) {
		NextDate = nextDate;
	}
	

}
