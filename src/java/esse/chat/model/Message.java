package esse.chat.model;

import java.io.Serializable;

/**
Classe que representa uma Mensagem enviada por um usuário.
*@author Equipe ESSE Chat
*/
public class Message implements Serializable
{
	/**
	* String usada para armazenar o nome do usuário
	*/
	private String chatterName = null;
	/**
	* String contendo mensagem
	*/
	private String message = null;

	/**
	* long contendo a hora que a mensagem foi entregue
	*/
	private long timeStamp;
	
        public Message(){
            
        }
        
        
        /**
	* Esse construtor aceita um nome do usuario, mensagem e tempo
	* @param name nome do usuário
	* @param message mensagem do usuário
	* @param timeStamp tempo da mensagem
	*/
	public Message(String name, String message, long timeStamp)
	{
		this.chatterName = name;
		this.message= message;
		this.timeStamp = timeStamp;
	}
	
	/**
	* retorna o nome do usuário
	* @return String
	*/
	public String getChatterName()
	{
		return chatterName;
	}
	
	/**
	* retorna a mensagem do usuário
	* @return String
	*/
	public String getMessage()
	{
		return message;
	}
	/**
	* retorna a hora de entrega da mensagem
	* @return long
	*/
	public long getTimeStamp()
	{
		return timeStamp;
	}
}