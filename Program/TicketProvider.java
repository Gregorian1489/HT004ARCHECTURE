import java.time.LocalDate;
import java.util.ArrayList;

public class TicketProvider {
    public static ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public static Ticket search(LocalDate date, long ticketNumber) {
        for (Ticket ticket: tickets) {
            if (ticket.date.equals(date) & ticket.rootNumber == ticketNumber)
                return ticket;
        }
        return null;
    }

    public Ticket getTicket(long rootNumber) {
        for (Ticket ticket : tickets) {
            if (ticket.rootNumber == rootNumber) {
                return ticket;
            }
        }
        return null;
    }

    public static boolean updateTicketStatus(Ticket ticket){
        if (ticket.isValid) {
            ticket.isValid = false;
            return true;
        }
        return false;
    }
}
