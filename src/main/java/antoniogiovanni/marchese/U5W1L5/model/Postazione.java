package antoniogiovanni.marchese.U5W1L5.model;

import antoniogiovanni.marchese.U5W1L5.interfaces.TipoPostazione;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

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
    @OneToMany(mappedBy = "postazione")
    private List<DisponibilitaPostazioni> disponibilitaPostazioniList;
    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioneList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Postazione that = (Postazione) o;
        return id == that.id && maxOccupanti == that.maxOccupanti && descrizione.equals(that.descrizione) && tipoPostazione == that.tipoPostazione && edificio.equals(that.edificio);
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipoPostazione=" + tipoPostazione +
                ", maxOccupanti=" + maxOccupanti +
                ", edificio=" + edificio +
                '}';
    }
}
