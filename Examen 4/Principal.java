// Pablo Manuel Fernández Velázquez
// Versión mejorada: correcciones, validaciones y mejor diseño OO.

import compraonline.*;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            Productos prod1 = new Productos("Patinete", "Toys", "23/02/2026");
            Productos prod2 = new Productos("Gafas", "RayBan", "23/02/2026");
            Productos prod3 = new Productos("Bicicleta", "Canyon", "23/02/2026");

            Vendedores vend1 = new Vendedores("Manuel");
            Vendedores vend2 = new Vendedores("Angela");

            vend1.anadirProducto(prod1);
            vend1.anadirProducto(prod2);
            vend2.anadirProducto(prod3);

            System.out.print("¿Cuál quieres que sea el nombre de la Plataforma? ");
            String nombrePlat = sc.nextLine().trim();

            PlataformaDeVenta plataforma = new PlataformaDeVenta(nombrePlat);

            plataforma.registrarVendedor(vend1);
            plataforma.registrarVendedor(vend2);

            System.out.println("\n=== VENDEDORES REGISTRADOS ===");
            System.out.println(plataforma.listarVendedores());

            System.out.println("=== PRODUCTOS EN LA PLATAFORMA ===");
            System.out.println(plataforma.listarProductos());

            System.out.print("\n¿Qué producto buscamos? ");
            String prodBusc = sc.nextLine().trim();

            Productos encontrado = plataforma.buscarProducto(prodBusc);
            if (encontrado != null) {
                System.out.println("\nProducto encontrado:");
                System.out.println(encontrado);
            } else {
                System.out.println("\nNo se encontró el producto: " + prodBusc);
            }

            // Ejemplo: eliminar un producto del vendedor 1
            boolean eliminado = vend1.eliminarProducto("Gafas");
            System.out.println("\nEliminar 'Gafas' del vendedor " + vend1.getNombre() + ": " + (eliminado ? "OK" : "No encontrado"));

            System.out.println("\n=== PRODUCTOS ACTUALIZADOS EN LA PLATAFORMA ===");
            System.out.println(plataforma.listarProductos());
        }
    }
}
