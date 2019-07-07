package arkham.knight.parcial2.repository;


import arkham.knight.parcial2.model.Componente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponenteRepository extends MongoRepository<Componente, String> {

    Componente findComponenteById(String id);
}
