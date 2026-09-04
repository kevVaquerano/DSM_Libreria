data class Libro(
    val id: String,
    val titulo: String,
    val autor: String,
    val categoria: String,
    val precio: Double,
    var stockActual: Int,
    val stockMinimo: Int
)

data class Cliente(
    val id: String,
    val nombre: String,
    val email: String,
    val nivelMembresia: String,
    var puntosFidelidad: Int
)

data class ItemPedido(
    val libro: Libro,
    val cantidad: Int
)

data class Pedido(
    val codigoTicket: String,
    val cliente: Cliente,
    val items: List<ItemPedido>,
    val total: Double,
    val puntosGanados: Int
)
