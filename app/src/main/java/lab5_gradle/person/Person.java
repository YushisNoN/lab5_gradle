package lab5_gradle.person;

import lab5_gradle.enums.Color;
import lab5_gradle.enums.Country;
import lab5_gradle.exceptions.NegativeValueException;
import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.locations.Location;

public class Person {
    private String name; // Поле не может быть null, Строка не может быть пустой
    private float height; // Значение поля должно быть больше 0
    private Color eyeColor; // Поле не может быть null
    private Color hairColor; // Поле не может быть null
    private Country nationality; // Поле не может быть null
    private Location location; // Поле может быть null

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

    public Country getCountry() {
        return this.nationality;
    }

    public Location geLocation() {
        return this.location;
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