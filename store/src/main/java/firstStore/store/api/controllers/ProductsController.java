package firstStore.store.api.controllers;

import firstStore.store.business.abstracts.ProductService;
import firstStore.store.core.utilities.result.DataResult;
import firstStore.store.core.utilities.result.Result;
import firstStore.store.entity.concretes.Product;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/api/products")


public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping("/getall")
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam(value = "productName", required = false) String productName) {
        //return this.productService.getByProductName(productName);
        //
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId/{productName}/{categoryId}")
    public DataResult<Product> getByProductNameAndCategoryId(@PathVariable("productName") String productName, @PathVariable("categoryId") int categoryId) {
        return this.productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameContains/{productName}")
    public DataResult<List<Product>> getByProductNameContains(@PathVariable("productName") String productName) {
        return this.productService.getByProductNameContains(productName);

    }

    @GetMapping("/getallpage")
    public DataResult<List<Product>> getAll(@RequestParam int pageNo, @RequestParam int pageSize) {
        return this.productService.getAll(pageNo - 1, pageSize);

    }

    @GetMapping("/sorted")
    public DataResult<List<Product>> getAllSorted() {
        return this.productService.getAllSorted();
    }

    @GetMapping("/query")
    public DataResult<List<Product>> getByNameAndCategory(@RequestParam(value = "params",required = false) String productName,@RequestParam(value = "params",required = false) Integer categoryId){
        return this.productService.getByNameAndCategory(productName,categoryId);
    }

    @GetMapping("/categoryId/{categoryId}")
    public DataResult<List<Product>> getByCategory_CategoryId(@PathVariable("categoryId") Integer categoryId){
        return this.productService.getByCategory_CategoryId(categoryId);
    }





}