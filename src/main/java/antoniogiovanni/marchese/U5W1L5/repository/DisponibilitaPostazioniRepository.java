package antoniogiovanni.marchese.U5W1L5.repository;

import antoniogiovanni.marchese.U5W1L5.model.DisponibilitaPostazioni;
import antoniogiovanni.marchese.U5W1L5.model.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DisponibilitaPostazioniRepository extends JpaRepository<DisponibilitaPostazioni,Long> {

    @Query("SELECT d FROM DisponibilitaPostazioni d WHERE d.libera = TRUE AND d.postazione= :postazione AND d.data = :data")
    List<DisponibilitaPostazioni> postazioneDisponibilePerData(Postazione postazione, LocalDate data);

}
