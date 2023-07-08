package estudo.jpa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "estoque")
public class Estoque {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tabela")
    @TableGenerator(name = "tabela", table = "hebernate_seequences",
                    pkColumnName = "sequence_name",
                    pkColumnValue = "estoque",
                    valueColumnName = "next_val",
                    initialValue = 0,
                    allocationSize = 50)
    private Integer id;

    @Column(name = "produto_id")
    private Integer produtoId;

    private Integer quatidade;
}
