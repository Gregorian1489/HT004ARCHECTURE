import java.time.LocalDate;
import java.util.ArrayList;

public class Customer {
 public static int id;
 ArrayList<Ticket> tickets = new ArrayList<Ticket>();
 CashProvider cash;

     public boolean buyTicket(Ticket ticket) {
         if (cash.isAuthorization && CardHolder.CustomerMoneyValid(id, ticket)) {
             cash.buy(ticket.price);
             tickets.add(ticket);
             return TicketProvider.updateTicketStatus(ticket);
         }
         return false;
     }

    public Ticket search(LocalDate date, long ticketNumber){
        return TicketProvider.search(date, ticketNumber);
    }
}
