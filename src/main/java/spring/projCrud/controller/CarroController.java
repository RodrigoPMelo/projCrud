package spring.projCrud.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.projCrud.domain.Carro;
import spring.projCrud.repositor.CarroRepository;

@RestController
@RequestMapping("/{id_estacionamento}")
public class CarroController {
    
    @Autowired
    private CarroRepository carroRepository;

    @GetMapping("/carros/{id}")
    public ResponseEntity<Carro> getCarro(@PathVariable("id") Integer id) {
        Carro carro = carroRepository.getCarro(id);
        if (carro == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(carro, HttpStatus.OK);
    }

    @GetMapping("/carros")
    public ResponseEntity<List<Carro>> getListCarro(String filtro) {
        List<Carro> carros = new ArrayList<>();
        if (filtro == null) {
            carroRepository.findAll().forEach(carros::add);
        } else {
            carroRepository.findAllWithFilter(filtro);
        }

        if (carros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(carros, HttpStatus.OK);
    }

    @PostMapping("/carros")
    public ResponseEntity<Carro> createCarro(@RequestBody Carro carroInput, @PathVariable("id_estacionamento") Integer id_estacionamento) {
        Carro carro = carroRepository.save(new Carro(carroInput, id_estacionamento));
        return new ResponseEntity<>(carro, HttpStatus.CREATED);
    }

    @PutMapping("/carros/{id}")
    public ResponseEntity<Carro> updateCarro(@PathVariable("id") Integer id, @RequestBody Carro carroInput) {
        Carro carro = carroRepository.getCarro(id);
        carro.update(carroInput);
        return new ResponseEntity<>(carroRepository.save(carro), HttpStatus.OK);
    }

    @DeleteMapping("/carros/{id}")
    public ResponseEntity<HttpStatus> deleteCarro(@PathVariable("id") Integer id) {
        carroRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
