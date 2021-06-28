package com.iagokaic.curstosb.Servicos;

import com.iagokaic.curstosb.Repositorios.RepositorioUsuario;
import com.iagokaic.curstosb.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return obj.get();
    }
}
