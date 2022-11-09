package spring.projCrud.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "carros")
public class Carro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carro_id")
    private Long idCarro;
    @ManyToOne
    @JoinColumn(name = "peca_id")
    private Peca peca;
    @Column(name = "nome")
    private String nome;
    @Column(name = "preco")
    private int preco;
    @Column(name = "marca")
    private String marca;
    @Column(name = "ano")
    private String anoFabricacao;

}
