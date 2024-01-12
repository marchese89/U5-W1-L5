package antoniogiovanni.marchese.U5W1L5.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String username;
    @NonNull
    private String nomeCompleto;
    @NonNull
    private String email;
    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioneList;

}
