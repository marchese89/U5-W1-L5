package antoniogiovanni.marchese.U5W1L5.repository;

import antoniogiovanni.marchese.U5W1L5.model.Postazione;
import antoniogiovanni.marchese.U5W1L5.model.Prenotazione;
import antoniogiovanni.marchese.U5W1L5.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Long> {
    @Query("SELECT COUNT (p) FROM Prenotazione p WHERE p.data = :data AND p.postazione = :postazione")
    long getPrenotatiByPostazioneAndData(LocalDate data , Postazione postazione);

    //vediamo se l'utente ha già fatto una prenotazione in una certa data
    //per evitare di fargli fare più prenotazioni nella stessa data
    @Query("SELECT p FROM Prenotazione p WHERE p.utente = :utente AND p.data = :data")
    List<Prenotazione> getPrenotazioniByUtenteData(Utente utente, LocalDate data);
}
