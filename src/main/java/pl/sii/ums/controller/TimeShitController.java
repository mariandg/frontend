package pl.sii.ums.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import pl.sii.ums.model.rest.TimeShitAnnotation;
import pl.sii.ums.model.rest.TimeShitCalendar;
import pl.sii.ums.services.impl.TimeShitCalendarServiceImpl;
import pl.sii.ums.services.impl.UmsInfoServiceImpl;

@Controller
public class TimeShitController {
	
    @Value("${spring.application.name}")
    String appName;
    
    private final String TIMESHIT_PAGE_NAME = "pages/timeshit";//"home  :: home";
    
    @Autowired
    private UmsInfoServiceImpl umsInfoService;
 
    private TimeShitCalendar calendar;
    
    @Autowired
    TimeShitCalendarServiceImpl timeShitCalendarService;
    
	@GetMapping("/timeshit")
	public String aboutUsPage(Model model) {
		
        model.addAttribute("pageName", TIMESHIT_PAGE_NAME);
        model.addAttribute("portalName", umsInfoService.getInformationAboutPortal().getName());
        model.addAttribute("portalDescription", umsInfoService.getInformationAboutPortal().getAboutCompany());
		return "main";
		
	}

	 @RequestMapping(value = "/timeshit/year/{yearNr}/month/{monthNr}", method = RequestMethod.GET)
	 public String detailRefresh(@PathVariable int yearNr, @PathVariable int monthNr, Model model) {

		calendar = timeShitCalendarService.getCalendar(yearNr, monthNr);
		model.addAttribute("calendar", calendar);
		return "fragments/timeshitcalendar";
	 }
	 
	 @PostMapping(path = "/timeshit/add/adnotation")
	 @ResponseStatus(value = HttpStatus.OK)
	 public void addAddnotation(@RequestParam(required = false)  String weekNumber,@RequestParam(required = false)  String dayInWeekNumber) {

		System.out.println("weekNumber : "+weekNumber);
		System.out.println("dayInWeekNumber : "+dayInWeekNumber);
		if(calendar.getWeeks().get((int)Integer.valueOf(weekNumber)).getDays()[(int)Integer.valueOf(dayInWeekNumber)-1].getAnnotations() != null) {
			System.out.println("IFFFF");
			calendar.getWeeks().get((int)Integer.valueOf(weekNumber)).getDays()[(int)Integer.valueOf(dayInWeekNumber)-1].getAnnotations().add(new TimeShitAnnotation("test", 8));
		} else {
			System.out.println("ELSE");
			List<TimeShitAnnotation> annotations = new ArrayList<TimeShitAnnotation>();
			annotations.add(new TimeShitAnnotation("test", 8));
			calendar.getWeeks().get((int)Integer.valueOf(weekNumber)).getDays()[(int)Integer.valueOf(dayInWeekNumber)-1].setAnnotations(annotations);
		}
	 }
	 
//	private boolean isLeapYear(int year) {
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, year);
//		return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
//	}
}
