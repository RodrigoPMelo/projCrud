package spring.projCrud.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estacionamento")
public class Estacionamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estacionamento", nullable = false)
    private Integer id;
    @Column(name = "cnpj", nullable = false)
    private Integer cnpj;
    @Column(name = "nome_fantasia", nullable = false)
    private String nomeFantasia;
    @Column(name = "endereco", nullable = false)
    private String endereco;

    public Estacionamento(Estacionamento estacionamento) {
        id = estacionamento.id;
        cnpj = estacionamento.cnpj;
        nomeFantasia = estacionamento.nomeFantasia;
        endereco = estacionamento.endereco;
    }

}
