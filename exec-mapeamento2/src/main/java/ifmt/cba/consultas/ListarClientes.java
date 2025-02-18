package ifmt.cba.consultas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ListarClientes {
    public static void main(String[] args) {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VendasTwo");
        EntityManager em = emf.createEntityManager();
        
        try {

            List<Object[]> resultados = em.createQuery(
                "SELECT c.id, c.nome, COUNT(v.id) " + 
                "FROM Cliente c " + 
                "LEFT JOIN c.vendas v " +
                "GROUP BY c.id, c.nome " +
                "ORDER BY c.nome", Object[].class 
            ).getResultList();

            
            System.out.println("Lista de Clientes:");
            System.out.println("--------------------------------------------------");
            for (Object[] row : resultados) {
                int idCliente = (int) row[0]; 
                String nomeCliente = (String) row[1]; 
                long quantidadeVendas = (long) row[2];

                System.out.println("Código: " + idCliente);
                System.out.println("Nome: " + nomeCliente);
                System.out.println("Quantidade de Vendas: " + quantidadeVendas);
                System.out.println("--------------------------------------------------");
            }
        } finally {
            
            em.close();
            emf.close();
        }
    }
}