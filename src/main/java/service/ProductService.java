package service;

import converter.ProductConverter;
import dao.ProductDao;
import entity.Category;
import entity.Product;
import model.ProductRequest;
import validator.ProductRequestValidator;

import java.util.List;
import java.util.Scanner;

public class ProductService {

    ProductDao productDao = new ProductDao();
    public ProductRequest createProduct(ProductRequest request){
        //Validate user input
        ProductRequestValidator.validateProduct(request);
        //convert model to entity
        Product product = ProductConverter.convertProductToEntity(request);
        //Dao insert product into database
        productDao.createProductEntity(product);
        return request;
    }

    public List<Product> displayProducts(){
        return productDao.displayProducts();
    }
    public List<Product> notifyLowStocks(){
        return productDao.notifyLowStocks();
    }
    public  void createProduct(Scanner sc){
        System.out.println("Please enter product details as required.");
        ProductRequest productRequest = new ProductRequest();
        System.out.println("Please enter product name ");
        productRequest.setProductName(sc.next());
        System.out.println("Please enter product category id ");
        productRequest.setCategory(new Category(sc.nextLong()));
        System.out.println("Please enter product description ");
        productRequest.setProductDescription(sc.next());
        System.out.println("Please enter product price ");
        productRequest.setPrice(sc.nextDouble());
        System.out.println("Please enter product quantity ");
        productRequest.setQuantity(sc.nextInt());
        ProductService productService=new ProductService();
        productService.createProduct(productRequest);
    }


}
