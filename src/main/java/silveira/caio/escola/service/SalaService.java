package silveira.caio.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silveira.caio.escola.model.entity.Sala;
import silveira.caio.escola.repository.SalaRepository;

@Service
public class SalaService {

	@Autowired
	SalaRepository repo;
	
	
	public List<Sala> findAllSala(){
		return repo.findAll();
	}
	
	public void saveSala(Sala obj) {
		repo.save(obj);
	}
	
}
