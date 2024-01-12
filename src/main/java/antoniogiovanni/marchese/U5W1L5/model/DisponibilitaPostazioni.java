package antoniogiovanni.marchese.U5W1L5.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class DisponibilitaPostazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Postazione postazione;
    private Boolean libera;
    private LocalDate date;
}
