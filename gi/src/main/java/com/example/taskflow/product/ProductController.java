package com.example.taskflow.product;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  private final ProductRepository products;
  public ProductController(ProductRepository products) { this.products = products; }
  @GetMapping public List<Product> all() { return products.findAllByOrderByCreatedAtDesc(); }
  @GetMapping("/summary") public Map<String, Long> summary() { return Map.of("total", products.count(), "active", products.countByStatus(ProductStatus.ACTIVE), "draft", products.countByStatus(ProductStatus.DRAFT)); }
  @PostMapping @ResponseStatus(HttpStatus.CREATED) public Product create(@Valid @RequestBody ProductRequest r) { return products.save(new Product(r.name().trim(), r.category().trim(), r.price(), r.stock(), r.status())); }
  @PutMapping("/{id}") public Product update(@PathVariable Long id, @Valid @RequestBody ProductRequest r) { Product p = get(id); p.update(r.name().trim(), r.category().trim(), r.price(), r.stock(), r.status()); return products.save(p); }
  @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { products.delete(get(id)); }
  private Product get(Long id) { return products.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found")); }
}
