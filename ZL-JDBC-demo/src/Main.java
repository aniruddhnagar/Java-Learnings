import java.sql.*;
import java.util.Scanner;

public class Main {
    //    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String url = "jdbc:mysql://localhost:3306/lenden";
    private static final String username = "root";
    private static final String password = "ruddh";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, password);
//            Statement statement = connection.createStatement();

//            =============== INSERT ==============
//            String query1 = String.format("INSERT INTO students(name, age, marks) VALUES('%s', %o, %f)", "Rahul", 31, 80.5);

//            ================= UPDATE ==============
//            String query2 = String.format("UPDATE students SET marks = %f WHERE id = %d", 86.5, 3);

//            =================== DELETE ==============
//            String query3 = "DELETE from students WHERE id=3";
//
//            int rowsAffected = statement.executeUpdate(query3);
//            if(rowsAffected > 0){
//                System.out.println("Data inserted Successfully!");
//            }else{
//                System.out.println("Data not inserted!");
//            }

//            String query4 = "INSERT INTO students(name, age, marks) VALUES(?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(query4);
//            preparedStatement.setString(1, "Umesh");
//            preparedStatement.setInt(2, 28);
//            preparedStatement.setDouble(3, 94.7);
//
//            int pRowsAffected = preparedStatement.executeUpdate();
//            if(pRowsAffected > 0){
//                System.out.println("Data inserted Successfully!");
//            }else{
//                System.out.println("Data not inserted!");
//            }

//            String query5 = "SELECT marks FROM students WHERE id = ?";
//            PreparedStatement preparedStatement1 = connection.prepareStatement(query5);
//            preparedStatement1.setInt(1, 1);

//            String query6 = "UPDATE students SET marks = ? WHERE id = ?";
//            PreparedStatement preparedStatement2 = connection.prepareStatement(query6);
//            preparedStatement2.setDouble(1, 78.5);
//            preparedStatement2.setInt(2, 6);
//            int pRowsAffected = preparedStatement2.executeUpdate();
//            if(pRowsAffected > 0){
//                System.out.println("Data inserted Successfully!");
//            }else{
//                System.out.println("Data not inserted!");
//            }
//
//            String query7 = "DELETE FROM students WHERE id = ?";
//            PreparedStatement preparedStatement3 = connection.prepareStatement(query7);
//            preparedStatement3.setInt(1, 4);
//            int pRowsAffected = preparedStatement3.executeUpdate();
//            if(pRowsAffected > 0){
//                System.out.println("Data inserted Successfully!");
//            }else{
//                System.out.println("Data not inserted!");
//            }


            //Batch processing------------------------
//            Scanner scanner = new Scanner(System.in);
//            while(true){
//                System.out.println("Enter name: ");
//                String name = scanner.next();
//                System.out.println("Enter age: ");
//                int age = scanner.nextInt();
//                System.out.println("Enter marks: ");
//                double marks = scanner.nextDouble();
//                System.out.println("Enter more data(Y/N): ");
//                String choice = scanner.next();
//                String query8 = String.format("INSERT INTO students(name, age, marks) VALUES('%s', %d, %f)", name, age, marks);
//
//                statement.addBatch(query8);
//
//                if(choice.toUpperCase().equals("N")){
//                    break;
//                }
//            }
//
//            int[] arr = statement.executeBatch();
//            for(int i = 0; i < arr.length ; i++) {
//                if(arr[i] == 0){
//                    System.out.println("Query: " + i + " not executed");
//                }
//            }

            //Batch processing------------------------
//            String query9 = "INSERT INTO students(name, age, marks) VALUES(?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(query9);
//            Scanner scanner = new Scanner(System.in);
//            while(true){
//                System.out.println("Enter name: ");
//                String name = scanner.next();
//                System.out.println("Enter age: ");
//                int age = scanner.nextInt();
//                System.out.println("Enter marks: ");
//                double marks = scanner.nextDouble();
//                System.out.println("Enter more data(Y/N): ");
//                String choice = scanner.next();
//
//                preparedStatement.setString(1, name);
//                preparedStatement.setInt(2, age);
//                preparedStatement.setDouble(3, marks);
//                preparedStatement.addBatch();
//
//                if(choice.toUpperCase().equals("N")){
//                    break;
//                }
//            }
//
//            int[] arr = preparedStatement.executeBatch();
//            for(int i = 0; i < arr.length ; i++) {
//                if(arr[i] == 0){
//                    System.out.println("Query: " + i + " not executed");
//                }
//            }

//            String query = " select * from students;";
//            ResultSet resultSet = statement.executeQuery(query);
//
//            while(resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                int age = resultSet.getInt("age");
//                double marks = resultSet.getDouble("marks");
//
//                System.out.println("ID: " + id);
//                System.out.println("NAME: " + name);
//                System.out.println("AGE: " + age);
//                System.out.println("MARKS: " + marks);
//                System.out.println("\n");
//            }


            //Debit Credit queries ------------
            connection.setAutoCommit(false);
            String debit_query = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
            String credit_query = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
            PreparedStatement debitPreparedStatement = connection.prepareStatement(debit_query);
            PreparedStatement creditPreparedStatement = connection.prepareStatement(credit_query);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter amount: ");
            double amount = scanner.nextDouble();
            System.out.println("Enter account number: ");
            int account_number = scanner.nextInt();

            debitPreparedStatement.setDouble(1, amount);
            debitPreparedStatement.setInt(2, account_number);
            creditPreparedStatement.setDouble(1, amount);
            creditPreparedStatement.setInt(2, 102);

            if(isSufficient(connection, account_number, amount)){
                debitPreparedStatement.executeUpdate();
                creditPreparedStatement.executeUpdate();
                connection.commit();
                System.out.println("Transaction Successfull");
            }else{
                connection.rollback();
                System.out.println("Transaction Failed!!");
            }

            debitPreparedStatement.close();
            creditPreparedStatement.close();
            scanner.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static boolean isSufficient(Connection connection, int account_number, double amount){
        try {
            String query = "SELECT balance FROM accounts WHERE account_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, account_number);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                double current_balance = resultSet.getDouble("balance");
                if(amount <= current_balance) {
                    return true;
                }
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
