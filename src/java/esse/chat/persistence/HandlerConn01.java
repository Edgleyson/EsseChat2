package esse.chat.persistence;

import java.sql.Connection;

/**
 * @author Equipe ESSE Chat
 */
public class HandlerConn01 extends HandlerConn {
    
    Connection conn = null;
    HandlerConn nextHandler;
    private String distribuidor;
    
    public HandlerConn01(){
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/ESSEDB";
        this.distribuidor = "MYSQL";
        this.nextHandler = new HandlerConn02();
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
