package ifmt.cba.consultas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ListarPessoas {

    public static void main(String[] args) {

        EntityManager em = Persistence.createEntityManagerFactory("VendasTwo").createEntityManager();

        em.getTransaction().begin();

        TypedQuery<Object[]> query = em.createQuery(
                "SELECT p.id, p.nome FROM PessoaFisica p ORDER BY p.nome", Object[].class);

        List<Object[]> resultado = query.getResultList();

        for (Object[] obj : resultado) {
            System.out.println("Código: " + obj[0] + ", Nome: " + obj[1]);
        }

        TypedQuery<Object[]> queryJuridica = em.createQuery(
                "SELECT p.id, p.nome FROM PessoaJuridica p ORDER BY p.nome", Object[].class);

        List<Object[]> resultadoJuridica = queryJuridica.getResultList();


        for (Object[] obj : resultadoJuridica) {
            System.out.println("Código: " + obj[0] + ", Nome: " + obj[1]);
        }

        em.getTransaction().commit();
        em.close();
    }
}
