
Feature: Registrar un usuario

  @RegistrarUsuario @HappyPath
  Scenario Outline: Registrar de manera existosa a un usuario con credenciales validas
    Given el uusuario está en la página de inicio
    And selecciona el boton de registro
    And ingresa un nombre de usuario "<username>" y contrasenia "<password>"
    When selecciona el boton registrar
    Then se realiza el registro de manera exitosa

    Examples:
      | username    | password |
      | usuarioqwer | pass123  |




