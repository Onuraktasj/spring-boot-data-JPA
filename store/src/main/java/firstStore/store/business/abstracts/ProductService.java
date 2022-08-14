package firstStore.store.business.abstracts;


import firstStore.store.core.utilities.result.DataResult;
import firstStore.store.core.utilities.result.Result;
import firstStore.store.entity.concretes.Product;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {

    DataResult <List<Product>> getAll();
    DataResult<List<Product>> getAll(Integer pageNo, Integer pageSize); //bu metodu sayfalama için kullancağız
    DataResult<List<Product>> getAllSorted();
    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product >getByProductNameAndCategoryId(String productName,Integer categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryId(String productName,Integer categoryId);


    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    DataResult<List<Product>>getByNameAndCategory(String productName, Integer categoryId);

    DataResult<List<Product>> getByCategory_CategoryId(Integer categoryId);

}

