/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esse.chat.persistence;


/**
 *
 * @author ESSE
 */
public class Fabrica {
    public static FabricaDAO FabricaMethod(String tipo){
        FabricaDAO fabrica;
        if("JDBC".equals(tipo)){
            fabrica = FabricaDaoJDBC.getInstancia();
            
        }else{
            fabrica = FabricaDaoJPA.getInstance();
        }
    return fabrica;
    }
}
