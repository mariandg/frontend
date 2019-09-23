package pl.sii.ums.services.util;

import java.util.ArrayList;
import java.util.List;

import pl.sii.ums.model.rest.TimeShitCalendar;
import pl.sii.ums.model.rest.TimeShitDay;
import pl.sii.ums.model.rest.TimeShitWeek;

public class TimeShitPreparationService {

	private TimeShitCalendar calendar;
	
	private List<TimeShitWeek> weeks = new ArrayList<TimeShitWeek>();
	
	public TimeShitPreparationService(int daysInMonth, int firstDayInMonth) {
		this.calendar = new TimeShitCalendar(daysInMonth, firstDayInMonth, getNumberOfTableCells(daysInMonth,firstDayInMonth),null);
	}
	
	public TimeShitCalendar prepareTimeShitCalendar() {
		
		int dayInAWeek = 0;
		int dayNumber = 0;
		int nextMonthDayIterator = 0;
		int daysNumberBeforCurrentMonth = calendar.getFirstDayInMonth()-1;
		int weeksNumber = getWeeksNumber(calendar.getDaysInMonth(), calendar.getFirstDayInMonth());
		
		boolean isCurrentMonth = true;
		for(int weeksIterator = 0 ; weeksIterator < weeksNumber ; weeksIterator++) {			

			TimeShitDay[] days = new TimeShitDay[7];
			for(int daysIterator = 0 ; daysIterator < 7; daysIterator++) {

				dayNumber = (daysIterator+1)+((weeksIterator*7)) - daysNumberBeforCurrentMonth; //- daysNumberBeforCurrentMonth
				
				if(dayNumber < 1) {
					isCurrentMonth = false;
					dayNumber = 30+dayNumber;
					
				}else if(dayNumber > calendar.getDaysInMonth()) {
					isCurrentMonth = false;
					dayNumber = 1+nextMonthDayIterator++;
				}else isCurrentMonth = true;
				
				if(((daysIterator+1)%7) == 0) {
					dayInAWeek = 7;					
				}else dayInAWeek = ((daysIterator+1)%7);
				
				days[daysIterator] = new TimeShitDay(dayInAWeek, dayNumber, isCurrentMonth, null);
			}
			
			weeks.add(new TimeShitWeek(0, weeksIterator+1, days));
		}

		calendar.setWeeks(weeks);
		//sshowDaysFromCalendar();
		return calendar;		
	}
	
	private int getNumberOfTableCells(int daysInMonth, int firstDayInMonth) {
	
		int weeks = 0;		
		weeks = getWeeksNumber(daysInMonth, firstDayInMonth);		
		return weeks*7;
	}
	
	private int getWeeksNumber(int daysInMonth, int firstDayInMonth) {

		int weeks = 0;
		int weeksPart = 0;		
		weeks = (daysInMonth+(firstDayInMonth-1))/7;
		weeksPart = (daysInMonth+(firstDayInMonth-1))%7;
		if(weeksPart>0)weeks += 1;
		return weeks;
	}
	
	public void showDaysFromCalendar() {
		for(int i = 0 ; i < calendar.getWeeks().size() ; i++)
			for(int j = 0 ; j < calendar.getWeeks().get(i).getDays().length ; j++) {
				System.out.print(calendar.getWeeks().get(i).getDays()[j].getDayNumber());
				System.out.print("   |   ");
				System.out.println(calendar.getWeeks().get(i).getDays()[j].getDayInWeek());
			}
		
	}
}
