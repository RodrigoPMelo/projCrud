package spring.projCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.projCrud.domain.Estacionamento;
import spring.projCrud.repositor.EstacionamentoRepository;

@RestController
public class EstacionamentoController {
    
    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    @GetMapping("/estacionamento/{id}")
    public ResponseEntity<Estacionamento> getCarro(@PathVariable("id") Integer id) {
        Estacionamento estacionamento = estacionamentoRepository.getEstacionamento(id);
        if (estacionamento == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(estacionamento, HttpStatus.OK);
    }
     @PostMapping("/estacionamento")
    public ResponseEntity<Estacionamento> createCarro(@RequestBody Estacionamento estacionamentoInput) {
        Estacionamento estacionamento = estacionamentoRepository.save(new Estacionamento(estacionamentoInput));
        return new ResponseEntity<>(estacionamento, HttpStatus.CREATED);
    }
}
