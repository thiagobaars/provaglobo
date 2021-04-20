#language: pt
#encoding: UTF-8
Funcionalidade: Desafios Sicredi
	
  Esquema do Cenario: Desafio 1
    Dado que eu acesso a URL do teste
    E mudo o valor da combo Select version para "Bootstrap V4 Theme"
    E clico no botão Add Customer
    Quando eu preencho os campos do formulário <name> , <lastName> , <contactFirstName> , <phone> , <adressLine1> , <adressLine2> , <city> , <state> , <postalCode> , <country> , <fromEmployer> , <creditLimit>
    E clico no botão Save
    Entao devo validar a mensagem "Your data has been successfully stored into the database."

    Exemplos: 
      | name  				| lastName | contactFirstName  | phone 				| adressLine1 					| adressLine2 | city 				 | state | postalCode | country | fromEmployer | creditLimit |
      | Teste Sicredi | Teste		 | Thiago						 | 51 9999-9999 | Av Assis Brasil, 3970 | Torre D		  | Porto Alegre | RS		 | 91000-000  | Brasil  | Fixter 			 | 200			   |

      
	Esquema do Cenario: Desafio 2
    Dado que eu executo todos os steps do Desafio 1 <name> , <lastName> , <contactFirstName> , <phone> , <adressLine1> , <adressLine2> , <city> , <state> , <postalCode> , <country> , <fromEmployer> , <creditLimit> , <comboVersion> , <mensagem>
    E clico no link go back to list
    Quando eu clicar na coluna Search Name e digitar o conteúdo do campo <name>
    E clicar no Checkbox
    E clicar no botão Delete
    Entao devo validar a mensagem "Are you sure that you want to delete this 1 item?"
    E dentro da popup, clicar no botão Delete
    E devo validar a mensagem que aparece no canto direito da tela "Your data has been successfully deleted from the database."

    Exemplos: 
      | name 				  | lastName | contactFirstName  | phone 				| adressLine1 					| adressLine2 | city 				 | state | postalCode | country | fromEmployer | creditLimit | comboVersion				| mensagem 																									|
      | Teste Sicredi | Teste		 | Thiago						 | 51 9999-9999 | Av Assis Brasil, 3970 | Torre D		  | Porto Alegre | RS		 | 91000-000  | Brasil  | Fixter 			 | 200			   | Bootstrap V4 Theme | Your data has been successfully stored into the database. |