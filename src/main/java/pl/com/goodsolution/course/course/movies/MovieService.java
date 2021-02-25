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

    public List<Movie> findMovie(String title, Long genreId) {
        if (title == null && genreId == null) {
            return StreamSupport.stream(movieRepository.findAll().spliterator(), false).collect(Collectors.toList());
        } else if (title == null && genreId != null) {
            return movieRepository.findByGenreId(genreId);
        } else if (title != null && genreId == null) {
            return movieRepository.findByTitle(title);
        } else {
            return movieRepository.findByTitleAndGenreId(title, genreId);
        }
    }

    @Transactional
    public void delete(Long id) {
        movieRepository.deleteMovieById(id);
    }

    @Transactional
    public void update(Movie movie, Long id) {
        movieRepository.updateMovie(id, movie.getTitle(), movie.getGenreId());
//        List<Movie> movies =
//                StreamSupport.stream(movieRepository.findAll().spliterator(), false).collect(Collectors.toList());
//        Movie movieFromDb = movies.stream()
//                .filter(movie1 -> id.equals(movie1.getMovieId()))
//                .findAny()
//                .orElse(null);
//        movieFromDb.setTitle(movie.getTitle());
//        movieFromDb.setGenreId(movie.getGenreId());
//        movieRepository.save(movieFromDb);
    }
}
