package spring.projCrud.repositor;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.projCrud.domain.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer>{
    
    @Query("select c from Carro c where c.id = ?1")
    public Carro getCarro(Integer id);
    
    @Query("SELECT p FROM Carro p WHERE CONCAT(p.ano, ' ', p.marca, ' ', p.modelo, ' ', p.id, ' ', p.preco) LIKE %?1%")
    public List<Carro> findAllWithFilter(String filtro);
}
