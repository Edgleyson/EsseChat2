/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esse.chat.persistence;

import esse.chat.model.ChatRoom;
import esse.chat.model.Chatter;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Equipe ESSE Chat
 */
class ChatRoomDaoJPA implements ChatRoomDao {

    private static final String SELECT_FROM_CHATROOM = "select c from Chatroom c";
    public ChatRoomDaoJPA() {
    }

    @Override
    public boolean incluirSala(ChatRoom room) throws SQLException {
        EntityManager em = FabricaDaoJPA.getInstance().getFactory().createEntityManager();
                EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(room);
		t.commit();
		em.close();
                return true;
    }

    @Override
    public boolean atualizarSala(ChatRoom room) throws SQLException {
        EntityManager em = FabricaDaoJPA.getInstance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(room);
		em.getTransaction().commit();
		em.close();
                return true;
    }

    @Override
    public boolean excluirSala(ChatRoom umaRoom) throws SQLException {
        EntityManager em = FabricaDaoJPA.getInstance().getFactory().createEntityManager();
            em.getTransaction().begin();
            ChatRoom room = (ChatRoom) em.find(ChatRoom.class, umaRoom.getRoomid());
            em.remove(room);
            em.getTransaction().commit();
            em.close();
            return true;
    }

    @Override
    public List<ChatRoom> listarSalas(ChatRoom room) throws SQLException {
        EntityManager em = FabricaDaoJPA.getInstance().getFactory().createEntityManager();
            List<ChatRoom> rooms = em.createQuery(SELECT_FROM_CHATROOM).getResultList();
		em.close();
		return rooms;
    }

    @Override
    public boolean cadastrarMonitor1(Long chatterId, int roomId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean cadastrarMonitor2(Long chatterId, int roomId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean cadastrarProfessor(Long chatterId, int roomId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
