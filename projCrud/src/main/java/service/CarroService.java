
package service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import repositor.CarroRepository;
import spring.projCrud.domain.Carro;

@Service
public class CarroService {
    private final CarroRepository _carroRepo;

    public CarroService(CarroRepository carroRepository) {
        this._carroRepo = carroRepository;
    }
    public Optional<Carro> getCarro(Integer id){
        return _carroRepo.findById(id);
    }
    public List<Carro> getCarrosList(){
        return _carroRepo.findAll();
    }
    public Carro updateCarro(Integer id){
        
        return null;
        
    }
    public void createCarro(Carro input){
        _carroRepo.save(input);
    }
    public void deleteCarro(Integer id){
        _carroRepo.deleteById(id);
    }
   
}
