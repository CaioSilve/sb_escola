package silveira.caio.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silveira.caio.escola.model.entity.Estudante;
import silveira.caio.escola.repository.EstudanteRepository;

@Service
public class EstudanteService {

	@Autowired
	EstudanteRepository repo;
	
	
	public List<Estudante> findAllEstudante(){
		return repo.findAll();
	}
	
	public int saveEstudante(Estudante obj) {
		if(campoVazio(obj)) return 1;
		
		try {
			repo.save(obj);
			return 0;
		} catch (Exception e) {
			return 2;
		}
		
	}
	
	private boolean campoVazio(Estudante estu) {
		if(estu.getEmail().isBlank() || estu.getNome().isBlank()) return true;
		return false;
	}

	
}
