
package controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CarroService;
import spring.projCrud.domain.Carro;

@RestController
@RequestMapping("/carros")
public class CarroController {
    private final CarroService _carroService;

    public CarroController(CarroService carroService) {
        this._carroService = carroService;
    }
    
    @GetMapping(path= "/{id}")
   
    public Carro getCarro(@PathVariable("id") Integer id){
        return _carroService.getCarro(id);
    }
    @GetMapping
    public List<Carro> getCarros() {
        return _carroService.getCarrosList();
    }
    @PutMapping(path= {"/{id}"})
    public Carro updateCarro(@PathVariable("id") Integer id){
        return _carroService.updateCarro(id);
    }
    @PostMapping
    public void createCarro(@RequestBody Carro input){
        _carroService.createCarro(input);
    }
    @DeleteMapping(path= {"/{id}"})
    public void deleteCarro(@PathVariable("id") Integer id){
        _carroService.deleteCarro(id);
    }
    
}
