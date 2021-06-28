package com.iagokaic.curstosb.recursos;

import com.iagokaic.curstosb.servicos.ServicoUsuario;
import com.iagokaic.curstosb.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursosUsuario {

    @Autowired
    private ServicoUsuario servico;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = servico.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario obj = servico.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
