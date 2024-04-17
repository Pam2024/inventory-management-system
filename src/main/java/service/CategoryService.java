package service;

import converter.CategoryConverter;
import dao.CategoryDao;
import entity.Category;
import model.CategoryRequest;
import validator.CategoryRequestValidator;

import java.util.List;
import java.util.Scanner;

public class CategoryService {

    CategoryDao categoryDao = new CategoryDao();

    public void createCategory(CategoryRequest request) {
        //Validate user input
        CategoryRequestValidator.validateCategory(request);
        //convert model to entity
        Category category = CategoryConverter.convertCategoryToEntity(request);
        //Dao insert product into database
        categoryDao.createCategory(category);
    }

    public List<Category> displayCategory() {
        return categoryDao.displayCategories();
    }

    public  void createCategory(Scanner sc){
        CategoryRequest categoryRequest=new CategoryRequest();
        System.out.println("Please enter a new category: ");
        categoryRequest.setName(sc.next());
        CategoryService categoryService=new CategoryService();
        categoryService.createCategory(categoryRequest);
    }
}
