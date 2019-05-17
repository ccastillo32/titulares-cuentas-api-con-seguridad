## titulares-cuentas-api-con-seguridad

API rest para la gestión de titulares de cuentas
Ejercicio #1 de la prueba técnica. (Bonus de autenticación)

Como Bonus, se implementó para el API REST, autenticación con Spring Security, Oauth2 y JWTComo Bonus, 
se implementó para el API REST, autenticación con Spring Security, Oauth2 y JWT
También, permite la creación de nuevos usuarios para que puedan autenticarse en la aplicación


### Font-end correspondiente

La parte front-end de este proyecto se encuentra en el siguiente repositorio:
https://github.com/ccastillo32/titulares-cuentas-frontend-con-seguridad

### Software requerido

MySQL (Se usó el community server 8.0.16)

### Configuración, antes de ejecutar

- En la base de datos MySQL crear una base de datos llamada titulares_cuentas

- Editar las siguientes entradas del archivo src/main/resources/application.properties, por los valores configurados en su base de datos:
spring.datasource.username=root
spring.datasource.password=2008

- El script de inicialización de las tablas se encuentra en src/main/resources/schema.sql, dicho script se ejecutará automaticamente al iniciar la aplicación.

- Las tablas se re-crean cada vez que inicia la applicación ejecutando los archivos schema.sql y data.sql, se entiende que esto no se debe hacer para producción, pero se deja de esta manera para facilitar la revisión del examen.

- Tener en cuenta que la aplicación corre por el puerto 8091, para evitar conflictos con el 8080. Cambiar dicho valor si lo considera necesario.

### Observaciones en cuanto al negocio:

Consultando información en Internet, se llegó a la conclusión de que el CUIT debería ser de esta manera:
El cuit debe empezar por 20, 23, 24 o 23 para titulares físicos.
El cuit debe empezar por 30, 33 o 34 para titulares jurídicos.

- Asi entonces el CUIT debe tener el siguiente formato:
(20|23|24|27|30|33|34)-XXXXXXXX-X
Es decir, empezar por 20, 23, 24 .. etc.
Seguido de 8 numeros, y un último numero verificador. Todo separado por guiones.

- El nombre/apellido del titular solo acepta letras o espacios.
Pero esto no aplica para la razón social. Ya que puede tener caracteres especiales y números, por ejemplo, Mi empresa #2

- El año de fundación no puede ser mayor al año actual.

- La aplicación valida que no se creen dos titulaes con el mismo CUIT, sin embargo, Los titulares, al momento de eliminar, no se elimina realmente, se inhabilitan.
Asi que, el CUIT que se inhabilitó queda disponible para un nuevo titular.

### Observación en cuanto a código

Desde un inicio se tuvo en cuenta aprovechar el uso de la herencia de JPA, para poder grabar un titular sin preocuparnos por los detalles de si es un titular físico o jurídico,
Para ello se creó la clase padre Titular.
Apoyada también por la anotación @Inheritance(strategy = InheritanceType.JOINED)

### Observación final

Se nombró el proyecto como titulares-cuentas-api-new, ya que se refactorizó en este nuevo proyecto.
La idea era eliminarle el 'new' antes de entregarlo.


