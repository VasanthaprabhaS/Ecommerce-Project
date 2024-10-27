package com.ecom.trip.holiday.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name="Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "id")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    @NotBlank(message = "Product Name is mandatory")
    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;
    @Column(name = "price")

    private int price;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
