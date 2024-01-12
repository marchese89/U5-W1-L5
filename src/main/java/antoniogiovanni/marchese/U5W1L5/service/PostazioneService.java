package antoniogiovanni.marchese.U5W1L5.service;

import antoniogiovanni.marchese.U5W1L5.model.Postazione;
import antoniogiovanni.marchese.U5W1L5.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> getAll(){
        return postazioneRepository.findAll();
    }

    public Postazione findById(long id){
        Optional<Postazione> found = postazioneRepository.findById(id);
        if(found.isEmpty()){
            return null;
        }
        return found.get();
    }

    public void create(Postazione edificio){
        postazioneRepository.save(edificio);
    }

    public Postazione update(Postazione postazione,long id){
        Optional<Postazione> found = postazioneRepository.findById(id);
        if(found.isEmpty()){
            return null;
        }
        found.get().setDescrizione(postazione.getDescrizione());
        found.get().setEdificio(postazione.getEdificio());
        found.get().setTipoPostazione(postazione.getTipoPostazione());
        found.get().setMaxOccupanti(postazione.getMaxOccupanti());
        postazioneRepository.save(found.get());

        return found.get();
    }

    public boolean delete(long id){
        Optional<Postazione> found = postazioneRepository.findById(id);
        if(found.isEmpty()){
            return false;
        }
        postazioneRepository.delete(found.get());
        return true;
    }
}
