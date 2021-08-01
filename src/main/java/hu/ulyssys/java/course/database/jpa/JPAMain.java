package hu.ulyssys.java.course.database.jpa;

import hu.ulyssys.java.course.database.jpa.dao.AuthorDAO;
import hu.ulyssys.java.course.database.jpa.dao.BlogPostDAO;
import hu.ulyssys.java.course.database.jpa.entity.Author;
import hu.ulyssys.java.course.database.jpa.entity.BlogPost;

import java.util.Date;

public class JPAMain {
    public static void main(String[] args) {
        // author tábla műveletek
        AuthorDAO authorDAO = new AuthorDAO();
        Author author = new Author();
        author.setFirstName("Pista");
        author.setLastName("Kis");
        author.setUsername("pityu");
        author.setCreatedDate(new Date());
        author.setLastModifiedDate(new Date());
        authorDAO.save(author);
        //author.setId(1L);
        //author.setUsername("pityubacsi");
        //author.setFirstName("István");
        //author.setLastName("Nagy");
        //author.setLastModifiedDate(new Date());
        //authorDAO.update(author);
        //authorDAO.deleteById(1L);
        authorDAO.findAll().forEach(author1 -> {
            System.out.println(author1.getId() + " " + author1.getUsername() + " " +
                    author1.getFirstName() + " " + author1.getLastName() + " " +
                    author1.getCreatedDate() + " " + author1.getLastModifiedDate());
        });

        authorDAO.findById(2L).forEach(author1 -> {
            System.out.println(author1.getId() + " " + author1.getUsername() + " " +
                    author1.getFirstName() + " " + author1.getLastName() + " " +
                    author1.getCreatedDate() + " " + author1.getLastModifiedDate());
        });

        authorDAO.findByUsername("pityubacsi").forEach(author1 -> {
            System.out.println(author1.getId() + " " + author1.getUsername() + " " +
                    author1.getFirstName() + " " + author1.getLastName() + " " +
                    author1.getCreatedDate() + " " + author1.getLastModifiedDate());
        });

        //blog_post tábla műveletek
        BlogPostDAO blogPostDAO = new BlogPostDAO();
        BlogPost blogPost = new BlogPost();
        blogPost.setCategory("JAVA");
        blogPost.setContent("JPA");
        blogPost.setTitle("JPA házi feladat");
        blogPost.setCreatedDate(new Date());
        blogPost.setLastModifiedDate(new Date());
        blogPost.setPublishedDate(new Date());
        blogPostDAO.save(blogPost);
        blogPost.setId(1L);
        blogPost.setCategory("MAVEN");
        blogPost.setContent("JPA1");
        blogPost.setTitle("JPA1 házi feladat");
        blogPost.setLastModifiedDate(new Date());
        blogPost.setPublishedDate(new Date());
        blogPostDAO.update(blogPost);
        //blogPostDAO.deleteById(1L);
        blogPostDAO.findAll().forEach(blogPost1 -> {
            System.out.println(blogPost1.getId() + " " + blogPost1.getCategory() + " " +
                    blogPost1.getContent() + " " + blogPost1.getTitle() + " " +
                    blogPost1.getCreatedDate() + " " + blogPost1.getLastModifiedDate() + " " +
                    blogPost1.getPublishedDate());
        });
        blogPostDAO.findById(2L).forEach(blogPost1 -> {
            System.out.println(blogPost1.getId() + " " + blogPost1.getCategory() + " " +
                    blogPost1.getContent() + " " + blogPost1.getTitle() + " " +
                    blogPost1.getCreatedDate() + " " + blogPost1.getLastModifiedDate() + " " +
                    blogPost1.getPublishedDate());
        });
        blogPostDAO.findByTitle("JPA házi feladat").forEach(blogPost1 -> {
            System.out.println(blogPost1.getId() + " " + blogPost1.getCategory() + " " +
                    blogPost1.getContent() + " " + blogPost1.getTitle() + " " +
                    blogPost1.getCreatedDate() + " " + blogPost1.getLastModifiedDate() + " " +
                    blogPost1.getPublishedDate());
        });
    }
}
