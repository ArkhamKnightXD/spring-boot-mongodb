package arkham.knight.parcial2.services;

import arkham.knight.parcial2.model.Suplidor;
import arkham.knight.parcial2.repository.SuplidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuplidorService {

    @Autowired
    private SuplidorRepository suplidorRepository;


    public List<Suplidor> listarSuplidores(){

        return suplidorRepository.findAll();
    }
}
