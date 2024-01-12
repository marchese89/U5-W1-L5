package antoniogiovanni.marchese.U5W1L5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
//per controllare se una riga si può inserire nella tabella relativa
//dobbiamo fare dei controlli lato Spring sul fatto che la postazione
//in quel giorno sia libera e che il numero degli utenti prenotati per
//quel giorno non ecceda la capienza massima della postazione stessa
@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private Utente utente;
    @NonNull
    private LocalDate date;
    @NonNull
    private Postazione postazione;
}
