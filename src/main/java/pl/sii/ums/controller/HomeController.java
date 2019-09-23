package pl.sii.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sii.ums.services.impl.UmsInfoServiceImpl;

@Controller
public class HomeController {
	
    @Value("${spring.application.name}")
    String appName;
    
    private final String HOME_PAGE_NAME = "pages/home";//"home  :: home";
    
    @Autowired
    private UmsInfoServiceImpl umsInfoService;
    
	@GetMapping("/")
	public String homePage(Model model) {
        model.addAttribute("pageName", HOME_PAGE_NAME);
        model.addAttribute("portalName", umsInfoService.getInformationAboutPortal().getName());
        model.addAttribute("portalDescription", umsInfoService.getInformationAboutPortal().getDescription());
		return "main";
	}
	
	@GetMapping("/aboutUs")
	public String aboutUsPage(Model model) {
		
        model.addAttribute("pageName", HOME_PAGE_NAME);
        model.addAttribute("portalName", umsInfoService.getInformationAboutPortal().getName());
        model.addAttribute("portalDescription", umsInfoService.getInformationAboutPortal().getAboutCompany());
		return "main";
		
	}
}

