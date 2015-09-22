/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esse.chat.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Equipe ESSE Chat
 */
public class FabricaDaoJPA extends FabricaDAO{
    
    	private static final String PERSISTENCE_UNIT_NAME = "EsseJPA";
	private EntityManagerFactory factory;
	private static FabricaDaoJPA instancia = null;
	
	private FabricaDaoJPA(){
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	public EntityManagerFactory getFactory(){
		return factory;
	}
	
	public static FabricaDaoJPA getInstance(){
		if(instancia == null){
			instancia = new FabricaDaoJPA();
		}
		return instancia;
	}
	private void destroyFactory(){
		factory.close();		
	}
	
	public static void destroyInstance(){
		if(instancia != null){
			instancia.destroyFactory();
			instancia = null;
		}
	}
    
   
    @Override
    public ChatterDao createChatterDAO() {
        return new ChatterDaoJPA();
    }

   
    @Override
    public ChatRoomDao createChatRoomDAO() {
        return new ChatRoomDaoJPA();
    }
    
}
