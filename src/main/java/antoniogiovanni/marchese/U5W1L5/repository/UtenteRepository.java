package antoniogiovanni.marchese.U5W1L5.repository;

import antoniogiovanni.marchese.U5W1L5.model.Utente;
import org.aspectj.apache.bcel.generic.LOOKUPSWITCH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
}
