package pl.com.goodsolution.course.course.movies;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Transactional
    public void create(Genre genre) {
        genreRepository.save(genre);
    }
}
