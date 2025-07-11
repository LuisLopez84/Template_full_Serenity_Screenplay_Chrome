@_03_consultar_usuario
Feature: Consultar usuario en OrangeHRM

  Scenario: Consultar un usuario existente
    Given "User" abre la página web
    When Inicia sesión con las credenciales "Admin" y "admin123"
    And consulta al usuario con username "LLOPEZ5"
    Then debería ver el usuario con nombre "LLOPEZ5"