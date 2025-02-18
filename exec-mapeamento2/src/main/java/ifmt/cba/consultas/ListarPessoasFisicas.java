package ifmt.cba.consultas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ListarPessoasFisicas {

    public static void main(String[] args) {
    
        EntityManager em = Persistence.createEntityManagerFactory("VendasTwo").createEntityManager();

        
        em.getTransaction().begin();

        TypedQuery<Object[]> query = em.createQuery(
                "SELECT p.id, p.nome, p.rg, p.cpf FROM PessoaFisica p ORDER BY p.nome", Object[].class);

        List<Object[]> resultado = query.getResultList();

        for (Object[] obj : resultado) {
            System.out.println("Código: " + obj[0] + ", Nome: " + obj[1] + ", RG: " + obj[2] + ", CPF: " + obj[3]);
            System.out.println("-------------------------------------------------------------------");
        }

        em.getTransaction().commit();
        em.close();
    }
}
