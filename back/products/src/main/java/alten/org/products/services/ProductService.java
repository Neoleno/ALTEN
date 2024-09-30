package alten.org.products.services;

import alten.org.products.DTO.ProductDTO;
import alten.org.products.DTO.ProductPatchDTO;
import alten.org.products.converters.ProductConverter;
import alten.org.products.entities.Product;
import alten.org.products.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<ProductDTO> getAllProducts(){
        List<Product> products = productRepository.findAll();

        return products.stream().map(ProductConverter::entityToDTO).toList();
    }

    public Boolean createProduct(ProductDTO productDTO){
        Product product = ProductConverter.DTOToEntity(productDTO);

        try{
            product.setCreatedAt(System.currentTimeMillis());
            productRepository.insert(product);

            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public ProductDTO getProductById(int id){
        Product product = productRepository.findById(id);
        if (product == null){
            throw new NotFoundException("Product with id: " + id + " Not Found");
        }
        return ProductConverter.entityToDTO(product);
    }

    public void patchProductById(ProductPatchDTO productPatchDTO, int id){
        Product existingProduct = productRepository.findById(id);

        if (existingProduct == null){
            throw new NotFoundException("Product with id: " + id + " Not Found");
        }

        if (productPatchDTO.code != null){
            existingProduct.setCode(productPatchDTO.code);
        }

        if (productPatchDTO.name != null){
            existingProduct.setName(productPatchDTO.name);
        }

        if (productPatchDTO.description != null){
            existingProduct.setDescription(productPatchDTO.description);
        }

        if (productPatchDTO.image != null){
            existingProduct.setImage(productPatchDTO.image);
        }

        if (productPatchDTO.price != null){
            existingProduct.setPrice(productPatchDTO.price);
        }

        if (productPatchDTO.category != null){
            existingProduct.setCategory(productPatchDTO.category);
        }

        if (productPatchDTO.shellId != null){
            existingProduct.setShellId(productPatchDTO.shellId);
        }

        if (productPatchDTO.internalReference != null){
            existingProduct.setInternalReference(productPatchDTO.internalReference);
        }

        if (productPatchDTO.inventoryStatus != null){
            existingProduct.setInventoryStatus(productPatchDTO.inventoryStatus);
        }

        if (productPatchDTO.rating != null){
            existingProduct.setRating(productPatchDTO.rating);
        }

        existingProduct.setUpdatedAt(System.currentTimeMillis());

        productRepository.save(existingProduct);
    }

    public void deleteProductById(int id){
        productRepository.deleteById(id);
    }
}
