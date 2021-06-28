package com.iagokaic.curstosb.Servicos;

import com.iagokaic.curstosb.Repositorios.RepositorioPedido;
import com.iagokaic.curstosb.entidades.Pedido;
import com.iagokaic.curstosb.entidades.Usuario;
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
