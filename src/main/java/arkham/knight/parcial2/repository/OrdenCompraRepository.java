package arkham.knight.parcial2.repository;

import arkham.knight.parcial2.model.OrdenCompra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenCompraRepository extends MongoRepository<OrdenCompra, String> {
    OrdenCompra findOrdenCompraById(String id);
}
