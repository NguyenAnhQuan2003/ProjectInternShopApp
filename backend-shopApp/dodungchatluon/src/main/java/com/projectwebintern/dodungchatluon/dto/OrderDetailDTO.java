package com.projectwebintern.dodungchatluon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
    @JsonProperty("order_id")
    @Min(value = 0, message = "id order cannot < 0")
    private Long orderID;

    @JsonProperty("product_id")
    @Min(value = 0, message = "id product cannot < 0")
    private Long productID;

    @Min(value = 0, message = "price cannot < 0")
    private float price;

    @JsonProperty("number_of_products")
    @Min(value = 1, message = "number of products cannot < 1")
    private int numberOfProducts;

    @JsonProperty("total_money")
    @Min(value = 0, message = "total money cannot < 0")
    private float totalMoney;

    private String color;
}
