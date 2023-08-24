import java.io.*;
import java.util.ArrayList;

public class CardHolder {

    int id;
    long card;
    long hashCard;
    double money;

    static String filepath ="cardholders.txt";
    public CardHolder(int id, long card, long hashCard, double money) {
        this.id = id;
        this.card = card;
        this.hashCard = hashCard;
        this.money = money;
    }
    static ArrayList<CardHolder> cardholders = new ArrayList<CardHolder>();

    public static void loadFromFile() {
        
        ArrayList<CardHolder> cardholders = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String cardholder;
            while ((cardholder = br.readLine()) != null){
                String[] substring = cardholder.split(";");
                cardholders.add(new CardHolder(Integer.parseInt(substring[0]), Long.parseLong(substring[1]), Long.parseLong(substring[2]),(Double.parseDouble(substring[3]))));
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        CardHolder.cardholders = cardholders;
    }
    public static void writeToFile(String filepath,int id, long card, long hashCard, double money) {
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filepath), "utf-8"))) {
            for(CardHolder c : cardholders) {
                writer.write(c.id + ";");
                writer.write(c.card + ";");
                writer.write(c.hashCard + ";");
                writer.write(c.money + ";\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean CustomerIsCardholder(int id) {
        for (CardHolder cardholder: cardholders) {
            if (cardholder.id == id)
                return true;
        }
        System.out.println("Вы не авторизованы в банковской системе");
        return false;
    }
    public static boolean CustomerMoneyValid(int id, Ticket ticket){
        if ((cardholders.get(id - 1).money) >= ticket.price){
        return true;
        } else {
            System.out.println("На карте недостаточно средств");
            return false;
        }
    }
}
