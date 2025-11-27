package io.github.filiperodrigues.controller;

import io.github.filiperodrigues.entity.Cliente;
import io.github.filiperodrigues.repository.ClienteRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    //construtor de classes mais anotation autowired para injeção de dependencias
    @Autowired
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    //metodo post salvar cliente
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar novo cliente")
    public Cliente salvar(@RequestBody @Valid Cliente cliente){
        return repository.save(cliente);

    }
    //metodo get buscar cliente
    @GetMapping("{id}")
    @Operation(summary = "Buscar cliente por id")
    public Cliente buscarPorId(@PathVariable Integer id){
        return repository
                .findById(id) // se encontrar ele retorna o cliente
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")); //caso contrario retorna a exception
    }

    //metodo delete - deletar cliente
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //código de sucesso não tem retorno
    @Operation(summary = "Deletar cliente por id")
    public void deletar(@PathVariable Integer id){
        repository
        .findById(id) // se encontrar ele retorna o cliente
                .map(cliente -> { repository.delete(cliente);
                return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)); //caso contrario retorna a exception

    }
    //metodo atualizar -  clientes
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Atualizar dados do cliente por id")
    public void atualizar(@PathVariable Integer id, @RequestBody @Valid Cliente clienteAtualizado){
        repository
        .findById(id) // se encontrar ele retorna o cliente
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setCpf(clienteAtualizado.getCpf());
                    return repository.save(cliente);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")); //caso contrario retorna a exception

    }
}
