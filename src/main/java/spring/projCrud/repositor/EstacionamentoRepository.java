package spring.projCrud.repositor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.projCrud.domain.Estacionamento;

@Repository
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Integer>{
    @Query("select c from Estacionamento c where c.id = ?1")
    public Estacionamento getEstacionamento(Integer id);
}
