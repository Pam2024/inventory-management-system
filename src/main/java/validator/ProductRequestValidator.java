package validator;

import model.ProductRequest;

import java.util.InputMismatchException;

public class ProductRequestValidator {
    public static void validateProduct(ProductRequest productRequest){
        if (productRequest.getProductName() == null)
            throw new InputMismatchException();
        if (productRequest.getCategory().getId() <= 0)
            throw new InputMismatchException();
        if (productRequest.getPrice() <= 0)
            throw new InputMismatchException();
        if (productRequest.getQuantity() <= 0)
            throw new InputMismatchException();
    }


}