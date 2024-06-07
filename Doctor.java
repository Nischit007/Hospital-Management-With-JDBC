package HospitalManagementSystem;


import java.util.Scanner;

public class Doctor {



    public Doctor(){

     
    }
    DoctorDB dDB=new DoctorDB();
  
    
    
    void displayDoctorDetail(){
        dDB.connectDb();
        dDB.displayDoctorsList();
    }

    boolean getDoctorById(int id){
        dDB.connectDb();
        boolean isTrue=dDB.checkDoctors(id);
        return isTrue;
    }
}
