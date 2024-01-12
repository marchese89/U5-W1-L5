package antoniogiovanni.marchese.U5W1L5.runners;

import antoniogiovanni.marchese.U5W1L5.model.Edificio;
import antoniogiovanni.marchese.U5W1L5.model.Prenotazione;
import antoniogiovanni.marchese.U5W1L5.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    DisponibilitaPostazioniService disponibilitaPostazioniService;
    @Autowired
    EdificioService edificioService;
    @Autowired
    PostazioneService postazioneService;
    @Autowired
    PrenotazioneService prenotazioneService;
    @Autowired
    UtenteService utenteService;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("----------------------- AVVIO RUNNER --------------------");
        Edificio edificio = new Edificio("Edificio 1","via Roma n.1","Roma");
        edificioService.create(edificio);

    }
}
