package pl.sii.ums.model.rest;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TimeShitDay {

	@Getter
	@Setter
	private int dayInWeek;

	@Getter
	@Setter
	private int dayNumber;

	@Getter
	@Setter
	private boolean currentMonth;
	
	@Getter
	@Setter
	private List<TimeShitAnnotation> annotations;
}
