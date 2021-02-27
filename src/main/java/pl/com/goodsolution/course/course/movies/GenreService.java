package pl.com.goodsolution.course.course.movies;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Transactional
    public void update(Long id, Genre genre) {
        genreRepository.update(id,genre.getName());
    }

    @Transactional
    public void delete(Long id) {
        genreRepository.deleteGenreById(id);
    }

    public Genre getGenre(Long id){
        return genreRepository.findById(id).get();
    }

    public List<Genre> findGenre(String name) {
        if(name == null) {
            return StreamSupport.stream(genreRepository.findAll().spliterator(),false).collect(Collectors.toList());
        }
        else {
            return genreRepository.findByName(name);
        }
    }
}
