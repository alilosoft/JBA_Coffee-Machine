class Complex {

    double real;
    double image;

    void add(Complex other) {
        this.real += other.real;
        this.image += other.image;
    }

    void subtract(Complex other) {
        this.real -= other.real;
        this.image -= other.image;
    }
}