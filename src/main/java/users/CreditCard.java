package users;

public class CreditCard {
    //Attributes
    private int idCreditCard;
    private String typeCard;

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
}
