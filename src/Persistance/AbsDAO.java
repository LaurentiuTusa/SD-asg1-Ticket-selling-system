package Persistance;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class AbsDAO<G> {

    public abstract void insert(G g) throws SQLException;
    public abstract List<G> select() throws SQLException;
    public abstract void update(G g) throws SQLException;
    public abstract void delete(G g) throws SQLException;
}
