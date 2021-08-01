package hu.ulyssys.java.course.database.jpa.dao;

import hu.ulyssys.java.course.database.jpa.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuthorDAO {
    private static final String PERSISTENCE_UNIT = "AuthorPersistence";

    private EntityManager createEntityManager(){
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }

    public void save(Author author){
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Author author){
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deleteById(Long id){
        EntityManager entityManager = createEntityManager();
        Author author = entityManager.find(Author.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Author> findAll(){
        return createEntityManager().createQuery("SELECT n FROM Author n", Author.class).getResultList();
    }

    public List<Author> findByUsername(String username){
        TypedQuery<Author> typedQuery = createEntityManager().createQuery("SELECT n FROM Author n WHERE n.username=:userName", Author.class);
        typedQuery.setParameter("userName", username);
        return typedQuery.getResultList();
    }

    public List<Author> findById(Long id){
        TypedQuery<Author> typedQuery = createEntityManager().createQuery("SELECT n FROM Author n WHERE n.id=:ID", Author.class);
        typedQuery.setParameter("ID", id);
        return typedQuery.getResultList();
    }


}
