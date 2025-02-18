package ifmt.cba.apps;

import ifmt.cba.vo.*;
import java.text.SimpleDateFormat;
import jakarta.persistence.*;

public class PersistenceAPP {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VendasTwo");
        if (emf == null) {
            System.out.println("EntityManagerFactory não foi criado!");
        }
        EntityManager em = emf.createEntityManager();
        if (em == null) {
            System.out.println("EntityManager não foi criado!");
        }

        try {
            em.getTransaction().begin();

            // Criando e persistindo 5 GrupoProduto
            GrupoProduto grupo1 = new GrupoProduto();
            grupo1.setNome("Frutas");
            GrupoProduto grupo2 = new GrupoProduto();
            grupo2.setNome("Bebidas");
            GrupoProduto grupo3 = new GrupoProduto();
            grupo3.setNome("Doces");
            GrupoProduto grupo4 = new GrupoProduto();
            grupo4.setNome("Eletrônicos");
            GrupoProduto grupo5 = new GrupoProduto();
            grupo5.setNome("Roupas");

            em.persist(grupo1);
            em.persist(grupo2);
            em.persist(grupo3);
            em.persist(grupo4);
            em.persist(grupo5);

            // Criando e persistindo 5 Fornecedores
            Fornecedor fornecedor1 = new Fornecedor();
            fornecedor1.setRazaoSocial("Fornecimento de frutas frescas");
            fornecedor1.setNome("SuperFrutas");
            fornecedor1.setNomeFantasia("SuperFrutas");
            fornecedor1.setCnpj("10101010101010");
    
            Fornecedor fornecedor2 = new Fornecedor();
            fornecedor2.setRazaoSocial("Distribuidor de bebidas");
            fornecedor2.setNome("BebidasDoBrasil");
            fornecedor2.setNomeFantasia("BebidasDoBrasil");
            fornecedor2.setCnpj("11111111111111");
    
            Fornecedor fornecedor3 = new Fornecedor();
            fornecedor3.setRazaoSocial("Doces e confeitos de alta qualidade");
            fornecedor3.setNome("DeliciasDoces");
            fornecedor3.setNomeFantasia("DeliciasDoces");
            fornecedor3.setCnpj("121212121212");
            

            Fornecedor fornecedor4 = new Fornecedor();
            fornecedor4.setRazaoSocial("Eletrônicos em promoção");
            fornecedor4.setNome("TechWorld");
            fornecedor4.setNomeFantasia("TechWorld");
            fornecedor4.setCnpj("131313131313");

            Fornecedor fornecedor5 = new Fornecedor();
            fornecedor5.setRazaoSocial("Roupas para todos os gostos");
            fornecedor5.setNome("Moda & Estilo");
            fornecedor5.setNomeFantasia("ModaEstilo");
            fornecedor5.setCnpj("141414141414");
    
            em.persist(fornecedor1);
            em.persist(fornecedor2);
            em.persist(fornecedor3);
            em.persist(fornecedor4);
            em.persist(fornecedor5);

            // Criando e persistindo 5 Produtos
            Produto produto1 = new Produto();
            produto1.setName("Maçã");
            produto1.setPreco(3.5);
            produto1.setGrupoProduto(grupo1);
            produto1.setFornecedor(fornecedor1);

            Produto produto2 = new Produto();
            produto2.setName("Refrigerante");
            produto2.setPreco(5.0);
            produto2.setGrupoProduto(grupo2);
            produto2.setFornecedor(fornecedor2);

            Produto produto3 = new Produto();
            produto3.setName("Chocolate");
            produto3.setPreco(7.2);
            produto3.setGrupoProduto(grupo3);
            produto3.setFornecedor(fornecedor3);

            Produto produto4 = new Produto();
            produto4.setName("Celular");
            produto4.setPreco(1200.0);
            produto4.setGrupoProduto(grupo4);
            produto4.setFornecedor(fornecedor4);

            Produto produto5 = new Produto();
            produto5.setName("Camiseta");
            produto5.setPreco(35.0);
            produto5.setGrupoProduto(grupo5);
            produto5.setFornecedor(fornecedor5);

            em.persist(produto1);
            em.persist(produto2);
            em.persist(produto3);
            em.persist(produto4);
            em.persist(produto5);

            // Criando e persistindo 5 Clientes
            Cliente cliente1 = new Cliente();
            cliente1.setNome("Ana Silva");
            cliente1.setCpf("12345678901");
            cliente1.setlimiteCredito(1500);
            cliente1.setrg("123456789");

            Cliente cliente2 = new Cliente();
            cliente2.setNome("Carlos Oliveira");
            cliente2.setCpf("10987654321");
            cliente2.setlimiteCredito(1200);
            cliente2.setrg("987654321");

            Cliente cliente3 = new Cliente();
            cliente3.setNome("Juliana Souza");
            cliente3.setCpf("11122334455");
            cliente3.setlimiteCredito(800);
            cliente3.setrg("112233445");

            Cliente cliente4 = new Cliente();
            cliente4.setNome("Roberto Lima");
            cliente4.setCpf("11122334455");
            cliente4.setlimiteCredito(800);
            cliente4.setrg("112233445");

            Cliente cliente5 = new Cliente();
            cliente5.setNome("Maria Santos");
            cliente5.setNome("Ana Souza");
            cliente5.setCpf("10987654321");
            cliente5.setlimiteCredito(1200);
            cliente5.setrg("987654321");

            em.persist(cliente1);
            em.persist(cliente2);
            em.persist(cliente3);
            em.persist(cliente4);
            em.persist(cliente5);

            // Criando e persistindo vendedor

            Vendedor vendedor1 = new Vendedor();
            vendedor1.setNome("Paulo Costa");
            vendedor1.setCpf("222333444");
            vendedor1.setPerComissao(8);
            vendedor1.setrg("123123123");

            Vendedor vendedor2 = new Vendedor();
            vendedor2.setNome("Julia Mendes");
            vendedor2.setCpf("333444555");
            vendedor2.setPerComissao(6);
            vendedor2.setrg("223344556");

            Vendedor vendedor3 = new Vendedor();
            vendedor3.setNome("Felipe Pereira");
            vendedor3.setCpf("444555666");
            vendedor3.setPerComissao(7);
            vendedor3.setrg("334455667");

            em.persist(vendedor1);
            em.persist(vendedor2);
            em.persist(vendedor3);

             // criando e persistindo Item de Venda

             ItemVenda itemVenda1 = new ItemVenda();
             itemVenda1.setPerDesconto(5);
             itemVenda1.setPrecoVenda(50);
             itemVenda1.setQuantidade(3);
             itemVenda1.setProdutos(produto1);
 
             ItemVenda itemVenda2 = new ItemVenda();
             itemVenda2.setPerDesconto(0);
             itemVenda2.setPrecoVenda(70);
             itemVenda2.setQuantidade(5);
             itemVenda2.setProdutos(produto2);
 
             ItemVenda itemVenda3 = new ItemVenda();
             itemVenda3.setPerDesconto(10);
             itemVenda3.setPrecoVenda(35);
             itemVenda3.setQuantidade(4);
             itemVenda3.setProdutos(produto3);
 
             em.persist(itemVenda1);
             em.persist(itemVenda2);
             em.persist(itemVenda3);

             // criando e persistindo Venda

            Venda venda1 = new Venda();
            venda1.setCliente(cliente1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dataVendaUtil = sdf.parse("2025-05-02");
            java.sql.Date dataVendaSql = new java.sql.Date(dataVendaUtil.getTime());
            venda1.setDataVenda(dataVendaSql);
            venda1.setVendedor(vendedor1);

            Venda venda2 = new Venda();
            venda2.setCliente(cliente1);
            java.util.Date dataVendaUtil2 = sdf.parse("2025-05-05");
            java.sql.Date dataVendaSql2 = new java.sql.Date(dataVendaUtil2.getTime());
            venda2.setDataVenda(dataVendaSql2);
            venda2.setVendedor(vendedor2);

            Venda venda3 = new Venda();
            venda3.setCliente(cliente2);
            java.util.Date dataVendaUtil3 = sdf.parse("2025-05-07");
            java.sql.Date dataVendaSql3 = new java.sql.Date(dataVendaUtil3.getTime());
            venda3.setDataVenda(dataVendaSql3);
            venda3.setVendedor(vendedor3);

            venda1.getItemVendas().add(itemVenda1);
            venda2.getItemVendas().add(itemVenda2);
            venda3.getItemVendas().add(itemVenda3);

            em.persist(venda1);
            em.persist(venda2);
            em.persist(venda3);

            // Estabelecendo as relações

            vendedor1.getVenda().add(venda1);
            vendedor2.getVenda().add(venda2);
            vendedor3.getVenda().add(venda3);

            cliente1.getVendas().add(venda1);
            cliente1.getVendas().add(venda2);
            cliente2.getVendas().add(venda3);

            em.merge(vendedor1);
            em.merge(vendedor2);
            em.merge(vendedor3);

            em.merge(cliente1);
            em.merge(cliente2);
            em.merge(cliente3);

            // Comitando a transação
            em.getTransaction().commit();
            System.out.println("Dados persistidos com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
