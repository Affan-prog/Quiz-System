// public class Main {
//     public static void main(String[] args) {
//         // Admin affan = new Admin();
//         // affan.addStudent();

//         // affan.removeTeacher();


//         Teacher rehan = new Teacher();
//         // rehan.signup();
//         rehan.uploadQuiz();
        
//         Student affan = new Student();
//         // affan.signup();
//         // affan.attemptQuiz();
        


//     }
// }


import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runQuizApp();
    }

    public static void runQuizApp() {
        try {
            while (true) {
                System.out.println();
                System.out.println("Welcome to QUIZ APP");
                System.out.println("Select Mode:");
                System.out.println("1. Student Mode");
                System.out.println("2. Teacher Mode");
                System.out.println("3. Admin Mode");
                System.out.print("Enter the number corresponding to your mode: ");
                String mode = scanner.nextLine();
                

                if (mode.equals("1")) {
                    Student student = studentLogin();
                    if (student != null) {
                        showStudentMenu(student);
                    }
                } else if (mode.equals("2")) {
                    Teacher teacher = teacherLogin();
                    if (teacher != null) {
                        showTeacherMenu(teacher);
                    }
                } else if (mode.equals("3")) {
                    Admin admin = adminLogin();
                    if (admin != null) {
                        showAdminMenu(admin);
                    }
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
                
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            // runQuizApp();
        }
    }

    public static Student studentLogin() {
        // System.out.println("\nStudent Login/Signup");
        return new Student();
    }

    public static Teacher teacherLogin() {
        // System.out.println("\nTeacher Login/Signup");
        return new Teacher();
    }

    public static Admin adminLogin() {
        // System.out.println("\nAdmin Login/Signup");
        return new Admin();
    }

    public static void showStudentMenu(Student student) {
        try {
            while (true) {
                System.out.println("\nStudent Menu:");
                System.out.println("1. Attempt Quiz");
                System.out.println("2. View Quizzes");
                System.out.println("0. Back to Main Menu");
                System.out.println("Enter your choice: ");
                String choice = scanner.nextLine();
                // scanner.close();

                if (choice.equals("1")) {
                    student.attemptQuiz();
                } else if (choice.equals("2")) {
                    student.viewQuizes();
                } else if (choice.equals("0")) {
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }

            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void showTeacherMenu(Teacher teacher) {
        try {
            while (true) {
                System.out.println("\nTeacher Menu:");
                System.out.println("1. Upload Quiz");
                System.out.println("0. Back to Main Menu");
                System.out.print("Enter your choice: ");
                String choice = scanner.nextLine();

                if (choice.equals("1")) {
                    teacher.uploadQuiz();
                } else if (choice.equals("0")) {
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void showAdminMenu(Admin admin) {
        try {
            while (true) {
                System.out.println("\nAdmin Menu:");
                System.out.println("1. Add Students");
                System.out.println("2. Remove Students");
                System.out.println("3. Add Teachers");
                System.out.println("4. Remove Teachers");
                System.out.println();
                System.out.println("0. Back to Main Menu");
                System.out.print("Enter your choice: ");
                
                
            if(scanner.hasNextLine()){
                    String choice = scanner.nextLine();
                    
                if (choice.equals("1")) {
                    admin.addStudent();
                } else if (choice.equals("2")) {
                    admin.removeStudent();
                } else if (choice.equals("3")) {
                    admin.addTeacher();
                } else if (choice.equals("4")) {
                    admin.removeTeacher();
                } else if (choice.equals("0")) {
                    break;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }

            }
            
            else {
                System.out.println("No input available. Please try again.");
            }
             
    }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

