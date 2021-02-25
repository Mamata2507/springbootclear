package pl.com.goodsolution.course.course.movies;

import javax.persistence.*;

@Entity
@Table(name="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id")
    private Long movieId;
    @Column(name="title")
    private String title;
    @Column(name="genre_id")
    private Long genreId;

    public Movie(String title, Long genreId) {
        this.title = title;
        this.genreId = genreId;
    }

    public Movie() {

    }

    public Long getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }
}
