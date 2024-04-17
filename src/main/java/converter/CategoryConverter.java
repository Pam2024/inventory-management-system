package converter;

import entity.Category;
import model.CategoryRequest;

public class CategoryConverter {
    public static Category convertCategoryToEntity(CategoryRequest request){
        Category category = new Category();
        category.setCategoryName(request.getName());
        return category;
    }
}
