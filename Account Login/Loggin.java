import java.util.*;

public class Loggin {
    private List<userDetails> details = new ArrayList<userDetails>();

    public boolean addUser(String name,char[] password){
        userDetails newUser = new userDetails(name, password);
        details.add(newUser);
        return true;
    }

    public boolean login(String name,char[] password){
        for(  userDetails detail : details  ){
            String username = detail.getUsername();
            if(username.equals(name) && detail.checkPassword(password)){
                detail.countLogin++;
                return true;
            }

        }
        return false;
    }
    public boolean checkUsername(String newUsername) {
        for (userDetails detail : details) {
            String username = detail.getUsername();
            if (username.equals(newUsername))
                return true;
        }
        return false;
    }



}
