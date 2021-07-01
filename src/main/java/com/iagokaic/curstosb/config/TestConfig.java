package com.iagokaic.curstosb.config;

import com.iagokaic.curstosb.entidades.*;
import com.iagokaic.curstosb.entidades.enums.StatusPedido;
import com.iagokaic.curstosb.repositorios.*;
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

    @Autowired
    private RepositorioCategoria repositorioCategoria;

    @Autowired
    private RepositorioProduto repositorioProduto;

    @Autowired
    private RepositorioItemPedido repositorioItemPedido;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Electronics");
        Categoria cat2 = new Categoria(null, "Books");
        Categoria cat3 = new Categoria(null, "Computers");

        Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        repositorioCategoria.saveAll(Arrays.asList(cat1, cat2, cat3));
        repositorioProduto.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategorias().add(cat2);
        p2.getCategorias().add(cat1);
        p2.getCategorias().add(cat3);
        p3.getCategorias().add(cat3);
        p4.getCategorias().add(cat3);
        p5.getCategorias().add(cat2);

        repositorioProduto.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Pedido ped1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.PAGO, u1);
        Pedido ped2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u2);
        Pedido ped3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u1);

        repositorioUsuario.saveAll(Arrays.asList(u1, u2));
        repositorioPedido.saveAll(Arrays.asList(ped1, ped2, ped3));

        ItemPedido ip1 = new ItemPedido(ped1, p1, 2, p1.getPreco());
        ItemPedido ip2 = new ItemPedido(ped1, p3, 1, p3.getPreco());
        ItemPedido ip3 = new ItemPedido(ped2, p3, 2, p3.getPreco());
        ItemPedido ip4 = new ItemPedido(ped3, p5, 2, p5.getPreco());

        repositorioItemPedido.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));

        Pagamento pay1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), ped1);
        ped1.setPagamento(pay1);

        repositorioPedido.save(ped1);
    }
}
