package hu.ulyssys.java.course.database.jpa.dao;

import hu.ulyssys.java.course.database.jpa.entity.Author;
import hu.ulyssys.java.course.database.jpa.entity.BlogPost;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BlogPostDAO {
    private static final String PERSISTENCE_UNIT = "BlogPostPersistence";

    private EntityManager createEntityManager(){
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }

    public void save(BlogPost blogPost){
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(blogPost);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(BlogPost blogPost){
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(blogPost);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deleteById(Long id){
        EntityManager entityManager = createEntityManager();
        BlogPost blogPost = entityManager.find(BlogPost.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(blogPost);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<BlogPost> findAll(){
        return createEntityManager().createQuery("SELECT n FROM BlogPost n", BlogPost.class).getResultList();
    }

    public List<BlogPost> findByTitle(String title){
        TypedQuery<BlogPost> typedQuery = createEntityManager().createQuery("SELECT n FROM BlogPost n WHERE n.title=:title", BlogPost.class);
        typedQuery.setParameter("title", title);
        return typedQuery.getResultList();
    }

    public List<BlogPost> findById(Long id){
        TypedQuery<BlogPost> typedQuery = createEntityManager().createQuery("SELECT n FROM BlogPost n WHERE n.id=:ID", BlogPost.class);
        typedQuery.setParameter("ID", id);
        return typedQuery.getResultList();
    }
}
