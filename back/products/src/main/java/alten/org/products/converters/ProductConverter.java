package alten.org.products.converters;

import alten.org.products.DTO.ProductDTO;
import alten.org.products.entities.Product;

public class ProductConverter {
    public static ProductDTO entityToDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getCode(),
                product.getName(),
                product.getDescription(),
                product.getImage(),
                product.getPrice(),
                product.getCategory(),
                product.getCreatedAt(),
                product.getUpdatedAt(),
                product.getShellId(),
                product.getInternalReference(),
                product.getInventoryStatus(),
                product.getRating()
                );
    }

    public static Product DTOToEntity(ProductDTO productDTO){
        return Product.builder()
                .id(productDTO.id)
                .code(productDTO.code)
                .image(productDTO.image)
                .name(productDTO.name)
                .description(productDTO.description)
                .price(productDTO.price)
                .category(productDTO.category)
                .createdAt(productDTO.createdAt)
                .updatedAt(productDTO.updatedAt)
                .shellId(productDTO.shellId)
                .internalReference(productDTO.internalReference)
                .inventoryStatus(productDTO.inventoryStatus)
                .rating(productDTO.rating)
                .build();
    }
}
