fun main() {
    val sistema = SistemaLibreria()
    var opcion: Int

    println("==================================================")
    println("           BOOKMASTER UDB - CONSOLA               ")
    println("==================================================")

    do {
        println("\n--- MENÚ PRINCIPAL ---")
        println("1. Listar Catalogo de Libros")
        println("2. Agregar Nuevo Libro (CRUD)")
        println("3. Eliminar Libro")
        println("4. Procesar Venta / Reserva (Lógica de Negocio)")
        println("5. Ver Alertas de Stock Crítico")
        println("6. Reporte General del Sistema")
        println("7. Salir")
        print("Seleccione una opción: ")

        try {
            val entrada = readlnOrNull()
            opcion = entrada?.toIntOrNull() ?: throw NumberFormatException("Entrada no numérica")

            when (opcion) {
                1 -> {
                    println("\n--- CATÁLOGO DE LIBROS ---")
                    sistema.listar().forEach { l ->
                        println("[${l.id}] ${l.titulo} | Autor: ${l.autor} | Precio: $${l.precio} | Stock: ${l.stockActual} (Min: ${l.stockMinimo})")
                    }
                }
                2 -> {
                    println("\n--- REGISTRAR NUEVO LIBRO ---")
                    print("ID del libro: ")
                    val id = readln()
                    print("Título: ")
                    val titulo = readln()
                    print("Autor: ")
                    val autor = readln()
                    print("Categoría: ")
                    val cat = readln()
                    print("Precio: ")
                    val precio = readln().toDouble()
                    print("Stock Inicial: ")
                    val stock = readln().toInt()
                    print("Stock Mínimo: ")
                    val stockMin = readln().toInt()

                    sistema.agregar(Libro(id, titulo, autor, cat, precio, stock, stockMin))
                    println("✅ ¡Libro agregado exitosamente!")
                }
                3 -> {
                    print("\nIngrese el ID del libro a eliminar: ")
                    val id = readln()
                    if (sistema.eliminar(id)) {
                        println("✅ Libro eliminado correctamente.")
                    } else {
                        println("⚠️ No se encontró ningún libro con ese ID.")
                    }
                }
                4 -> {
                    println("\n--- PROCESAR VENTA DE TICKET ---")
                    val cliente = sistema.listaClientes.first() // Toma al primer cliente
                    println("Cliente seleccionado: ${cliente.nombre} (Nivel: ${cliente.nivelMembresia})")

                    print("Ingrese el ID del libro a comprar: ")
                    val idLibro = readln()
                    val libro = sistema.buscarLibroPorId(idLibro)

                    if (libro != null) {
                        print("Cantidad: ")
                        val cant = readln().toInt()
                        
                        val pedido = sistema.procesarPedido(cliente, listOf(ItemPedido(libro, cant)))
                        println("\n🎉 ¡VENTA COMPLETADA!")
                        println("Ticket Generado: ${pedido.codigoTicket}")
                        println("Total Pagado: $${pedido.total}")
                        println("Puntos Ganados: +${pedido.puntosGanados} (Total acum: ${cliente.puntosFidelidad})")
                    } else {
                        println(" Libro no encontrado.")
                    }
                }
                5 -> {
                    println("\n--- ALERTAS DE STOCK CRÍTICO ---")
                    val alertas = sistema.obtenerAlertasStock()
                    if (alertas.isEmpty()) {
                        println(" No hay libros con stock crítico por ahora.")
                    } else {
                        alertas.forEach { l ->
                            println(" ALERTA: '${l.titulo}' - Quedan ${l.stockActual} unidades (Mínimo requerido: ${l.stockMinimo})")
                        }
                    }
                }
                6 -> {
                    println("\n--- REPORTE GENERAL ---")
                    println("Total de Títulos en Sistema: ${sistema.listaLibros.size}")
                    println("Total de Pedidos Procesados: ${sistema.listaPedidos.size}")
                    println("Total Recaudado: $${sistema.listaPedidos.sumOf { it.total }}")
                }
                7 -> println("Saliendo de BookMaster UDB...")
                else -> println("⚠️ Opción inválida.")
            }
        } catch (e: Exception) {
            println("❌ Error: Ingreso de datos no válido. Se registró en el Log de errores.")
            LoggerService.logError("Error de interacción en menú principal", e)
            opcion = -1
        }

    } while (opcion != 7)
}