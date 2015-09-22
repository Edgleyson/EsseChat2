package esse.chat.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipe ESSE Chat
 */
public abstract class HandlerConn{
    
    protected HandlerConn nextConn;
    protected String driver = "";
    protected String url = "";
    protected String logon = "ESSEDB";
    protected String password = "esse";
    
    public abstract Connection conectarBD(String dist);
    
    public Connection conectar(String driver, String url) {
        Connection connection = null;
            try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, logon, password);
            //JOptionPane.showMessageDialog(null, "Conexao com o Workspace do Chat realizada com sucesso");
            }   catch (SQLException | ClassNotFoundException ex) {
            //JOptionPane.showMessageDialog(null, "Driver JDBC - ODBC não encontrado!");
            } 
        return connection;
    }
}
