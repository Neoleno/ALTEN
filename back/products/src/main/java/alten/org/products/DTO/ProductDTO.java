package alten.org.products.DTO;

import alten.org.products.entities.utils.InventoryStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    public Integer id;
    public String code;
    public String name;
    public String description;
    public String image;
    public Integer price;
    public String category;
    public Long createdAt;
    public Long updatedAt;
    public Integer shellId;
    public String internalReference;
    public InventoryStatus inventoryStatus;
    public Integer rating;
}
