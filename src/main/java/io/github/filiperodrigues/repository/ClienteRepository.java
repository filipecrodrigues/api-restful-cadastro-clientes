package io.github.filiperodrigues.repository;


import io.github.filiperodrigues.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Integer>{ //extendes do pacote JPA Repository (Tendo como parametros Cliente e sua chave primaria Integer)
}
