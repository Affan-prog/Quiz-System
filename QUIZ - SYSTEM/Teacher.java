import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
// import java.io.FileReader;



public class Teacher extends User{

    // Teacher(){
    //     this.up_or_in();
    // }

    // public void up_or_in(){
    //     Scanner scn = new Scanner(System.in);

    //     System.out.println("1) Login");
    //     System.out.println("2) Signup");
    //     System.out.print("Select an option (1-2) : ");
    //     int input = scn.nextInt();

    //     if(input==1){
    //         this.login();
    //     }
    //     else if(input==2){
    //         this.signup();
    //     }
    //     else{
    //         scn.close();
    //         throw new IncorrectKeyException("Invalid Input.");
    //     }
    //     scn.close();

    // }
    


    public void login(){
        try{
            Scanner scn = new Scanner(System.in);
            System.out.print("Enter your Id :");
            String teacher_Id = scn.nextLine();
    
            System.out.print("Enter your Password :"); 
            String password = scn.nextLine();
            
            File newfile = new File("data\\teachers data\\"+teacher_Id+".txt");
    
            if (newfile.exists()) 
            {
                 Scanner data = new Scanner(newfile);
                 String data_raw = data.nextLine();
                 String[] newdata = data_raw.split(",");
                 data.close();
    
                 boolean found = false;
                 for(int i = 0 ; i < newdata.length; i += 3){ 
                     if (teacher_Id.equals(newdata[i]) && password.equals(newdata[i+1])) {
                         System.out.println("Welcome "+newdata[i + 2]);   
                         found = true;
                         break;
                     }
                 }
                 if (!found) {
                     System.out.println("Account does not exist. Try Again!");
                 }
             } else {
                System.out.println("Enter correct Credentials.");
            }

        }
        catch(Exception e){
            System.out.println("An Error occurred.");
        }
    }
    

    public void signup(){
        try{

            System.out.print("Enter your Id :");
            String teacher_Id = scn.nextLine();

            System.out.print("Enter a Strong Password :");
            String password = scn.nextLine();

            // File teacher_entry = new File("data\\accounts\\teacher_accounts.txt");
            // FileWriter mywriter = new FileWriter(teacher_entry);
            // mywriter.append(","+teacher_Id);
            // mywriter.close();

            File newfile = new File("data\\teachers data\\"+teacher_Id+".txt");

            if (!newfile.exists()) {

                System.out.print("Enter Your Name :");
                String name = scn.nextLine();

                System.out.print("Enter Your Favourite Food Name:");
                String food_name = scn.nextLine();

                newfile.createNewFile();

                FileWriter updatedFile = new FileWriter(newfile);

                updatedFile.write(teacher_Id+","+password+","+name+","+food_name);
                updatedFile.close();
                
                System.out.print("Sign up Successfull.\n");
                //System.out.print(newfile.getName());03   

                FileWriter myWriter = new FileWriter("data\\accounts\\teacher_accounts.txt");
                myWriter.append(","+teacher_Id);
                myWriter.close();
            }
            else{
                System.out.print("Account already exists.");
            }
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
   }

   public void uploadQuiz() {
    try {
        String repeat = "yes";

        System.out.print("Enter teacher's Id: ");
        String teacher_Id = scn.nextLine();

        System.out.print("Enter teacher's name: ");
        String teacher_name = scn.nextLine();

        File file = new File("data\\accounts\\teacher_accounts.txt");
        Scanner reader = new Scanner(file);
        String content = reader.nextLine();
        String[] teachers_account = content.split(",");
        reader.close();

        boolean fileExists = false;

        for (String id : teachers_account) {
            if (id.equals(teacher_Id)) {
                System.out.println("Account Detected.");
                fileExists = true;
                break;
            }
        }

        if (fileExists) {
            System.out.print("Enter name of the Quiz: ");
            String quiz_name = scn.nextLine();

            System.out.print("Set security key for this Quiz: ");
            String sec_key = scn.nextLine();

            File quiz_file = new File("data\\quizes\\" + quiz_name + ".txt");

            if (!quiz_file.exists()) {
                quiz_file.createNewFile();

                FileWriter myWriter = new FileWriter(quiz_file, true);
                myWriter.append(teacher_Id + "," + quiz_name + "," + sec_key + "\n");

                int c = 1;
                while (repeat.equals("yes")) {
                    System.out.print("Enter question no." + c + ": ");
                    String ques = scn.nextLine();

                    String[] question_info = new String[6];
                    question_info[0] = ques;

                    System.out.println("Enter your any 4 options.");
                    for (int i = 1; i <= 5; i++) {
                        if (i == 5) {
                            System.out.println("Select the correct option for this question: ");
                            for (int x = 0; x < question_info.length; x++) {
                                if (x == 0 || x == 5) {
                                    continue;
                                } else {
                                    System.out.println(x + ") " + question_info[x]);
                                }
                            }

                            System.out.print("Enter the correct option number from the above options: ");
                            String correct_opt = scn.nextLine().trim();

                            if (correct_opt.equals("1")) {
                                question_info[5] = question_info[1];
                            } else if (correct_opt.equals("2")) {
                                question_info[5] = question_info[2];
                            } else if (correct_opt.equals("3")) {
                                question_info[5] = question_info[3];
                            } else if (correct_opt.equals("4")) {
                                question_info[5] = question_info[4];
                            } else {
                                System.out.println("Invalid Input.");
                                continue;
                            }

                            System.out.println("Correct answer has been set successfully.");

                            String to_save = String.join(",", question_info);
                            myWriter.append(to_save + "\n");

                        } else {
                            System.out.print("Enter option no." + i + ": ");
                            String options = scn.nextLine();
                            question_info[i] = options;
                        }
                    }
                    System.out.print("Do you want to enter another question? Yes/No: ");
                    repeat = scn.nextLine();
                    if (!repeat.equalsIgnoreCase("yes")) {
                        repeat = "no";
                        System.out.println("Quiz uploaded successfully.");
                    }
                    c += 1;
                }
                myWriter.close();

                // Quiz entry in all quizes record
                File quiz_entry = new File("data\\quizes info\\all quizes record.txt");
                FileWriter mywriter = new FileWriter(quiz_entry, true);
                mywriter.append(teacher_name + "," + teacher_Id + "," + quiz_name + "," + sec_key + "\n");
                mywriter.close();

                // Quiz entry in quiz names
                File quiz_names_file = new File("data\\uploaded quizes by teachers\\quiz names.txt");
                FileWriter quiz_writer = new FileWriter(quiz_names_file, true);
                quiz_writer.append(quiz_name+",");
                quiz_writer.close();
            } else {
                System.out.println("Quiz already exists.");
            }
        } else {
            throw new FileNotFoundException("Teacher with this Id does not exist.");
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}





}
