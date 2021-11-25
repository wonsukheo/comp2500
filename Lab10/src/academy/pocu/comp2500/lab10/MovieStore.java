package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.util.ArrayList;

public class MovieStore implements IRequestHandler {
    private ArrayList<Movie> movieArrayList = new ArrayList<Movie>();

    public void add(Movie movie) {
        this.movieArrayList.add(movie);
    }

    public boolean remove(int index) {
        if (this.movieArrayList.size() > index) {
            this.movieArrayList.remove(index);
            return true;
        }

        return false;
    }

    @Override
    public ResultBase handle(Request request) {
        for (Movie movie : this.movieArrayList) {
            if (movie.getTitle().equals(request.getMovieTitle())) {
                return new OkResult(movie);
            }
        }

        return new NotFoundResult();
    }
}
