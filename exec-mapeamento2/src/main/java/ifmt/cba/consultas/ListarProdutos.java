package ifmt.cba.consultas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ListarProdutos {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VendasTwo");
        EntityManager em = emf.createEntityManager();
        
        try {
            List<Object[]> resultados = em.createQuery(
                "SELECT p.id, p.name, p.precoVenda, g.nome, f.id, f.razaoSocial " +
                "FROM Produto p " +
                "JOIN p.grupoProduto g " +
                "LEFT JOIN p.fornecedor f " +
                "ORDER BY p.name", Object[].class
            ).getResultList();

            for (Object[] row : resultados) {
                int idProduto = (int) row[0];
                String nomeProduto = (String) row[1];
                double precoVenda = (double) row[2];
                String nomeGrupo = (String) row[3];
                Integer idFornecedor = (row[4] != null) ? (int) row[4] : null;
                String razaoSocialFornecedor = (row[5] != null) ? (String) row[5] : "Sem Fornecedor";

                System.out.println("Produto: " + idProduto + " - " + nomeProduto + " (Preço: R$" + precoVenda + ")");
                System.out.println("  Grupo de Produto: " + nomeGrupo);
                System.out.println("  Fornecedor: " + (idFornecedor != null ? idFornecedor + " - " + razaoSocialFornecedor : "Nenhum"));
                System.out.println("--------------------------------------------------");
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
