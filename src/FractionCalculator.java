import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] args) {
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("-------------------------------------------------------------------------------");
        String operation = getOperation();
        String firstFractionString = input();
        String secondFractionString = input();
        Fraction firstFraction = getFraction(firstFractionString);
        Fraction secondFraction = getFraction(secondFractionString);
        if(operation.equals("+")){
            Fraction newFraction = firstFraction.add(secondFraction);
            System.out.println(newFraction.toLowestTerms());
        } else if (operation.equals("-")){
            Fraction newFraction = firstFraction.subtract(secondFraction);
            System.out.println(newFraction.toLowestTerms());
        } else if (operation.equals("*")){
            Fraction newFraction = firstFraction.multiply(secondFraction);
            System.out.println(newFraction.toLowestTerms());
        } else if (operation.equals("/")){
            Fraction newFraction = firstFraction.divide(secondFraction);
            System.out.println(newFraction.toLowestTerms());
        } else if (operation.equals("=")){
            System.out.println(firstFraction.equals(secondFraction));
        } else if (operation.equalsIgnoreCase("q")){
            System.out.println("Goodbye");
            System.exit(0);
        }
    }

    public static String getOperation() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
        String operation = input.next();
        if (operation.equals("+")) {
            return "+";
        } else if (operation.equals("-")) {
            return "-";
        } else if (operation.equals("/")) {
            return "/";
        } else if (operation.equals("*")) {
            return "*";
        } else if (operation.equals("=")) {
            return "=";
        } else if (operation.equalsIgnoreCase("q")) {
            return "Quit";
        } else {
            System.out.println("Invalid Operation!");
            return getOperation();
        }
    }

    public static String input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String fraction = input.nextLine();
        if (!validFraction(fraction)) {
            System.out.print("That's not a valid fraction. Try again: ");
            fraction = input.nextLine();
        }
        return fraction;
    }

    public static boolean validFraction(String fraction) {
        if (fraction.contains(("/"))) {
            String[] split = fraction.split("/");
            int num = Integer.parseInt(split[0]);
            int den = Integer.parseInt((split[1]));

            if (den <= 0) {
                return false;
            }
        } else if (fraction.matches(".*[a-zA-Z]+.*")) {
            return false;
        } else if (fraction.contains(Character.toString(' '))) {
            return false;
        } else if (fraction.contains(Character.toString('.'))) {
            return false;
        } else if (fraction.contains(Character.toString('?'))) {
            return false;
        } else if (fraction.contains(Character.toString('!'))) {
            return false;
        } else if (fraction.contains(Character.toString('$'))) {
            return false;
        }
        return true;
    }

    public static Fraction getFraction(String fractionString) {
        if (fractionString.contains("/")) {
            String[] split = fractionString.split("/");
            int num = Integer.parseInt(split[0]);
            int den = Integer.parseInt(split[1]);
            if (num == 0) {
                Fraction newFraction = new Fraction();
                return newFraction;
            } else {
                Fraction newFraction = new Fraction(num, den);
                return newFraction;
            }
        } else if (fractionString.matches(("[0-9]+"))) {
            int num = Integer.parseInt(fractionString);
            Fraction newFraction = new Fraction(num);
            return newFraction;
        } else if ((fractionString.indexOf("-")) == 0 &&((fractionString.substring(1).matches("[0-9]+")))){
            int num = -(Integer.parseInt(fractionString.substring(1)));
            Fraction newFraction = new Fraction(num);
            return newFraction;
        } else {
            Fraction newFraction = new Fraction();
            return newFraction;
        }

    }
}