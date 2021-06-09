package JPA;

import javax.persistence.EntityManager;

import model.Usuario;

public class InsereAdmin {

	public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(new Usuario(1, "Eze", "Eze", "1234"));
        em.merge(new Usuario(2, "Dode", "Dode", "1234"));
        em.merge(new Usuario(3, "Ande", "Ande", "1234"));
        em.getTransaction().commit();
	}

}
