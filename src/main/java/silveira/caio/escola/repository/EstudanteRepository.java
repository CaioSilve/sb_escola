package silveira.caio.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import silveira.caio.escola.model.entity.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
