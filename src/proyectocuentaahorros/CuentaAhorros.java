package proyectocuentaahorros;

import java.util.Scanner;

public class CuentaAhorros {
    static Scanner sc = new Scanner(System.in);
    static String[] nombres = new String[5];
    static String[] correos = new String[5];
    static String[] telefonos = new String[5];
    static int[] contrasenas = new int[5];
    static double[] saldos = {20000, 0, 0, 0, 0};
    static String[][] usuarios = new String[5][5];
    static int usuarioActual = -1;

    public static void main(String[] args) {
        appCajeroautomatico();
    }

    public static void appCajeroautomatico() {
        System.out.println("==== Bienvenido a su aplicación móvil ====");
        iniciarPrograma();
    }

    public static void iniciarPrograma() {
        menuInicio();
    }

    public static void menuInicio() {
        boolean iniciar = true;

        while(iniciar) {
            try {
                System.out.println("\n¿Qué deseas hacer?");
                System.out.println("1. Registrar nuevo usuario");
                System.out.println("2. Iniciar Sesión");
                System.out.println("3. Salir");
                System.out.print("Opción: ");
                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("1. Registrar nuevo usuario");
                        registrarUsuario();
                        break;
                    case 2:
                        System.out.println("2. Iniciar sesión");
                        boolean inicioExitoso = iniciarSesion();
                        if (inicioExitoso) {
                            menuCajero(inicioExitoso);
                        }
                        break;
                    case 3:
                        System.out.println("Gracias por utilizar nuestros servicios.");
                        iniciar = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Solo se permiten números");
                System.out.println(e);
                sc.nextLine();
            }
        }
    }

    public static void registrarUsuario() {
        System.out.println("Para registrarse digita los siguientes campos: \n");
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i] == null) {
                try {
                    System.out.println("Ingrese su nombre");
                    nombres[i] = sc.next();
                    System.out.println("Ingrese su correo");
                    correos[i] = sc.next();
                    System.out.println("Ingrese su Telefono");
                    telefonos[i] = sc.next();
                    System.out.println("Ingrese su contraseña");
                    contrasenas[i] = Integer.parseInt(sc.next());

                    usuarios[i][0] = nombres[i];
                    usuarios[i][1] = correos[i];
                    usuarios[i][2] = telefonos[i];
                    usuarios[i][3] = Integer.toString(contrasenas[i]);
                    usuarios[i][4] = String.valueOf(saldos[i]);
                    System.out.println("Usuario registrado exitosamente\nPuedes iniciar sesión!");
                    return;

                } catch (Exception e) {
                    System.out.println("Dato invalido: Solo se permiten números");
                    System.out.println(e);
                    sc.nextLine();
                }
            }
        }
    }


    public static boolean iniciarSesion() {
        try{
            System.out.println("Ingrese su correo:");
            String correo = sc.next();
            System.out.println("Ingrese su contraseña:");
            int contrasena = sc.nextInt();

            for (int i = 0; i < correos.length; i++) {
                if (correos[i] != null && correos[i].equals(correo) && contrasenas[i] == contrasena) {
                    usuarioActual = i;
                    System.out.println("Inicio de sesión exitoso.");
                    return true;
                }
            }
            System.out.println("Correo o contraseña incorrectos. Debe registrarse primero.");
            return false;

        } catch (Exception e) {
            System.out.println("Dato invalido: Solo se permiten números.");
            System.out.println(e);
            sc.nextLine();
            return false;
        }
    }
    public static void menuCajero(boolean inicioExitoso) {
        if(inicioExitoso) {
         while(true) {
             try {
                 System.out.println("\n==== Menú Cajero Automático ====");
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
                         System.out.println("Salió del menú cajero.");
                         return;
                     default:
                         System.out.println("Ingrese una opcion valida");
                         break;
                 }

             } catch (Exception e){
                 System.out.println("Dato invalido: Solo se permiten números.");
                 System.out.println(e);
                 sc.nextLine();
             }

         }

        } else {
            System.out.println("No inicio sesión correctamente");
        }
    }

    public static void consultarSaldo() {
        System.out.println("Su saldo actual es de $ " + saldos[usuarioActual]);
        finalizar();
    }

    public static double retirarDinero() {
        System.out.println("Digita el valor a retirar: ");
        double valorRetiro = sc.nextInt();
        if(saldos[usuarioActual] >= valorRetiro) {
            saldos[usuarioActual] = saldos[usuarioActual] - valorRetiro;
        } else {
            System.out.println("Fondos insuficientes");
        }
        System.out.println("Su saldo actual es de " + saldos[usuarioActual]);
        finalizar();

        return saldos[usuarioActual];
    }

    public static double consignarDinero() {
        System.out.println("Digita el valor a consignar: ");
        double valorConsignacion = sc.nextInt();
        if(valorConsignacion >=0) {
            saldos[usuarioActual] = saldos[usuarioActual] + valorConsignacion;
        }else {
            System.out.println("Digite un valor superior a 0");
        }
        System.out.println("Saldo actual es de " + saldos[usuarioActual]);
        finalizar();
        return saldos[usuarioActual];
    }
    public static double transferirDinero() {
        System.out.println("Digita el valor a transferir: $ ");
        double valorTransferencia = sc.nextInt();

        if(saldos[usuarioActual] >= valorTransferencia) {
            System.out.println("Digita el numero de cuenta Ahorros/Corriente");
            String numeroCuenta = sc.next();
            saldos[usuarioActual] = saldos[usuarioActual] - valorTransferencia;
            System.out.println("Usted va transferir el valor de: $ " + valorTransferencia);
            System.out.println("para la cuenta Numero: " + numeroCuenta);
        } else {
            System.out.println("Fondos insuficientes");
        }
        System.out.println("Saldo actual es de " + saldos[usuarioActual]);
        finalizar();
        return saldos[usuarioActual];
    }
    public static void finalizar() {
        System.out.println("Transaccion Finalizada" + " ");
        System.out.println(" ");
    }

}






