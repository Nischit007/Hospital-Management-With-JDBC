package HospitalManagementSystem;


import java.util.Scanner;

public class Patients {

    private Scanner scanner;

    public Patients(Scanner scanner){
        this.scanner=scanner;
    }
    PatientsDB pDB=new PatientsDB();

    
    public void addPatient(){
        pDB.connectDb();
        System.out.print("Enter Patient Name: ");
        String name=scanner.next();
        System.out.print("Enter Patient Age: ");
        int age=scanner.nextInt();
        System.out.print("Enter Patients Gender: ");
        String gender=scanner.next();

        
        pDB.connectDb();
        pDB.insertTable(name, age, gender);  
    }
    void displayPatientsDetail(){
        pDB.displayPatientsList();
    }

    boolean getPatientById(int id){
        boolean isTrue=pDB.checkPatients(id);
        return isTrue;
    }

}
