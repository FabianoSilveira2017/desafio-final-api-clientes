package com.example.api.service;

import com.example.api.model.Cliente;
import com.example.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }
    public List<Cliente> buscarPorNome(String nome) {
        return clienteRepository.findByNome(nome);
    }
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
    public long contarClientes() {
        return clienteRepository.count();
    }
    public Optional<Cliente> atualizar(Long id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id) // Busca o cliente existente
                .map(clienteExistente -> {
                    // Atualiza os campos do cliente existente com os dados fornecidos
                    clienteExistente.setNome(clienteAtualizado.getNome());
                    clienteExistente.setEmail(clienteAtualizado.getEmail());
                    // Atualize outros campos conforme necessário
                    return clienteRepository.save(clienteExistente); // Salva e retorna o cliente atualizado
                });
    }
}
