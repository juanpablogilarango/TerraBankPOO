package users;

public class Customer extends Users{
    private String typeClient;
    private int numberCreditCard;
    private double creditCardQuota;
    private double buy;

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

    public void setCreditCardQuota(double creditCardQuota){
        this.creditCardQuota = creditCardQuota;
    }

    public double getCreditCardQuota(){
        return creditCardQuota;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getBuy(){
        return buy;
    }

}
