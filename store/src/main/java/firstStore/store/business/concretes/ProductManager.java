package firstStore.store.business.concretes;

import firstStore.store.api.controllers.ProductsController;
import firstStore.store.business.abstracts.ProductService;
import firstStore.store.core.utilities.result.DataResult;
import firstStore.store.core.utilities.result.Result;
import firstStore.store.core.utilities.result.SuccessDataResult;
import firstStore.store.core.utilities.result.SuccessResult;
import firstStore.store.dataAccess.abstracts.ProductDao;
import firstStore.store.entity.concretes.Product;
import firstStore.store.exception.ProductNotNullException;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class ProductManager implements ProductService {


    private ProductDao productDao;
    private ProductsController productsController;

    @Autowired
    public ProductManager(ProductDao productDao){
        super();
        this.productDao= productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(this.productDao.findAll(),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getAll(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"Başarılı");
    }

    @Override
    public Result add(Product product) {
        if(product.getProductName().isBlank() || product.getProductName().isEmpty()){
            throw new ProductNotNullException("Product name must be not null");

        }
        this.productDao.save(product); // save metodu ile ekleme ve güncelllemleri hızlıca yapabiliriz
        return new SuccessResult("Ürün eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"Data listelendi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, Integer categoryId) {
        return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listelendi");

    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, Integer categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data listelendi");

    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories),"Data listelendi");

    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"Data listelendi");

    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"Data listelendi");

    }



    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, Integer categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName,categoryId));
    }

    @Override
    public DataResult<List<Product>>getByCategory_CategoryId(Integer categoryId) {

        return new SuccessDataResult<List<Product>>(this.productDao.getByCategory_CategoryId(categoryId));

    }


}