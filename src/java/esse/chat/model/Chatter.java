package esse.chat.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
* Esta classe representa uma usuário na sala de chat.
* @author Equipe ESSE Chat
*/
@SuppressWarnings("serial")
@Entity 
@Table(name = "CHATTER")
public class Chatter implements Serializable
{
        private static final long serialVersionUID = 1L;  
        
        @Id
        @SequenceGenerator(name = "CHATTER_ID_GENERATOR", sequenceName = "SEQ_CHATTER_ID") 
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CHATTER_ID_GENERATOR")  
         
        @Column (name = "userid")
	private long id;
        @Column (name = "nome", nullable = false)
        private String name;
        @Column (name = "nickname", unique = true)
        private String nick = null;
        @Column (name = "senha", nullable = false)
        private String senha;
        @Column (name = "sexo", nullable = false)
	private String sex;
        @Column (nullable = false)
        private String nascimento;
        @Column (nullable = false)
	private String email;
        @Column (nullable = false)
	private int status;
        @Transient
        private int idade = 0;
        @Transient
        private long loginTime = -1;
        @Transient
	private long enteredInRoomAt = -1;

    public Chatter() {        
    }
        
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    
     /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param nome the name to set
     */
    public void setName(String nome) {
        this.name = nome;
    }

    /**
     * @return the nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * @param nick the nick to set
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sexo the sex to set
     */
    public void setSex(String sexo) {
        this.sex = sexo;
    }

    /**
     * @return the nascimento
     */
    public String getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    private int calculaIdade(String nascimento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
    * retorna o tempo de login em milisegundos
    * @return 
    */
	public long getLoginTime()
	{
		return loginTime;
	}

	/**
	* Define o tempo em milésimos de segundo, quando um usuário entrou em uma sala.
        * Usado para exibir apenas as mensagens enviadas após uma pessoa entrar em uma sala.
        * @param enteredAt
	*/

	public void setEnteredInRoomAt(long enteredAt)
	{
		this.enteredInRoomAt = enteredAt;
	}
	/**
	* Retorna o tempo em milésimos de segundo, quando um usuário entrou em uma sala.
        * Usado para exibir apenas as mensagens enviadas após uma pessoa entrar em uma sala.
	* @return long tempo em milisegundos
	*/
	public long getEnteredInRoomAt()
	{
		return enteredInRoomAt;
	}

     
    public Chatter(long id, String nick, String nome, String sexo, String senha, String nasc, String email, int status, long loginTime) {
        this.id = id;
        this.nick = nick;
        this.name = nome;
        this.sex = sexo;
        this.senha = senha;
        this.nascimento = nasc;
        this.email = email;
        this.status = status;
        this.loginTime = loginTime;
    }
    
        
    public Chatter(String nome, String nick, String sexo, String senha, String nasc, String email, int status) {
        this.name = nome;
        this.nick = nick;
        this.sex = sexo;
        this.senha = senha;
        this.nascimento = nasc;
        this.email = email;
        this.status = status;
    }
}