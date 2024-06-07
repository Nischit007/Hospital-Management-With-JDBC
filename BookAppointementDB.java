package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class BookAppointementDB {
     Connection con;
            private final String url="jdbc:postgresql://localhost:5432/postgres";
            private final String userName="postgres";
            private final String password="123";

                    void connectDb(){
            try{
                con=DriverManager.getConnection(url,userName,password);
                System.out.println("Connection success!! ");
            }catch(Exception e){
                System.out.println(e);
            }

        }
                void insertTable(int patient_id,int doctor_id,String appointmentDate){
            try{
            Statement st=con.createStatement();
            String insertTable=String.format("INSERT INTO patients(name,age,gander)VALUES(%s,%s,%s)",patient_id,doctor_id,appointmentDate);
            int rowAffected=st.executeUpdate(insertTable);
            if(rowAffected>0){
                System.out.println("Sucessfully inserted");
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

       boolean checkDoctorIsAvailable(int doctor_id, String appointmentDate) {
        String query = "SELECT COUNT(*) FROM appointments WHERE doctor_id = ? AND appointment_date = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, doctor_id);
            pstmt.setString(2, appointmentDate);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count == 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        }
}
