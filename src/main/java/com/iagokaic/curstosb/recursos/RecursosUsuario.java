package com.iagokaic.curstosb.recursos;

import com.iagokaic.curstosb.entidades.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursosUsuario {

    @GetMapping
    public ResponseEntity<Usuario> findAll() {
        Usuario u = new Usuario(1L, "Iago", "iago@gmail.com", "95984052000", "senha");
        return ResponseEntity.ok().body(u);
    }
}
