import java.sql.*;

public class StudentDao
{
    String url = "jdbc:mysql://localhost:3306/testdb";
    String userName = "root";
    String password = "password";
    Connection connection = null;
    public void connect()
    {
        System.out.println("Connected");
        try
        {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected");
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }

    public Student getStudent(int rollno)
    {
        Student student = new Student();
        student.rollNo = rollno;

        try {
            String query = "select StudentName from Student where StudentId ="+ 1789;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            System.out.println(resultSet);
            String name = resultSet.getString(1);
            student.name = name;
            return student;
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
        return null;
    }

    public void addStudent(Student student)
    {
        String query = "insert into Student values(?, ?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,student.rollNo);
            preparedStatement.setString(2,student.name);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
