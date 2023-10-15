package ru.malikkkz.SpringShoppp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "charasteristic_values")
public class CharasteristicValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty(message = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "charasteristic_id")
    private Charasteristic charasteristic;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharasteristicValue that = (CharasteristicValue) o;
        return Objects.equals(Id, that.Id) && Objects.equals(name, that.name) && Objects.equals(charasteristic, that.charasteristic) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, charasteristic, product);
    }
}
