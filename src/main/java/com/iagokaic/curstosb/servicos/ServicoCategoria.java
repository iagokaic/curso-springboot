package com.iagokaic.curstosb.servicos;

import com.iagokaic.curstosb.entidades.Categoria;
import com.iagokaic.curstosb.repositorios.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoCategoria {

    @Autowired
    private RepositorioCategoria repositorioCategoria;

    public List<Categoria> findAll() {
        return repositorioCategoria.findAll();
    }

    public Categoria findById(Long id) {
        Optional<Categoria> obj = repositorioCategoria.findById(id);
        return obj.get();
    }
}
