package io.github.filiperodrigues.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

//entidade responsável por guardar os serviços
@Entity
@Data /* cria getters e setters conctrutor padrão e o construtor com parametros*/
public class Servico {

    @Id //chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* para o banco incrementar o ID de forma automatica*/
    private Integer id;


    @Column(nullable = false, length = 150) // não pode ser nulo
    private String descricao;

    @ManyToOne   // Ou seja 1 para muitos, Muitos serviços para um cliente
    @JoinColumn(name = "id_cliente")  //para definir uma chave estrangeira
    private Cliente cliente;

    @Column
    private BigDecimal valor; //valor do serviço prestado

}
