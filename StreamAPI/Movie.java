import java.util.*;
import java.util.stream.*;

class Movie {
    String title;
    double rating;
    int releaseYear;

    public Movie(String title, double rating, int releaseYear) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return title + " (" + releaseYear + ") - Rating: " + rating;
    }
}

public class TopMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Inception", 8.8, 2010),
                new Movie("The Dark Knight", 9.0, 2008),
                new Movie("Interstellar", 8.6, 2014),
                new Movie("Oppenheimer", 8.5, 2023),
                new Movie("Barbie", 7.3, 2023),
                new Movie("Dune", 8.2, 2021),
                new Movie("Avengers: Endgame", 8.4, 2019),
                new Movie("The Godfather", 9.2, 1972),
                new Movie("Parasite", 8.6, 2019),
                new Movie("Spider-Man: No Way Home", 8.3, 2021)
        );

        List<Movie> top5 = movies.stream()
                .filter(m -> m.rating >= 7.5) // filter: only good movies
                .sorted(Comparator.comparingDouble(Movie::rating).reversed()
                        .thenComparing(Comparator.comparingInt(Movie::releaseYear).reversed()))
                .limit(5)
                .collect(Collectors.toList());

        top5.forEach(System.out::println);
    }
}
