package com.iagokaic.curstosb.repositorios;

import com.iagokaic.curstosb.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProduto extends JpaRepository<Produto, Long> {


}
