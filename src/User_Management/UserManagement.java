package User_Management;

import java.sql.*;
import java.util.*;

public class UserManagement {
	public static void main(String args[]) throws SQLException {
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db","root","simran@123");
		Statement statement=connection.createStatement();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("***Welcome to User Management***");
		
		while(true) {
			System.out.println("What would you like to do?");
			System.out.println("\n 1. Add User \n 2. Update User \n 3. Search User \n 4. Delete User \n 5. Print User Details\n 6. Exit  ");
		
			System.out.println("Enter your choice: ");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1: System.out.println("****Add User***");
					System.out.println("Enter the user details: ");
			
					System.out.println("Enter the user id: ");
					int user_id=sc.nextInt();
					
					System.out.println("Enter the name: ");
					String name=sc.next();
					
					System.out.println("Enter the email: ");
					String email=sc.next();
					
					System.out.println("Enter the address: ");
					String address=sc.next();
					
					System.out.println("Enter the user name: ");
					String username=sc.next();
					
					System.out.println("Enter the password: ");
					String password=sc.next();
					
					String addUserQuery="INSERT INTO user VALUES('"+user_id+"', '"+name+"', '"+email+"', "
							+ "'"+address+"','"+username+"','"+password+"')";
					
					boolean isInserted=statement.execute(addUserQuery);
					if(isInserted==false) {
						System.out.println("User Inserted Successfully!!");
					}
					else {
						System.out.println("User Insertion Failed!!!");
					}
			        break;
			        
			case 2:System.out.println("****Update User***");
					System.out.println("Enter the user id to update: ");
					int userIdToUpdate=sc.nextInt();
					
					System.out.println("Enter the updated user id: ");
					int updatedId=sc.nextInt();
					
					System.out.println("Enter the updated name: ");
					String updatedName=sc.next();
					
					System.out.println("Enter the updated email: ");
					String updatedEmail=sc.next();
					
					System.out.println("Enter the updated address: ");
					String updatedAddress=sc.next();
					
					System.out.println("Enter the updated username: ");
					String updatedUsername=sc.next();
					
					System.out.println("Enter the updated password: ");
					String updatedPassword=sc.next();
					
					String updateProductQuery=String.format("UPDATE product SET user_id='%d', name='%s', email='%s', address='%s', username='%s', password='%s' WHERE user_id='%d'" ,updatedId, updatedName, updatedEmail, updatedAddress,  updatedUsername, updatedPassword);
					
					int rowsAffected=statement.executeUpdate(updateProductQuery);
					if(rowsAffected>0) {
						System.out.println("User Updated Successfully!!");
					}
					else {
						System.out.println("User Update Failed!!");
					}
			       break;
			       
			case 3: System.out.println("***Search User****");
					
					System.out.println("Enter the user_id to search: ");
					String userIDToSearch=sc.next();
					
					String searchUserQuery=String.format("SELECT * from product where product_id='%d'", userIDToSearch);
					
					ResultSet resultSet=statement.executeQuery(searchUserQuery);
					
					if(resultSet.next()) {
						System.out.println("User Found!!!");
					}else {
						System.out.println("User Not Found!!!");
					}
			
			
			       	break;
			       
			case 4: System.out.println("****Delete User****");
					System.out.println("Enter the user id to delete: ");
					int userIdToDelete=sc.nextInt();
					
					String deleteUserQuery=String.format("DELETE FROM product where product_id='%d'", userIdToDelete);
					int resultToDelete=statement.executeUpdate(deleteUserQuery);
					
					if(resultToDelete>0) {
						System.out.println("User Deleted successfully!!");
					}
					else {
						System.out.println("User Deleteion Failed!!");
					}
					break;
					
			case 5:System.out.println("****View User Details****");
			       String userViewQuery="SELECT * FROM user";
			       
			       ResultSet resultSet1=statement.executeQuery(userViewQuery);
			       
			       while(resultSet1.next()) {
			    	   int userid=resultSet1.getInt("user_id");
			    	   String name1=resultSet1.getString("name");
			    	   String emailid=resultSet1.getString("email");
			    	   String addressUser=resultSet1.getString("address");
			    	   String username1=resultSet1.getString("username");
			    	   String password1=resultSet1.getString("password");
			    	   
			    	   System.out.println("User ID: "+userid);
			    	   System.out.println("Name: "+name1);
			    	   System.out.println("Email id: "+emailid);
			    	   System.out.println("Address: "+addressUser);
			    	   System.out.println("Username: "+username1);
			    	   System.out.println("---------------------");
			       }
			       
			       break;
			       
			       
			case 6: System.out.println("Exitting the application!!");
			        return;
			
			default:System.out.println("Please enter the valid choice!!");
			}
		}
	}
}
