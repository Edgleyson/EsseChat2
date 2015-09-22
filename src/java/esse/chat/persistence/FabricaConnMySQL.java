package esse.chat.persistence;

import java.sql.Connection;

/**
 *
 * @author Equipe ESSE Chat
 */


public class FabricaConnMySQL implements FabricaConexao{

    public static FabricaConnMySQL instancia;
    
    protected FabricaConnMySQL() {
    }
    
    public static FabricaConnMySQL getInstancia(String tipo) {
        if (instancia == null)
            instancia = new FabricaConnMySQL();
        return instancia;
    }
    
    String dist = "MYSQL";
    HandlerConn handler;
    
    @Override
    public Connection fazerConexao() {   
        handler = new HandlerConn01();
        Connection conn = handler.conectarBD(dist);        
        return conn;
    }
       

}    

