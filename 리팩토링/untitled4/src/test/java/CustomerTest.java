import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

class CustomerTest {

    public static final int CHILDRENS = 2;
    public static final int NEW_RELEASE = 1;
    public static final int REGULAR = 0;

    public static final String NAME = "NAME_NOT_IMPORTANT";
    public static final String TITLE = "TITLE_NOT_IMPORTANT";
    Customer customer = new Customer(NAME);

    @Test
    public void test() {
        Customer customer = new Customer("Bob");
        customer.addRental(new Rental(new RegularMovie("Jaws"), 2));
        customer.addRental(new Rental(new RegularMovie("Golden Eye"), 3));
        customer.addRental(new Rental(new NewReleaseMovie("Short New"), 1));
        customer.addRental(new Rental(new NewReleaseMovie("Long New"), 2));
        customer.addRental(new Rental(new ChilderensMovie("Bambi"), 3));
        customer.addRental(new Rental(new ChilderensMovie("Toy Story"), 4));

        String expected = "" +
                "Rental Record for Bob\n" +
                "\tJaws\t2.0\n" +
                "\tGolden Eye\t3.5\n" +
                "\tShort New\t3.0\n" +
                "\tLong New\t6.0\n" +
                "\tBambi\t1.5\n" +
                "\tToy Story\t3.0\n" +
                "Amount owed is 19.0\n" +
                "You earned 7 frequent renter points";

        assertEquals(expected, customer.statement());
    }

    @Test
    public void returnNewCustomer() {
        assertThat(customer, is(notNullValue()));
    }

    @Test
    public void statementForNoRental() {
        assertThat(customer.statement(), is("Rental Record for NAME_NOT_IMPORTANT\n"
                + "Amount owed is 0.0\n"
                + "You earned 0 frequent renter points"));
    }

    @Test
    public void statementForRegularMovieRentalForLessThan3Days() {
        // arrange
        addRental(2, REGULAR);

        // assert
        assertThat(customer.statement(), is("Rental Record for NAME_NOT_IMPORTANT\n"
                + "\tTITLE_NOT_IMPORTANT\t2.0\n"
                + "Amount owed is 2.0\n"
                + "You earned 1 frequent renter points"));
    }

    @Test
    public void statementForNewReleaseMovie() {
        addRental(1, NEW_RELEASE);




        // assert
        assertThat(customer.statement(), is("Rental Record for NAME_NOT_IMPORTANT\n"
                + "\tTITLE_NOT_IMPORTANT\t3.0\n"
                + "Amount owed is 3.0\n"
                + "You earned 1 frequent renter points"));
    }

    @Test
    public void statementForChildrensMovieRentalMoreThan3Days() {
        addRental(4, CHILDRENS);




        // assert
        assertThat(customer.statement(), is("Rental Record for NAME_NOT_IMPORTANT\n"
                + "\tTITLE_NOT_IMPORTANT\t3.0\n"
                + "Amount owed is 3.0\n"
                + "You earned 1 frequent renter points"));
    }

    @Test
    public void statementForChildrensMovieRentalMoreThan4Days() {
        addRental(3, CHILDRENS);




        // assert
        assertThat(customer.statement(), is("Rental Record for NAME_NOT_IMPORTANT\n"
                + "\tTITLE_NOT_IMPORTANT\t1.5\n"
                + "Amount owed is 1.5\n"
                + "You earned 1 frequent renter points"));
    }

    @Test
    public void statementForNewReleaseMovieRentalMoreThan1Day() {
        // arrange
        addRental(2, NEW_RELEASE);



        // assert
        assertThat(customer.statement(), is("Rental Record for NAME_NOT_IMPORTANT\n"
                + "\tTITLE_NOT_IMPORTANT\t6.0\n"
                + "Amount owed is 6.0\n"
                + "You earned 2 frequent renter points"));
    }

    @Test
    public void statementForFewMovieRental() {
        // arrange
        addRental(1, REGULAR);
        addRental(4, NEW_RELEASE);
        addRental(4, CHILDRENS);

        // assert
        assertThat(customer.statement(), is("Rental Record for NAME_NOT_IMPORTANT\n"
                + "\tTITLE_NOT_IMPORTANT\t2.0\n"
                + "\tTITLE_NOT_IMPORTANT\t12.0\n"
                + "\tTITLE_NOT_IMPORTANT\t3.0\n"
                + "Amount owed is 17.0\n"
                + "You earned 4 frequent renter points"));
    }

//    @Test
//    public void statementForNewReleaseMoviePriceCodeChangeDay() {
//        addRental(2, Movie.NEW_RELEASE);
//        for (Rental r :customer.getRentals()) {
//            Movie m = r.getMovie();
//            m.setPriceCode(Movie.CHILDRENS);
//        };
//
//        // assert
//        assertThat(customer.statement(), is("Rental Record for NAME_NOT_IMPORTANT\n"
//                + "\tTITLE_NOT_IMPORTANT\t1.5\n"
//                + "Amount owed is 1.5\n"
//                + "You earned 1 frequent renter points"));
//    }

    private void addRental(int daysRented, int priceCode) {
        Rental rental = getRental(daysRented, priceCode);
        customer.addRental(rental);
    }

    private static Rental getRental(int daysRented, int priceCode) {
        IMovie movie;

        if (priceCode == REGULAR) {
            movie = new RegularMovie(TITLE);
        }
        else if (priceCode == NEW_RELEASE) {
            movie = new NewReleaseMovie(TITLE);
        }
        else {
            movie = new ChilderensMovie(TITLE);
        }

        Rental rental = new Rental(movie, daysRented);
        return rental;
    }
}