package Model;

public class ConcertArtists {
    private int id;
    private int concertId;
    private int artistId;

    public ConcertArtists(int id, int concertId, int artistId) {
        this.id = id;
        this.concertId = concertId;
        this.artistId = artistId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConcertId() {
        return concertId;
    }

    public void setConcertId(int concertId) {
        this.concertId = concertId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
}
