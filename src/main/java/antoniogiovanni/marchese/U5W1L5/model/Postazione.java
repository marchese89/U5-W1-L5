package antoniogiovanni.marchese.U5W1L5.model;

import antoniogiovanni.marchese.U5W1L5.interfaces.TipoPostazione;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "postazioni")
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "descrizione")
    @NonNull
    private String descrizione;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_postazione")
    @NonNull
    private TipoPostazione tipoPostazione;
    @NonNull
    @Column(name = "max_occupanti")
    private int maxOccupanti;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    @NonNull
    private Edificio edificio;
    @OneToMany
    private List<DisponibilitaPostazioni> disponibilitaPostazioniList;
    @OneToMany
    private List<Prenotazione> prenotazioneList;
}
