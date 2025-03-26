import java.util.Arrays;

public class userDetails {
    private String username;
    private char[] password;
    //private char[][] oldPasswordStorage = new char[5][];
    //int countLogin = 0;
    //int countChange = 1;
    userDetails(String name,char[] password){
        this.username = name;
        this.password = encryptPassword(password);
    }
    public char[] encryptPassword(char[] pass){
        char[] password = Arrays.copyOf(pass,pass.length);
        for(int i=0;i<password.length;i++){
            char temp = password[i];
            if( temp=='z' ) password[i]='b';
            else if( temp=='Z' ) password[i]='B';
            else if( temp == 'y') password[i]='a';
            else if( temp == 'Y') password[i]='A';
            else password[i] = (char) (temp + 2);
        }

        return password;
    }
    public char[] decryptPassword(char[] pass){
        char[] password = Arrays.copyOf(pass,pass.length);
        for(int i=0;i<password.length;i++){
            char temp = password[i];
            if( temp=='a' ) password[i]='y';
            else if( temp=='A' ) password[i]='Y';
            else if( temp == 'b') password[i]='z';
            else if( temp == 'B') password[i]='Z';
            else password[i] = (char) (temp-2);
        }

        return password;
    }
    public String getUsername() {
        return this.username;
    }

    private boolean checkPassword(char[] oldEncryptPassword,char[] newPassword){
        getPassword();
        char[] oldPassword = decryptPassword(oldEncryptPassword);
       if(oldPassword.length != newPassword.length){
           return false;
       }
       for(int i=0;i<oldPassword.length;i++){
           if(oldPassword[i]!=newPassword[i]){
               return false;
           }
       }
       return true;
    }

    public boolean checkPassword(char[] password){
        getPassword();
        char[] oldPassword = this.password;
        return checkPassword(oldPassword,password);
    }
    public boolean setPassword(char[] newPassword,char[] hisPassword) {
        char[] oldPassword = this.password;
        if(checkPassword(oldPassword,hisPassword)){
            if(checkPassword(oldPassword,newPassword)){
                return false;
            }
            else{
                this.password = encryptPassword(newPassword);
                return true;
            }
        }
        else{
            return false;
        }
    }

    public void getPassword(){
        System.out.println("decrypt->"+" "+new String(decryptPassword(this.password)));
        System.out.println("encrypt->"+" "+new String(this.password);
    }
}
