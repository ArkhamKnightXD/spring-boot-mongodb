package arkham.knight.parcial2.services;

import arkham.knight.parcial2.model.Componente;
import arkham.knight.parcial2.repository.ComponenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponenteService {

    @Autowired
    private ComponenteRepository componenteRepository;

    public void createComponent(Componente componente){

        componenteRepository.save(componente);
    }

    public List<Componente> listarComponentes(){

        return componenteRepository.findAll();
    }

    public Componente findComponenteById(int id){

        return componenteRepository.findComponenteById(id);
    }


    public void deleteComponent(Componente componente){

        componenteRepository.delete(componente);
    }




}
