/*Database testing using Java, Selenium, TestNG example
Home >> Selenium Tutorials >> Database testing using Java, Selenium, TestNG example

As we know every application has to maintain a database like My SQL, Oracle or any other databases to store all its data. And where as Selenium Webdriver is used for testing web applications and we perform many operations like submitting information and some times retrieving information and validate them.

In selenium scripts, when there is a need of getting the Data from the database we may have to use APIs which helps to interact with database like JDBC.

Java Database Connectivity(JDBC) is a Java API which is used to connect and interact with Database.

Why do we use JDBC instead ODBC?

ODBC is developed and written in C, which is platform Independent. where as JDBC API is a specification provides set of interfaces which are written and developed in Java programming language.

How to Connect to database using JDBC?

The below are the Steps to Connect to database, before proceeding, you need to have MySQL Connector. You can download from here Download MySQL Connector Jar and add it the build path as we add selenium webdriver jar.

1. Load and Registering the Driver
2. Establishing Connection.
3. Creating Statement Object
4. Execute the Statement
5. Closing the connection.

1. Load and Register the Driver:

For registering the Driver we Load the Driver class using forName() method.

forName() is the static factory method which is present in predefined class called "Class". This method loads the class which is mentioned as parameter.

Class.forName("com.mysql.jdbc.Driver");// class.forName load the Driver class
Internally this Driver class will register the driver by using static method called registerDriver().

2. Establishing Connection:

For establishing connection with database we call static method called getConnection(...) present in DriverManager Class. This method contains three arguments of string type. i.e., url, username and password

DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","root"); 
URL contains "jdbc(main protocol):mysql(sub protocol for mySql)://localhost:3306(sub name for mysql (host:prot))/Employee(database)" and this method return type is Connection Object ie.,

Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","root");  
3. Creating Statement Object:

For creating statement object we need to call a method called createStatement() which is present in Connection Interface.

con.createStatement();
And this method returns Statement object and it is no argument method.

Statement st= con.createStatement();
4.Executing Queries:

For executing queries there are different methods present in Statement Interface for retrieving records and for updating records.

Retrieving records:
for executing select queries(for fetching records) we call a method called executeQuery(String qry) by taking string as parameter.

st.executeQuery("Select * from Employee");
This method returns ResultSet object.

Resultset rs= st.executeQuery("Select * from Employee");// once executeQuery() executes the query and stores the records in to ResultSet object. 

Now we need to get the records from ResultSet object. To access the resultset object it uses a method called next() which presents in ResultSet Interface.

By default Resultset reference 'rs' points to before first row. it moves rs to next row and returns true. When it returns true we retrieve the data in first row. next() returns false when rs points to after the last row. this next() will repeats the execution using while loop till it returns false.

To get the data from rows we use getXxx(..) taking string or integer as parameters. Here integer means column position and string means column name of the record. xxx indicates primitive datatypes or string object.

while(rs.next()) {
int EmpId= rs.getInt("EmpId");
String EmpName= rs.getString("EmpName");
String EmpAddress=rs.getString(3);
Double EmpSal= rs.getDouble(4);
String EmpDept=rs.getString("EmpDept");
System.out.println(EmpId+"\t"+EmpName+"\t"+EmpAddress+"\t"+EmpSal+"\t"+EmpDept);
}
Updating records:
To update records in a table we use a method called executeUpdate(String str)

st.executeUpdate("update Employee set EmpName='Robert' where EmpId=2");
which returns integer value as how many records have been updated.

int result = st.executeUpdate("update Employee set EmpName='Robert' where EmpId=2");
System.out.println("number of records updated is" +result);
5. Closing the Connection:

Once execution of all statements were completed we need to close all the connections by using method called close() present in Connection interface

con.close();
Database which we use for example has the following records in Table 'Employee'
database testing with selenium

Now its time to look into below simple example program and later we will jump into framework example : - In next tutorial, We will try to take an example which will take the parameters (like database credentials , environment details etc) from properties files and proceed the test based on parameters specified.

*//**
 * Created by VISISHTA on 12/17/2015.
 *//*

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

public class SeleniumDataBaseTesting {

   private Connection connection;
   private static Statement statement;
   private static ResultSet rs;

    @BeforeClass
    public void setUp() {
            String databaseURL = "jdbc:mysql://localhost:3306/easy";
            String user = "root";
            String password = "root";
            connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Connecting to Database...");
                connection = DriverManager.getConnection(databaseURL, user, password);
                if (connection != null) {
                    System.out.println("Connected to the Database...");
                }
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
            catch (ClassNotFoundException ex) {
               ex.printStackTrace();
            }
    }

    @Test
    public void getEmployeesFromDataBase() {
        try {
            String query = "select * from employee";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                int EmpId= rs.getInt("EmpId");
                String EmpName= rs.getString("EmpName");
                String EmpAddress=rs.getString(3);
                String EmpDept=rs.getString("EmpDept");
                Double EmpSal= rs.getDouble(5);
                System.out.println(EmpId+"\t"+EmpName+"\t"+EmpAddress+"\t"+EmpSal+"\t"+EmpDept);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
      if (connection != null) {
                try {
                    System.out.println("Closing Database Connection...");
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
      }
}
In the above example, we have, setUp() will create a database connection, and in @Test method we will execute and iterate the table to print all the values in the database. And last tearDown() has close connection which will close the database connection if it is opened.

Output of the above program should look like below:

database testing result with selenium

Till now we have seen example on how to access database,now let us see how we actually perform database testing using Selenium.

There are mainly two things that we might want to test to verify database with Selenium.

First, after making any action in the web application (Front-end), we may want to check the database if all the details we submitted are stored correctly. Now for example, when creating an account, we will input some data email Id, username etc. To make sure an account is created, we can check record created in database with all the details user provided.

Other case can be like, after performing any action, we may want to check the data displayed in the UI is correct by comparing the Database.

Hope this article helps you. Do let us know if have come across any difficulties when working with the above program and feedback is also welcome.
‹ Handling Security Certificates in Chrome and IE browser using WebDriver How to do Database testing using Selenium Webdriver Framework Example ›
Selenium Tutorials: 
Selenium Tutorials

Tags: 
Database Testing
Add new comment
Comments

@beforeclass

Permalink Submitted by Gaurav on Wed, 04/27/2016 - 06:18
Hi Team,

Hope you to find in a great spirit.i want to know actual behavior of @beforeclass ???

what does actually means of this @beforeclass
reply
Very Good information and

Permalink Submitted by Viewer on Tue, 05/10/2016 - 08:44
Very Good information and detailed explanation with example. Appreciated
reply
Add new comment

Your name 
Subject 
Comment *


More information about text formats
*/