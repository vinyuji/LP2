package ifmt.cba.consultas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ListarVendas {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VendasTwo");
        EntityManager em = emf.createEntityManager();

        try {
            List<Object[]> resultados = em.createQuery(
                "SELECT v.id, v.dataVenda, SUM(iv.quantidade * iv.precoVenda * (1 - iv.perDesconto / 100)), iv.id, iv.quantidade, iv.precoVenda, iv.perDesconto " +
                "FROM Venda v " +
                "JOIN v.itensVenda iv " +
                "GROUP BY v.id, iv.id " +
                "ORDER BY v.dataVenda DESC", Object[].class
            ).getResultList();

            for (Object[] row : resultados) {
                int idVenda = (int) row[0];
                java.sql.Date sqlDate = (java.sql.Date) row[1];
                java.util.Date dataVenda = new java.util.Date(sqlDate.getTime()); 
                double valorTotalVenda = (double) row[2];
                int idItemVenda = (int) row[3];
                int quantidade = (int) row[4];
                double precoVenda = (double) row[5];
                double perDesconto = (double) row[6];

                System.out.println("Venda: " + idVenda + " - Data: " + dataVenda + " - Total: R$" + valorTotalVenda);
                System.out.println("  Item: " + idItemVenda + " - Quantidade: " + quantidade + " - Preço Unitário: R$" + precoVenda + " - Desconto: " + perDesconto + "%");
                System.out.println("--------------------------------------------------");
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
