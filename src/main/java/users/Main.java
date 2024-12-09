package users;

public class Main {
    public static void main(String[] args){
        Customer clientOne = new Customer("carlos@gmail.com", "27112254");
        String clientOneEmail = clientOne.getEmailUser();
        System.out.println(clientOneEmail);
    }

}
