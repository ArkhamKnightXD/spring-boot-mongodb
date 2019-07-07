package arkham.knight.parcial2.repository;

import arkham.knight.parcial2.model.MovimientoInventario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoInventarioRepository extends MongoRepository<MovimientoInventario, String> {
}
