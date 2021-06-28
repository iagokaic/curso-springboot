package com.iagokaic.curstosb.servicos;

import com.iagokaic.curstosb.repositorios.RepositorioPedido;
import com.iagokaic.curstosb.entidades.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoPedido {

    @Autowired
    private RepositorioPedido repositorioPedido;

    public List<Pedido> findAll() {
        return repositorioPedido.findAll();
    }

    public Pedido findById(Long id) {
        Optional<Pedido> obj = repositorioPedido.findById(id);
        return obj.get();
    }
}
