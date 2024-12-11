package users;

public class AdquisitionCreditCard {
    private int idAdquisition;
    private String date, amount;

    public AdquisitionCreditCard(int idAdquisition, String date, String amount) {
        this.idAdquisition = idAdquisition;
        this.date = date;
        this.amount = amount;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
