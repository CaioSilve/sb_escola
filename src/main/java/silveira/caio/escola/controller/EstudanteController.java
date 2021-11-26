package silveira.caio.escola.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silveira.caio.escola.model.entity.Estudante;
import silveira.caio.escola.service.EstudanteService;

@Controller
@RequestMapping("/estudantes")
public class EstudanteController {

	@Autowired
	EstudanteService serv;
	
	@GetMapping
	public ModelAndView getAllEstudantes(){
		ModelAndView mv = new ModelAndView("Lista");
		
		mv.addObject("estudantes", serv.findAllEstudante());
		mv.addObject("tipo", "Estudante");
		
		
		mv.setStatus(HttpStatus.OK);

		return mv;
	}
	
	@PostMapping
	public ModelAndView getEstudante(@ModelAttribute("filtro") Object filtro){
		ModelAndView mv = new ModelAndView("Lista");
		
		List<Estudante> lista = new ArrayList<Estudante>();
		
		try {
			lista = serv.findAllEstudante().stream()
					.filter(o-> o.getId() == Long.parseLong(filtro.toString()))
					.collect(Collectors.toList());
		}catch (Exception e) {
			lista = serv.findAllEstudante().stream()
					.filter(o-> o.getNome().toLowerCase().contains(filtro.toString().toLowerCase()))
					.collect(Collectors.toList());
		}
	
		
		mv.addObject("estudantes", lista); 
		mv.addObject("tipo", "Estudante");
		
		mv.setStatus(HttpStatus.OK);
		

		return mv;
	}
	
	
	@GetMapping("/novo")
	public ModelAndView setEstuForm() {
		ModelAndView mv = new ModelAndView("Form");
		Estudante es = new Estudante();
		
		mv.addObject("tipo", "Estudante");
		mv.addObject("estu", es);
		mv.addObject("salas", serv.findAllSalas());
		mv.setStatus(HttpStatus.OK);
		
		
		return mv;
	}
	
	@PostMapping("/novo")
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
	
	@GetMapping("/editar/{id}")
	public ModelAndView setEditForm(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("FormEstudante");
		
		
		mv.addObject("estu", serv.findByIdEstu(id));
		mv.addObject("salas", serv.findAllSalas());
		mv.setStatus(HttpStatus.OK);
		
		return mv;
	}
	
	@PostMapping("/editar/{id}")
	public ModelAndView editEstu(@PathVariable Long id, @ModelAttribute Estudante estu) {
		ModelAndView mv = new ModelAndView("redirect:/estudantes");
		
		if(serv.updateEstudante(id, estu)) {
			mv.setStatus(HttpStatus.OK);
		} else {
			mv.setStatus(HttpStatus.BAD_REQUEST);
			mv.setViewName("redirect:/estudantes/editar/" + id.toString());
		}
		
		return mv;
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView delEstu(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("redirect:/estudantes");
		
		try {
			serv.deleteEstudante(id);
			mv.setStatus(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			mv.setStatus(HttpStatus.BAD_REQUEST);
		}
		
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
}
