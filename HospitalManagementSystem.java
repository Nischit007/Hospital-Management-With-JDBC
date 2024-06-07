package HospitalManagementSystem;

import java.util.Scanner;

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Doctor doctor=new Doctor();
        BookAppointement bookap=new BookAppointement(scanner);
        Patients p=new Patients(scanner); 
        while(true){
            System.out.println("HOSPITAL MAANGEMENT SYSTEM");
             System.out.println("1. Add Patient");
             System.out.println("2. View Patients");
             System.out.println("3. View Doctors");
             System.out.println("4. Book Appointment");
             System.out.println("5. Exit");

             System.out.println("Enter your choice");
             int choice=scanner.nextInt();
             switch(choice){
                case 1:
                // Add Patient
                p.addPatient();
                break;
                case 2:
                // View Patients
                p.displayPatientsDetail();
                break;
                case 3:
                // View Doctors
                doctor.displayDoctorDetail();
                break;
                case 4:
                // Book Appointment
                bookap.BookAppointement(p, doctor);
                break;
                case 5:
                // exit
                return;
                default:
                System.out.println("Enter valid choice!!!");

             }



        }
    }
}





// create table appointments(
// 	id  SERIAL PRIMARY KEY,
// 	patient_id int NOT NULL,
// 	doctor_id int NOT NULL,
// 	appointment_date DATE NOT NULL,
// 	FOREIGN KEY(patient_id) REFERENCES patients(id),
// 	FOREIGN KEY(doctor_id) REFERENCES doctors(id)
	
// );