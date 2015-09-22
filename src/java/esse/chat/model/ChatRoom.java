package esse.chat.model;

import java.io.Serializable;
import java.util.Map;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/** Classe que representa uma sala de chat
*@author Equipe ESSE Chat
*/
@SuppressWarnings("serial")
@Entity 
@Table(name = "CHATROOM")
public class ChatRoom implements Serializable
{
	/*
	* usada para armazenar o nome da sala de chat
	*/
	@Id
        @SequenceGenerator(name = "CHATTER_ID_GENERATOR", sequenceName = "SEQ_CHATROOM_ID") 
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CHATTER_ID_GENERATOR")
        @Column (name = "roomid")
        private int roomid;
        @Column (name = "nome", unique = true)
	private String name;
        @Column (name = "descricao", nullable = false)
	private String description;
        @Column (nullable = true)
	private long professor = 0;
        @Column (nullable = true)
        private long monitor1 = 0;
        @Column (nullable = true)
        private long monitor2 = 0;  
        @Transient
	public Map<Long, Chatter> chatters;
	/*
	* Linked list para armazenar objetos Message
	*/
	@Transient
        private List messages = new LinkedList();
	
	/*
	* Usado para setar o número máximo de mensagens
	*/
        @Transient
	private int messages_size = 25;
        
        public ChatRoom()
	{
		chatters = new HashMap();
	}
        
        /**
        * @return the roomid
        */
       public int getRoomid() {
           return roomid;
       }

       /**
        * @param roomid the roomid to set
        */
       public void setRoomid(int roomid) {
           this.roomid = roomid;
       }

       /**
        * @return the name
        */
       public String getName() {
           return name;
       }

       /**
        * @param name the name to set
        */
       public void setName(String name) {
           this.name = name;
       }

       /**
        * @return the description
        */
       public String getDescription() {
           return description;
       }

       /**
        * @param description the description to set
        */
       public void setDescription(String description) {
           this.description = description;
       }

       /**
        * @return the professor
        */
       public long getProfessor() {
           return professor;
       }

       /**
        * @param professor the professor to set
        */
       public void setProfessor(long professor) {
           this.professor = professor;
       }

       /**
        * @return the monitor1
        */
       public long getMonitor1() {
           return monitor1;
       }

       /**
        * @param monitor1 the monitor1 to set
        */
       public void setMonitor1(long monitor1) {
           this.monitor1 = monitor1;
       }

       /**
        * @return the monitor2
        */
       public long getMonitor2() {
           return monitor2;
       }

       /**
        * @param monitor2 the monitor2 to set
        */
       public void setMonitor2(long monitor2) {
           this.monitor2 = monitor2;
       }
        
        
	/**
	* Este construtor recebe um nome e descrição
        * Para criar uma nova ChatRoom
	* @param name Nome da sala
	* @param descr Descrição da sala
	*/
	public ChatRoom(String name, String descr)
	{
                this.name= name;
		this.description = descr;
                chatters = new HashMap();
	}
	
        public ChatRoom(int id, String name, String descr, long prof, long mt1, long mt2)
	{
                this.roomid = id;
                this.name= name;
		this.description = descr;
                this.professor = prof;
                this.monitor1 = mt1;
                this.monitor2 = mt2;
                chatters = new HashMap();
	}
	
	
	/**
	* Adiciona usuário à lista
     	* @param chatter usuário
	*/
	public synchronized void addChatter(Chatter chatter)
	{
                chatters.put(chatter.getId(), chatter);
           
	}
	
	
	/**
	* Retorna usuário da lista.
	* @param id nome do usuário
	* @return esse.chat.Chatter
	*/
	public Chatter getChatter(long id)
	{
		return (Chatter)chatters.get(id);
	}
	
	/**
	* verifica se um participante existe ou não
	* @param id nome do usuário para checar
	* @return boolean
	*/
	public boolean chatterExists(long id)
	{
           return chatters.containsKey(id);
        }
	
            
	
	
	/**
	* retorna número total de usuários na sala
	* @return int
	*/
	public int getNoOfChatters()
	{
		return chatters.size();
	}
	
	/**
	* Retorna um conjunto contendo todos os usuários da sala
	* @return java.util.Set
	*/
	public Set getChatters()
	{
            return chatters.entrySet();
        }
        
	public Map getMapChatters()
	{
            return chatters;
        }
	
	/** retorna um array contendo todos os usuários
	* @return esse.chat.Chatter[]
	*/
	public Chatter[] getChattersArray()
	{
		Chatter[] chattersArray = new Chatter[chatters.size()];
		Set myChatters = getChatters();
		Iterator chattersit = myChatters.iterator();
		int i = 0;
		while(chattersit.hasNext())
		{
			Map.Entry me = (Map.Entry)chattersit.next();
			long key = (long) me.getKey();
			chattersArray[i] = (Chatter)me.getValue();
			i++;
		}
		return chattersArray;
	}
	
	/** Adiciona uma mensagemà lista de mensagens
	* @param msg objeto mensagem
	*/
	public synchronized void addMessage(Message msg)
	{
		if(messages.size()==messages_size)
		{
			((LinkedList)messages).removeFirst();
		}
		messages.add(msg);
	}
	
	/**
	* retorna um objecto ListIterator contendo todas as mensagens
	* @return java.util.ListIterator
	*/	
	public ListIterator getMessages()
	{
		return messages.listIterator();
	}

	/**
	* Retorna um array de mensagens enviadas após determinado tempo
	* @param afterTimeStamp Time in milliseconds.
	* @return array
	*/	
	public Message[] getMessages(long afterTimeStamp)
	{
		ListIterator li = messages.listIterator();
		List temp = new ArrayList();
		Message m;
		while (li.hasNext())
		{
			m = (Message)li.next();
			if (m.getTimeStamp() >= afterTimeStamp)
			{
				temp.add(m);
			}
		}
		Object o[] = temp.toArray();
		Message[] arr = new Message[o.length];
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = (Message)o[i];
		}
		return arr;
	}

	/**
	* Retorna o número total de mensagens na lista de mensagens
	* @return int
	*/
	public int getNoOfMessages()
	{
		return messages.size();
	}
	
	/**
	* Define tamanho máximo de mensagens.
	* @param size
	*/
	public void setMaximumNoOfMessages(int size)
	{
		messages_size = size;
	}
	
	/**
	* retorna número maxmium de mensagens definidas.
	* @return int
	*/
	public int getMaxiumNoOfMessages()
	{
		return messages_size;
	}
        

}