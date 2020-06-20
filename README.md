## Descripción
Platzi - Curso de Hibernate y Java Spring - App Spring Boot

## Docker - Instalación y ejecución
1. Descargar la imagen de postgres.
<br>`docker pull postgres:9.6.6-alpine`
2. Ejecutar la imagen para crear el contenedor.
<br>`docker run -d --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=platzi postgres:9.6.6-alpine`
3. Iniciar el contenedor ya existente (si está abajo).
<br>`docker start postgres`
- Ver el estado de los contenedores actuales.
<br>`docker ps -a`
- Eliminar un contenedor de manera forzada.
<br>`docker rm -f postgres`

## Proyecto Spring Boot.
- Se debe instalar el Plugin de [Lombok](http://www.advlatam.com/en/lombok-a-library-to-code-more-cleanly/) en IntelliJ IDEA para que tome las anotaciones AllArgsConstructor, Data, que tome los getters y setters, entre otros.
- El contenedor docker debe estar arriba antes de iniciar el proyecto de Spring Boot.
    > El lo que hará es que a través del archivo [**application.yaml**](https://github.com/cesardramirez/e-reservation/blob/master/src/main/resources/application.yaml#L9) es crear la base de datos por medio de Hibernate por primera vez a través de los modelos.