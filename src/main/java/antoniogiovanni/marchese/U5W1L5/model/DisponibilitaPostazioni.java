package antoniogiovanni.marchese.U5W1L5.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "disponibilita_postazioni")
@RequiredArgsConstructor
public class DisponibilitaPostazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "postazione_id")
    @NonNull
    private Postazione postazione;
    @NonNull
    private Boolean libera;
    @NonNull
    private LocalDate data;
}
