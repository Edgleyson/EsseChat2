/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esse.chat.persistence;

import esse.chat.model.ChatRoom;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Equipe ESSE Chat
 */
public interface ChatRoomDao{
    boolean incluirSala(ChatRoom room) throws SQLException;
    boolean atualizarSala(ChatRoom room) throws SQLException;
    boolean excluirSala(ChatRoom room) throws SQLException;
    List<ChatRoom> listarSalas(ChatRoom room) throws SQLException;
    boolean cadastrarMonitor1(Long chatterId, int roomId)throws SQLException;
    boolean cadastrarMonitor2(Long chatterId, int roomId)throws SQLException;
    boolean cadastrarProfessor(Long chatterId, int roomId)throws SQLException;
}
