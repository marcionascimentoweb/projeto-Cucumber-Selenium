#language: pt
#encoding: iso-8859-1

Funcionalidade: Cadastrar funcion�rio
como um funcion�rio do sistema eu quero cadastrar 
funcion�rio para que eu possa gerenciar funcion�rios.

Cen�rio: Cadastro de funcion�rio com sucesso
Sistema dever� realizar o cadastro de um funcion�rio com sucesso
Dado Acessar a p�gina de cadastro de funcion�rio
E Informar o nome do funcion�rio "Sergio da Silva Mendes"
E Informar o cpf do funcion�rio "123.456.789-00"
E Informar a data de admiss�o do funcion�rio "25/03/2021"
E informar o resumo de atividades "Analista de Testes e Programador"
Quando Solicitar a realiza��o do cadastro
Ent�o Sistema informa que o cadastro do funcion�rio foi realizado com sucesso

Cen�rio: Valida��o de campos obrigat�rios
Sistema dever� verificar a obrigatoriedade dos campos do formul�rio
Dado Acessar a p�gina de cadastro de funcion�rio
Quando Solicitar a realiza��o do cadastro
Ent�o Sistema informa que todos os campos s�o de preenchimento obrigat�rio