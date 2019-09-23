package pl.sii.ums.model.rest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TimeShitWeek {

//	public TimeShitWeek(int dayInWeek, int weekNumber, TimeShitDay[] days) {
//		this.dayInWeek = dayInWeek;
//		this.weekNumber = weekNumber;
//		this.days = new TimeShitDay[7];
//		this.days = days;
//	}
	
	@Getter
	@Setter
	private int dayInWeek;

	@Getter
	@Setter
	private int weekNumber;
	

	@Getter
	@Setter
	private TimeShitDay[] days;

}
