@as @mobile @articulo

Feature: Casos de prueba sobre un artículo de Diario AS en mobile

  Background:
    Given El usuario se encuentra en el artículo 'https://argentina.as.com/futbol/la-argentina-de-messi-se-rompe-n'
    And El usuario acepta el pop-up de cookies

  @AUT-28 @publicidad @severity=minor
  Scenario Outline: CP01. Carga de contenedor de tipo STICKY en el articulo de mobile
    When El usuario espera a que cargue la página por completo
    Then El usuario visualiza el elemento publicitario "<contenedor>"
    And El "<contenedor>" tiene una de las dimensiones indicadas "<dimensiones>"
    Examples:
      | contenedor | dimensiones            |
      | STICKY     | 970x90, 980x90, 728x90 |

  @AUT-29 @publicidad @severity=minor
  Scenario Outline: CP02. Carga de contenedores de tipo MLDB1 en el articulo de mobile
    When El usuario espera a que cargue el elemento "<contenedor>"
    Then El usuario visualiza el elemento publicitario "<contenedor>"
    And El "<contenedor>" tiene una de las dimensiones indicadas "<dimensiones>"
    Examples:
      | contenedor | dimensiones                               |
      | MLDB1       | 728x90, 970x250, 970x90, 980x250, 980x90 |

  @AUT-30 @publicidad @severity=minor
  Scenario Outline: CP03. Carga de contenedores de tipo MPU en el articulo de mobile
    When El usuario espera a que cargue el elemento "<contenedor>"
    And El usuario se desplaza hasta el listado de artículos
    Then El usuario visualiza el elemento publicitario "<contenedor>"
    And El "<contenedor>" tiene una de las dimensiones indicadas "<dimensiones>"
    Examples:
      | contenedor | dimensiones      |
      | MPU1       | 300x250, 300x600 |
      | MPU2       | 300x250, 300x600 |
      | MPU3       | 300x250, 300x600 |

  @AUT-31 @publicidad @severity=minor
  Scenario Outline: CP04. Carga de contenedor de tipo BTN en el articulo de mobile
    When El usuario espera a que cargue el elemento "<contenedor>"
    Then El usuario visualiza el elemento publicitario "<contenedor>"
    And El "<contenedor>" tiene una de las dimensiones indicadas "<dimensiones>"
    Examples:
      | contenedor | dimensiones      |
      | BTN1       | 300x100          |

  @AUT-32 @publicidad @severity=minor
  Scenario Outline: CP05. Carga de contenedor de tipo INTEXT en el articulo de mobile
    When El usuario espera a que cargue el elemento "<contenedor>"
    Then El usuario visualiza el elemento publicitario "<contenedor>"
    And El "<contenedor>" tiene una de las dimensiones indicadas "<dimensiones>"
    Examples:
      | contenedor | dimensiones      |
      | INTEXT     | 1x1              |