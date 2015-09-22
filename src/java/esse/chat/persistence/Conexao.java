/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esse.chat.persistence;

import java.sql.Connection;

/**
 *
 * @author Equipe ESSE Chat
 */
public class Conexao {
    public Connection criarConexao(){
        FabricaConexao cnx = FabricaConnOracle.getInstancia();
        Connection conexao = cnx.fazerConexao();
        return conexao;
    }
}
