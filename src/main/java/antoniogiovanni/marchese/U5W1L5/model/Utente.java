package antoniogiovanni.marchese.U5W1L5.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return id == utente.id && username.equals(utente.username) && nomeCompleto.equals(utente.nomeCompleto) && email.equals(utente.email);
    }

}
