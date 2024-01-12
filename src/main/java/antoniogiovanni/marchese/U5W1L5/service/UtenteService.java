package antoniogiovanni.marchese.U5W1L5.service;

import antoniogiovanni.marchese.U5W1L5.model.Prenotazione;
import antoniogiovanni.marchese.U5W1L5.model.Utente;
import antoniogiovanni.marchese.U5W1L5.repository.PrenotazioneRepository;
import antoniogiovanni.marchese.U5W1L5.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public List<Utente> getAll(){
        return utenteRepository.findAll();
    }

    public Utente findById(long id){
        Optional<Utente> found = utenteRepository.findById(id);
        if(found.isEmpty()){
            return null;
        }
        return found.get();
    }

    public void create(Utente utente){
        utenteRepository.save(utente);
    }

    public Utente update(Utente utente,long id){
        Optional<Utente> found = utenteRepository.findById(id);
        if(found.isEmpty()){
            return null;
        }
        found.get().setEmail(utente.getEmail());
        found.get().setUsername(utente.getUsername());
        found.get().setNomeCompleto(utente.getNomeCompleto());
        utenteRepository.save(found.get());

        return found.get();
    }

    public boolean delete(long id){
        Optional<Utente> found = utenteRepository.findById(id);
        if(found.isEmpty()){
            return false;
        }
        utenteRepository.delete(found.get());
        return true;
    }
}
