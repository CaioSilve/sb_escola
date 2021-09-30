package silveira.caio.escola.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_salas")
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String desc;
	private int seme;
	@ManyToMany
	private List<Disciplina> discis = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "sala")
	private List<Estudante> estu = new ArrayList<>();
	
	public Sala() {
		// TODO Auto-generated constructor stub
	}

	public Sala(String desc, int semestre, List<Disciplina> discis) {
		super();
		this.desc = desc;
		this.seme = semestre;
		this.discis = discis;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getSeme() {
		return seme;
	}

	public void setSeme(int seme) {
		this.seme = seme;
	}

	public List<Disciplina> getDiscis() {
		return discis;
	}

	public void setDiscis(List<Disciplina> discis) {
		this.discis = discis;
	}

	public List<Estudante> getEstu() {
		return estu;
	}

	public Long getId() {
		return id;
	}
	
	
}
