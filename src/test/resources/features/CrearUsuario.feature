@02_crear_usuario
Feature: Crear nuevo usuario en OrangeHRM

  Scenario: Crear un nuevo usuario correctamente
    Given "User" abre la página web
    When Inicia sesión con las credenciales "Admin" y "admin123"
    And navega al modulo de administracion de usuarios
    And crea un nuevo usuario con username "LLOPEZ5" y password "1234567l" y confirPass "1234567l"
    Then debería ver el mensaje "Successfully Saved"