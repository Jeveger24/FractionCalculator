public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int den) {
        this.numerator = num;
        this.denominator = den;

        if (denominator == 0) {
            throw new IllegalArgumentException();
        } else if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }

    public Fraction(int num) {
        this.numerator = num;
        this.denominator = 1;
    }

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public String toString() {
        String result = this.numerator + "/" + this.denominator;
        return result;
    }

    public double toDouble() {
        double result = this.numerator / this.denominator;
        return result;
    }

    public Fraction add(Fraction other) {
        int newNum = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDen = this.denominator * other.denominator;
        Fraction newF = new Fraction(newNum, newDen);
        return newF;
    }

    public Fraction subtract(Fraction other) {
        int newNum = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDen = this.denominator * other.denominator;
        Fraction newF = new Fraction(newNum, newDen);
        return newF;
    }

    public Fraction multiply(Fraction other) {
        int newNum = this.numerator * other.numerator ;
        int newDen = this.denominator * other.denominator;
        Fraction newF = new Fraction(newNum, newDen);
        return newF;
    }

    public Fraction divide(Fraction other) {
        int newNum = this.numerator * other.denominator ;
        int newDen = other.denominator * this.numerator;
        Fraction newF = new Fraction(newNum, newDen);
        return newF;
    }

    public boolean equals(Fraction other) {
        double a = this.toDouble();
        double b = other.toDouble();
        boolean result = (a==b);
        return result;
    }

    public Fraction toLowestTerms() {
        int factor = gcd(this.numerator, this.denominator);
        int newNum = this.numerator / factor;
        int newDen = this.denominator / factor;
        Fraction newF = new Fraction(newNum, newDen);
        return newF;
    }

    public static int gcd(int num, int den) {
        if(den == 0){
            return num;
        }
        return gcd(den, num%den);
    }
}