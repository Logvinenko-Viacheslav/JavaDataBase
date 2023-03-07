package main;

import java.sql.*;

public class Main {

    private Connection connection;
    public static void main(String[] args) {
        Main prog = new Main();
        prog.run();
    }

    private  void run(){
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/university", "TeSla", "123");
             try (
                 PreparedStatement ps = connection.prepareStatement("select * from student");
                 ResultSet rs = ps.executeQuery())
                 {
                     while (rs.next()) {
                         int id = rs.getInt("id");
                         String name = rs.getString("name");
                         String surname = rs.getString("surname");
                         String patronymic = rs.getString("patronymic");
                         String birthDate = rs.getString("birthDate");
                         String address = rs.getString("address");
                         String mobilePhone = rs.getString("mobilePhone");
                         String faculty = rs.getString("faculty");
                         int course = rs.getInt("course");
                         String clas = rs.getNString("class");
                         System.out.println(id);
                     }
                 }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
