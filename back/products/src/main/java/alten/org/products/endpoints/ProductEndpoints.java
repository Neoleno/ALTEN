package alten.org.products.endpoints;

import alten.org.products.DTO.ProductDTO;
import alten.org.products.DTO.ProductPatchDTO;
import alten.org.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductEndpoints {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> productsDTO = productService.getAllProducts();
        return new ResponseEntity<>(productsDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createProducts(@RequestBody ProductDTO productDTO){
        Boolean isCreated = productService.createProduct(productDTO);
        HttpStatus status = isCreated ? HttpStatus.CREATED: HttpStatus.CONFLICT;
        return new ResponseEntity<>(status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable int id){
        ProductDTO productDTO = productService.getProductById(id);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patchProduct(@RequestBody ProductPatchDTO productPatchDTO, @PathVariable int id){
        productService.patchProductById(productPatchDTO, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id){
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
