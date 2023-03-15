package Business_logic;

import Persistance.*;

public class Admin {
    private UserDAO ud = new UserDAO();
    private ArtistDAO ad = new ArtistDAO();
    private ConcertDAO cd = new ConcertDAO();
    private int searchId;

    public Admin(UserDAO ud, ArtistDAO ad, ConcertDAO cd) {
        this.ud = ud;
        this.ad = ad;
        this.cd = cd;
    }

    public UserDAO getUd() {
        return ud;
    }

    public void setUd(UserDAO ud) {
        this.ud = ud;
    }

    public ArtistDAO getAd() {
        return ad;
    }

    public void setAd(ArtistDAO ad) {
        this.ad = ad;
    }

    public ConcertDAO getCd() {
        return cd;
    }

    public void setCd(ConcertDAO cd) {
        this.cd = cd;
    }

    public int getSearchId() {
        return searchId;
    }

    public void setSearchId(int searchId) {
        this.searchId = searchId;
    }

    public void export(){
        ExportTicketFactory etf = new ExportTicketFactory();
        ExportTicket exportTicket = etf.createExport();
        exportTicket.expotTickets(getSearchId());
    }
}
