package proyectocuentaahorros;

import java.util.Scanner;

public class CuentaAhorros {

    static Scanner sc = new Scanner(System.in);
    static String[] users = new String[4];
    static double saldoAhorros = 20000;

    public static void main(String[] args) {
      appCajeroAutomatico();
    }

    public static void appCajeroAutomatico() {
        System.out.println("Bienvenido a su Aplicación Movil");
        inicio();
    }

    public static void inicio() {

            System.out.println("\n¿Qué acción deseas realizar?");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Salir");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("1. Registrar nuevo usuario");
                    register();
                    break;
                case 2:
                    System.out.println("2. Salir");
                    System.out.println("Gracias por usar nuestros servicios.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intenta de nuevo.");
            }
    }
    public static void register() {
        System.out.println("Para registrarse digita los siguientes campos: \n");
        try {
            System.out.println("Ingrese su nombre");
            String name = sc.next();
            System.out.println("Ingrese su correo");
            String email = sc.next();
            System.out.println("Ingrese su Telefono");
            int phone = sc.nextInt();
            System.out.println("Ingrese su contraseña");
            int password = sc.nextInt();

            users[0] = name;
            users[1] = email;
            users[2] = String.valueOf(phone);
            users[3] = String.valueOf(password);

            System.out.println("Usuario registrado exitosamente");
            login();
        } catch (Exception e) {
            System.out.println("Dato invalido: Teléfono y contraseña deben ser numéricos");
            System.out.println(e);
            sc.next();
            register();
        }
    }
    public static boolean login() {
        boolean isLogged;

        System.out.println("Ingrese su usuario y contraseña para iniciar sesion: \n");
        System.out.println("Ingrese su usuario");
        String user = sc.next();
        System.out.println("Ingrese su contraseña");
        int userPassword = sc.nextInt();
        String userPassword1 = String.valueOf(userPassword);

        if((user.equals(users[1]) || user.equals(users[2])) && userPassword1.equals(users[3])) {
            isLogged = true;
            System.out.println("Inicio de sesión exitoso.\nBienvenido, " + users[0]);
            menuCajero();
        } else {
            isLogged = false;
            System.out.println("User o Password invalidos");
            login();
        }
        return isLogged;
    }

    public static void menuCajero() {
        System.out.println("\nQue operacion deseas realizar?");
        System.out.println("1. Consultar Saldo\n" +
                "2. Retirar Dinero\n" +
                "3. Consignar Dinero\n" +
                "4. Tranferir Dinero\n" +
                "5. Salir\n");

        int opc = sc.nextInt();

        switch (opc) {
            case 1:
                System.out.println("Consulta de saldo");
                consultarSaldo();
                break;
            case 2:
                System.out.println("Retirar Dinero");
                retirarDinero();
                break;
            case 3:
                System.out.println("Consignar Dinero");
                consignarDinero();
                break;
            case 4:
                System.out.println("Transferencia de Dinero");
                transferirDinero();
                break;
            case 5:
                System.out.println("Salir");
                salir();
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                break;
        }
    }

    public static void consultarSaldo() {
        System.out.println("Su saldo actual es de " + saldoAhorros);
        finalizar();
    }
    public static double retirarDinero() {
        System.out.println("Digita el valor a retirar: ");
        double valorRetiro = sc.nextInt();
        if(saldoAhorros >= valorRetiro) {
            saldoAhorros = saldoAhorros - valorRetiro;
        } else {
            System.out.println("Fondos insuficientes");
        }
        System.out.println("Su saldo actual es de " + saldoAhorros);
        finalizar();
        return saldoAhorros;
    }
    public static double consignarDinero() {
        System.out.println("Digita el valor a consignar: ");
        double valorConsignacion = sc.nextInt();
        if(valorConsignacion >=0) {
            saldoAhorros = saldoAhorros + valorConsignacion;
        }else {
            System.out.println("Digite un valor superior a 0");
        }
        System.out.println("Saldo actual es de " + saldoAhorros);
        finalizar();
        return saldoAhorros;
    }

    public static double transferirDinero() {
        System.out.println("Digita el valor a transferir: $ ");
        double valorTransferencia = sc.nextInt();

        if(saldoAhorros >= valorTransferencia) {
            System.out.println("Digita el numero de cuenta Ahorros/Corriente");
            String numeroCuenta = sc.next();
            saldoAhorros = saldoAhorros - valorTransferencia;
            System.out.println("Usted va transferir el valor de: $ " + valorTransferencia);
            System.out.println("para la cuenta Numero: " + numeroCuenta);
        } else {
            System.out.println("Fondos insuficientes");
        }
        System.out.println("Saldo actual es de " + saldoAhorros);
        finalizar();
        return saldoAhorros;
    }
    public static void salir() {
        System.out.println("Vuelve pronto " + users[0]);
    }
    public static void finalizar() {
        System.out.println("Transaccion Finalizada" + " ");
        System.out.println(" ");
        menuCajero();
    }
}
