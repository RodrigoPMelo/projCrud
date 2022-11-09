
package repositor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.projCrud.domain.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer>{
   
}
