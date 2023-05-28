package web.model;

public class Car {
    private String model;
    private String series;
    private int yearOfRelease;

    public Car(String model, String series, int yearOfRelease) {
        this.model = model;
        this.series = series;
        this.yearOfRelease = yearOfRelease;
    }

    public String getModel() {
        return model;
    }

    public String getSeries() {
        return series;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }
}
