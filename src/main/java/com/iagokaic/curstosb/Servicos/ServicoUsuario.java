package com.iagokaic.curstosb.Servicos;

import com.iagokaic.curstosb.Repositorios.UsuarioRepositorio;
import com.iagokaic.curstosb.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoUsuario {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> findAll() {
        return usuarioRepositorio.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = usuarioRepositorio.findById(id);
        return obj.get();
    }
}
