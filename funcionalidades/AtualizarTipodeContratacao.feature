#language: pt
#encoding: iso-8859-1

Funcionalidade: Atualizar Tipo de Contratação como um usuário do sitema 
eu quero definir o tipo de contratação de um funcionário de modo que eu
possa gerenciar funcionários

Esquema do Cenário: Definir o tipo de contratação de um funcionário com sucesso
Sistema deverá atualizar o tipo de contratação do funcionário selecionado
Dado Acessar a página de atualização de tipo de contratação
E Selecionar o funcionário desejado <funcionario>
E Selecionar o tipo de contratação <tipodecontratacao>
Quando Solicitar a atualização do tipo de contratação do funcionário
Então Sistema informa que o tipo de contratação do funcionário foi atualizado com sucesso 

Exemplos:
| funcionario            | tipodecontratacao |
| "Ana Paula dos Santos" | "Estagio"         |  
| "Carlos Alberto Souza" | "CLT"             |
| "Fabiana da Silva"     | "Pessoa Jurídica" |

Cenário: Validação dos campos obrigatórios para atualizar o tipo de contratação do funcionário
Sistema deverá informar que todos os campos são obrigatórios
Dado Acessar a página de atualização de tipo de contratação
Quando Solicitar a atualização do tipo de contratação do funcionário
Então Sistema informa que os campos são obrigatórios para atualizar os dados 

