
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;



class Admin extends User{
    Scanner scn = new Scanner(System.in);

    // Admin(){
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
            String admin_Id = scn.nextLine();
    
            System.out.print("Enter your Password :"); 
            String password = scn.nextLine();
            
            File newfile = new File("data\\admin data\\"+admin_Id+".txt");
    
            if (newfile.exists()) 
            {
                 Scanner data = new Scanner(newfile);
                 String data_raw = data.nextLine();
                 String[] newdata = data_raw.split(",");
                 data.close();
    
                 boolean found = false;
                 for(int i = 0 ; i < newdata.length; i += 3){ 
                     if (admin_Id.equals(newdata[i]) && password.equals(newdata[i+1])) {
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
            String admin_Id = scn.nextLine();

            System.out.print("Enter a Strong Password :");
            String password = scn.nextLine();

            // File teacher_entry = new File("data\\accounts\\teacher_accounts.txt");
            // FileWriter mywriter = new FileWriter(teacher_entry);
            // mywriter.append(","+teacher_Id);
            // mywriter.close();

            File newfile = new File("data\\admin data\\"+admin_Id+".txt");

            if (!newfile.exists()) {

                System.out.print("Enter Your Name :");
                String name = scn.nextLine();

                System.out.print("Enter Your Favourite Food Name:");
                String food_name = scn.nextLine();

                newfile.createNewFile();

                FileWriter updatedFile = new FileWriter(newfile);

                updatedFile.write(admin_Id+","+password+","+name+","+food_name);
                updatedFile.close();
                
                System.out.print("Sign up Successfull.\n");
                //System.out.print(newfile.getName());03   

                FileWriter myWriter = new FileWriter("data\\accounts\\admin_accounts.txt");
                myWriter.append(admin_Id+",");
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



    public void addStudent(){
        try{

            System.out.print("Enter Student Roll Number :");
            String std_roll = scn.nextLine();

            // System.out.print("Enter a Strong Password :");
            // String password = scn.nextLine();

            File newfile = new File("data\\students data\\"+std_roll+".txt");

            if (!newfile.exists()) {

                
                System.out.print("Enter Student Name :");
                String name = scn.nextLine();

                System.out.print("Enter a Strong Password :");
                String password = scn.nextLine();

                System.out.print("Enter Student's Favourite Food Name:");
                String food_name = scn.nextLine();

                newfile.createNewFile();

                FileWriter updatedFile = new FileWriter(newfile);

                updatedFile.write(std_roll+","+password+","+name+","+food_name);
                updatedFile.close();
                
                System.out.print("Student "+name+" Added Successfully.");
                //System.out.print(newfile.getName());
            }
            else{
                System.out.print("Student already exists.");
            }
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
   }

   void removeStudent(){

    try{
           // Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Student Roll Number : ");
            String std_roll=scn.nextLine();
            File file=new File("data\\students data\\"+std_roll+".txt");
            
        if(file.exists()){

            System.out.println();
            System.out.println("Student Account detected.");
            System.out.println();
            System.out.print("Student Details : ");
            //String std_pass = scanner.nextLine();
            Scanner reader = new Scanner(file);

            String content=reader.nextLine();
            
            String[] data = content.split(",");        
            
            reader.close();
            
            // for(String i: data){
            //     System.out.println(i);
            // }

            System.out.println("Student Name : "+data[2]);
            System.out.println("Student Roll Num : "+data[0]);
            System.out.println("Student Favourite Dish : "+data[3]);
            System.out.println();

            System.out.println("Are you sure you want to delete the student ?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("Select an Option : ");
            
            int choice = scn.nextInt();
                     
            if(choice==1){

                //String name = file.getName();
                file.delete();
                System.out.println("Student has been removed.");

            }

            else{
                System.out.println("Process terminated.");
                System.out.println("Back to the Main Menu.");
                }
                reader.close();
        }
            
    
        else{
                System.out.println("Account does not exist.");
            }      

            
            
// try block ends here
    }

    catch(Exception e){
                System.out.print("An Error occured.");
    }
        }

    public void addTeacher(){
        try{

            System.out.print("Enter Teacher Id :");
            String teacherId = scn.nextLine();

            // System.out.print("Enter a Strong Password :");
            // String password = scn.nextLine();

            File newfile = new File("data\\students data\\"+teacherId+".txt");

            if (!newfile.exists()) {

                
                System.out.print("Enter Teacher Name :");
                String name = scn.nextLine();

                System.out.print("Enter a Strong Password :");
                String password = scn.nextLine();

                System.out.print("Enter Teacher's Favourite Food Name:");
                String food_name = scn.nextLine();

                newfile.createNewFile();

                FileWriter updatedFile = new FileWriter(newfile);

                updatedFile.write(teacherId+","+password+","+name+","+food_name);
                updatedFile.close();
                
                System.out.print("Teacher "+name+" Added Successfully.");
                //System.out.print(newfile.getName());
            }
            else{
                System.out.print("Teacher already exists.");
            }
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }

    }

//     public void removeTeacher(){
//         try{
//             //Scanner scanner =new Scanner(System.in);
//             System.out.print("Enter Teacher ID: ");
//             String teacher_ID= scn.nextLine();
//             File file=new File("data\\teachers data\\"+teacher_ID+".txt");
            
//             if(file.exists()){

//                 System.out.println();
//                 System.out.println("Teacher Account detected.");
//                 System.out.println();
//                 System.out.print("Teacher Details : ");
//                 //String std_pass = scanner.nextLine();
//                 Scanner reader = new Scanner(file);

//                 String content=reader.nextLine();
                
//                 String[] data = content.split(",");        
                
//                 reader.close();
                
//                 // for(String i: data){
//                 //     System.out.println(i);
//                 // }

//                 System.out.println("Teacher Name : "+data[2]);
//                 System.out.println("Teacher Roll Num : "+data[0]);
//                 System.out.println("Teacher Favourite Dish : "+data[3]);
//                 System.out.println();

//                 System.out.println("Are you sure you want to delete the Teacher ?");
//                 System.out.println("1. Yes");
//                 System.out.println("2. No");
//                 System.out.print("Select an Option : ");
                
//             if(scn.hasNextLine()){
                         

//                 String choice = scn.nextLine();

//                 if(choice.equals("1")){

//                     //String name = file.getName();
//                     file.delete();
//                     System.out.println("Teacher has been Successfully removed.");

//                 }

//                 else{
//                     System.out.println("Process terminated.");
//                     System.out.println("Back to the Main Menu.");
//                     }
//                     reader.close();
//             }

//             else {
//                 System.out.println("No input available. Please try again.");
//             }
//         }

            
    
//         else{
//                 System.out.println("Account does not exist.");
//             }      

//             scn.close();
            
// // try block ends here
//     }

//     catch(Exception e){
//         System.out.print("An Error occured.");
//     }
//     }

void removeTeacher(){

    try{
           // Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Teacher Roll Number : ");
            String teacher_ID=scn.nextLine();
            File file=new File("data\\teachers data\\"+teacher_ID+".txt");
            
        if(file.exists()){

            System.out.println();
            System.out.println("Teacher Account detected.");
            System.out.println();
            System.out.print("Teacher Details : ");
            //String std_pass = scanner.nextLine();
            Scanner reader = new Scanner(file);

            String content=reader.nextLine();
            
            String[] data = content.split(",");        
            
            reader.close();
            
            // for(String i: data){
            //     System.out.println(i);
            // }

            System.out.println("Teacher Name : "+data[2]);
            System.out.println("Teacher Roll Num : "+data[0]);
            System.out.println("Teacher Favourite Dish : "+data[3]);
            System.out.println();

            System.out.println("Are you sure you want to delete the Teacher ?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("Select an Option : ");
            
            String choice = scn.nextLine();
                     
            if(choice.equals("1")){

                //String name = file.getName();
                file.delete();
                System.out.println("Teacher has been removed.");

            }

            else{
                System.out.println("Process terminated.");
                System.out.println("Back to the Main Menu.");
                }
                reader.close();
        }
            
    
        else{
                System.out.println("Account does not exist.");
            }      

            
            
// try block ends here
    }

    catch(Exception e){
                System.out.print("An Error occured.");
    }
        }

}