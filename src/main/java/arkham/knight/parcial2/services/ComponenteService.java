package arkham.knight.parcial2.services;

//Estos son los import necesarios para utilizar aggregate y deben de ser importados como static
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import arkham.knight.parcial2.model.Componente;
import arkham.knight.parcial2.repository.ComponenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponenteService {

    //Este Autowired es necesario para poder trabajar los aggregate en
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ComponenteRepository componenteRepository;

    public List<Componente> getComponenteByAggregation(){

        Aggregation aggregation = newAggregation(match(Criteria.where("stock").gt(10)));

        //Convert the aggregation result into a List
        AggregationResults<Componente> groupResults
                = mongoTemplate.aggregate(aggregation, Componente.class, Componente.class);
        List<Componente> result = groupResults.getMappedResults();

        return result;

    }

    public void createComponent(Componente componente){

        componenteRepository.save(componente);
    }

    public List<Componente> listarComponentes(){

        return componenteRepository.findAll();
    }

    public Componente findComponenteById(String id){

        return componenteRepository.findComponenteById(id);
    }


    public void deleteComponent(Componente componente){

        componenteRepository.delete(componente);
    }


    public void deleteAllComponents(){

        componenteRepository.deleteAll();
    }


}
