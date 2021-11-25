package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.User;

public class Request {
    private User user;
    private String movieTitle;

    public Request(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass() || this.hashCode() != obj.hashCode()) {
            return false;
        }

        Request other = (Request) obj;

        if (this.user != null) {
            if (this.user.equals(other.getUser()) && this.movieTitle.equals(other.getMovieTitle())) {
                return true;
            } else {
                return false;
            }
        } else {
            if (this.movieTitle.equals(other.getMovieTitle())) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public int hashCode() {
        if (this.user != null) {
            return this.user.hashCode() ^ this.movieTitle.hashCode() << 16;
        } else {
            return this.movieTitle.hashCode();
        }
    }
}
