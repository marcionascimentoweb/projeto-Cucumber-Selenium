#language: pt
#encoding: iso-8859-1

Funcionalidade: Atualizar Tipo de Contrata��o como um usu�rio do sitema 
eu quero definir o tipo de contrata��o de um funcion�rio de modo que eu
possa gerenciar funcion�rios

Esquema do Cen�rio: Definir o tipo de contrata��o de um funcion�rio com sucesso
Sistema dever� atualizar o tipo de contrata��o do funcion�rio selecionado
Dado Acessar a p�gina de atualiza��o de tipo de contrata��o
E Selecionar o funcion�rio desejado <funcionario>
E Selecionar o tipo de contrata��o <tipodecontratacao>
Quando Solicitar a atualiza��o do tipo de contrata��o do funcion�rio
Ent�o Sistema informa que o tipo de contrata��o do funcion�rio foi atualizado com sucesso 

Exemplos:
| funcionario            | tipodecontratacao |
| "Ana Paula dos Santos" | "Estagio"         |  
| "Carlos Alberto Souza" | "CLT"             |
| "Fabiana da Silva"     | "Pessoa Jur�dica" |

Cen�rio: Valida��o dos campos obrigat�rios para atualizar o tipo de contrata��o do funcion�rio
Sistema dever� informar que todos os campos s�o obrigat�rios
Dado Acessar a p�gina de atualiza��o de tipo de contrata��o
Quando Solicitar a atualiza��o do tipo de contrata��o do funcion�rio
Ent�o Sistema informa que os campos s�o obrigat�rios para atualizar os dados 

