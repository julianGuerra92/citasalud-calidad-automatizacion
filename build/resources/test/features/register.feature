# Authors: Miguelangel Vélez y Julian Rodríguez

Feature: Registro de nuevo usuario
  Como visitante,
  Quiero registrarme en el sistema,
  Para poder acceder a sus funcionalidades.

  Scenario: Registro exitoso de un nuevo usuario
    Given que quiero registrarme como nuevo usuario
    When ingreso los datos de nuevo usuario
    Then debería recibir una respuesta correcta

  Scenario Outline: Registro fallido con datos inválidos
    Given que quiero registrarme como nuevo usuario
    When ingreso los datos: "<dni>", "<password>", "<email>"
    Then debería recibir una respuesta de error del sistema

    Examples:
      | dni         | password             | email                        |
      |             |                      | lopez@gmail.com              | # Campos vacíos
      | 1234567891  | ContrasenaFuerte123* | juan.perez,gmail.com         | # Correo inválido
      | 1234567890  | ContrasenaFuerte123* | miguel.velez@udea.edu.co     | # Usuario ya registrado
      | 9876543210  | 123                  | laura.gomez@udea.edu.co      | # Contraseña corta

