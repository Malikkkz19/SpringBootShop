package ru.malikkkz.SpringShoppp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name can't be empty")
    @Size(min = 2, max = 100, message = "Error!")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Charasteristic> charasteristics;


    public Product(Long id, String name, Category category, List<Review> reviews, List<Charasteristic> charasteristics) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.reviews = reviews;
        this.charasteristics = charasteristics;
    }

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(category, product.category) && Objects.equals(reviews, product.reviews) && Objects.equals(charasteristics, product.charasteristics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, reviews, charasteristics);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", reviews=" + reviews +
                ", charasteristics=" + charasteristics +
                '}';
    }
}
