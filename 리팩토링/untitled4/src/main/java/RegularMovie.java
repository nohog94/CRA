public class RegularMovie implements IMovie{
    private String _title;

    public RegularMovie(String title) {
        _title = title;
    }

    @Override
    public int getPriceCode() {
        return REGULAR;
    }

    @Override
    public double getMoviePrice(int getDaysRented) {
        double price = 2;
        if (getDaysRented > 2)
            price += (getDaysRented - 2) * DELAY_PRICE;
        return price;
    }


    @Override
    public String getTitle() {
        return _title;
    }
}
