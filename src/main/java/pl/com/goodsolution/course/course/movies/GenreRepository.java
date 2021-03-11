package pl.com.goodsolution.course.course.movies;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    List<Genre> findByName(String name);

    @Modifying
    @Query("DELETE FROM Genre g WHERE g.genreId = :genreId")
    void deleteGenreById(@Param("genreId") Long id);

    @Modifying
    @Query("UPDATE Genre g SET g.name = :name WHERE g.genreId = :genreId")
    void update(@Param("genreId") Long genreId, @Param("name") String name);
}
