package lab5_gradle.locations;

import lab5_gradle.exceptions.NullValueException;

public class Location {
    private long x;
    private Double y; // Поле не может быть null
    private double z;

    public void setLocationHeight(Double newHeight) throws NullValueException {
        if (null == newHeight) {
            throw new NullValueException();
        }
        this.y = newHeight;
    }

    public void setLocationWidth(long newWidth) {
        this.x = newWidth;
    }

    public void setLocationDepth(double newDepth) {
        this.z = newDepth;
    }

    public long getLocationWidth() {
        return this.x;
    }

    public double getLocationDepth() {
        return this.z;
    }

    public Double getLocationHeight() {
        return this.y;
    }

    @Override
    public String toString() {
        return "Location={" +
                "width=" + this.x +
                ", height=" + this.y +
                ", depth=" + this.z +
                "}";
    }
}