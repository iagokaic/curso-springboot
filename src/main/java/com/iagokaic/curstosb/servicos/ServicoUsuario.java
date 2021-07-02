package com.iagokaic.curstosb.servicos;

import com.iagokaic.curstosb.repositorios.RepositorioUsuario;
import com.iagokaic.curstosb.entidades.Usuario;
import com.iagokaic.curstosb.servicos.exceptions.DatabaseException;
import com.iagokaic.curstosb.servicos.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public List<Usuario> findAll() {
        return repositorioUsuario.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = repositorioUsuario.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Usuario inserir(Usuario obj) {
        return repositorioUsuario.save(obj);
    }

    public void deletar(Long id) {
        try {
            repositorioUsuario.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }

    }

    public Usuario atualizar(Long id, Usuario obj) {
        try {
            Usuario entidade = repositorioUsuario.getById(id);
            atualizarDados(entidade, obj);
            return repositorioUsuario.save(entidade);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }

    }

    private void atualizarDados(Usuario entidade, Usuario obj) {
        entidade.setNome(obj.getNome());
        entidade.setEmail(obj.getEmail());
        entidade.setTelefone(obj.getTelefone());
    }
}
