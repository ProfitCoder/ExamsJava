// Pablo Manuel Fernández Velázquez
// Versión mejorada: ID por instancia, lista dinámica con límite, comparaciones correctas.

package compraonline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Vendedores {

    public static final int MAX_PRODUCTOS = 5;

    private static int nextId = 1;

    private final int id;
    private final String nombre;
    private final List<Productos> productos = new ArrayList<>(MAX_PRODUCTOS);

    public Vendedores(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "nombre").trim();
        if (this.nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del vendedor no puede estar vacío");
        }
        this.id = nextId++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public List<Productos> getProductos() {
        return Collections.unmodifiableList(productos);
    }

    /** Añade un producto si hay espacio y si no está duplicado por nombre+marca+fecha. */
    public boolean anadirProducto(Productos producto) {
        Objects.requireNonNull(producto, "producto");
        if (productos.size() >= MAX_PRODUCTOS) return false;
        if (productos.contains(producto)) return false;
        return productos.add(producto);
    }

    /** Elimina el primer producto cuyo nombre coincida (case-insensitive). */
    public boolean eliminarProducto(String nombreProducto) {
        if (nombreProducto == null || nombreProducto.trim().isEmpty()) return false;
        String buscado = nombreProducto.trim();

        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equalsIgnoreCase(buscado)) {
                productos.remove(i);
                return true;
            }
        }
        return false;
    }

    /** Devuelve el producto si existe; si no, null. */
    public Productos buscarProducto(String nombreProducto) {
        if (nombreProducto == null || nombreProducto.trim().isEmpty()) return null;
        String buscado = nombreProducto.trim();

        for (Productos p : productos) {
            if (p.getNombre().equalsIgnoreCase(buscado)) return p;
        }
        return null;
    }

    /** Texto para imprimir productos de forma bonita. */
    public String listarProductosComoTexto() {
        if (productos.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (Productos p : productos) {
            sb.append("  - ").append(p.getNombre())
              .append(" (").append(p.getMarca()).append(") ")
              .append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String resumen() {
        return "Vendedor{nombre='" + nombre + "', id=" + id + ", productos=" + productos.size() + "}";
    }

    @Override
    public String toString() {
        return resumen();
    }
}
