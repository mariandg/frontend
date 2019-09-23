package pl.sii.ums.model.rest;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TimeShitCalendar {

//	public TimeShitCalendar(int daysInMonth, int firstDayInMonth, List<TimeShitWeek> weeks) {
//		this.daysInMonth = daysInMonth;
//		this.firstDayInMonth = firstDayInMonth;
//		this.weeks = weeks;
//	}
	@Getter
	@Setter
	private int daysInMonth;
	
	@Getter
	@Setter
	private int firstDayInMonth;

	@Getter
	@Setter
	private int cellNumber;
	
	@Getter
	@Setter
	private List<TimeShitWeek> weeks;
	
}
