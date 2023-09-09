package hiepdt9.gmail.com.assignment_spring_boot.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "baiviet")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tieude")
    private String title;

    @Column(name = "noidung")
    private String content;

    @Column(name = "ngayviet")
    private Date startDate;

    @Column(name = "id_tacgia")
    private int idAuthor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }
}
