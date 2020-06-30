


Feature:  Validacion busqueda

  Scenario: Validacion busqueda en google de: "Sophos solutions":
  
    Given Abrir google crome y ingresar la url de google  
    When Ingresar buqueda
    Then Validar resultado
    
    	| resul |
			| 5.410.000 |