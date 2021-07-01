package com.iagokaic.curstosb.servicos;

import com.iagokaic.curstosb.entidades.Produto;
import com.iagokaic.curstosb.repositorios.RepositorioProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoProduto {

    @Autowired
    private RepositorioProduto repositorioProduto;

    public List<Produto> findAll() {
        return repositorioProduto.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> obj = repositorioProduto.findById(id);
        return obj.get();
    }
}
