package users;

public class Administrator extends Users{
    //Attributes:

    Administrator(String email, String password){
        super(email, password);
    }

    //Methods:


    @Override
    public void register() {
        super.register();
    }

    public void listBuys(){
        System.out.println("Listado de compras");
    }

    public void listUsers(){
        System.out.println("Listado de usuarios");
    }
}
