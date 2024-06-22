package Product_Management;
import java.sql.*;
import java.util.*;

public class ProductManagement {
	public static void main(String args[]) throws SQLException {
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db","root","simran@123");
		Statement statement=connection.createStatement();
		System.out.println("Connection Established Successfully!!");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("****Welcome to Product Management****");
		while(true) {
			System.out.println("\nWhat would you like to do? ");
			System.out.println("1. Add Product");
			System.out.println("2. Update Product");
			System.out.println("3. View Product");
			System.out.println("4. Delete Product");
			System.out.println("5. Search Product");
			System.out.println("6. Exit");
			
			System.out.println("Enter your choice: ");
			int choice=sc.nextInt();
			
			switch(choice) {
				case 1: System.out.println("Add Product!!!");
						System.out.println("Enter the product details: ");
						System.out.println("Enter the product id: ");
						int product_id=sc.nextInt();
						
						System.out.println("Enter the product name: ");
						String name=sc.next();
						
						System.out.println("Enter the product quantity: ");
						int quantity=sc.nextInt();
						
						System.out.println("Enter the product price: ");
						int price=sc.nextInt();
						
						String addProductquery="INSERT INTO product VALUES ('"+product_id+"', '"+name+"','"+quantity+"','"+price+"')";						
						//String addProductquery=("Insert into product(product_id, name, quantity, price) values(product_id, name, quantity, price)");
						//Statement statement=connection.createStatement();
						
						
						boolean isInserted=statement.execute(addProductquery);
						if(isInserted==false) {
							System.out.println("Product Inserted Successfully111111");
						}
						else {
							System.out.println("Product Insertion Failed!!!");
						}
						
						break;
						
				case 2: System.out.println("Update Product!!!");
						System.out.println("Enter the product id to update: ");
						int productIdToUpdate=sc.nextInt();
						
						System.out.println("Enter the updated product id: ");
						int updatedId=sc.nextInt();
						
						System.out.println("Enetr the updated product name: ");
						String updatedName=sc.next();
						
						System.out.println("Enter the updated product quantity: ");
						int updatedQuantity=sc.nextInt();
						
						System.out.println("Enter the updated product price: ");
						int updatedPrice=sc.nextInt();
						
						String updateProductQuery=String.format("UPDATE product SET product_id='%d', name='%s', quantity='%d', price='%d' WHERE product_id='%d' ", updatedId, updatedName, updatedQuantity, updatedPrice, productIdToUpdate);
						
						//String UpdateProductQuery="Update product set product_id=updatedId, name=updatedName, quantity=updatedQuantity, price=updatedPrice where product_id=productIdToUpdate";
								
						//Statement statement1=connection.createStatement();
						int rowsAffected=statement.executeUpdate(updateProductQuery);
						//boolean isUpdated=statement1.execute(UpdateProductQuery);
						
						if (rowsAffected > 0) {
					        System.out.println("Product Updated Successfully!");
					    } else {
					        System.out.println("Product Update Failed!");
					    }
				        break;
				        
				case 3: System.out.println("View Product!!!");
						System.out.println("The Product Details are: ");
						String ViewProductQuery="SELECT * FROM product";
						
						ResultSet result=statement.executeQuery(ViewProductQuery);
//						while(result.next()) {
//							System.out.println(result.getString(1));
//							System.out.println(result.getString(2));
//							System.out.println(result.getString(3));
//							System.out.println(result.getString(4));
//						}
						while (result.next()) {
					        int productId = result.getInt("product_id");
					        String productName = result.getString("name");
					        int productQuantity = result.getInt("quantity");
					        int productPrice = result.getInt("price");

					        System.out.println("Product ID: " + productId);
					        System.out.println("Product Name: " + productName);
					        System.out.println("Product Quantity: " + productQuantity);
					        System.out.println("Product Price: " + productPrice);
					        System.out.println("---------------------");
					    }
				        break;
				        
				case 4: System.out.println("Delete Product!!!");
						System.out.println("Enter the product id to delete: ");
						int productIdToDelete=sc.nextInt();
						
						String deleteProductQuery=String.format("DELETE FROM product where product_id='%d'",productIdToDelete) ;
						int resultToDelete=statement.executeUpdate(deleteProductQuery);
						
						if(resultToDelete>0) {
							System.out.println("Product Delete Successfully!!");
						}
						else {
							System.out.println("Product Delete Failed!!!");
						}
				        break;
				        
				case 5: System.out.println("Search Product!!!");
						System.out.println("Enter the product id to search:");
						int productIdToSearch=sc.nextInt();
						
						String searchProductQuery=String.format("SELECT * FROM product where product_id='%d'", productIdToSearch);
				        ResultSet resultSet1=statement.executeQuery(searchProductQuery);
				        
				        if(resultSet1.next()) {
				        	System.out.println("Product Found!!");
				        }
				        else {
				        	System.out.println("Product Not Found!!");
				        }
						break;
				        
				case 6: System.out.println("Exitting the Application!!!");
				        return;
				        
			default: System.out.println("Wrong choice!!!");
			}
		}
	}
}
