package silveira.caio.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silveira.caio.escola.model.entity.Estudante;
import silveira.caio.escola.repository.SalaRepository;
import silveira.caio.escola.service.EstudanteService;

@Controller
@RequestMapping("/estudantes")
public class EstudanteController {

	@Autowired
	EstudanteService serv;
	
	@Autowired
	SalaRepository salaRepo;
	
	@GetMapping
	public ModelAndView getAllEstudantes(){
		ModelAndView mv = new ModelAndView("Estudantes");
		
		mv.addObject("estudantes", serv.findAllEstudante());
		
		mv.setStatus(HttpStatus.OK);

		return mv;
	}
	
	
	@GetMapping("/novo")
	public ModelAndView setEstuForm() {
		ModelAndView mv = new ModelAndView("NovoEstudante");
		Estudante es = new Estudante();
		
		mv.addObject("estu", es);
		mv.addObject("salas", salaRepo.findAll());
		mv.setStatus(HttpStatus.OK);
		
		
		return mv;
	}
	
	
	@PostMapping
	public ModelAndView addEstu(@ModelAttribute("estu") Estudante estu) {
		ModelAndView mv = new ModelAndView();
		
		switch (serv.saveEstudante(estu)) {
		case 1:
			mv.setStatus(HttpStatus.BAD_REQUEST);
			mv.setViewName("redirect:/estudantes/novo");
			break;
		case 2:
			mv.setStatus(HttpStatus.CONFLICT);
			mv.setViewName("redirect:/estudantes/novo");
			break;
		default:
			mv.setStatus(HttpStatus.OK);
			mv.setViewName("redirect:/estudantes");
			break;
		}
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
}
