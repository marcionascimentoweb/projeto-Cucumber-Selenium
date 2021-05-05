#language: pt
#encoding: iso-8859-1

Funcionalidade: Cadastrar funcionário
como um funcionário do sistema eu quero cadastrar 
funcionário para que eu possa gerenciar funcionários.

Cenário: Cadastro de funcionário com sucesso
Sistema deverá realizar o cadastro de um funcionário com sucesso
Dado Acessar a página de cadastro de funcionário
E Informar o nome do funcionário "Sergio da Silva Mendes"
E Informar o cpf do funcionário "123.456.789-00"
E Informar a data de admissão do funcionário "25/03/2021"
E informar o resumo de atividades "Analista de Testes e Programador"
Quando Solicitar a realização do cadastro
Então Sistema informa que o cadastro do funcionário foi realizado com sucesso

Cenário: Validação de campos obrigatórios
Sistema deverá verificar a obrigatoriedade dos campos do formulário
Dado Acessar a página de cadastro de funcionário
Quando Solicitar a realização do cadastro
Então Sistema informa que todos os campos são de preenchimento obrigatório