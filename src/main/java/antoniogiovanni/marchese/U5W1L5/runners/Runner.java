package antoniogiovanni.marchese.U5W1L5.runners;

import antoniogiovanni.marchese.U5W1L5.U5W1L5Application;
import antoniogiovanni.marchese.U5W1L5.interfaces.TipoPostazione;
import antoniogiovanni.marchese.U5W1L5.model.*;
import antoniogiovanni.marchese.U5W1L5.service.*;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        Postazione postazione = new Postazione("Postazione1", TipoPostazione.PRIVATO,5,edificioService.findByNome("Edificio 1").get(0));
        System.out.println("Creo una postazione");
        postazioneService.create(postazione);
        DisponibilitaPostazioni disponibilitaPostazioni = new DisponibilitaPostazioni(postazioneService.findById(1),true,LocalDate.now());
        disponibilitaPostazioniService.create(disponibilitaPostazioni);
        System.out.println("creata disponibilità");
        Utente utente = new Utente("utente1","nome completo","email@email.it");
        utenteService.create(utente);
        System.out.println("salvo un utente");
        Prenotazione prenotazione = new Prenotazione(utenteService.findById(1),LocalDate.now(),postazioneService.findById(1));
        boolean risultatoPrenotazione = prenotazioneService.create(prenotazione);
        System.out.println("----------------------- PRENOTAZIONE IN DATA NON LIBERA ----------------------------");
        Prenotazione prenotazioneNo = new Prenotazione(utenteService.findById(1),LocalDate.now().plusDays(2),postazioneService.findById(1));
        boolean risultatoPrenotazioneNo = prenotazioneService.create(prenotazioneNo);
        System.out.println("risultato prenotazione: "+risultatoPrenotazioneNo);

        System.out.println("---------------------------------- NUMERO PRENOTATI PER POSTAZIONE E DATA --------------------------");
        long prenotati = prenotazioneService.getPrenotatiByPostazioneAndData(LocalDate.now(),postazioneService.findById(1));
        System.out.println(prenotati);
        postazioneService.findByTipoPostazioneCitta(TipoPostazione.PRIVATO,"Roma").forEach(System.out::println);
        System.out.println("--------------- PRENOTAZIONE NELLA STESSA DATA -------------------------");
        Prenotazione prenotazione2 = new Prenotazione(utenteService.findById(1),LocalDate.now(),postazioneService.findById(1));
        boolean risultatoPrenotazione2 = prenotazioneService.create(prenotazione2);
        System.out.println("risultato: "+risultatoPrenotazione2);
        System.out.println("---------------------------------------- FINE RUNNER --------------------------------");
    }
}
