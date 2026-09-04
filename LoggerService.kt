import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

object LoggerService {
    private const val LOG_FILE = "errores.log"

    fun logError(mensaje: String, excepcion: Throwable? = null) {
        val formato = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val timestamp = formato.format(Date())
        val detalle = excepcion?.message ?: excepcion?.toString() ?: "Sin detalles adicionales"
        val linea = "[$timestamp] ERROR: $mensaje | Detalle: $detalle\n"

        try {
            File(LOG_FILE).appendText(linea)
        } catch (e: Exception) {
            System.err.println("No se pudo escribir en el archivo de log: ${e.message}")
        }
    }
}
