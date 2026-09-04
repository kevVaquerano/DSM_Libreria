// Interfaz para aplicar POO
interface IGestionable<T> {
    fun agregar(item: T)
    fun listar(): List<T>
    fun eliminar(id: String): Boolean
}

class SistemaLibreria : IGestionable<Libro> {
    val listaLibros = mutableListOf<Libro>()
    val listaPedidos = mutableListOf<Pedido>()
    val listaClientes = mutableListOf<Cliente>()

    init {
        // Carga inicial de datos de prueba
        listaLibros.add(Libro("L01", "El Principito", "A. Saint-Exupéry", "Ficción", 12.0, 8, 3))
        listaLibros.add(Libro("L02", "Clean Code", "Robert C. Martin", "Tecnología", 35.0, 2, 5)) // En Stock Crítico
        listaLibros.add(Libro("L03", "Kotlin Programming", "Big Nerd Ranch", "Tecnología", 45.0, 10, 4))

        listaClientes.add(Cliente("C01", "Hayzel González", "hayzel@udb.edu.sv", "PLATA", 50))
        listaClientes.add(Cliente("C02", "Kevin Vaquerano", "kevin@udb.edu.sv", "ORO", 120))
    }

    override fun agregar(item: Libro) {
        listaLibros.add(item)
    }

    override fun listar(): List<Libro> = listaLibros

    override fun eliminar(id: String): Boolean {
        return listaLibros.removeIf { it.id.lowercase() == id.lowercase() }
    }

    fun buscarLibroPorId(id: String): Libro? {
        return listaLibros.find { it.id.lowercase() == id.lowercase() }
    }

    // Lógica de Negocio 1: Filtrar libros con Stock Crítico
    fun obtenerAlertasStock(): List<Libro> {
        return listaLibros.filter { it.stockActual <= it.stockMinimo }
    }

    // Lógica de Negocio 2: Procesar Compra y Acumular Puntos (Fidelización)
    fun procesarPedido(cliente: Cliente, items: List<ItemPedido>): Pedido {
        var total = 0.0
        
        for (item in items) {
            if (item.libro.stockActual < item.cantidad) {
                throw IllegalArgumentException("Stock insuficiente para: ${item.libro.titulo}")
            }
            total += item.libro.precio * item.cantidad
        }

        // Aplicar factor de puntos según membresía
        val factor = when (cliente.nivelMembresia.uppercase()) {
            "ORO" -> 2.0
            "PLATA" -> 1.5
            else -> 1.0 // BRONCE
        }

        val puntosGanados = (total * factor).toInt()
        cliente.puntosFidelidad += puntosGanados

        // Actualizar Stock Dinámicamente
        for (item in items) {
            item.libro.stockActual -= item.cantidad
        }

        val codigoTicket = "UDB-${(1000..9999).random()}"
        val nuevoPedido = Pedido(codigoTicket, cliente, items, total, puntosGanados)
        listaPedidos.add(nuevoPedido)

        return nuevoPedido
    }
}