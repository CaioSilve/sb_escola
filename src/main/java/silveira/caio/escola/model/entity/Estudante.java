package silveira.caio.escola.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_estudantes")
public class Estudante {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	@ManyToOne
	private Sala sala;
	@OneToMany(mappedBy = "id.estu")
	private List<Nota> notas = new ArrayList<>();
	
	public Estudante() {
		// TODO Auto-generated constructor stub
	}

	public Estudante(String nome, String email, Sala sala) {
		super();
		this.nome = nome;
		this.email = email;
		this.sala = sala;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
