package ifmt.cba.consultas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ListarVendedores {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VendasTwo");
        EntityManager em = emf.createEntityManager();

        try {
            List<Object[]> resultados = em.createQuery(
                "SELECT v.id, v.nome, ve.id, ve.valorTotal, (ve.valorTotal * v.perComissao / 100) " +
                "FROM Vendedor v " +
                "LEFT JOIN v.vendas ve " +
                "ORDER BY v.nome", Object[].class
            ).getResultList();

        
            System.out.println("Lista de Vendedores e Vendas:");
            System.out.println("--------------------------------------------------");
            for (Object[] row : resultados) {
                int idVendedor = (int) row[0];
                String nomeVendedor = (String) row[1]; 
                int idVenda = (int) row[2]; 
                float valorTotalVenda = (float) row[3]; 
                float valorComissao = (float) row[4]; 

                System.out.println("Código Vendedor: " + idVendedor);
                System.out.println("Nome Vendedor: " + nomeVendedor);
                System.out.println("  Venda ID: " + idVenda);
                System.out.println("  Valor Total Venda: R$" + valorTotalVenda);
                System.out.println("  Valor Comissão: R$" + valorComissao);
                System.out.println("--------------------------------------------------");
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}