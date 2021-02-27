package pl.com.goodsolution.course.course.movies;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GenreApi {
    private final GenreService genreService;

    public GenreApi(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping(path = "/api/genre", consumes = "application/json; charset=UTF-8",
            produces = "application/json; charset=UTF-8")
    public void createGenre(@RequestBody Genre genre) {
        genreService.create(genre);
    }

    @GetMapping(path = "/api/genre/{id}", produces = "application/json; charset=UTF-8")
    public Genre getGenreById(@PathVariable Long id) {
        return genreService.getGenre(id);
    }

    @GetMapping(path = "/api/genre", produces = "application/json; charset=UTF-8")
    public List<Genre> findGenre(@RequestParam(value = "name", required = false) String name) {
        return genreService.findGenre(name);
    }

    @PutMapping(path = "/api/genre/{id}", consumes = "application/json; charset=UTF-8")
    public void modifyMovie(@PathVariable Long id, @RequestBody Genre genre) {
        genreService.update(id,genre);
    }

    @DeleteMapping(path = "/api/genre/{id}")
    public void deleteGenre(@PathVariable Long id) {
        genreService.delete(id);
    }
}
