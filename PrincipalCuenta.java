import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class PrincipalCuenta {
    public static void main(String[] args) {
        
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);
        
        Cuenta cuentaActual = null;
        
        int opcion;

        do {
            System.out.println("1. Crear cuenta");
            System.out.println("2. Conocer cantidad de cuentas creadas");
            System.out.println("3. Listar cuentas");
            System.out.println("4. Seleccionar cuenta actual");
            System.out.println("5. Asignar nombre de la cuenta habiente");
            System.out.println("6. Depositar");
            System.out.println("7. Retirar");
            System.out.println("8. Consultar saldo");
            System.out.println("9. Consultar estado de la cuenta");
            System.out.println("10. Salir");
            
            opcion = teclado.nextInt();
            teclado.nextLine();
            
            
            switch (opcion) {
                case 1:
                    int opcionCuenta;
                    submenuCuenta:
                    do {
                        System.out.println("1. Ingresar nombre de la cuenta y cantidad");
                        System.out.println("2. Ingresar solo cantidad");
                        System.out.println("3. Volver");
                        
                        opcionCuenta = teclado.nextInt();
                        teclado.nextLine();
                        
                        switch (opcionCuenta) {
                            case 1:
                                String nombreOpcion1;
                                System.out.println("Ingrese el nombre de la cuenta: ");
                                nombreOpcion1 = teclado.nextLine();
                                
                                double saldoOpcion1;
                                System.out.println("Ingrese el saldo de la cuenta: ");
                                saldoOpcion1 = teclado.nextDouble();
                                
                                Cuenta cuentaNuevaOpcion1 = new Cuenta(nombreOpcion1, saldoOpcion1);
                                
                                cuentas.add(cuentaNuevaOpcion1);
                                
                                break submenuCuenta;
                            case 2:                            
                                double saldoOpcion2;
                                System.out.println("Ingrese el saldo de la cuenta: ");
                                saldoOpcion2 = teclado.nextDouble();
                                
                                Cuenta cuentaNueva = new Cuenta(saldoOpcion2);
                                
                                cuentas.add(cuentaNueva);
                                
                                break submenuCuenta;
                            case 3:
                                System.out.println("Volviendo...");
                                break;
                            default:
                                System.out.println("Opción inválida");
                        }
                    }while (opcionCuenta != 3);
                    System.out.println("Se creo su cuenta con exito.");
                    break;
                case 2:
                    System.out.println("Cantidad de cuentas creadas: " + Cuenta.getCantCuentasCreadas());
                    break;
                case 3:
                    if (cuentas.isEmpty()) {
                        System.out.println("No hay cuentas creadas");
                    }else {
                        for (Cuenta c : cuentas) {
                            System.out.println(c.toString());
                        }
                    }
                    break;
                case 4:
                    String codigoIngresado;
                    System.out.println("Ingrese el codigo de la cuenta(Ejemplo: cta-1): ");
                    codigoIngresado = teclado.nextLine();
                    
                    boolean encontrada = false;
                    
                    for (Cuenta c : cuentas) {
                        if (c.getCodCuenta().equals(codigoIngresado)){
                            cuentaActual = c;
                            System.out.println("Se encontro su cuenta.");
                            encontrada = true;
                                
                            break;
                        }
                        }
                        
                    if (!encontrada) {
                        System.out.println("No se encontro ninguna cuenta con ese codigo.");
                    }
                    
                    break;
                case 5:
                    if (cuentaActual == null) {
                        System.out.println("Debe de seleccionar una cuenta primero.");
                    }else {
                        String nombreIngresado;
                        System.out.println("Ingrese el nombre para la cuenta.");
                        nombreIngresado = teclado.nextLine();
                        
                        cuentaActual.setNombreCuentaHabiente(nombreIngresado);
                        System.out.println("El nombre fue establecido con exito.");
                    }
                    break;
                case 6:
                    if (cuentaActual == null) {
                        System.out.println("Debe de seleccionar una cuenta primero.");
                    }else {
                        double montoIngresado;
                        System.out.println("Ingrese el monto a depositar.");
                        montoIngresado = teclado.nextDouble();
                        
                        double saldoActualizado = cuentaActual.depositar(montoIngresado);
                        System.out.println("El deposito fue realizado con exito, su saldo es de: " + saldoActualizado);
                    }
                    break;
                case 7:
                    if (cuentaActual == null) {
                        System.out.println("Debe de seleccionar una cuenta primero.");
                    }else {
                        double montoIngresado;
                        System.out.println("Ingrese el monto a depositar.");
                        montoIngresado = teclado.nextDouble();
                        
                        double saldoActual = cuentaActual.getSaldo();
                        double saldoActualizado = cuentaActual.retirar(montoIngresado);
                        
                        if (saldoActual == saldoActualizado) {
                            System.out.println("El retiro fue denegado, saldo actual: " + saldoActual);
                        }else {
                            System.out.println("El retiro fue realizado con exito, su saldo es de: " + saldoActualizado);
                        }
                    }
                    break;
                case 8:
                    if (cuentaActual == null) {
                        System.out.println("Debe de seleccionar una cuenta primero.");
                    }else {
                        System.out.println("Su saldo es de: " + cuentaActual.getSaldo());
                    }
                    break;
                case 9:
                    if (cuentaActual == null) {
                        System.out.println("Debe de seleccionar una cuenta primero.");
                    }else {
                        System.out.println(cuentaActual.toString());
                    }
                    break;
                case 10:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
            
        } while (opcion != 10);
        
    }
}