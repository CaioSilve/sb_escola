package silveira.caio.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silveira.caio.escola.model.entity.Estudante;
import silveira.caio.escola.model.entity.Sala;
import silveira.caio.escola.repository.EstudanteRepository;
import silveira.caio.escola.repository.SalaRepository;

@Service
public class EstudanteService {

	@Autowired
	EstudanteRepository repo;
	
	@Autowired
	SalaRepository salaRepo;
	
	
	public List<Estudante> findAllEstudante(){
		return repo.findAll();
	}
	
	public List<Sala> findAllSalas(){
		return salaRepo.findAll();
	}
	
	public Estudante findByIdEstu(Long id) {
		return repo.findById(id).get();
	}
	
	public int saveEstudante(Estudante obj) {
		if(campoVazio(obj)) return 1;
		
		if(obj.getSala().getDesc().trim() != "") {
			for (Sala s: salaRepo.findAll()) {
				if(s.getDesc().equals(obj.getSala().getDesc())) {
					obj.setSala(salaRepo.getById(s.getId()));
					break;
				}
			}
		} else {
			obj.setSala(null);
		}
		
		try {
			repo.save(obj);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 2;
		}
		
	}
	
	public boolean updateEstudante(Long id, Estudante estu) {
		
		try {
			Estudante old = repo.findById(id).get();
			old.setNome(estu.getNome());
			old.setEmail(estu.getEmail());
			old.setSala(estu.getSala());
			old.setNotas(estu.getNotas());
			this.saveEstudante(old);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage()); 
			return false;
		}
		
	}
	
	public void deleteEstudante(Long id) {
		repo.deleteById(id);
	}
	
	private boolean campoVazio(Estudante estu) {
		if(estu.getEmail().isBlank() || estu.getNome().isBlank()) return true;
		return false;
	}

	
}
