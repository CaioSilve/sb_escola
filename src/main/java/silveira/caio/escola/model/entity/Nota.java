package silveira.caio.escola.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import silveira.caio.escola.model.entity.pk.pkNota;

@Entity
@Table(name = "tb_notas")
public class Nota {

	
	@EmbeddedId
	private pkNota id = new pkNota();
	private Double nota1;
	private Double nota2;
	private Double notasAdd;
	
	public Nota() {
		// TODO Auto-generated constructor stub
	}

	public Nota(Estudante estu, Disciplina disci, Double nota1, Double nota2, Double notasAdd) {
		super();
		this.id.setEstu(estu);
		this.id.setDisci(disci);
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.notasAdd = notasAdd;
	}

	public Double getNota1() {
		return nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

	public Double getNotasAdd() {
		return notasAdd;
	}

	public void setNotasAdd(Double notasAdd) {
		this.notasAdd = notasAdd;
	}

	public Estudante getEstudante() {
		return id.getEstu();
	}
	
	public Disciplina getDisciplina() {
		return id.getDisci();
	}
	
	
	
	
	
}
