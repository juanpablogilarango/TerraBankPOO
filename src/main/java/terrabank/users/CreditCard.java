package terrabank.users;

public class CreditCard {
    //Attributes
    private int idCreditCard;
    private String typeCard, description;
    private double amount;

    public CreditCard(int idCreditCard, String typeCard) {
        this.idCreditCard = idCreditCard;
        this.typeCard = typeCard;
    }

    public int getIdCreditCard() {
        return idCreditCard;
    }

    public void setIdCreditCard(int idCreditCard) {
        this.idCreditCard = idCreditCard;
    }

    public String getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(String typeCard) {
        this.typeCard = typeCard;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
