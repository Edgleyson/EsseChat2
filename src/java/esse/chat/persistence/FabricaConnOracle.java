package esse.chat.persistence;

import java.sql.Connection;

/**
 *
 * @author Equipe ESSE Chat
 */

public class FabricaConnOracle implements FabricaConexao{
    
    public static FabricaConnOracle instancia;
    
    protected FabricaConnOracle() {
    }
    
    public static FabricaConnOracle getInstancia() {
        if (instancia == null)
            instancia = new FabricaConnOracle();
        return instancia;
    }
    
    String dist = "ORACLE";
    HandlerConn handler;
    
    @Override
    public Connection fazerConexao() {
        handler = new HandlerConn01();
        Connection conn = handler.conectarBD(dist);        
        return conn;
    }
}    

