package hu.ulyssys.java.course.database.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "blog_post")
public class BlogPost extends AbstractEntity implements Serializable {
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "category")
    private String category;
    @Column(name = "published_date")
    private Date publishedDate;

    public BlogPost(){

    }

    public BlogPost(Long id, Date createdDate, Date lastModifiedDate, String title, String content, String category, Date publishedDate) {
        super(id, createdDate, lastModifiedDate);
        this.title = title;
        this.content = content;
        this.category = category;
        this.publishedDate = publishedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}
