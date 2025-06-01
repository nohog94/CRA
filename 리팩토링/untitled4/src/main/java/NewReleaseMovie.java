public class NewReleaseMovie implements IMovie{
    private String _title;

    public NewReleaseMovie(String title) {
        _title = title;
    }

    @Override
    public int getPriceCode() {
        return NEW_RELEASE;
    }

    @Override
    public double getMoviePrice(int getDaysRented) {
        double price = 0;
        price += getDaysRented * DELAY_PRICE_NEW_RELEASE;
        return price;
    }

    @Override
    public String getTitle() {
        return _title;
    }
}
