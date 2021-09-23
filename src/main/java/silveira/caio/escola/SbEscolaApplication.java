package silveira.caio.escola;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import silveira.caio.escola.model.entity.Disciplina;
import silveira.caio.escola.model.entity.Estudante;
import silveira.caio.escola.model.entity.Sala;
import silveira.caio.escola.repository.DisciplinaRepository;
import silveira.caio.escola.repository.EstudanteRepository;
import silveira.caio.escola.repository.NotaRepository;
import silveira.caio.escola.repository.SalaRepository;

@SpringBootApplication
public class SbEscolaApplication implements CommandLineRunner {

	@Autowired
	DisciplinaRepository repoDisc;
	
	@Autowired
	SalaRepository repoSala;
	
	@Autowired
	EstudanteRepository repoEstu;
	
	@Autowired
	NotaRepository repoNota;
	
	public static void main(String[] args) {
		SpringApplication.run(SbEscolaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Disciplina d = new Disciplina("Engenharia da computação");
		Disciplina c = new Disciplina("MPTCC");
		Disciplina e = new Disciplina("Economia");
		
		
		repoDisc.saveAll(Arrays.asList(d,c,e));
		
		Sala s1 = new Sala("1B", 2, repoDisc.findAll());
		repoSala.save(s1);
		
		
		Estudante es1 = new Estudante("Caio Silveira", "caio@gmai.com", s1);
		Estudante es2 = new Estudante("Pedro", "predo@gmail.com", null);
		
		
		
		repoEstu.saveAll(Arrays.asList(es1,es2));
		
		
		
	}

}
