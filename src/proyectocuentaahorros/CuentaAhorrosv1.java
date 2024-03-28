package proyectocuentaahorros;

import java.util.Scanner;

public class CuentaAhorrosv1 {

    static Scanner sc = new Scanner(System.in);
    static double saldoAhorros = 20000;
    static String user;
    static String name;
    static String email;
    static String phone;
    static int password;
    static int userPassword;

    static  boolean userRegister;
    static  boolean isLogged;

    public static void main(String[] args) {
        cajeroAutomatico();
    }
    public static void cajeroAutomatico() {
        registroUsuario();
    }
    public static void registroUsuario() {
        System.out.println("Bienvenido desea registrarse: 1.Si 2.No");
        int respuesta = sc.nextInt();
        if(respuesta ==1){
            register();
            if(isLogged) {
                menuCajero();
            }
        } else {
            System.out.println("Proceso finalizado");
        }

    }

    public static void register() {

        System.out.println("Para registrarse digita los siguientes campos: \n");
        try {

            System.out.println("Ingrese su nombre");
            name = sc.next();
            System.out.println("Ingrese su correo");
            email = sc.next();
            System.out.println("Ingrese su Telefono");
            phone = sc.next();
            System.out.println("Ingrese su contraseña");
            password = sc.nextInt();
            System.out.println("El usuario registrado es : " + name);
            login();
        } catch (Exception e) {
            System.out.println("Ingresa el tipo de dato corecto: \nEl telefono y constraseña deben ser numeros");
            System.out.println(e);
            sc.next();
            registroUsuario();
        }
    }
    public static boolean login() {
        System.out.println("Ingrese su usuario y contraseña para iniciar sesion: \n");
        System.out.println("Ingrese su usuario");
        user = sc.next();
        System.out.println("Ingrese su contraseña");
        userPassword = sc.nextInt();

        if((user.equals(email) || user.equals(phone)) && userPassword == password) {
            isLogged = true;
            System.out.println("Bienvenido " + name);
        } else {
            System.out.println("User o Password invalidos");
            isLogged = false;
        }
        return isLogged;
    }


    public static void menuCajero() {
        System.out.println("Que operacion deseas realizar?");
        System.out.println("1. Consultar Saldo\n" +
                "2. Retirar Dinero\n" +
                "3. Consignar Dinero\n" +
                "4. Tranferir Dinero\n" +
                "5. Salir\n");

        int opc = sc.nextInt();

        switch (opc) {
            case 1:
                System.out.println("Consulta de saldo");
                consultaSaldo();
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
    public static void consultaSaldo() {
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
        System.out.println("Vuelve pronto " + name);
        registroUsuario();
    }
    public static void finalizar() {
        System.out.println("Transaccion Finalizada" + " ");
        System.out.println(" ");
        menuCajero();
    }
}
