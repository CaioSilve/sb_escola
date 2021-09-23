package silveira.caio.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silveira.caio.escola.model.entity.Nota;
import silveira.caio.escola.repository.NotaRepository;

@Service
public class NotaService {

	@Autowired
	NotaRepository repo;
	
	
	public List<Nota> findAllNota(){
		return repo.findAll();
	}
	
	public void saveNota(Nota obj) {
		repo.save(obj);
	}
	
}
