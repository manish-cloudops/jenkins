package com.example.taskflow.product;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProductRequest(
  @NotBlank @Size(max = 120) String name,
  @NotBlank @Size(max = 80) String category,
  @NotNull @DecimalMin(value = "0.00") BigDecimal price,
  @NotNull @Min(0) Integer stock,
  ProductStatus status
) {}
