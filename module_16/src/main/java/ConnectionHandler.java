import java.sql.*;

public class ConnectionHandler {

    public static final String DB_URL = "jdbc:postgresql://localhost:5432/";

    private final String connectionUrl;

    private Connection connection;

    public ConnectionHandler(String dbUrl, String dbName, String schema, String username, String password) throws ClassNotFoundException {
        this.connectionUrl = dbUrl + dbName
                + "?currentSchema=" + schema
                + "&user=" + username
                + "&password=" + password;

        // Occorre conoscere il nome del driver e il suo package
        Class.forName("org.postgresql.Driver");
    }

    public Connection getConnection() throws SQLException {
        if ( this.connection == null || this.connection.isClosed() ) {
            // Se la connessione non esiste o e' chiusa, la crea
            this.connection = DriverManager.getConnection(connectionUrl);
        }

        // Ritorna la connessione
        return this.connection;
    }

    public void closeConnection() throws SQLException {
        if ( this.connection != null && !this.connection.isClosed() ) {
            this.connection.close();
            this.connection = null;
        }
    }

    public PreparedStatement prepareStatement(String query) throws SQLException {
        // Uso il metodo getConnection invece di accedere direttamente per
        // garantire che la connection sia attiva
        Connection conn = getConnection();

        // Creo un oggetto PreparedStatement con la query specificata come parametro e lo ritorno
        return conn.prepareStatement(query);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectionHandler connectionHandler = new ConnectionHandler(
                ConnectionHandler.DB_URL, "db_test", "public", "postgres", "161198"
        );

        String query = "SELECT * FROM tabella";
        PreparedStatement stmt = connectionHandler.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String cognome = rs.getString("cognome");
            System.out.println(id + ": " + nome + " " + cognome);
        }

        rs.close();
        stmt.close();
    }

}
