public class userDetails {
    private String username;
    private char[] password;

    int countLogin;
    userDetails(String name,char[] password){
        this.username = name;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    private boolean checkPassword(char[] oldPassword,char[] newPassword){
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
                this.password = newPassword;
                return true;
            }
        }
        else{
            return false;
        }



    }
}
