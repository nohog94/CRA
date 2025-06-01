public class ChilderensMovie implements IMovie{

    private String _title;

    public ChilderensMovie(String title) {
        _title = title;
    }

    @Override
    public int getPriceCode() {
        return CHILDRENS;
    }

    @Override
    public double getMoviePrice(int getDaysRented) {
        double price = 1.5;
        if (getDaysRented > 3) {
            price += (getDaysRented - 3) * DELAY_PRICE;
        }
        return price;
    }

    @Override
    public String getTitle() {
        return _title;
    }
}
