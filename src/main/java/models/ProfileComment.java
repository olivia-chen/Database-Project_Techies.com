package models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class ProfileComment {
    private Long id;
    private UserTable author;
    private Long profile_id;
    private String content;
    private Timestamp timestamp;

    public ProfileComment() {}

    public ProfileComment(UserTable author, Long profile_id, String content, Timestamp timestamp) {
        this.author = author;
        this.profile_id = profile_id;
        this.content = content;
        this.timestamp = timestamp;
    }

    @Id
    @Column(name = "profilecomment_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public UserTable getAuthor() {
        return author;
    }

    public void setAuthor(UserTable author) {
        this.author = author;
    }

    public Long getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Long post_id) {
        this.profile_id = post_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the timestamp
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
