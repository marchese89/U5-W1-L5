package antoniogiovanni.marchese.U5W1L5.repository;

import antoniogiovanni.marchese.U5W1L5.model.Postazione;
import antoniogiovanni.marchese.U5W1L5.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Long> {
    @Query("SELECT COUNT (p) FROM Prenotazione p WHERE p.data = :data AND p.postazione = :postazione")
    long getPrenotatiByPostazioneAndData(LocalDate data , Postazione postazione);
}
