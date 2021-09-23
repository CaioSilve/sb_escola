package silveira.caio.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silveira.caio.escola.service.EstudanteService;

@Controller
@RequestMapping("/estudantes")
public class EstudanteController {

	@Autowired
	EstudanteService serv;
	
	@GetMapping
	public ModelAndView getAllEstudantes(){
		ModelAndView mv = new ModelAndView("Estudantes");
		
		mv.addObject("estudantes", serv.findAllEstudante());
		
		mv.setStatus(HttpStatus.OK);

		return mv;
	}
	
}
