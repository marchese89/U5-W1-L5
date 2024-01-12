package antoniogiovanni.marchese.U5W1L5.service;

import antoniogiovanni.marchese.U5W1L5.model.Edificio;
import antoniogiovanni.marchese.U5W1L5.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public List<Edificio> getAll(){
        return edificioRepository.findAll();
    }

    public Edificio findById(long id){
        Optional<Edificio> found = edificioRepository.findById(id);
        if(found.isEmpty()){
            return null;
        }
        return found.get();
    }

    public void create(Edificio edificio){
        edificioRepository.save(edificio);
    }

    public Edificio update(Edificio edificio,long id){
        Optional<Edificio> found = edificioRepository.findById(id);
        if(found.isEmpty()){
            return null;
        }
        found.get().setNome(edificio.getNome());
        found.get().setCitta(edificio.getCitta());
        found.get().setIndirizzo(edificio.getIndirizzo());
        edificioRepository.save(found.get());

        return found.get();
    }

    public boolean delete(long id){
        Optional<Edificio> found = edificioRepository.findById(id);
        if(found.isEmpty()){
            return false;
        }
        edificioRepository.delete(found.get());
        return true;
    }
}
