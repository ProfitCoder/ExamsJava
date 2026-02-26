// Pablo Manuel Fernández Velázquez
// Versión mejorada: lógica corregida, sin recursión accidental, sin NPEs.

package compraonline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PlataformaDeVenta {

    public static final int MAX_VENDEDORES = 10;

    private final String nombre;
    private final List<Vendedores> vendedores = new ArrayList<>(MAX_VENDEDORES);

    public PlataformaDeVenta(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser null").trim();
        if (this.nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la plataforma no puede estar vacío");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List<Vendedores> getVendedores() {
        return Collections.unmodifiableList(vendedores);
    }

    /** Registra un vendedor si hay hueco y si no está ya registrado (por ID). */
    public boolean registrarVendedor(Vendedores vendedor) {
        Objects.requireNonNull(vendedor, "vendedor");
        if (vendedores.size() >= MAX_VENDEDORES) return false;

        for (Vendedores v : vendedores) {
            if (v.getId() == vendedor.getId()) {
                return false; // ya está
            }
        }
        return vendedores.add(vendedor);
    }

    /** Busca el primer producto con ese nombre en cualquier vendedor (case-insensitive). */
    public Productos buscarProducto(String nombreProducto) {
        if (nombreProducto == null || nombreProducto.trim().isEmpty()) return null;
        String buscado = nombreProducto.trim();

        for (Vendedores v : vendedores) {
            Productos p = v.buscarProducto(buscado);
            if (p != null) return p;
        }
        return null;
    }

    public String listarVendedores() {
        if (vendedores.isEmpty()) return "(sin vendedores)";

        StringBuilder sb = new StringBuilder();
        for (Vendedores v : vendedores) {
            sb.append(v.resumen()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    /** Lista todos los productos a la venta agregados por vendedor. */
    public String listarProductos() {
        if (vendedores.isEmpty()) return "(sin productos)";

        StringBuilder sb = new StringBuilder();
        for (Vendedores v : vendedores) {
            sb.append("Vendedor: ").append(v.getNombre())
              .append(" (ID ").append(v.getId()).append(")")
              .append(System.lineSeparator());

            String lista = v.listarProductosComoTexto();
            sb.append(lista.isEmpty() ? "  (sin productos)" : lista);

            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "PlataformaDeVenta{nombre='" + nombre + "', vendedores=" + vendedores.size() + "}";
    }
}
