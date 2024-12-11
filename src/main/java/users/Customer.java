package users;

public class Customer extends Users{
    private int  numberCreditCard, creditCardQuota;
    private String typeClient;
    private double creditAmount;

    //Constructor of customer:
    Customer(String emailUser, String passwordUser){
        super(emailUser, passwordUser);
    }

    //Methods:
    public void register(){
        super.register();
    }


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
