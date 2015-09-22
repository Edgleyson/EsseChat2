/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esse.chat.persistence;

/**
 *
 * @author Equipe ESSE Chat
 */
public class FabricaDaoJDBC extends FabricaDAO{
    
    private static FabricaDaoJDBC instancia = null;
    
    private FabricaDaoJDBC() {
    }
    
    public static FabricaDaoJDBC getInstancia() {
        if (instancia == null)
            instancia = new FabricaDaoJDBC();
        return instancia;
    }
    
    public static void destroyInstancia(){
	if(instancia != null){
            instancia = null;
	}
    }
    
    @Override
    public ChatterDao createChatterDAO() {
        return new ChatterDaoJDBC();
    }

    
    @Override
    public ChatRoomDao createChatRoomDAO() {
        return new ChatRoomDaoJDBC();
    }
    
}
