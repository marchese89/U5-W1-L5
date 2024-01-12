package antoniogiovanni.marchese.U5W1L5.repository;

import antoniogiovanni.marchese.U5W1L5.interfaces.TipoPostazione;
import antoniogiovanni.marchese.U5W1L5.model.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione,Long> {
    @Query("SELECT p FROM Postazione p WHERE p.tipoPostazione = :tipoPostazione AND p.edificio.citta = :citta")
    List<Postazione> findByTipoPostazioneCitta(TipoPostazione tipoPostazione, String citta);
}
