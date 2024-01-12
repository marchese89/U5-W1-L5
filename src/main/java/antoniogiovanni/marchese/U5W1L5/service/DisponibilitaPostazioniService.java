package antoniogiovanni.marchese.U5W1L5.service;

import antoniogiovanni.marchese.U5W1L5.model.DisponibilitaPostazioni;
import antoniogiovanni.marchese.U5W1L5.model.Postazione;
import antoniogiovanni.marchese.U5W1L5.repository.DisponibilitaPostazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DisponibilitaPostazioniService {
    @Autowired
    private DisponibilitaPostazioniRepository disponibilitaPostazioniRepository;

    public List<DisponibilitaPostazioni> getAll(){
        return disponibilitaPostazioniRepository.findAll();
    }

    public DisponibilitaPostazioni findById(long id){
        Optional<DisponibilitaPostazioni> found = disponibilitaPostazioniRepository.findById(id);
        if(found.isEmpty()){
            return null;
        }
        return found.get();
    }

    public void create(DisponibilitaPostazioni disponibilitaPostazioni){
        disponibilitaPostazioniRepository.save(disponibilitaPostazioni);
    }

    public DisponibilitaPostazioni update(DisponibilitaPostazioni disponibilitaPostazioni,long id){
        Optional<DisponibilitaPostazioni> found = disponibilitaPostazioniRepository.findById(id);
        if(found.isEmpty()){
            return null;
        }
        found.get().setData(disponibilitaPostazioni.getData());
        found.get().setLibera(disponibilitaPostazioni.getLibera());
        found.get().setPostazione(disponibilitaPostazioni.getPostazione());
        disponibilitaPostazioniRepository.save(found.get());

        return found.get();
    }

    public boolean delete(long id){
        Optional<DisponibilitaPostazioni> found = disponibilitaPostazioniRepository.findById(id);
        if(found.isEmpty()){
            return false;
        }
        disponibilitaPostazioniRepository.delete(found.get());
        return true;
    }

    public boolean postazioneDisponibilePerData(Postazione postazione, LocalDate data){
        return disponibilitaPostazioniRepository.postazioneDisponibilePerData(postazione,data).size() > 0;
    }
}
