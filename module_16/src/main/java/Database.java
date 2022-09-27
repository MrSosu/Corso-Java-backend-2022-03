import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database
{

    private ConnectionHandler handler;

    public Database(String url, String dbName, String schema, String utente, String password) throws ClassNotFoundException {
        handler = new ConnectionHandler(url, dbName, schema, utente, password);
    }

    public Utente getUtente(int id) throws SQLException {
        PreparedStatement ps = handler.prepareStatement("SELECT * FROM utente WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Utente utente = null;
        if (rs.next())
            utente = Utente.fromResultSet(rs);

        ps.close();
        rs.close();

        return utente;
    }

    public List<Utente> getUtenti() throws SQLException {
        List<Utente> utenti = new ArrayList<>();
        PreparedStatement ps = handler.prepareStatement("SELECT * FROM utente");
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            Utente utente = new Utente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cognome")
            );
            utenti.add(utente);
        }

        ps.close();
        rs.close();

        return utenti;
    }

    public int insertUtente(String nome, String cognome) throws SQLException
    {
        PreparedStatement ps = handler.prepareStatement("INSERT INTO utente (nome, cognome) VALUES (?, ?)");
        ps.setString(1, nome);
        ps.setString(2, cognome);
        int updatedRows = ps.executeUpdate();

        ps.close();

        return updatedRows;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Database db = new Database(ConnectionHandler.DB_URL, "AndiamoATeatro", "public", "postgres", "161198");

        db.insertUtente("Mario", "Rossi");

        for (Utente utente : db.getUtenti())
        {
            System.out.println(utente);
        }

        System.out.println("Utente con id = " + 1 + " " + db.getUtente(1));
    }

}
