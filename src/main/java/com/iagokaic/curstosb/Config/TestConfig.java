package com.iagokaic.curstosb.Config;

import com.iagokaic.curstosb.Repositorios.RepositorioPedido;
import com.iagokaic.curstosb.Repositorios.RepositorioUsuario;
import com.iagokaic.curstosb.entidades.Pedido;
import com.iagokaic.curstosb.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private RepositorioPedido repositorioPedido;

    @Override
    public void run(String... args) throws Exception {
        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        repositorioUsuario.saveAll(Arrays.asList(u1, u2));
        repositorioPedido.saveAll(Arrays.asList(o1, o2, o3));
    }
}
