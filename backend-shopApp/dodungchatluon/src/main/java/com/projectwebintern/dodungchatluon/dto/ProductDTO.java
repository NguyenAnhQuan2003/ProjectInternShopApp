package com.projectwebintern.dodungchatluon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class ProductDTO {
    @NotBlank(message = "name khong duoc null")
    @Size(min = 3, max = 200, message = "do dai ten tu 3 den 200")
    private String name;

    @Min(value = 0, message = "gia tien phai lon hon 0")
    @Max(value = 100000000, message = "gia tien phai nho hon 100 trieu")
    private float price;
    private String thumbnail;
    private String description;
    @JsonProperty("category_id")
    private Integer categoryId;
    private List<MultipartFile> files;
}
