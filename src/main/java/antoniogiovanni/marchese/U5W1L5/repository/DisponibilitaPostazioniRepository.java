package antoniogiovanni.marchese.U5W1L5.repository;

import antoniogiovanni.marchese.U5W1L5.model.DisponibilitaPostazioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilitaPostazioniRepository extends JpaRepository<DisponibilitaPostazioni,Long> {
}