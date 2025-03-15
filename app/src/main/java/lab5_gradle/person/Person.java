package lab5_gradle.person;

import java.util.Objects;

import lab5_gradle.enums.Color;
import lab5_gradle.enums.Country;
import lab5_gradle.exceptions.NegativeValueException;
import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.locations.Location;

public class Person implements Comparable<Person> {
    private String name; // Поле не может быть null, Строка не может быть пустой
    private float height; // Значение поля должно быть больше 0
    private Color eyeColor; // Поле не может быть null
    private Color hairColor; // Поле не может быть null
    private Country nationality; // Поле не может быть null
    private Location location; // Поле может быть null

    public Person() {
    }

    @Override
    public int compareTo(Person other) {
        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        int heightComparison = Float.compare(this.height, other.height);
        if (heightComparison != 0) {
            return heightComparison;
        }
        int eyeColorComparison = this.eyeColor.compareTo(other.eyeColor);
        if (eyeColorComparison != 0) {
            return eyeColorComparison;
        }
        int hairColorComparison = this.hairColor.compareTo(other.hairColor);
        if (hairColorComparison != 0) {
            return hairColorComparison;
        }
        int nationalityComparison = this.nationality.compareTo(other.nationality);
        if (nationalityComparison != 0) {
            return nationalityComparison;
        }
        if (this.location == null && other.location == null) {
            return 0;
        } else if (this.location == null) {
            return -1;
        } else if (other.location == null) {
            return 1;
        }
        return this.location.compareTo(other.location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return Float.compare(person.height, height) == 0 &&
                Objects.equals(name, person.name) &&
                eyeColor == person.eyeColor &&
                hairColor == person.hairColor &&
                nationality == person.nationality &&
                Objects.equals(location, person.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, height, eyeColor, hairColor, nationality, location);
    }

    public static class PersonBuilder {
        private Person newPerson;

        public PersonBuilder() {
            newPerson = new Person();
        }

        public Person buildPerson() {
            return newPerson;
        }

        public PersonBuilder setName(String name) throws NullValueException {
            if (null == name) {
                throw new NullValueException();
            }
            newPerson.name = name;
            return this;
        }

        public PersonBuilder setHeight(float height) throws NegativeValueException {
            if (height <= 0) {
                throw new NegativeValueException();
            }
            newPerson.height = height;
            return this;
        }

        public PersonBuilder setLocation(Location location) throws NullValueException {
            if (null == location) {
                throw new NullValueException();
            }
            newPerson.location = location;
            return this;
        }

        public PersonBuilder setEyeColor(Color eyeColor) throws NullValueException {
            if (null == eyeColor) {
                throw new NullValueException();
            }
            newPerson.eyeColor = eyeColor;
            return this;
        }

        public PersonBuilder setHairColor(Color hairColor) throws NullValueException {
            if (null == hairColor) {
                throw new NullValueException();
            }
            newPerson.hairColor = hairColor;
            return this;
        }

        public PersonBuilder setNationality(Country country) throws NullValueException {
            if (null == country) {
                throw new NullValueException();
            }
            newPerson.nationality = country;
            return this;
        }

    }

    public String getName() {
        return this.name;
    }

    public float getHeight() {
        return this.height;
    }

    public Color getEyeColor() {
        return this.eyeColor;
    }

    public Color getHairColor() {
        return this.hairColor;
    }

    public Country getNationality() {
        return this.nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location loc) {
        this.location = loc;
    }

    public void setHairColor(Color color) {
        this.hairColor = color;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEyeColor(Color color) {
        this.eyeColor = color;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + this.name +
                ", height=" + this.height +
                ", eyeColor=" + this.eyeColor +
                ", hairColor=" + this.hairColor +
                ", country=" + this.nationality +
                ", location=" + this.location +
                "}";
    }
}