package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DoctorDB {
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

        public void displayDoctorsList(){
            StringBuilder sb=new StringBuilder();
            try{
                
                Statement st=con.createStatement();
                String displayTable="SELECT * FROM doctors";
                ResultSet rs=st.executeQuery(displayTable);
                while(rs.next()){
                    int id=rs.getInt("id");
                    String name=rs.getString("name");
                    String gender=rs.getString("specialization");

                    sb.append("Doctor Id :" +id).append("\n");
                    sb.append("name:" +name).append("\n");
                    sb.append("gender :" +gender).append("\n");

                    System.out.println(sb.toString());
                    
                }

            }catch(Exception e){
                e.printStackTrace();
            }
         
        }

        boolean checkDoctors(int id){
            try{
                
                Statement st=con.createStatement();
                String displayTable="SELECT * FROM patients";
                ResultSet rs=st.executeQuery(displayTable);
                while(rs.next()){
                    int pid=rs.getInt("id");
                    if(id==pid){
                        return true;
                    }

                }
                
            }catch(Exception e){

                }

        
    return false;



    }
}