package com.iagokaic.curstosb.Repositorios;

import com.iagokaic.curstosb.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {


}
