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
	
	public void saveEstudante(Estudante obj) {
		repo.save(obj);
	}
	
}
