package pl.com.goodsolution.course.course.movies;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MovieApi {
    private final MovieService movieService;

    public MovieApi(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(path = "/api/movies", consumes = "application/json; charset=UTF-8",
            produces = "application/json; charset=UTF-8")
    public void createMovie(@RequestBody Movie movie) {
        movieService.create(movie);
    }

    @GetMapping(path = "/api/movies/{id}", produces = "application/json; charset=UTF-8")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @GetMapping(path = "/api/movies", produces = "application/json; charset=UTF-8")
    public List<Movie> findMovies(@RequestParam(value = "title", required = false) String title,
                                  @RequestParam(value = "genre_id", required = false) Long genreId) {
        return movieService.findMovie(title, genreId);
    }

    @PutMapping(path = "/api/movies/{id}", consumes = "application/json; charset=UTF-8")
    public void modifyMovie(@PathVariable Long id, @RequestBody Movie movie) {
        movieService.update(movie, id);
    }

    @DeleteMapping(path = "/api/movies/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.delete(id);
    }
}
