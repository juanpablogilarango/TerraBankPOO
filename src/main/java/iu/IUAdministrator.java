package iu;

import java.util.Scanner;

public class IUAdministrator {
    static Scanner sc = new Scanner(System.in);
    //EL ADMINISTRADOR, PUEDE: CREAR, LISTAR, ELIMINAR Y ACTUALIZAR. -CRUD de tarjeta de creditos...
    //para instanciarlo en el main:  iu.Menu menu = new iu.Menu();
    public void menuAdministrator(){

        int option;

        do {
            System.out.println("Ingrese una opción: 1) Crear tarjeta de crédito \n 2) Actualizar tarjeta de crédito \n" +
                    "3) Eliminar tarjeta de crédito \n 4) Listar tarjetas de crédito \n " +
                    " 5) Ver Clientes 6) Regresar al menú anterior");
            option = sc.nextInt();
            switch (option){
                case 1:
                    createCreditCard();
                    break;
                case 2:
                    updateCreditCard();
                    break;
                case 3:
                    deleteCreditCard();
                    break;
                case 4:
                    listCreditCard();
                    break;
                case 5:
                    listCustomer();
                    break;
                case 6:
                    option = 5;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");

            }
        } while (option != 5);


    }

    public void createCreditCard(){
        System.out.println("Creacion de la tarjeta de credito");
    }

    public void updateCreditCard(){
        System.out.println("Actualizacion de la tarjeta de credito");
    }

    public void deleteCreditCard(){
        System.out.println("Eliminacion de la tarjeta de credito");
    }

    public void listCreditCard(){
        System.out.println("Lista de las tarjetas de credito");
    }

    public void listCustomer(){
        System.out.println("Lista de clientes");
    }

}
