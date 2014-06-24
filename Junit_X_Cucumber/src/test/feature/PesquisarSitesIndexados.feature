#language: pt
Funcionalidade: Pesquisar sites indexados

  Cenário: Pesquisar um termo que esteja presente em sites indexados
    Dado que exista pelo menos um site indexado contendo o termo "Cucumber"
    Quando faço uma pesquisa por esse termo
    Então resultado de busca exibe todos os sites com o termo pesquisado

  Cenário: Pesquisar por um termo que não esteja presente em nenhum site indexado
    Dado que o termo "dsfasdfasfdasfasfasfdasdfasfasfsaf" não esteja presente em nenhum site indexado
    Quando faço uma pesquisa por esse termo
    Então o resultado de busca exibe uma mensagem informando que o termo não nenhum site correspondente
