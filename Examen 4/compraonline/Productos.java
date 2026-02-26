// Pablo Manuel Fernández Velázquez
// Versión mejorada: campos encapsulados, validación real de fecha, equals/hashCode.

package compraonline;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Objects;

public class Productos {

    private static final DateTimeFormatter FORMATO_FECHA =
            DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

    private final String nombre;
    private final String marca;
    private final LocalDate fechaDeRegistro;

    public Productos(String nombre, String marca, String fechaDeRegistro) {
        this.nombre = normalizarObligatorio(nombre, "nombre");
        this.marca = normalizarObligatorio(marca, "marca");
        this.fechaDeRegistro = parseFecha(fechaDeRegistro);
    }

    private static String normalizarObligatorio(String s, String campo) {
        Objects.requireNonNull(s, "El campo " + campo + " no puede ser null");
        String t = s.trim();
        if (t.isEmpty()) throw new IllegalArgumentException("El campo " + campo + " no puede estar vacío");
        return t;
    }

    private static LocalDate parseFecha(String fecha) {
        Objects.requireNonNull(fecha, "fechaDeRegistro");
        try {
            return LocalDate.parse(fecha.trim(), FORMATO_FECHA);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Fecha incorrecta (usa dd/MM/yyyy): " + fecha, e);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public LocalDate getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s%nMarca: %s%nFecha de registro: %s",
                nombre, marca, fechaDeRegistro.format(FORMATO_FECHA));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Productos)) return false;
        Productos that = (Productos) o;
        return nombre.equalsIgnoreCase(that.nombre)
                && marca.equalsIgnoreCase(that.marca)
                && fechaDeRegistro.equals(that.fechaDeRegistro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), marca.toLowerCase(), fechaDeRegistro);
    }
}
