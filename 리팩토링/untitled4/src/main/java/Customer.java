import java.util.ArrayList;
import java.util.List;


public class Customer {

    private String _name;
    private List<Rental> _rentals = new ArrayList<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public List<Rental> getRentals() {
        return _rentals;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        result += getRecordByMovie();
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";

        return result;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : _rentals) {
            totalAmount += rental.getPrice();
        }
        return totalAmount;
    }

    private int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : _rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoint();
        }
        return frequentRenterPoints;
    }

    private String getRecordByMovie() {
        String result = "";
        for (Rental rental : _rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getPrice()) + "\n";
        }
        return result;
    }
}