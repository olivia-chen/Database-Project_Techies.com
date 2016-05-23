package models;

import javax.persistence.*;


@Entity
public class Profile {
    private Long id;
    private UserTable author;
    private String birthday;
    private String gender;
    private String hobby;
    private String workplace;

    public Profile(UserTable author, String birthday, String gender, String hobby, String workplace) {
        this.author = author;
        this.birthday = birthday;
        this.gender = gender;
        this.hobby = hobby;
        this.workplace = workplace;
    }
    public Profile(){}

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="post_id")
    //@SequenceGenerator(name="post_id", sequenceName="post_id", allocationSize=1)
    @Column(name = "profile_id")
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the author
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public UserTable getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(UserTable author) {
        this.author = author;
    }

    /**
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the datatype to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the content to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the hobby
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * @param hobby the permission to set
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    /**
     * @return the workPlace
     */
    public String getWorkplace() {
        return workplace;
    }

    /**
     * @param workplace the timestamp to set
     */
    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
}
