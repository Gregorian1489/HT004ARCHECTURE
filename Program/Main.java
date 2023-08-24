import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Загрузим список CardHolder
        CardHolder.loadFromFile();

        // Добавление билетов
        TicketProvider.tickets.add(new Ticket(1, 400, -1, LocalDate.of(2023, 8, 22), true));
        TicketProvider.tickets.add(new Ticket(2, 300, -1, LocalDate.of(2023, 8, 22), false));
        TicketProvider.tickets.add(new Ticket(3, 200, -1, LocalDate.of(2023, 8, 21), true));

        // ------------ Пример успешной покупки билета ------------------------------
        // Создаем пользователя 1
        Customer customer = new Customer();
        customer.cash = new CashProvider();
        customer.cash.isAuthorization = false;
        customer.id = 1;

        // Ищем билет
        LocalDate date = LocalDate.of(2023, 8, 22);
        Ticket search_ticket = customer.search(date, 1);
        // Если билет доступен
        if (search_ticket != null) {
            // Авторизовываемся на CashProvider
            CashProvider.authorization(customer);
            // Покупаем билет
            boolean buy_ticket_result = customer.buyTicket(search_ticket);
            if (buy_ticket_result) {
                System.out.printf("Успешно купили билет № %s \n", search_ticket.rootNumber);
            }
            else System.out.print("Покупка билета не удалась");

        }
        else {
            System.out.print("Ошибка при покупке билета...");
        }
        
    }
}

