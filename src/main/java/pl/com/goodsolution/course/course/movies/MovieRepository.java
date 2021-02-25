package pl.com.goodsolution.course.course.movies;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findByTitle(String title);
    List<Movie> findByGenreId(Long genreId);
    List<Movie> findByTitleAndGenreId(String title, Long genreId);

    @Modifying
    @Query("DELETE FROM Movie m WHERE m.id = :id")
    void deleteMovieById(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Movie m SET m.title = :title, m.genre_id = :genre_id WHERE m.id = :id")
    void updateMovie(@Param("id") Long id, @Param("title") String title, @Param("genre_id") Long genreId);
}
