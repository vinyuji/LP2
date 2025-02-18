package ifmt.cba.consultas;

import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ListaFornecedores {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VendasTwo");
        EntityManager em = emf.createEntityManager();

        try {
            List<Fornecedor> fornecedores = em.createQuery(
                "SELECT DISTINCT f FROM Fornecedor f LEFT JOIN FETCH f.produtos ORDER BY f.razaoSocial", Fornecedor.class
            ).getResultList();
            
            for (Fornecedor fornecedor : fornecedores) {
                System.out.println("Fornecedor: " + fornecedor.getId() + " - " + fornecedor.getRazaoSocial());
                
                for (Produto produto : fornecedor.getProdutos()) {
                    System.out.println("    Produto: " + produto.getId() + " - " + fornecedor.getProdutos());
                }
                System.out.println("--------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar fornecedores: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
