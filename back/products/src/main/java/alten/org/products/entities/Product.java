package alten.org.products.entities;

import alten.org.products.entities.utils.InventoryStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document("products")
public class Product {
    @Id
    private String mongoId;

    @Indexed(unique = true)
    private Integer id;

    private String code;
    private String name;
    private String description;
    private String image;
    private Integer price;
    private String category;
    private Long createdAt;
    private Long updatedAt;
    private Integer shellId;
    private String internalReference;
    private InventoryStatus inventoryStatus;
    private Integer rating;
}
