package crudOperation;

import java.util.Scanner;

public class CrudMainApp {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		CrudOperations operation = new CrudOperations();
		int choice;
		while(true) {
			System.out.println();
			System.out.println("====Crud app menu====");
			System.out.println("1. Insert in Table");
			System.out.println("2. Read Table");
			System.out.println("3. Update Data");
			System.out.println("4. Delete Data");
			System.out.println("5. Exit");
			
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1: 
				operation.insertData("student");
				break;
					
			case 2: 
				sc.nextLine();
				operation.readTable("student");	
				break;
			case 3:
				break;
			case 4:
				System.out.println("Enter the key you want to delete: ");
				int key = sc.nextInt();
				operation.delKey(key);
			case 5:
				sc.close();
				System.exit(0);
				break;
				default: 
					System.out.println("Invalid input");
			}
			
			
		}
	}
}
