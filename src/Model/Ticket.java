package Model;

public class Ticket {
    private int id;
    private int price;
    private int concertId;
    private String name;

    public Ticket(int id, int price, int concertId, String name) {
        this.id = id;
        this.price = price;
        this.concertId = concertId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getConcertId() {
        return concertId;
    }

    public void setConcertId(int concertId) {
        this.concertId = concertId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        String s = "id= " + this.getId() + ", price= " + this.getPrice() + ", concertId= " + this.getConcertId() + ", name= " + this.getName();
        return s;
    }
}
