public class Rental {
    private IMovie _movie;
    private int _daysRented;

    public Rental(IMovie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public IMovie getMovie() {
        return _movie;
    }

    public double getPrice() {
        return getMovie().getMoviePrice(getDaysRented());
    }

    public int getFrequentRenterPoint() {
        int frequentRenterPoint = 1;
        if (getMovie().getPriceCode() == IMovie.NEW_RELEASE && getDaysRented() > 1) {
            frequentRenterPoint = 2;
        }
        return frequentRenterPoint;
    }
}