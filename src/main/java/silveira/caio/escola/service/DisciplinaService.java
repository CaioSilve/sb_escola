package silveira.caio.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silveira.caio.escola.model.entity.Disciplina;
import silveira.caio.escola.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	DisciplinaRepository repo;
	
	
	public List<Disciplina> findAllDisci(){
		return repo.findAll();
	}
	
	public Disciplina findByIdDisci(Long id) {
		return repo.getById(id);
	}
	
	public void saveDisci(Disciplina obj) {
		repo.save(obj);
	}
	
}
