@as @mobile @portada

Feature: Casos de prueba sobre la página principal de Diario AS en mobile

  Background:
    Given El usuario se encuentra en la página de inicio
    And El usuario acepta el pop-up de cookies

  @AUT-24 @publicidad @severity=minor
  Scenario Outline: CP01. Carga de contenedor de tipo STICKY en la portada de mobile
    When El usuario espera a que cargue la página por completo
    And El usuario se desplaza hasta el listado de artículos
    Then El usuario visualiza el elemento publicitario "<contenedor>"
    And El "<contenedor>" tiene una de las dimensiones indicadas "<dimensiones>"
    Examples:
      | contenedor | dimensiones            |
      | STICKY     | 970x90, 980x90, 728x90 |

  @AUT-25 @publicidad @severity=minor
  Scenario Outline: CP02. Carga de contenedor de tipo MLDB1 en la portada de mobile
    When El usuario espera a que cargue el elemento "<contenedor>"
    Then El usuario visualiza el elemento publicitario "<contenedor>"
    And El "<contenedor>" tiene una de las dimensiones indicadas "<dimensiones>"
    Examples:
      | contenedor | dimensiones                               |
      | MLDB1       | 728x90, 970x250, 970x90, 980x250, 980x90 |

  @AUT-26 @publicidad @severity=minor
  Scenario Outline: CP03. Carga de contenedores de tipo MPU en la portada de mobile
    When El usuario espera a que cargue el elemento "<contenedor>"
    Then El usuario visualiza el elemento publicitario "<contenedor>"
    And El "<contenedor>" tiene una de las dimensiones indicadas "<dimensiones>"
    Examples:
      | contenedor | dimensiones      |
      | MPU1       | 300x250, 300x600 |
      | MPU2       | 300x250, 300x600 |
      | MPU3       | 300x250, 300x600 |