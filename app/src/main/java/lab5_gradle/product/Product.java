package lab5_gradle.product;

import java.time.LocalDateTime;
import java.util.Objects;

import lab5_gradle.coordinates.Coordinates;
import lab5_gradle.enums.UnitOfMeasure;
import lab5_gradle.exceptions.EmptyValueException;
import lab5_gradle.exceptions.NegativeValueException;
import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.person.Person;
import lab5_gradle.utility.IdGenerator;

public class Product implements Comparable<Product> {

    private long id; // Значение поля должно быть больше 0, Значение этого поля должно быть //
                     // уникальным, Значение этого поля должно генерироваться автоматически
    private String name; // Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; // Поле не может быть null
    private java.time.LocalDateTime creationDate; // Поле не может быть null, Значение этого поля должно
                                                  // генерироваться// автоматически
    private int price; // Значение поля должно быть больше 0
    private UnitOfMeasure unitOfMeasure; // Поле может быть null
    private Person owner; // Поле не может быть null

    public Product() {
        this.creationDate = java.time.LocalDateTime.now().withNano(0);
        this.id = IdGenerator.getProductID();
    }

    @Override
    public int compareTo(Product other) {
        int priceComparison = Integer.compare(this.price, other.price);
        if (priceComparison != 0) {
            return priceComparison;
        }
        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Long.compare(this.id, other.id);
    }

    public static class ProductBuilder {
        private Product newProduct;

        public ProductBuilder() {
            newProduct = new Product();
        }

        public Product buildProduct() {
            return newProduct;
        }

        public ProductBuilder setName(String name) throws NullValueException, EmptyValueException {
            if (null == name) {
                throw new NullValueException();
            }
            if (name.isEmpty()) {
                throw new EmptyValueException();
            }
            newProduct.name = name;
            return this;
        }

        public ProductBuilder setCoordinates(Coordinates coordinates) throws NullValueException {
            if (null == coordinates) {
                throw new NullValueException();
            }
            newProduct.coordinates = coordinates;
            return this;
        }

        public ProductBuilder setPrice(int newPrice) throws NegativeValueException {
            if (newPrice <= 0) {
                throw new NegativeValueException();
            }
            newProduct.price = newPrice;
            return this;
        }

        public ProductBuilder setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
            if (null == unitOfMeasure) {
                newProduct.unitOfMeasure = null;
                return this;
            }
            newProduct.unitOfMeasure = unitOfMeasure;
            return this;
        }

        public ProductBuilder setOwner(Person owner) throws NullValueException {
            if (null == owner) {
                throw new NullValueException();
            }
            newProduct.owner = owner;
            return this;
        }
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public Person getOwner() {
        return this.owner;
    }

    public long getId() {
        return this.id;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return this.unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + this.id +
                ", name=" + this.name +
                ", coordinates=" + this.coordinates +
                ", creationDate=" + this.creationDate +
                ", price=" + this.price +
                ", unitOfMeasure=" + this.unitOfMeasure +
                ", owner=" + this.owner +
                "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, price, unitOfMeasure, owner);
    }
}