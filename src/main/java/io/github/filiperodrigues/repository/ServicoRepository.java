package io.github.filiperodrigues.repository;

import io.github.filiperodrigues.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
