package hiepdt9.gmail.com.assignment_spring_boot.entity;

import javax.persistence.*;

@Entity(name = "tacgia")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tentacgia")
    private String authorName;

    @Column(name = "hoten")
    private String fullName;

    // 0: male, 1: female; 2: other
    @Column(name = "gioitinh")
    private int gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
