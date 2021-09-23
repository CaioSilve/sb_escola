package silveira.caio.escola.model.entity.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

import silveira.caio.escola.model.entity.Disciplina;
import silveira.caio.escola.model.entity.Estudante;

@Embeddable
public class pkNota implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	@OneToOne
	private Estudante estu;
	@OneToOne
	private Disciplina disci;
	
	public Estudante getEstu() {
		return estu;
	}
	public void setEstu(Estudante estu) {
		this.estu = estu;
	}
	public Disciplina getDisci() {
		return disci;
	}
	public void setDisci(Disciplina disci) {
		this.disci = disci;
	}
	
	
}
