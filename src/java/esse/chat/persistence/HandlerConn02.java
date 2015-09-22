package esse.chat.persistence;

import java.sql.Connection;

/**
 * @author Equipe ESSE Chat
 */
public class HandlerConn02 extends HandlerConn{

    Connection conn = null;
    HandlerConn nextHandler;
    private String distribuidor;
    
    public HandlerConn02(){
        this.driver = "oracle.jdbc.driver.OracleDriver";
        this.url = "jdbc:oracle:thin:@localhost:1521:XE";
        this.distribuidor = "ORACLE";
        this.nextHandler = null;
    }
    
    @Override
    public Connection conectarBD(String dist){
        if(distribuidor.equals(dist)){
            conn = conectar(driver, url);
            return conn;
        }else{
            if(nextHandler!=null){
                return nextHandler.conectarBD(dist);
            }else{
                return null;
            }
        }
    }
   
}
