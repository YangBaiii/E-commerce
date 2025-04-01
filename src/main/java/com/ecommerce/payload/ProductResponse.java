package com.ecommerce.payload;

import lombok.Data;

import java.util.List;
@Data
public class ProductResponse {
    private List<ProductDTO> content;
}
