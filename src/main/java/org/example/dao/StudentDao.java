package org.example.dao;

import org.example.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String username = "postgres";
    private final String password = "nihad29";

    // Bağlantını almaq üçün metod
    private Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    // Tələbə məlumatlarını saxlamaq üçün metod
    public void save(Student student) {
        String sql = "INSERT INTO students (name, surname, age, grade) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(sql)) {


            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setInt(3, student.getAge());
            statement.setInt(4, student.getGrade());

            // SQL sorğunu icra edin
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Tələbə məlumatlarını yeniləmək üçün metod (ad və soyada görə)
    public void update(Student student, String name, String surname) {
        String sql = "UPDATE students SET age = ?, grade = ? WHERE name = ? AND surname = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, student.getAge());
            statement.setInt(2, student.getGrade());
            statement.setString(3, name);
            statement.setString(4, surname);

            // SQL sorğunu icra edin
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Tələbə uğurla yeniləndi!");
            } else {
                System.out.println("Tələbə tapılmadı!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
