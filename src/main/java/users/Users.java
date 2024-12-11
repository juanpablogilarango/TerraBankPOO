package users;

public class Users {
    private int idUser;
        private String nameUser, lastNameUser, emailUser, birthdateUser, passwordUser;

    public Users(String emailUser, String nameUser ,String passwordUser){
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
        this.nameUser = nameUser;
    }


    public void setIdUser(int idUser){
        this.idUser = idUser;
    }

    public int getIdUser(){
        return this.idUser;
    }

    public void setNameUser(String nameUser){
        this.nameUser = nameUser;
    }

    public String getNameUser(){
        return this.nameUser;
    }

    public void setLastNameUser(String lastNameUser) {
        this.lastNameUser = lastNameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public String getEmailUser(){
        return emailUser;
    }

    public void setBirthdateUser(String birthdateUser){
        this.birthdateUser = birthdateUser;
    }

    public String getBirthdateUser(){
        return birthdateUser;
    }

    public void setPasswordUser(String passwordUser){
        this.passwordUser = passwordUser;
    }

    public String getPasswordUser(){
        return this.passwordUser;
    }
}
