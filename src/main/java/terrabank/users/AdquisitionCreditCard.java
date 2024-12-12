package terrabank.users;

public class AdquisitionCreditCard {
    private int idAdquisition, numberCreditCard;
    private String date;

    public AdquisitionCreditCard(int idAdquisition, String date) {
        this.idAdquisition = idAdquisition;
        this.date = date;
    }

    public int getIdAdquisition() {
        return idAdquisition;
    }

    public void setIdAdquisition(int idAdquisition) {
        this.idAdquisition = idAdquisition;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNumberCreditCard(int numberCreditCard){
        this.numberCreditCard = numberCreditCard;
    }

    public int getNumberCreditCard(){
        return numberCreditCard;
    }

}
