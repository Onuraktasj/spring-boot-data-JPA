package firstStore.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(ProductNotNullException.class)
    public ResponseEntity<?> productNotNull(ProductNotNullException productNotNullException){
        List<String> detail = new ArrayList<>();
        detail.add(productNotNullException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Product Not NUll",detail);
       return ResponseEntity.badRequest().body(errorResponse);
    }



}
