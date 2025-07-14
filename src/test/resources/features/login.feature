# Authors: Miguelangel Vélez y Julian Rodríguez

Feature: Inicio de sesión de usuario
  Como usuario registrado,
  Quiero iniciar sesión con mi cédula y contraseña,
  Para acceder a las funcionalidades protegidas.

  Scenario: Inicio de sesión exitoso con credenciales válidas
    Given que soy un usuario registrado
    When ingreso mis credenciales válidas
    Then debería ver una respuesta exitosa del sistema

  Scenario: Inicio de sesión fallido con credenciales inválidas
    Given que soy un usuario registrado
    When ingreso credenciales inválidas
    Then debería ver una respuesta de error del sistema