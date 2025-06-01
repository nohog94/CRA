public interface IMovie {
    int CHILDRENS = 2;
    int NEW_RELEASE = 1;
    int REGULAR = 0;
    double DELAY_PRICE = 1.5;
    int DELAY_PRICE_NEW_RELEASE = 3;

    int getPriceCode();

    double getMoviePrice(int getDaysRented);

    String getTitle();

}
