package silveira.caio.escola.repository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	public ModelAndView getHome() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

}
