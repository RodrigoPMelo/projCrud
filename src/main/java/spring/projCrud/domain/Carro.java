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
@Table(name = "carro")
public class Carro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carro", nullable = false)
    private Integer id;
    @Column(name = "modelo_carro", nullable = false)
    private String modelo;
    @Column(name = "id_estacionamento", nullable = false)
    private Integer id_estacionamento;
    @Column(name = "ano_carro", nullable = false)
    private String ano;
    @Column(name = "preco_carro", nullable = false)
    private Double preco;
    @Column(name = "marca_carro", nullable = false)
    private String marca;
    @Column(name = "kilometragem_carro", nullable = false)
    private Integer kilometragem;

    public Carro(Carro carro, Integer estacionamento_id) {
        id = carro.id;
        ano = carro.ano;
        kilometragem = carro.kilometragem;
        marca = carro.marca;
        modelo = carro.modelo;
        preco = carro.preco;
        id_estacionamento = estacionamento_id;
    }


    public void update(Carro carro) {
        ano = carro.ano;
        kilometragem = carro.kilometragem;
        marca = carro.marca;
        modelo = carro.modelo;
        preco = carro.preco;
    }

}
