package io.github.filiperodrigues.model.entity;


import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;



@Entity
@Data /* cria getters e setters conctrutor padrão e o construtor com parametros*/
@NoArgsConstructor //manter um construtor vazio
@AllArgsConstructor //gerar construtor com todos argumentos
@Builder //gera um builder de cliente
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)/* para o banco incrementar o ID de forma automatica*/
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private  String nome;

    @Column(nullable = false, length = 11)
    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @Column(name = "data_cadastro", updatable = false)
    private LocalDate dataCadastro;

    /*Getters e seters criados com o loobok*/
}
