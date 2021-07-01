package com.iagokaic.curstosb.recursos;

import com.iagokaic.curstosb.entidades.Produto;
import com.iagokaic.curstosb.servicos.ServicoProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class RecursosProduto {

    @Autowired
    private ServicoProduto servico;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> list = servico.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Produto obj = servico.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
