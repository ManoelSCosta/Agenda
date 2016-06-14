# Agenda
Agenda de compromissos

# Ferramentas utilizadas
Banco de dados MySQL versao 5.7.13.0, Eclipse Mars 2, Android Studio 2.1.1, Tomcat 7

# Instrucoes para configuracao do ambiente
1 - Baixar os arquivos dos projetos (https://github.com/victor-machado/agenda-services.git e https://github.com/victor-machado/Agenda.git)
2 - Baixar e instalar o MySQL (http://dev.mysql.com/downloads/mysql/), o Eclipse (http://www.eclipse.org/downloads/packages/), e o Android Studio (https://developer.android.com/studio/index.html)
3 - No MySQL Workbench criar o banco de dados e as tabelas com os scripts sql localizado no projeto agenda-services/sql/agenda_compromissos.txt
4 - Baixar o Tomcat (https://tomcat.apache.org/download-70.cgi) e colocar em diretorio de preferencia
5 - Abrir o Eclipse
6 - Configurar o servidor no Eclipse, na aba 'servers' adicionar um novo servidor com o caminho apontando para a pasta do Tomcat baixado
7 - No workspace do Eclipse importar um projeto maven com o caminho apontando para o diretorio do projeto agenda-services, fazer um clean no projeto e depois clicando com o botao direito na pasta do projeto selecionar Maven>Update project
8 - Na pasta 'Servers/Tomcat v7.0 Server at localhost-config' criada no workspace do projeto alterar o arquivo server.xml substituindo a tag <Connector connectionTimeout="20000" port="8081" protocol="HTTP/1.1" redirectPort="8443"/> para evitar conflitos de porta
9 - Clicar com o botao direito no servidor, selecionar a opcao de adicionar e remover e incluir o projeto no servidor
10 - Iniciar o servidor
11 - Abrir o Android Studio
12 - Importar o projeto Agenda
13 - Iniciar um emulador
14 - Rodar o aplicativo no emulador
