package com.restaurants.ordermanagementapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "table_number")
    private Integer tableNumber;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)//FetchType.LAZY will first load the main entity ( Owner), then the related entity ( Blog) on demand.
    @JoinColumn(name = "product_id")
    private List<Product> productList;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    public BigDecimal calculateTotalPrice() {
        return productList.stream()
                .map(product -> product.getUnitPrice().multiply(new BigDecimal(product.getQuantity()))) // Multiplica o preço unitário pela quantidade
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Soma todos os preços totais
    }
}
