/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esse.chat.persistence;

import esse.chat.model.ChatRoom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ChatRoomDaoJDBC implements ChatRoomDao {
    
    Conexao cnx;
    private Connection conn;  
    private ChatRoom room;
    
    @Override
    public boolean incluirSala(ChatRoom room) throws SQLException {
        cnx = new Conexao();
        PreparedStatement stmt = null;
        conn = cnx.criarConexao();
        this.room = room;
        String cmdsql = "insert into ESSEDB.CHATROOM (nome, descricao) values (?,?)";
        try { //Prepara o comando stmt setando os VALUES (?, ?, ?)
                stmt = conn.prepareStatement(cmdsql); 
                stmt.setString(1, room.getName());
                stmt.setString(2, room.getDescription());
                stmt.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally{
                try {
                    if (stmt != null)
                        stmt.close();
                    if (conn != null)
                        conn.close();
                    } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }return true;
    }           

    @Override
    public boolean atualizarSala(ChatRoom room) throws SQLException {
        cnx = new Conexao();
        conn = cnx.criarConexao();
        try {
            String cmdsql = "UPDATE ESSEDB.CHATROOM SET NOME=?, DESCRICAO=?, PROFESSOR=?, MONITOR1=?, MONITOR2=? WHERE ROOMID=?";
        try ( //Prepara o comando stmt setando os VALUES (?, ?, ?, ?, ?)
                PreparedStatement stmt = conn.prepareStatement(cmdsql)) {
                stmt.setString(1, room.getName());
                stmt.setString(2, room.getDescription());
                stmt.setLong(3, room.getProfessor());
                stmt.setLong(4, room.getMonitor1());
                stmt.setLong(5, room.getMonitor2());
                stmt.setInt(6, room.getRoomid());
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            conn.close();
        }return true;
    }

    @Override
    public boolean excluirSala(ChatRoom room) throws SQLException {
        cnx = new Conexao();
        conn = cnx.criarConexao();
        try {
            try (Statement stmt = conn. createStatement()) {
                stmt.execute ("DELETE FROM ESSEDB.CHATROOM WHERE ROOMID = " + room.getRoomid());
                stmt.close();
            }
        } catch (Exception excecao) {
            throw (excecao);
        }finally{
            conn.close();
        }return true;
    }

    
    @Override
    public List<ChatRoom> listarSalas(ChatRoom room) throws SQLException {
        cnx = new Conexao();
                List<ChatRoom> rooms = new ArrayList<>() ;
        conn = cnx.criarConexao();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ESSEDB.CHATROOM");
        /*
        try {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next() ) {
                    room = new ChatRoom();
                    room.setRoomid(rs.getLong("roomid"));
                    room.setName(rs.getString("nome"));
                    room.setProfessor(rs.getString("professor"));
                    room.setMonitor1(rs.getString("monitor1"));
                    room.setMonitor2(rs.getString("monitor2"));
                    //Adiciona as salas à lista de salas
                    rooms.add(room);
                }rs.close();
            }stmt.close();
        } catch (Exception excecao) {
            throw (excecao);
        }finally{
            conn.close();
        }*/
                return rooms;
    }

    @Override
    public boolean cadastrarMonitor1(Long chatterId, int roomId) throws SQLException {
        cnx = new Conexao();
        conn = cnx.criarConexao();
        try {
            String cmdsql = "UPDATE ESSEDB.CHATROOM SET MONITOR1=? WHERE ROOMID=?";
        try ( //Prepara o comando stmt setando os VALUES (?, ?, ?, ?, ?)
                PreparedStatement stmt = conn.prepareStatement(cmdsql)) {
                stmt.setLong(1, chatterId);
                stmt.setInt(2, roomId);
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            conn.close();
        }return true;
    }

    @Override
    public boolean cadastrarMonitor2(Long chatterId, int roomId) throws SQLException {
        cnx = new Conexao();
        conn = cnx.criarConexao();
        try {
            String cmdsql = "UPDATE ESSEDB.CHATROOM SET MONITOR2=? WHERE ROOMID=?";
        try ( //Prepara o comando stmt setando os VALUES (?, ?, ?, ?, ?)
                PreparedStatement stmt = conn.prepareStatement(cmdsql)) {
                stmt.setLong(1, chatterId);
                stmt.setInt(2, roomId);
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            conn.close();
        }return true;
    }

    @Override
    public boolean cadastrarProfessor(Long chatterId, int roomId) throws SQLException {
        cnx = new Conexao();
        conn = cnx.criarConexao();
        try {
            String cmdsql = "UPDATE ESSEDB.CHATROOM SET PROFESSOR=? WHERE ROOMID=?";
        try ( //Prepara o comando stmt setando os VALUES (?, ?, ?, ?, ?)
                PreparedStatement stmt = conn.prepareStatement(cmdsql)) {
                stmt.setLong(1, chatterId);
                stmt.setInt(2, roomId);
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            conn.close();
        }return true;
    }
}
