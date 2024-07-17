import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;


public class Student extends User{
    
    

    // Student(){
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

    // public void login(){
    //     int length = 0;
    //     try{
    //         System.out.print("Enter Your Roll Number :");
    //         String roll_no = scn.nextLine();
 
    //         System.out.print("Enter Your Password :"); 
    //         String password = scn.nextLine();
    //         scn.close();
            
    //         File newfile = new File("data\\students data\\"+roll_no+".txt");
    //         if (newfile.exists()) 
    //         {
    //              Scanner data = new Scanner(newfile);
    //              String data_raw = data.nextLine();
    //              String[] newdata = data_raw.split(",");
    //              for(String datalocal : newdata){
    //                  length+=1;
    //              }
    //              data.close();
 
    //              for(int i = 0 ; i < length ; i++){
    //                  if ((roll_no.equals(newdata[i])) && (password.equals(newdata[i+1]))) {
    //                      System.out.print("Welcome "+newdata[i + 2]);   
    //                      break;
    //                  }
    //                  else{
    //                      System.out.print("Account does not exist. Try Again!");
    //                      break;
    //                  }
    //              }
    //          }
    //         else{
    //         System.out.print("Enter correct Credentials.");
    //         }
    //     }
    //     catch(Exception e){
    //         System.out.print("An Error occured.");
    //     }
 
    // }
    
    public void login(){
        try{
            Scanner scn = new Scanner(System.in); 
            System.out.print("Enter Your Roll Number :");
            String roll_no = scn.nextLine();
    
            System.out.print("Enter Your Password :"); 
            String password = scn.nextLine();
            
            File newfile = new File("data\\students data\\"+roll_no+".txt");
            if (newfile.exists()) 
            {
                 Scanner data = new Scanner(newfile);
                 String data_raw = data.nextLine();
                 String[] newdata = data_raw.split(",");
                 data.close();
    
                 boolean found = false;
                 for(int i = 0 ; i < newdata.length; i += 3){ 
                     if (roll_no.equals(newdata[i]) && password.equals(newdata[i+1])) {
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
            scn.close();
            
        }
        catch(Exception e){
            System.out.println("An Error occurred.");
        }
    }
    
    

    public void signup(){

        
        try{
            Scanner scn = new Scanner(System.in);
    
            System.out.println("Enter Roll Number :");
            String roll_no = scn.nextLine();
    
            System.out.println("Enter a Strong Password :");
            String password = scn.nextLine();
    
            File newfile = new File("data\\students data\\"+roll_no+".txt");
    
            if (!newfile.exists()) {
    
                System.out.print("Enter Your Name :");
                String name = scn.nextLine();
    
                System.out.print("Enter Your Favourite Food Name:");
                String food_name = scn.nextLine();
    
                newfile.createNewFile();
    
                FileWriter updatedFile = new FileWriter(newfile,true);
    
                updatedFile.write(roll_no+","+password+","+name+","+food_name);
                updatedFile.close();
                
                System.out.print("Sign up Successfull.\n");
                //System.out.print(newfile.getName());
    
                FileWriter myWriter = new FileWriter("data\\accounts\\student_accounts.txt",true);
                myWriter.append(roll_no+",");
                myWriter.close();
            }
            else{
                System.out.print("Account already exists.");
            }

            scn.close();
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
    
    
   
   public void attemptQuiz() {
    try {
        System.out.println();
        System.out.print("Enter Roll Number: ");
        String roll_num = scn.nextLine();

        File file = new File("data\\accounts\\student_accounts.txt");
        Scanner reader = new Scanner(file);
        String content = reader.nextLine();
        String[] students_account = content.split(",");
        reader.close();

        boolean fileExists = false;

        for (String id : students_account) {
            if (id.equals(roll_num)) {
                fileExists = true;
                break;
            }
        }

        if (fileExists) {
            System.out.println("Account detected.");
            System.out.println();

            File std_file = new File("data\\students data\\" + roll_num + ".txt");
            Scanner student_reader = new Scanner(std_file);
            String student_info = student_reader.nextLine();
            String[] student_credentials = student_info.split(",");
            student_reader.close();

            System.out.print("Enter your password: ");
            String student_password = scn.nextLine();
            System.out.println();

            if (student_password.equals(student_credentials[1])) {
                File quizes_file = new File("data\\uploaded quizes by teachers\\quiz names.txt");
                Scanner quizes_reader = new Scanner(quizes_file);
                String quiz_names = quizes_reader.nextLine();
                String[] quizes = quiz_names.split(",");
                quizes_reader.close();

                System.out.println("Select Quiz.");
                for (int x = 0; x < quizes.length; x++) {
                    if (quizes[x] != null) {
                        System.out.println((x + 1) + ") " + quizes[x]);
                    }
                }

                System.out.print("Enter Quiz no. you want to attempt: ");
                int quiz_to_attempt = scn.nextInt();
                scn.nextLine(); // Consume the newline character

                File questions_file = new File("data\\quizes\\" + quizes[quiz_to_attempt - 1] + ".txt");
                Scanner questions_reader = new Scanner(questions_file);

                System.out.print("Enter Security Key: ");
                String sec_key = scn.nextLine();

                boolean correctKey = false;
                while (questions_reader.hasNextLine()) {
                    String quiz_credentials = questions_reader.nextLine();
                    String[] credentials = quiz_credentials.split(",");

                    if (sec_key.equals(credentials[2])) {
                        correctKey = true;
                        break;
                    }
                }

                if (!correctKey) {
                    questions_reader.close();
                    throw new IncorrectKeyException("Incorrect security key.");
                }

                System.out.println("Quiz Started.");
                System.out.println();

                int marks = 0;
                int question_count = 0;
                while (questions_reader.hasNextLine()) {
                    String question_content = questions_reader.nextLine();
                    String[] question_values = question_content.split(",");

                    if (question_values.length < 6) {
                        continue; // Skip lines that do not have enough data
                    }

                    System.out.println("Q." + (question_count + 1) + ") " + question_values[0]);
                    for (int i = 1; i <= 4; i++) {
                        System.out.println(i + ") " + question_values[i]);
                    }
                    System.out.println();

                    System.out.print("Choose the Correct Answer: ");
                    System.out.println();
                    int answer = scn.nextInt();
                    scn.nextLine(); // Consume the newline character

                    if (question_values[answer].equals(question_values[5])) {
                        marks++;
                    }

                    question_count++;
                }
                questions_reader.close();
                System.out.println("Marks Obtained: " + marks + "/" + question_count);
            } else {
                System.out.println("Incorrect password.");
            }
        } else {
            System.out.println("Account not found.");
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

   

public void viewQuizes() {
    try {
        File quizes_file = new File("data\\uploaded quizes by teachers\\quiz names.txt");
        Scanner quizes_reader = new Scanner(quizes_file);

        if (!quizes_reader.hasNextLine()) {
            quizes_reader.close();
            throw new NoQuizFoundException("No Quiz found.");
        }

        String quiz_names = quizes_reader.nextLine();
        quizes_reader.close();

        if (quiz_names.trim().isEmpty()) {
            throw new NoQuizFoundException("No Quiz found.");
        }

        String[] quizes = quiz_names.split(",");

        System.out.println("All Quizzes:");
        for (int x = 0; x < quizes.length; x++) {
            if (quizes[x] != null && !quizes[x].trim().isEmpty()) {
                System.out.println((x + 1) + ") " + quizes[x]);
            }
        }
    } catch (NoQuizFoundException e) {
        System.out.println("Quiz file not found.");
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
}

   
   
    
    public void viewMarks(){

    }

    public void viewAnswers(){
        
    }
    
    public void viewLeaderboard(){

    }


}