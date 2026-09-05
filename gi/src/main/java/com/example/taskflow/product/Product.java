package com.example.taskflow.product;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "products")
public class Product {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
  @Column(nullable = false, length = 120) private String name;
  @Column(nullable = false, length = 80) private String category;
  @Column(nullable = false, precision = 12, scale = 2) private BigDecimal price;
  @Column(nullable = false) private Integer stock;
  @Enumerated(EnumType.STRING) @Column(nullable = false) private ProductStatus status = ProductStatus.DRAFT;
  @Column(nullable = false, updatable = false) private Instant createdAt = Instant.now();

  protected Product() {}
  public Product(String name, String category, BigDecimal price, Integer stock, ProductStatus status) { update(name, category, price, stock, status); }
  public Long getId() { return id; }
  public String getName() { return name; }
  public String getCategory() { return category; }
  public BigDecimal getPrice() { return price; }
  public Integer getStock() { return stock; }
  public ProductStatus getStatus() { return status; }
  public Instant getCreatedAt() { return createdAt; }
  public void update(String name, String category, BigDecimal price, Integer stock, ProductStatus status) { this.name = name; this.category = category; this.price = price; this.stock = stock; this.status = status == null ? ProductStatus.DRAFT : status; }
}
