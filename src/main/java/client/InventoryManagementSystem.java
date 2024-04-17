package client;

import service.CategoryService;
import service.ProductService;

import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args)  {
        Scanner sc= new Scanner(System.in);
        int choice;

        do{
            System.out.println("Inventory Management system");
            System.out.println("1. Add category");
            System.out.println("2. Display all products");
            System.out.println("3. Notify for low stocks");
            System.out.println("4. Add product");
            System.out.println("5. Display all categories");

            choice= sc.nextInt();

            ProductService productService = new ProductService();
            CategoryService categoryService = new CategoryService();

            switch (choice){
                case 1:{
                    categoryService.createCategory(sc);
                    break;
                }
                case 2:{
                    System.out.println(productService.displayProducts());
                    break;
                }
                case 3:{
                    System.out.println(productService.notifyLowStocks());
                    break;
                }
                case 4:{
                    productService.createProduct(sc);
                    break;
                }
                case 5:{
                    System.out.println(categoryService.displayCategory());
                    break;
                }
                default: {
                    System.out.println("Please choose one of the options above");
                    break;
                }
            }
        }while (choice != 8);
        sc.close();
    }
}
