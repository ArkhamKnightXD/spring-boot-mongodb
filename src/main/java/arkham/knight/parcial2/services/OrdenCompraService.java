package arkham.knight.parcial2.services;

import arkham.knight.parcial2.model.OrdenCompra;
import arkham.knight.parcial2.repository.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;


    public void createOrdenCompra(OrdenCompra ordenCompra){

        ordenCompraRepository.save(ordenCompra);
    }

    public List<OrdenCompra> listarOrdenesDeCompra(){

        return ordenCompraRepository.findAll();
    }

    public OrdenCompra findOrdenCompraById(String id){

        return ordenCompraRepository.findOrdenCompraById(id);
    }


    public void deleteOrden(OrdenCompra ordenCompra){

        ordenCompraRepository.delete(ordenCompra);
    }

    public void deleteAllOrden(){

        ordenCompraRepository.deleteAll();
    }


}
