package ifmt.cba.apps;

import java.text.SimpleDateFormat;

import ifmt.cba.util.*;
import ifmt.cba.vo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersistenceAPP {
    
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            // Criando e persistindo GrupoProduto  
            GrupoProduto grupo1 = new GrupoProduto();
            grupo1.setName("Sementes");

            GrupoProduto grupo2 = new GrupoProduto();
            grupo2.setName("legumes");

            GrupoProduto grupo3 = new GrupoProduto();
            grupo3.setName("massas");

            em.persist(grupo1);
            em.persist(grupo2);
            em.persist(grupo3);

            // Criando e persistindo Fornecedor

            Fornecedor fornecedor1 = new Fornecedor();
            fornecedor1.setName("VinyciusLegumesLTDA");
            fornecedor1.setNameFantasia("VinyciusLegumes");
            fornecedor1.setRazaoSocial("alimentar as pessoas");
            fornecedor1.setProdutos(null);
            
            Fornecedor fornecedor2 = new Fornecedor();
            fornecedor2.setName("VinyciusMassasLTDA");
            fornecedor2.setNameFantasia("VinyciusMassas");
            fornecedor2.setRazaoSocial("alimentar as pessoas");
            fornecedor2.setProdutos(null);
    
            Fornecedor fornecedor3 = new Fornecedor();
            fornecedor3.setName("VinyciusSementesLTDA");
            fornecedor3.setNameFantasia("VinyciusSementes");
            fornecedor3.setRazaoSocial("alimentar as pessoas");
            fornecedor3.setProdutos(null);
                
            em.persist(fornecedor3);
            em.persist(fornecedor1);
            em.persist(fornecedor2);

            // Criando e persistindo Produto
            Produto produto1 = new Produto();
            produto1.setName("arroz");
            produto1.setPreco(10.00);
            produto1.setGrupoProduto(grupo1);
            produto1.setFornecedor(fornecedor3);
        
            Produto produto2 = new Produto();
            produto2.setName("Cenora");
            produto2.setPreco(5.00);
            produto2.setGrupoProduto(grupo2);
            produto2.setFornecedor(fornecedor1);
            
            Produto produto3 = new Produto();
            produto3.setName("Macarrao");
            produto3.setPreco(11.00);
            produto3.setGrupoProduto(grupo3);
            produto3.setFornecedor(fornecedor2);

            em.persist(produto1);
            em.persist(produto2);
            em.persist(produto3);

            // criando e persistindo Item de Venda

            ItemVenda itemVenda1 = new ItemVenda();
            itemVenda1.setPerDesconto(0);
            itemVenda1.setPrecoVenda(10000);
            itemVenda1.setQuantidade(4);
            itemVenda1.setProdutos(produto1);

            ItemVenda itemVenda2 = new ItemVenda();
            itemVenda2.setPerDesconto(0);
            itemVenda2.setPrecoVenda(12000);
            itemVenda2.setQuantidade(2);
            itemVenda2.setProdutos(produto2);

            ItemVenda itemVenda3 = new ItemVenda();
            itemVenda3.setPerDesconto(0);
            itemVenda3.setPrecoVenda(4000);
            itemVenda3.setQuantidade(1);
            itemVenda3.setProdutos(produto3);

            ItemVenda itemVenda4 = new ItemVenda();
            itemVenda4.setPerDesconto(0);
            itemVenda4.setPrecoVenda(10000);
            itemVenda4.setQuantidade(4);
            itemVenda4.setProdutos(produto1);

            ItemVenda itemVenda5 = new ItemVenda();
            itemVenda5.setPerDesconto(0);
            itemVenda5.setPrecoVenda(10000);
            itemVenda5.setQuantidade(4);
            itemVenda5.setProdutos(produto2);


            // Criando e persistindo Cliente

            Cliente cliente1 = new Cliente();
            cliente1.setName("Vinycius");
            cliente1.setCpf("70527755141");
            cliente1.setlimiteCredito(1000);
            cliente1.setrg("10202020");
            cliente1.setVendas(null);

            Cliente cliente2 = new Cliente();
            cliente2.setName("Vinycius2");
            cliente2.setCpf("70527755141");
            cliente2.setlimiteCredito(1000);
            cliente2.setrg("10239393");
            cliente2.setVendas(null);

            Cliente cliente3 = new Cliente();
            cliente3.setName("Vinycius2");
            cliente3.setCpf("70527755141");
            cliente3.setlimiteCredito(1000);
            cliente3.setrg("10348348");
            cliente3.setVendas(null);

            em.persist(cliente3);
            em.persist(cliente2);
            em.persist(cliente1);

            // Criando e persistindo vendedor
            
            Vendedor vendedor1 = new Vendedor();
            vendedor1.setName("vinycius4");
            vendedor1.setCpf("1231234324"); 
            vendedor1.setPerComissao(5);
            vendedor1.setrg("123123123");
            vendedor1.setVenda(null);

            Vendedor vendedor2 = new Vendedor();
            vendedor2.setName("vinycius5");
            vendedor2.setCpf("345345345345"); 
            vendedor2.setPerComissao(5);
            vendedor2.setrg("3434343434");
            vendedor2.setVenda(null);

            Vendedor vendedor3 = new Vendedor();
            vendedor3.setName("vinycius6");
            vendedor3.setCpf("576567567567"); 
            vendedor3.setPerComissao(5);
            vendedor3.setrg("656565656");
            vendedor3.setVenda(null);

            em.persist(vendedor1);
            em.persist(vendedor2);
            em.persist(vendedor3);


            // criando e persistindo Venda

            Venda venda1 = new Venda();
            venda1.setCliente(cliente1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dataVendaUtil = sdf.parse("2025-02-02");
            java.sql.Date dataVendaSql = new java.sql.Date(dataVendaUtil.getTime());
            venda1.setDataVenda(dataVendaSql);
            venda1.setVendas(null);
            venda1.setVendedor(vendedor1);

            Venda venda2 = new Venda();
            venda2.setCliente(cliente1);
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dataVendaUtil2 = sdf2.parse("2025-02-02");
            java.sql.Date dataVendaSql2 = new java.sql.Date(dataVendaUtil2.getTime());
            venda2.setDataVenda(dataVendaSql2);
            venda2.setVendas(null);
            venda2.setVendedor(vendedor2);

            Venda venda3 = new Venda();
            venda3.setCliente(cliente1);
            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dataVendaUtil3 = sdf3.parse("2025-02-02");
            java.sql.Date dataVendaSql3 = new java.sql.Date(dataVendaUtil3.getTime());
            venda3.setDataVenda(dataVendaSql3);
            venda3.setVendas(null);
            venda3.setVendedor(vendedor3);


            Venda venda4 = new Venda();
            venda4.setCliente(cliente1);
            SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dataVendaUtil4 = sdf4.parse("2025-02-02");
            java.sql.Date dataVendaSql4 = new java.sql.Date(dataVendaUtil4.getTime());
            venda4.setDataVenda(dataVendaSql4);
            venda4.setVendas(null);
            venda4.setVendedor(vendedor1);


            Venda venda5 = new Venda();
            venda5.setCliente(cliente1);
            SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dataVendaUtil5 = sdf5.parse("2025-02-02");
            java.sql.Date dataVendaSql5 = new java.sql.Date(dataVendaUtil5.getTime());
            venda5.setDataVenda(dataVendaSql5);
            venda5.setVendas(null);
            venda5.setVendedor(vendedor2);

















            
        } catch (Exception e) {

        }
    }
}
