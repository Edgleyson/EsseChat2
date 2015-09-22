<!DOCTYPE html>
<!-- Escrito pela Equipe ESSE para a Disciplina WEB2 - TADS - IFPE -->

<%@ page errorPage="error.jsp" %>

<html>
    <head>
        <title>ESSE Chat: Cadastro</title>
        <script>
        if(window.top !== window.self)
        {
            window.top.location = window.location;
        }
        </script>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/chat.css">
        <meta name="Author" content="Equipe ESSE Chat (Edgleyson, Edlas, Saulo e Sérgio)">
    </head>
    <body onLoad="document.login.name.focus();">
        <header>
            <%@ include file="pageheader.html" %>
        </header>
        <div class="formcadastro">
                <form name="login" id="formCadastro" method="post" action="<%=request.getContextPath()%>/control/CadastraChatterServlet">

                    <label for="name" class="white">Nome: </label><br/>
                    <input type="text" id="name" name="name" size="30" placeholder="Nome Completo"><br/>
                    
                    <label for="nick" class="white">Nickname: </label><br/>
                    <input type="text" id="nick" name="nickname" size="10" placeholder="Apelido"><br/>

                    <label for="day" class="white">Data de nascimento: </label><br/>
                    <select aria-label="Dia" name="birthday_day" id="day" title="Dia" class="_5dba">
        <option value="0">Dia</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="13">13</option>
        <option value="14">14</option>
        <option value="15">15</option>
        <option value="16">16</option>
        <option value="17">17</option>
        <option value="18">18</option>
        <option value="19">19</option>
        <option value="20">20</option>
        <option value="21">21</option>
        <option value="22">22</option>
        <option value="23">23</option>
        <option value="24">24</option>
        <option value="25">25</option>
        <option value="26">26</option>
        <option value="27">27</option>
        <option value="28">28</option>
        <option value="29">29</option>
        <option value="30">30</option>
        <option value="31">31</option>
    </select>
    <select aria-label="M&#xea;s" name="birthday_month" id="month" title="M&#xea;s" class="_5dba">
        <option value="0">Mês</option>
        <option value="1">Jan</option>
        <option value="2">Fev</option>
        <option value="3">Mar</option>
        <option value="4">Abr</option>
        <option value="5">Maio</option>
        <option value="6">Jun</option>
        <option value="7">Jul</option>
        <option value="8">Ago</option>
        <option value="9">Set</option>
        <option value="10">Out</option>
        <option value="11">Nov</option>
        <option value="12">Dez</option>
    </select>
    <select aria-label="Ano" name="birthday_year" id="year" title="Ano" class="_5dba">
        <option value="0">Ano</option>
        <option value="2000">2000</option>
        <option value="1999">1999</option>
        <option value="1998">1998</option>
        <option value="1997">1997</option>
        <option value="1996">1996</option>
        <option value="1995">1995</option>
        <option value="1994">1994</option>
        <option value="1993">1993</option>
        <option value="1992">1992</option>
        <option value="1991">1991</option>
        <option value="1990">1990</option>
        <option value="1989">1989</option>
        <option value="1988">1988</option>
        <option value="1987">1987</option>
        <option value="1986">1986</option>
        <option value="1985">1985</option>
        <option value="1984">1984</option>
        <option value="1983">1983</option>
        <option value="1982">1982</option>
        <option value="1981">1981</option>
        <option value="1980">1980</option>
        <option value="1979">1979</option>
        <option value="1978">1978</option>
        <option value="1977">1977</option>
        <option value="1976">1976</option>
        <option value="1975">1975</option>
        <option value="1974">1974</option>
        <option value="1973">1973</option>
        <option value="1972">1972</option>
        <option value="1971">1971</option>
        <option value="1970">1970</option>
        <option value="1969">1969</option>
        <option value="1968">1968</option>
        <option value="1967">1967</option>
        <option value="1966">1966</option>
        <option value="1965">1965</option>
        <option value="1964">1964</option>
        <option value="1963">1963</option>
        <option value="1962">1962</option>
        <option value="1961">1961</option>
        <option value="1960">1960</option>
        <option value="1959">1959</option>
        <option value="1958">1958</option>
        <option value="1957">1957</option>
        <option value="1956">1956</option>
        <option value="1955">1955</option>
        <option value="1954">1954</option>
        <option value="1953">1953</option>
        <option value="1952">1952</option>
        <option value="1951">1951</option>
        <option value="1950">1950</option>
        <option value="1949">1949</option>
        <option value="1948">1948</option>
        <option value="1947">1947</option>
        <option value="1946">1946</option>
        <option value="1945">1945</option>
        <option value="1944">1944</option>
        <option value="1943">1943</option>
        <option value="1942">1942</option>
        <option value="1941">1941</option>
        <option value="1940">1940</option>
        <option value="1939">1939</option>
        <option value="1938">1938</option>
        <option value="1937">1937</option>
        <option value="1936">1936</option>
        <option value="1935">1935</option>
        <option value="1934">1934</option>
        <option value="1933">1933</option>
        <option value="1932">1932</option>
        <option value="1931">1931</option>
        <option value="1930">1930</option>
        <option value="1929">1929</option>
        <option value="1928">1928</option>
        <option value="1927">1927</option>
        <option value="1926">1926</option>
        <option value="1925">1925</option>
        <option value="1924">1924</option>
    </select><br/>
                    
                    <label for="sex" class="white">Sexo:&nbsp;</label><br/>
                    <select size="1" id="sex" name="sex">
                        <option value="m">
                            Masculino
                        </option>
                        <option value="f">
                            Feminino
                        </option>
                    </select><br/>
                    <label for="email" class="white">E-mail: </label><br/>
                    <input type="email" id="email" name="email" size="30" placeholder="seuemail@com"><br/>
                    
                    <label for="email2" class="white">Confirme seu E-mail: </label><br/>
                    <input type="email" id="email2" name="email2" size="30" placeholder="seuemail@com"><br/>
                    
                    <label for="senha" class="white">Digite uma Senha: </label><br/>
                    <input type="password" id="senha" name="senha" size="15"><br/>
                    
                    <label for="senha2" class="white">Confirme sua Senha: </label><br/>
                    <input type="password" id="senha2" name="senha2" size="15"><br/>
                    
                    <input type="hidden" name="iduser" value="1"><br/>
                    
         <input type="submit" class="botao" name="Submit" value="Cadastrar">

                </form>
            </div>
    </body>

</html>