/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esse.chat.persistence;

import esse.chat.model.Chatter;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Equipe ESSE Chat
 */
public class ChatterDaoJPA implements ChatterDao {

    private static final String SELECT_FROM_CHATTER = "select c from Chatter c"; 
    public ChatterDaoJPA() {
    }

    @Override
    public boolean inserirDados(Chatter chatter) throws SQLException {
        EntityManager em = FabricaDaoJPA.getInstance().getFactory().createEntityManager();
                EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(chatter);
		t.commit();
		em.close();
                return true;
    }

    @Override
    public boolean atualizarDados(Chatter chatter) throws SQLException {
        EntityManager em = FabricaDaoJPA.getInstance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(chatter);
		em.getTransaction().commit();
		em.close();
                return true;
    }

    @Override
    public boolean excluirDados(Chatter umChatter) throws SQLException {
        EntityManager em = FabricaDaoJPA.getInstance().getFactory().createEntityManager();
                em.getTransaction().begin();
		Chatter chatter = (Chatter)em.find(Chatter.class, umChatter.getId());
		em.remove(chatter);
		em.getTransaction().commit();
		em.close();
                return true;
    }

    @Override
    public Chatter pesquisarDados(String nickname) throws SQLException {
        EntityManager em = FabricaDaoJPA.getInstance().getFactory().createEntityManager();
                Chatter chatter = (Chatter) em.find(Chatter.class, nickname);
		em.close();
		return chatter;
    }

    @Override
    public Chatter consultarChatter(String str) throws SQLException {
        EntityManager em = FabricaDaoJPA.getInstance().getFactory().createEntityManager();
                Chatter chatter = (Chatter) em.find(Chatter.class, str);
		em.close();
		return chatter;
    }

    @Override
    public List<Chatter> listarChatters() throws SQLException {
        EntityManager em = FabricaDaoJPA.getInstance().getFactory().createEntityManager();
                List<Chatter> chatters = em.createQuery(SELECT_FROM_CHATTER).getResultList();
		em.close();
		return chatters;
    }
    
}
