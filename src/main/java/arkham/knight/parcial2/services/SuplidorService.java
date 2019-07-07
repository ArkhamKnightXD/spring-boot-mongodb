package arkham.knight.parcial2.services;

import arkham.knight.parcial2.repository.SuplidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuplidorService {

    @Autowired
    private SuplidorRepository suplidorRepository;
}
