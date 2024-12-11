package users;

public class Customer extends Users{
    private int  numberCreditCard, creditCardQuota;
    private String typeClient;
    private double creditAmount;

    //Constructor of customer:
    public Customer(String email, String nameUser, String password){
        super(email, nameUser ,password);
    }

    //Methods:



    //getters and setters:
    public void setTypeClient(String typeClient){
        this.typeClient = typeClient;
    }

    public String getTypeClient(){
        return this.typeClient;
    }

    public void setNumberCreditCard(int numberCreditCard){
        this.numberCreditCard = numberCreditCard;
    }

    public int getNumberCreditCard(){
        return numberCreditCard;
    }

    public void setCreditCardQuota(int creditCardQuota){
        this.creditCardQuota = creditCardQuota;
    }

    public int getCreditCardQuota(){
        return creditCardQuota;
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public double getCreditAmount(){
        return creditAmount;
    }


}
