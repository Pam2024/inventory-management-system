package validator;

import model.CategoryRequest;

import java.util.InputMismatchException;

public class CategoryRequestValidator {
    public static void validateCategory (CategoryRequest categoryRequest){
        if (categoryRequest.getName() == null)
            throw new InputMismatchException();
    }
}