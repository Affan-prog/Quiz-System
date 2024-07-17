import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;


public abstract class User{

    // String userName ;
    // String userId ;
    // String password ;
    // String fav_food ;
    Scanner scn = new Scanner(System.in);

    abstract void login();
    // abstract void logout();
    
    public void reset_Password(){
        int length=0;

        System.out.print("Do you want to reset your password? ");
        String answer = scn.nextLine();
        try{
            if (answer.equals("yes")) {

                System.out.print("Enter your Roll Number :");
                String roll_no = scn.nextLine();
                
                System.out.print("Enter Your Favourite Food Name: :");
                String food_name = scn.nextLine();

                File newFile = new File("data\\students data\\"+roll_no+".txt");

                Scanner updatedFile = new Scanner(newFile);
                String data_raw = updatedFile.nextLine();

                updatedFile.close();

                String[] newdata = data_raw.split(",");

                for(String datalocal : newdata){
                    length+=1;
                }

                for(int i = 0 ; i < length ; i++){

                    if ((roll_no.equals(newdata[i])) && (food_name.equals(newdata[i+3]))) {
                        
                        System.out.println("Welcome "+newdata[i + 2]);

                        System.out.print("Enter a new password :");
                        String password = scn.nextLine();

                        System.out.print("Confirm your new password :");
                        String Confirm_password = scn.nextLine();

                        while(password.equals(Confirm_password)){

                            if (!password.equals(Confirm_password)) {
                                System.out.print("Passwords dont match.");
                                System.out.println();
                                System.out.print("Re-enter your password :");
                                System.out.print("Confirm your new password :");
                                String Confirm_password1 = scn.nextLine();
                                Confirm_password = Confirm_password1;
                            }
                            else{
                                newdata[i + 1] = password;
                                String name = newdata[i + 2];
                                File newFile2 = new File("data\\students data\\"+roll_no+".txt");
                                FileWriter updatedFile2 = new FileWriter(newFile2);
                                updatedFile2.write(roll_no+","+password+","+name+","+food_name);
                                updatedFile2.close();
                
                                System.out.print("Your Password has been Successfully reset.");
                                break;
                            
                            }
                        }
                        break;
                    }
                    else{
                        System.out.print("Enter Valid Credentials.");
                        break;
                    }
                }
                
            }
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
   }
    
}