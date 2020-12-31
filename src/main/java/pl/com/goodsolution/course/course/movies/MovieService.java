package pl.com.goodsolution.course.course.movies;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional
    public void create(Movie movie) {
        movieRepository.save(movie);
    }

    public Movie getMovie(Long id) {
        return movieRepository.findById(id).get();
    }

    public List<Movie> findMovie(String title) {
        if (title == null) {
            return StreamSupport.stream(movieRepository.findAll().spliterator(),false).collect(Collectors.toList());
        }
        else {
            return movieRepository.findByTitle(title);
        }
    }
}
