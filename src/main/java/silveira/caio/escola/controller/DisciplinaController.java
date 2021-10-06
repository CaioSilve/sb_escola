package silveira.caio.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silveira.caio.escola.service.DisciplinaService;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

	@Autowired
	DisciplinaService serv;
	
	@GetMapping
	public ModelAndView getDisciplinas() {
		ModelAndView mv = new ModelAndView("Lista");
		
		mv.addObject("tipo", "Disciplina");
		mv.addObject("disciplinas", serv.findAllDisci());
		
		mv.setStatus(HttpStatus.OK);
		
		return mv;
	}
	
	
	
	
	
}
