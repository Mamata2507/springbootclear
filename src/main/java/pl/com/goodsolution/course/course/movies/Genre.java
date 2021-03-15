package pl.com.goodsolution.course.course.movies;

import javax.persistence.*;

@Entity
@Table(name="genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="genre_id")
    private Long genreId;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "genre")
    private Movie movie;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {}

    public Long getGenreId() {
        return genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
