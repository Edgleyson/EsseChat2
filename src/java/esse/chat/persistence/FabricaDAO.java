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
public abstract class FabricaDAO {

    public abstract ChatterDao createChatterDAO();
    public abstract ChatRoomDao createChatRoomDAO();
}
