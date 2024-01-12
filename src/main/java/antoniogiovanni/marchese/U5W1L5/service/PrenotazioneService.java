package antoniogiovanni.marchese.U5W1L5.service;

import antoniogiovanni.marchese.U5W1L5.model.Prenotazione;
import antoniogiovanni.marchese.U5W1L5.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

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

    public void create(Prenotazione prenotazione){
        prenotazioneRepository.save(prenotazione);
    }

    public Prenotazione update(Prenotazione prenotazione,long id){
        Optional<Prenotazione> found = prenotazioneRepository.findById(id);
        if(found.isEmpty()){
            return null;
        }
        found.get().setDate(prenotazione.getDate());
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
}
