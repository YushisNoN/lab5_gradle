package lab5_gradle.coordinates;

import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.exceptions.CoordinateWrongValueException;

public class Coordinates {
    private Long x; // Значение поля должно быть больше -852, Поле не может быть null
    private Integer y; // Поле не может быть null

    public void setCoordinateX(Long newValueX) throws NullValueException, CoordinateWrongValueException {
        if (null == newValueX) {
            throw new NullValueException();
        }
        if (newValueX < -852) {
            throw new CoordinateWrongValueException();
        }
        this.x = newValueX;
    }

    public void setCoordinateY(Integer newValueY) throws NullValueException {
        if (null == newValueY) {
            throw new NullValueException();
        }
        this.y = newValueY;
    }

    public Long getCoordinateX() {
        return this.x;
    }

    public Integer getCoordinateY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + this.x +
                ", y=" + this.y +
                "}";
    }
}