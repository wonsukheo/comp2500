package academy.pocu.comp2500.lab2;

public class ComplexNumber {
    public double real;
    public double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(double real) {
        this(real, 0.0f);
    }

    public ComplexNumber() {
        this(0.0f, 0.0f);
    }

    public boolean isReal() {
        if (this.imaginary == 0.0f) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isImaginary() {
        if (this.real == 0.0f) {
            return true;
        } else {
            return false;
        }
    }

    public ComplexNumber getConjugate() {
        return new ComplexNumber(this.real, -this.imaginary);
    }

    public ComplexNumber add(ComplexNumber num) {
        double real = this.real + num.real;
        double imaginary = this.imaginary + num.imaginary;

        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber subtract(ComplexNumber num) {
        double real = this.real - num.real;
        double imaginary = this.imaginary - num.imaginary;

        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber multiply(ComplexNumber num) {
        double real = this.real * num.real - this.imaginary * num.imaginary;
        double imaginary = this.real * num.imaginary + this.imaginary * num.real;

        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber divide(ComplexNumber num) {
        double denominator = (num.real * num.real) + (num.imaginary * num.imaginary);

        double real = (this.real * num.real + this.imaginary * num.imaginary) / denominator;
        double imaginary = (this.imaginary * num.real - this.real * num.imaginary) / denominator;

        return new ComplexNumber(real, imaginary);
    }
}