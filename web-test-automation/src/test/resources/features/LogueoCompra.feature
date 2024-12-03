@testRoldan
  Feature:Logueo y compra

    @LoginUsuario @HappyPath
    Scenario Outline: Iniciar sesión con credenciales válidas
    Given el usuario esta en la pagina de inicio
    And selecciona el boton de login
    And ingresa al login un nombre de usuario "<username>" y contrasenia "<password>"
    When selecciona el boton loguear
    Then se realiza el registro de manera exitosa
    Examples:
    | username    | password |
    | usuarioqwer | pass123  |

    @AgregarProducto @HappyPath
    Scenario: Agregar producto al carrito y mostrar mensaje de confirmación

      Given el usuario está en la página de productos
      When selecciona un producto
      And seleccion addtocart
      Then el sistema muestra un mensaje de "Product added."
      And el producto aparece en el carrito

