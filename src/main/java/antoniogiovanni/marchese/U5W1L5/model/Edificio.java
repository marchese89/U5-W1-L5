package antoniogiovanni.marchese.U5W1L5.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String nome;
    @NonNull
    private String indirizzo;
    @NonNull
    private String citta;

//    @OneToMany
//    private List<Postazione> postazioneList;

}
