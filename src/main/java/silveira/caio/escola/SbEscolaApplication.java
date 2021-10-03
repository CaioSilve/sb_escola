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
		Disciplina d1 = new Disciplina("Engenharia da computação");
		Disciplina d2 = new Disciplina("MPTCC");
		Disciplina d3 = new Disciplina("Economia");
		Disciplina d4 = new Disciplina("Administração");
		Disciplina d5 = new Disciplina("Programação mobile");
		
		repoDisc.saveAll(Arrays.asList(d1,d2,d3,d4,d5));
		 
		
		Sala s1 = new Sala("1B", 2, repoDisc.findAll());
		Sala s2 = new Sala("3A", 5, Arrays.asList(d4,d5));
		
		repoSala.saveAll(Arrays.asList(s1,s2));
		
		
		Estudante es1 = new Estudante("Caio Silveira, o mais gato de todos", "caio@gmai.com", s1);
		Estudante es2 = new Estudante("Gisele Matos", "gisele@gmai.com", null);
		Estudante es3 = new Estudante("Otávio Zigueira", "otavio@gmai.com", s1);
		Estudante es4 = new Estudante("Laiane Ribeiro", "laiane@gmai.com", s2);
		Estudante es5 = new Estudante("Pedro", "predo@gmail.com", null);
	
		repoEstu.saveAll(Arrays.asList(es1,es2,es3,es4,es5));
		
	}

}
