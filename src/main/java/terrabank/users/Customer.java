package terrabank.users;

public class Customer extends Users{
    String typeCustomer;

    //Constructor of customer:
    public Customer(String idUser, String email, String nameUser, String lastNameUser, String password, String typeCustomer){
        super(idUser, email, nameUser, password);
        this.typeCustomer = typeCustomer;
    }


}
