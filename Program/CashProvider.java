public class CashProvider{
    boolean isAuthorization;

    public static boolean buy(double prise) {
        double remains = CardHolder.cardholders.get(Customer.id - 1).money - prise;
        
        System.out.println("С карты будет списано " + prise + " у.е.");
        System.out.println("Остаток на счете = " + remains);
        System.out.println("номер билета: " + TicketProvider.tickets.get(0).rootNumber + " " + "Стоимость билета: "  + prise
        );

        return true;
    }

    public static void authorization(Customer customer){
        customer.cash.isAuthorization = CardHolder.CustomerIsCardholder(customer.id);
    }
}

