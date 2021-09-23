package silveira.caio.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import silveira.caio.escola.model.entity.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

}
