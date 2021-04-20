#language: pt
#encoding: UTF-8
Funcionalidade: Desafios Globo
	
  Esquema do Cenario: Assistir programa
    Dado que eu acesso a URL do Globoplay
    Quando realizo a busca pelo <programa>
    E clico para Assistir
    Entao devo conseguir assistir o programa

    Exemplos: 
      | programa  				 		 | 
      | Sinta-se em Casa  		 |
       
      
   Esquema do Cenario: Verificar consumo de programa
    Dado que eu acesso a URL do Globoplay
    E faço login 
    E após logar, realizo a busca pelo <programa>
    E clico para Assistir
    Quando assisto alguns segundos do programa
    E clico para voltar para a tela do programa
    Entao o contador do progresso deve ser atualizado com o tempo assistido

    Exemplos: 
      | programa  				 		 | 
      | Sinta-se em Casa  		 | 