Neste projeto desenvolvi um programa com JDBC utilizando DAO.
Caso você queira testar, sinta-se livre para pegar uma query inicial que deixei
disponível na pasta "sqlQueries".

Este é um programa ainda em desenvolvimento, então futuramente pretendo atualizar
para colocar mais outras tabelas.

A conexão também é algo personalizado para você,
aqui eu utilizei um driver do SQL server.

Também deixei um espaço na variável de conexão
para você colocar o nome da sua máquina. E por
padrão a porta do sql server é 1433, mas isso
pode mudar dependendo da sua variável de ambiente.

Vale mencionar que utilizei uma conexão
com integrated security. Sinta-se
livre para customizar essa conexão
caso queira inserir credenciais como
login e senha utilizando a seguinte estrutura:

private static final String DATABASE_URL = "jdbc:sqlserver://SEU-SERVIDOR:1433;databaseName=biblioteca;user=SEU-USUARIO;password=SUA-SENHA;encrypt=false;";

Sinta-se a vontade para testar!