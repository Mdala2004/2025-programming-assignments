import java.util.*;

public class TestHospitalER {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        HospitalERSystem erRoom = new HospitalERSystem();

        //Er system menu
        while(true){
            System.out.println("Hospital ER Menu");
            System.out.println("1. Admit patient");
            System.out.println("2. Treat patient");
            System.out.println("3. Undo last treatment");
            System.out.println("4. Show queue");
            System.out.println("5. Show history");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            while(choice > 5 || choice < 0){
                System.out.println("Enter input again: ");
                choice = sc.nextInt();
                sc.nextLine();
            }

            switch(choice){
                case 1:
                    System.out.println("Enter these details to admit a patient: ");
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter surname: ");
                    String surname = sc.nextLine();

                    String priority = "";

                    while (true) {
                        System.out.print("Enter priority (emergency or normal): ");
                        priority = sc.nextLine().toLowerCase();

                        if (priority.equals("emergency") || priority.equals("normal")) {
                            break;
                        } else {
                            System.out.println("Invalid input. Please type 'emergency' or 'normal'.");
                        }
                    }

                    HospitalERSystem.Patient patient = new HospitalERSystem.Patient(name, surname, priority);// references the patient class in er system class and puts its parameters in place

                    try {
                        erRoom.admitPatient(patient);
                    } catch (IllegalArgumentException e) {//a catch all exception to stop any sort of illegal inputs
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;//from the switch

                    case 2: 
                        erRoom.treatPatient();
                        break;
                    case 3:
                        erRoom.undoLastTreatment();
                        break;
                    case 4:
                        erRoom.displayQueue();
                        break;
                    case 5:
                        erRoom.displayHistory();
                        break;
                    case 0:
                        System.out.println("Exiting program.");
                        break;
                    default:
                        System.out.println("Invalid input. Use numbers between 0 and 5.");
            }

            if(choice == 0){
                break;
            }
        } 
        sc.close();
    }
}
