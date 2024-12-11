package users;

public class Customer extends Users{
    private int  numberCreditCard, creditCardQuota;
    private String typeCard;
    private double creditAmount;

    //Constructor of customer:
    public Customer(String email, String nameUser, String password){
        super(email, nameUser ,password);
    }

    //Methods:



    //getters and setters:
    public void setTypeCard(String typeClient){
        this.typeCard = typeClient;
    }

    public String getTypeCard(){
        return this.typeCard;
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
