package converter;

import entity.Category;
import entity.Product;
import model.ProductRequest;

public class ProductConverter {
    public static Product convertProductToEntity(ProductRequest request){
        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setDescription(request.getProductDescription());
        product.setCategory(new Category(request.getCategory().getId()));
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        return product;



    }
}