package users;

public class Administrator extends Users{
    //Attributes:


    public Administrator(String email, String nameUser, String password){
        super(email, nameUser ,password);
    }

    //Methods:

    public void listBuys(){
        System.out.println("Listado de compras");
    }

    public void listUsers(){
        System.out.println("Listado de usuarios");
    }
}
