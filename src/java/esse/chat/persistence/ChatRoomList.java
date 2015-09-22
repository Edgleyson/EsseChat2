package esse.chat.persistence;

import esse.chat.model.ChatRoom;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

/**
* This class is used to manipulate and store ChatRoom objects.
* It provides methods to store and retrieve ChatRoom objects
* in this <code>ChatRoomList</code>.
*@author Equipe ESSE Chat
*/
public class ChatRoomList
{
    //Fazendo da lista um Singleton
    public static ChatRoomList instancia;
    
    protected ChatRoomList() {
        roomList = new HashMap();
    }
    
    public static ChatRoomList getInstancia() {
        if (instancia == null)
            instancia = new ChatRoomList();
        return instancia;
    }
    
    
    /**
	* Stores all the ChatRoom objects
	*/
	public Map<String, ChatRoom> roomList; 
	/**
	*/

	/**
	* adds new chat room object to a list of Rooms.
	* @param room ChatRoom object
	*/
	public synchronized void addRoom(ChatRoom room)
	{
	try{	
            roomList.put(room.getName(), room);
	}catch(NullPointerException e){
                System.err.println("Sala não");
            }
        }
	/**
	* Used to remove a ChatRoom object from the
	* list of ChatRooms.
	* @param name is a String object is the name of the
	* room to be removed from the list of rooms.
	*/
	public synchronized void removeRoom(String name)
	{
            for (Iterator it = roomList.entrySet().iterator(); it.hasNext(); ) {  
            Map.Entry entry = (Map.Entry) it.next();  
            if (name.equals((String)entry.getKey()))  
                it.remove();  
            }
	}
	
	/** Returns a ChatRoom object
	* @param name is the name of the ChatRoom object to be returned.
	* @return ChatRoom object.
	*/
	public ChatRoom getRoom(String name)
	{
            //Collection<Integer> conjNomes = mapaNomes.keySet();
         
        Set<Map.Entry<String, ChatRoom>> set = roomList.entrySet();
        Iterator it = set.iterator();
                
        //getKey() - recupera a chave do mapa (a String) 
        //getValue() - recupera o valor do mapa (o Chatter)
         
        while(it.hasNext()){
            Map.Entry<String, ChatRoom> entry = (Map.Entry)it.next();
            if(entry.getKey().equals(name)){
                return (ChatRoom)entry.getValue();
            }
	}
        return null;
        }
            
	
	/** Finds the room of chatter having this name.
	* @param id is the name of the Chatter object.
	* @return ChatRoom object.
	*/
	public ChatRoom getRoomOfChatter(long id)
	{
            //Collection<Integer> conjNomes = mapaNomes.keySet();
         
        Set<Map.Entry<String, ChatRoom>> set = roomList.entrySet();
        Iterator it = set.iterator();
                
        //getKey() - recupera a chave do mapa (a String) 
        //getValue() - recupera o valor do mapa (o Chatter)
         
        while(it.hasNext()){
            Map.Entry<String, ChatRoom> entry = (Map.Entry)it.next();
            ChatRoom room = (ChatRoom)entry.getValue();
            boolean chatterexists = room.chatterExists(id);
			if (chatterexists)
			{
				return room;
			}
	}
        return null;
	}
	/** Returns a Set containing all the ChatRoom objects
	* @return Set
	*/
	
	public Set getRoomList()
	{
		return roomList.entrySet();
	}
	
	/** returns an array containing all ChatRoom objects
	* @return sukhwinder.chat.ChatRoom[]
	*/
	public ChatRoom[] getRoomListArray()
	{
		ChatRoom[] roomListArray = new ChatRoom[roomList.size()];
		Set roomlist = getRoomList();
		Iterator roomlistit = roomlist.iterator();
		int i = 0;
		while(roomlistit.hasNext())
		{
			Map.Entry me = (Map.Entry)roomlistit.next();
			String key = (String) me.getKey();
			roomListArray[i] = (ChatRoom)me.getValue();
			i++;
		}
		return roomListArray;
	}
	
	/**
	* searches each ChatRoom for existance of a chatter.
	* @param nickname Name of the chatter to find.
	* @return boolean
	
	public boolean chatterExists(long id)
	{
		boolean chatterexists = false;
		ChatRoom[] rooms = this.getRoomListArray();
		for (int i = 0; i < rooms.length; i++)
		{
			chatterexists = rooms[i].chatterExists(id);
			if (chatterexists)
			{
				break;
			}
		}
		return chatterexists;
	}*/
}