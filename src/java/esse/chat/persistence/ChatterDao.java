/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esse.chat.persistence;

import esse.chat.model.Chatter;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Equipe ESSE Chat
 */
public interface ChatterDao {
    boolean inserirDados(Chatter chatter)throws SQLException;
    boolean atualizarDados(Chatter chatter)throws SQLException;
    boolean excluirDados(Chatter chatter)throws SQLException;
    Chatter pesquisarDados(String nickname)throws SQLException;
    Chatter consultarChatter(String str)throws SQLException;
    List<Chatter> listarChatters() throws SQLException;
}
