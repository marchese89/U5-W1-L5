package antoniogiovanni.marchese.U5W1L5.model;

import antoniogiovanni.marchese.U5W1L5.interfaces.TipoPostazione;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String descrizione;
    @NonNull
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;
    @NonNull
    private int maxOccupanti;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    @NonNull
    private Edificio edificio;
}
