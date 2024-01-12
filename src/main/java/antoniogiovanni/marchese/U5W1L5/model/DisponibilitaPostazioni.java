package antoniogiovanni.marchese.U5W1L5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Postazione postazione;
    private Boolean libera;
    private LocalDate date;
}
