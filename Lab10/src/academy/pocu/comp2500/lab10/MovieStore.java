package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.*;

import java.util.ArrayList;

public class MovieStore implements IRequestHandler {
    ArrayList<Movie> movieArrayList = new ArrayList<Movie>();

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
