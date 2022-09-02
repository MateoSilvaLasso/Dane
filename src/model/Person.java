package model;

public class Person {
    private int cedula;
    private String fullName;
    private String born;
    private String city;
    private Person right;
    private Person left;

    @Override
    public String toString() {
        return "*************************\n" +
                "name=" + fullName+"\n" +
                "date=" + born + "\n" +
                "cedula=" + cedula + "\n" +
                "city=" + city + "\n" +
                "\n";
    }

    public Person(int cedula, String fullName, String born, String city) {
        this.cedula = cedula;
        this.fullName = fullName;
        this.born = born;
        this.city = city;
    }


    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Person getRight() {
        return right;
    }

    public void setRight(Person right) {
        this.right = right;
    }

    public Person getLeft() {
        return left;
    }

    public void setLeft(Person left) {
        this.left = left;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
