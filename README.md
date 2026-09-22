# BookMaster UDB 📚

## Descripción del proyecto

BookMaster UDB es un sistema de gestión de biblioteca desarrollado en Kotlin como parte de la Etapa 2 del proyecto de Desarrollo de Software Móvil.

El sistema permite administrar un catálogo de libros, controlar inventario, gestionar clientes y procesar ventas aplicando reglas de negocio mediante una interfaz de consola.

El proyecto implementa programación orientada a objetos, manejo de colecciones, validación de datos y registro de errores.


## Tecnologías utilizadas

- Kotlin
- Programación Orientada a Objetos (POO)
- Colecciones de Kotlin
- Consola de comandos
- Archivos de registro (.log)


## Funcionalidades principales

### Gestión de libros

Permite realizar operaciones sobre el catálogo:

- Agregar nuevos libros.
- Listar libros registrados.
- Eliminar libros.
- Validar información ingresada.


Datos administrados:

- ID del libro.
- Título.
- Autor.
- Categoría.
- Precio.
- Stock inicial.
- Stock mínimo.


### Procesamiento de ventas

El sistema permite:

- Seleccionar libros disponibles.
- Validar existencia de inventario.
- Calcular el total de compra.
- Actualizar el stock automáticamente.
- Generar un ticket de compra.
- Acumular puntos según nivel de membresía.


### Control de inventario

Incluye:

- Registro de stock actual.
- Configuración de stock mínimo.
- Detección de libros con stock crítico.


### Reporte general

Permite visualizar información del sistema:

- Total de libros registrados.
- Pedidos realizados.
- Total recaudado.


## Estructura del proyecto

Main.kt

Contiene el menú principal y la interacción con el usuario mediante consola.


SistemaLibreria.kt

Contiene la lógica principal del sistema:

- Gestión de libros.
- Clientes.
- Pedidos.
- Procesamiento de ventas.
- Alertas de stock.


Modelos.kt

Contiene las clases principales utilizadas por el sistema:

- Libro.
- Cliente.
- ItemPedido.
- Pedido.


LoggerService.kt

Administra el registro de errores generados durante la ejecución del sistema.


## Validaciones implementadas

El sistema valida:

- Campos obligatorios.
- Datos numéricos incorrectos.
- IDs duplicados.
- Títulos repetidos.
- Datos inválidos de autor y categoría.
- Stock incorrecto.
- Cantidades mayores al inventario disponible.


## Manejo de errores

El sistema utiliza excepciones para controlar errores durante la ejecución.

Los errores son registrados automáticamente en el archivo:

errores.log


## Ejecución del proyecto

Para ejecutar la aplicación utilizando el archivo generado:

java -jar App.jar


También puede ejecutarse mediante:

run.bat


## Menú principal

El sistema cuenta con las siguientes opciones:

1. Listar catálogo de libros.
2. Agregar nuevo libro.
3. Eliminar libro.
4. Procesar venta / reserva.
5. Ver alertas de stock crítico.
6. Reporte general del sistema.
7. Salir.


## Integrantes del proyecto

- Kevin Arturo Vaquerano Morales VM223215
- Hayzel Evelyn González Gutiérrez GG240801


## Estado del proyecto

Versión correspondiente a la Etapa 2 del desarrollo del sistema BookMaster UDB.
