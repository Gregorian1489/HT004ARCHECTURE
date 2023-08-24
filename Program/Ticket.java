import java.time.LocalDate;

public class Ticket {
    long rootNumber;
    double price;
    int place;
    LocalDate date;
    boolean isValid;

    public Ticket(long rootNumber, double price, int place, LocalDate date, boolean isValid){
        this.rootNumber = rootNumber;
        this.price = price;
        this.place = place;
        this.date = date;
        this.isValid = isValid;
    }
}
