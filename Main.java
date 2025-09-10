package app;

import java.util.*;

/**
 * Sistema de Inventario de Supermercado
 * Historia de Usuario 7: HU_007_INVENTARIO_SUPERMERCADO
 * 
 * Sistema que permite registrar productos y su cantidad en inventario,
 * controlar el stock y generar alertas por baja existencia.
 */
public class Main {
    // Constante para definir número fijo de productos
    private static final int MAX_PRODUCTOS = 5;
    
    // Vectores para registrar nombres de productos y cantidades disponibles
    private static String[] nombresProductos = new String[MAX_PRODUCTOS];
    private static int[] cantidadesDisponibles = new int[MAX_PRODUCTOS];
    
    // Variable acumuladora para mostrar el total de productos en inventario
    private static int totalProductosInventario = 0;
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE INVENTARIO DE SUPERMERCADO ===");
        System.out.println("Historia de Usuario 7: HU_007_INVENTARIO_SUPERMERCADO");
        System.out.println();
        
        // Los productos y sus cantidades se ingresan usando un ciclo
        ingresarProductos();
        
        // Menú principal
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            
            switch(opcion) {
                case 1:
                    mostrarTodosLosProductos();
                    break;
                case 2:
                    buscarProductoPorNombre();
                    break;
                case 3:
                    actualizarInventario();
                    break;
                case 4:
                    generarAlertaBajaExistencia();
                    break;
                case 5:
                    System.out.println("¡Gracias por usar el sistema de inventario!");
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 5.");
            }
            
            if (opcion != 5) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
            
        } while (opcion != 5);
        
        scanner.close();
    }
    
    /**
     * Ingresa los productos iniciales al inventario usando un ciclo
     */
    private static void ingresarProductos() {
        System.out.println("=== REGISTRO INICIAL DE PRODUCTOS ===");
        System.out.println("Por favor, ingrese " + MAX_PRODUCTOS + " productos:");
        System.out.println();
        
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            System.out.print("Producto " + (i + 1) + " - Nombre: ");
            nombresProductos[i] = scanner.nextLine().trim();
            
            int cantidad;
            do {
                System.out.print("Producto " + (i + 1) + " - Cantidad: ");
                try {
                    cantidad = Integer.parseInt(scanner.nextLine().trim());
                    if (cantidad < 0) {
                        System.out.println("Error: No se puede ingresar una cantidad negativa. Intente nuevamente.");
                    }
                } catch (NumberFormatException e) {
                    cantidad = -1;
                    System.out.println("Error: Por favor ingrese un número válido.");
                }
            } while (cantidad < 0);
            
            cantidadesDisponibles[i] = cantidad;
            totalProductosInventario += cantidad;
            System.out.println();
        }
        
        System.out.println("¡Productos registrados exitosamente!");
        System.out.println("Total de productos en inventario: " + totalProductosInventario);
        System.out.println();
    }
    
    /**
     * Muestra el menú principal de opciones
     */
    private static void mostrarMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Mostrar todos los productos y sus existencias");
        System.out.println("2. Buscar un producto por nombre y ver su cantidad");
        System.out.println("3. Actualizar el inventario (aumentar o disminuir stock)");
        System.out.println("4. Generar alerta de productos con cantidad menor a 10");
        System.out.println("5. Salir");
        System.out.println();
        System.out.println("Total de productos en inventario: " + totalProductosInventario);
        System.out.print("Seleccione una opción (1-5): ");
    }
    
    /**
     * Lee y valida la opción seleccionada por el usuario
     */
    private static int leerOpcion() {
        try {
            int opcion = Integer.parseInt(scanner.nextLine().trim());
            return opcion;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    /**
     * 1. Mostrar todos los productos y sus existencias
     */
    private static void mostrarTodosLosProductos() {
        System.out.println("\n=== LISTADO COMPLETO DE PRODUCTOS ===");
        System.out.println("┌─────┬─────────────────────────┬──────────┐");
        System.out.println("│ No. │ Producto                │ Cantidad │");
        System.out.println("├─────┼─────────────────────────┼──────────┤");
        
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            System.out.printf("│ %-3d │ %-23s │ %-8d │%n", 
                            (i + 1), nombresProductos[i], cantidadesDisponibles[i]);
        }
        
        System.out.println("└─────┴─────────────────────────┴──────────┘");
        System.out.println("Total de productos en inventario: " + totalProductosInventario);
    }
    
    /**
     * 2. Buscar un producto por nombre y ver su cantidad
     */
    private static void buscarProductoPorNombre() {
        System.out.println("\n=== BÚSQUEDA DE PRODUCTO ===");
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombreBuscado = scanner.nextLine().trim();
        
        boolean encontrado = false;
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            if (nombresProductos[i].equalsIgnoreCase(nombreBuscado)) {
                System.out.println("\n✓ Producto encontrado:");
                System.out.println("Nombre: " + nombresProductos[i]);
                System.out.println("Cantidad disponible: " + cantidadesDisponibles[i]);
                
                if (cantidadesDisponibles[i] < 10) {
                    System.out.println("️  ALERTA: Este producto tiene stock bajo (menos de 10 unidades)");
                }
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("Producto no encontrado en el inventario.");
        }
    }
    
    /**
     * 3. Actualizar el inventario (aumentar o disminuir stock con validaciones)
     */
    private static void actualizarInventario() {
        System.out.println("\n=== ACTUALIZACIÓN DE INVENTARIO ===");
        System.out.print("Ingrese el nombre del producto a actualizar: ");
        String nombreProducto = scanner.nextLine().trim();
        
        int indiceProducto = -1;
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            if (nombresProductos[i].equalsIgnoreCase(nombreProducto)) {
                indiceProducto = i;
                break;
            }
        }
        
        if (indiceProducto == -1) {
            System.out.println(" Producto no encontrado en el inventario.");
            return;
        }
        
        System.out.println("\nProducto encontrado: " + nombresProductos[indiceProducto]);
        System.out.println("Cantidad actual: " + cantidadesDisponibles[indiceProducto]);
        System.out.println();
        System.out.println("Opciones de actualización:");
        System.out.println("1. Aumentar stock");
        System.out.println("2. Disminuir stock");
        System.out.print("Seleccione una opción (1-2): ");
        
        int tipoActualizacion;
        try {
            tipoActualizacion = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println(" Opción no válida.");
            return;
        }
        
        if (tipoActualizacion != 1 && tipoActualizacion != 2) {
            System.out.println("Opción no válida. Debe ser 1 o 2.");
            return;
        }
        
        System.out.print("Ingrese la cantidad a " + (tipoActualizacion == 1 ? "aumentar" : "disminuir") + ": ");
        int cantidad;
        try {
            cantidad = Integer.parseInt(scanner.nextLine().trim());
            if (cantidad < 0) {
                System.out.println("Error: No se puede ingresar una cantidad negativa.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido.");
            return;
        }
        
        int cantidadAnterior = cantidadesDisponibles[indiceProducto];
        
        if (tipoActualizacion == 1) {
            cantidadesDisponibles[indiceProducto] += cantidad;
            totalProductosInventario += cantidad;
            System.out.println(" Stock aumentado exitosamente.");
        } else {
            if (cantidad > cantidadesDisponibles[indiceProducto]) {
                System.out.println("Error: No se puede disminuir más cantidad de la disponible.");
                System.out.println("Cantidad disponible: " + cantidadesDisponibles[indiceProducto]);
                System.out.println("Cantidad solicitada a disminuir: " + cantidad);
                return;
            }
            cantidadesDisponibles[indiceProducto] -= cantidad;
            totalProductosInventario -= cantidad;
            System.out.println(" Stock disminuido exitosamente.");
        }
        
        System.out.println("\nResumen de actualización:");
        System.out.println("Producto: " + nombresProductos[indiceProducto]);
        System.out.println("Cantidad anterior: " + cantidadAnterior);
        System.out.println("Cantidad actual: " + cantidadesDisponibles[indiceProducto]);
        System.out.println("Total de productos en inventario: " + totalProductosInventario);
        
        if (cantidadesDisponibles[indiceProducto] < 10) {
            System.out.println("  ALERTA: Este producto ahora tiene stock bajo (menos de 10 unidades)");
        }
    }
    
    /**
     * 4. Generar alerta de productos con cantidad menor a 10
     */
    private static void generarAlertaBajaExistencia() {
        System.out.println("\n=== ALERTA DE BAJA EXISTENCIA ===");
        System.out.println("Productos con cantidad menor a 10 unidades:");
        System.out.println();
        
        boolean hayAlerta = false;
        System.out.println("┌─────┬─────────────────────────┬──────────┐");
        System.out.println("│ No. │ Producto                │ Cantidad │");
        System.out.println("├─────┼─────────────────────────┼──────────┤");
        
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            if (cantidadesDisponibles[i] < 10) {
                System.out.printf("│ %-3d │ %-23s │ %-8d │%n", 
                                (i + 1), nombresProductos[i], cantidadesDisponibles[i]);
                hayAlerta = true;
            }
        }
        
        System.out.println("└─────┴─────────────────────────┴──────────┘");
        if (hayAlerta) {
            System.out.println(" Se recomienda reabastecer estos productos.");
        } else {
            System.out.println(" Todos los productos tienen stock suficiente (10 o más unidades).");
        }
    }
}
