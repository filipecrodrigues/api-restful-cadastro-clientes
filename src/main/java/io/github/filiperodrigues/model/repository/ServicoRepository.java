package io.github.filiperodrigues.model.repository;

import io.github.filiperodrigues.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
