package HospitalManagementSystem;

import java.util.Scanner;

public class BookAppointement {
    private Scanner scanner;
    BookAppointement(Scanner scanner){
        this.scanner=scanner;
    }
    BookAppointementDB bookapdb=new BookAppointementDB();
    public void BookAppointement(Patients p,Doctor d){
        System.out.println("Enter Patient ID: ");
        int patient_id=scanner.nextInt();
        System.out.println("Enter Doctor ID: ");
        int doctor_id=scanner.nextInt();
        System.out.println("Enter appointment date(YYYY-MM-DD)");
        String appointmentDate=scanner.next();
        if(p.getPatientById(patient_id) && d.getDoctorById(doctor_id)){
            if(checkDoctorAvailabilty(doctor_id,appointmentDate)){
                bookapdb.insertTable(patient_id,doctor_id,appointmentDate);
            }else{
                System.out.println("Doctor not available on this date");
            }
        }else{
            System.out.println("Either doctor or patient doesn't exits");
        }
    }
    public boolean checkDoctorAvailabilty(int doctor_id,String appointmentDate){
        return bookapdb.checkDoctorIsAvailable(doctor_id, appointmentDate);
    }
    
}
