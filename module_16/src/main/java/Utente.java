import java.sql.ResultSet;
import java.sql.SQLException;

public class Utente
{
    int id;
    String nome;
    String cognome;

    public Utente(int id, String nome, String cognome)
    {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
    }

    public static Utente fromResultSet(ResultSet rs) throws SQLException {
        return new Utente(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cognome")
        );
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
