package arkham.knight.parcial2.services;

import arkham.knight.parcial2.model.MovimientoInventario;
import arkham.knight.parcial2.repository.MovimientoInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoInventarioService {

    @Autowired
    private MovimientoInventarioRepository movimientoInventarioRepository;


    public void createMovimientoInventario(MovimientoInventario movimientoInventario){

        movimientoInventarioRepository.save(movimientoInventario);
    }

    public List<MovimientoInventario> listarMovimientoInventario(){

        return movimientoInventarioRepository.findAll();
    }


    public void deleteMovimientoInventario(MovimientoInventario movimientoInventario){

        movimientoInventarioRepository.delete(movimientoInventario);
    }

    public void deleteAllMovimientos(){

        movimientoInventarioRepository.deleteAll();
    }

}
