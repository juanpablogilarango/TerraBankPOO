package terrabank.users;

public class Administrator extends Users{
    //Attributes:
    private double salary;

    public Administrator(String idUser, String email, String nameUser, String password){
        super(idUser, email, nameUser ,password);
    }

    //Methods:

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public void listUsers(){
        System.out.println("Listado de usuarios");
    }


}
