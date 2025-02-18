package ifmt.cba.consultas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ListarPessoasJuridicas {

    public static void main(String[] args) {

        EntityManager em = Persistence.createEntityManagerFactory("VendasTwo").createEntityManager();

        em.getTransaction().begin();

        TypedQuery<Object[]> query = em.createQuery(
                "SELECT p.id, p.nomeFantasia, p.cnpj FROM PessoaJuridica p ORDER BY p.nomeFantasia", Object[].class);

        List<Object[]> resultado = query.getResultList();

        for (Object[] obj : resultado) {
            System.out.println("Código: " + obj[0] + ", Nome Fantasia: " + obj[1] + ", CNPJ: " + obj[2]);
            System.out.println("---------------------------------------------------------------------");
        }

        em.getTransaction().commit();
        em.close();
    }
}

