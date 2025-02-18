package ifmt.cba.apps;

import java.text.SimpleDateFormat;

import ifmt.cba.vo.GrupoProduto;
import ifmt.cba.vo.*;

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
            
            // Criando e persistindo GrupoProduto  
            GrupoProduto grupo1 = new GrupoProduto();
            grupo1.setNome("Frutas");

            GrupoProduto grupo2 = new GrupoProduto();
            grupo2.setNome("Bebidas");

            GrupoProduto grupo3 = new GrupoProduto();
            grupo3.setNome("Doces");

            em.persist(grupo1);
            em.persist(grupo2);
            em.persist(grupo3);

            // Criando e persistindo Fornecedor

            Fornecedor fornecedor1 = new Fornecedor();
            fornecedor1.setNome("SuperFrutas");
            fornecedor1.setNomeFantasia("SuperFrutas");
            fornecedor1.setRazaoSocial("Fornecimento de frutas frescas");
    
            Fornecedor fornecedor2 = new Fornecedor();
            fornecedor2.setNome("BebidasDoBrasil");
            fornecedor2.setNomeFantasia("BebidasDoBrasil");
            fornecedor2.setRazaoSocial("Distribuidor de bebidas");
    
            Fornecedor fornecedor3 = new Fornecedor();
            fornecedor3.setNome("DeliciasDoces");
            fornecedor3.setNomeFantasia("DeliciasDoces");
            fornecedor3.setRazaoSocial("Doces e confeitos de alta qualidade");
                
            em.persist(fornecedor3);
            em.persist(fornecedor1);
            em.persist(fornecedor2);

            // Criando e persistindo Produto
            Produto produto1 = new Produto();
            produto1.setName("Maçã");
            produto1.setPreco(5.00);
            produto1.setGrupoProduto(grupo1);
            produto1.setFornecedor(fornecedor1);
        
            Produto produto2 = new Produto();
            produto2.setName("Refrigerante");
            produto2.setPreco(7.00);
            produto2.setGrupoProduto(grupo2);
            produto2.setFornecedor(fornecedor2);
            
            Produto produto3 = new Produto();
            produto3.setName("Chocolate");
            produto3.setPreco(3.50);
            produto3.setGrupoProduto(grupo3);
            produto3.setFornecedor(fornecedor3);

            em.persist(produto1);
            em.persist(produto2);
            em.persist(produto3);

            // Criando e persistindo Cliente

            Cliente cliente1 = new Cliente();
            cliente1.setNome("Carlos Silva");
            cliente1.setCpf("12345678901");
            cliente1.setlimiteCredito(1500);
            cliente1.setrg("123456789");

            Cliente cliente2 = new Cliente();
            cliente2.setNome("Ana Souza");
            cliente2.setCpf("10987654321");
            cliente2.setlimiteCredito(1200);
            cliente2.setrg("987654321");

            Cliente cliente3 = new Cliente();
            cliente3.setNome("João Oliveira");
            cliente3.setCpf("11122334455");
            cliente3.setlimiteCredito(800);
            cliente3.setrg("112233445");

            em.persist(cliente3);
            em.persist(cliente2);
            em.persist(cliente1);

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

            em.getTransaction().commit();
            
        } catch (Exception e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
