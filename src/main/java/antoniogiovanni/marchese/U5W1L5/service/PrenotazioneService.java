package antoniogiovanni.marchese.U5W1L5.service;

import antoniogiovanni.marchese.U5W1L5.model.Postazione;
import antoniogiovanni.marchese.U5W1L5.model.Prenotazione;
import antoniogiovanni.marchese.U5W1L5.repository.DisponibilitaPostazioniRepository;
import antoniogiovanni.marchese.U5W1L5.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private DisponibilitaPostazioniRepository disponibilitaPostazioniRepository;

    public List<Prenotazione> getAll(){
        return prenotazioneRepository.findAll();
    }

    public Prenotazione findById(long id){
        Optional<Prenotazione> found = prenotazioneRepository.findById(id);
        if(found.isEmpty()){
            return null;
        }
        return found.get();
    }

    public boolean create(Prenotazione prenotazione){
        //aggiungiamo una prenotazione solo se c'è ancora posto
        //e inoltra la postazione scelta risulta libera in quella data
        if(disponibilitaPostazioniRepository.postazioneDisponibilePerData(prenotazione.getPostazione(),prenotazione.getData()).size() > 0){
            long giaPrenotati = prenotazioneRepository.getPrenotatiByPostazioneAndData(prenotazione.getData(),prenotazione.getPostazione());
            if(giaPrenotati < prenotazione.getPostazione().getMaxOccupanti()) {
                prenotazioneRepository.save(prenotazione);
                return true;
            }
        }
        return false;
    }

    public Prenotazione update(Prenotazione prenotazione,long id){
        Optional<Prenotazione> found = prenotazioneRepository.findById(id);
        if(found.isEmpty()){
            return null;
        }
        found.get().setData(prenotazione.getData());
        found.get().setPostazione(prenotazione.getPostazione());
        found.get().setUtente(prenotazione.getUtente());
        prenotazioneRepository.save(found.get());

        return found.get();
    }

    public boolean delete(long id){
        Optional<Prenotazione> found = prenotazioneRepository.findById(id);
        if(found.isEmpty()){
            return false;
        }
        prenotazioneRepository.delete(found.get());
        return true;
    }
    public long getPrenotatiByPostazioneAndData(LocalDate data, Postazione p){
        return prenotazioneRepository.getPrenotatiByPostazioneAndData(data,p);
    }

}
