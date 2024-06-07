package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PatientsDB {
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
        void insertTable(String name,int age,String gender){
            try{
            Statement st=con.createStatement();
            String insertTable=String.format("INSERT INTO patients(name,age,gander)VALUES(%s,%s,%s)",name,age,gender);
            int rowAffected=st.executeUpdate(insertTable);
            if(rowAffected>0){
                System.out.println("Sucessfully inserted");
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        public void displayPatientsList(){
            StringBuilder sb=new StringBuilder();
            try{
                
                Statement st=con.createStatement();
                String displayTable="SELECT * FROM patients";
                ResultSet rs=st.executeQuery(displayTable);
                while(rs.next()){
                    int id=rs.getInt("id");
                    int age=rs.getInt("age");
                    String name=rs.getString("name");
                    String gender=rs.getString("gender");

                    sb.append("Id :" +id).append("\n");
                    sb.append("age :" +age).append("\n");
                    sb.append("name:" +name).append("\n");
                    sb.append("gender :" +gender).append("\n");

                    System.out.println(sb.toString());
                    
                }

            }catch(Exception e){
                e.printStackTrace();
            }
         
        }

        boolean checkPatients(int id){
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