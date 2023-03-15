package Business_logic;

import Model.Ticket;
import Persistance.ConcertDAO;
import Persistance.TicketDAO;

import java.sql.SQLException;

public class Cashier {
    private TicketDAO td = new TicketDAO();

    public Cashier(TicketDAO td) {
        this.td = td;
    }

    public TicketDAO getTd() {
        return td;
    }

    public void setTd(TicketDAO td) {
        this.td = td;
    }

    public void sellTicket(String buyerName, int amount, int concertId) throws SQLException {
        Ticket t = td.selectById(concertId).get(0);

        t.setName(buyerName);
        //check for ticket limit
        boolean avaliable = td.check(concertId, amount);

        if (avaliable) {//check is true
            for (int i = 0; i<amount; i++){
                td.insert(t);
            }
            System.out.println("\nTickets were bought!");
        } else {//check is false
            System.out.println("\nWarning!! Not enough tickets!");
        }
    }
}
