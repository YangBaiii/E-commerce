package com.ecommerce.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long productID;
    private String productName;
    private String image;
    private String description;
    private Integer quantity;
    private Double price;
    private Double discount;
    private Double specialPrice;
}
