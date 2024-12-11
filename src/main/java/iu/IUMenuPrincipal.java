package iu;

import java.util.Scanner;

public class IUMenuPrincipal {
    static Scanner sc = new Scanner(System.in);
    public void menuPrincipal(){
        int option;

        do {
            System.out.println("Señor usuario, ingrese opcion: \n 1) Iniciar sesión como administrador " +
                    "\n 2) Iniciar sesión como cliente \n 3) Registrarse como cliente \n 4) salir" );
            option = sc.nextInt();
            switch (option){
                case 1:
                    System.out.println("Iniciar sesión como administrador");
                    
                    break;
                case 2:
                    System.out.println("Iniciar sesión como cliente");
                    break;
                case 3:
                    System.out.println("Registrarse como cliente");
                    break;
                case 4:
                    option = 4;
                    break;
                default:
                    System.out.println("Ingrese una opción valida");
            }

        } while (option != 4);
    }
}
