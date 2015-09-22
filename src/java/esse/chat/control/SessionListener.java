package esse.chat.control;

import esse.chat.model.ChatRoom;
import esse.chat.persistence.ChatRoomList;
import esse.chat.model.Chatter;
import java.util.Map;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

/** Usado pela aplicação de chat para ouvir eventos de sessão.
*   @author Equipe ESSE Chat
*/
public class SessionListener implements HttpSessionAttributeListener 
{
        @Override
	public void attributeAdded(HttpSessionBindingEvent hsbe){}

        @Override
	public void attributeReplaced(HttpSessionBindingEvent hsbe){}

	/** Este é o método que nos interessa. 
         * Apaga um usuário da lista de usuários quando sua sessão expirar.
         * @param hsbe
	*/
        @Override
	public void attributeRemoved(HttpSessionBindingEvent hsbe)
	{
	    String name = hsbe.getName();
            HttpSession session = hsbe.getSession();
	    if ("nickname".equals(name))
            {
		String nickname = (String)hsbe.getValue();
		if (nickname != null)
		{
                    ServletContext application = session.getServletContext();
                    if (application != null)
                    {
			Object o = application.getAttribute("myListRooms");		
			if (o != null)
			{
                            ChatRoomList roomList = (ChatRoomList)o;
                            Object obj = session.getAttribute("chatterid");
                            String id = obj.toString();
                            long chatterId = Long.parseLong(id);
                            ChatRoom room = roomList.getRoomOfChatter(chatterId);
				if (room != null)
				{
				    Map<Long, Chatter> map = room.getMapChatters();
                                    Chatter esseChatter = map.remove(chatterId);
                                    			
				}
			}
                    }
                    else
                    {
			System.out.println("ServletContext is null");
                    }					
		}
            }		
	}
}