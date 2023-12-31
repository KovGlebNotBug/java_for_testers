package ru.stqa.geometry.figures;


public record Triangle(double sideA, double sideB, double sideC) {

   public Triangle {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException("A side of triangle cannot be less or equal to zero.");
        }
        if (!((sideA+sideB) > sideC) | !((sideB+sideC) > sideA) | !((sideA+sideC) > sideB)) {
           throw new IllegalArgumentException("The sum of a two sides of triangle can not be less than the third side.");
       }
    }

    public static void printTriangleArea(Triangle t) {
        String textArea = String.format("Площядь треуголника с сторонами %.1f / %.1f / %.1f = " + t.triangleArea(), t.sideA, t.sideB, t.sideC);
        System.out.println(textArea);
    }

    public static void printTrianglePerimeter(Triangle t){
        String textPerimeter = String.format("Периметр треуголника с сторонами %.1f / %.1f / %.1f = %.2f" , t.sideA, t.sideB, t.sideC, t.trianglePerimeter());
        System.out.println(textPerimeter);
    }

    public double trianglePerimeter() {
        return this.sideA + this.sideB + this.sideC;
    }

    public double triangleArea() {
        var p = trianglePerimeter() / 2;
        return Math.sqrt(p * (p - this.sideA) * (p - this.sideB) * (p - this.sideC));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(triangle.sideA, this.sideA) == 0 && Double.compare(triangle.sideB, this.sideB) == 0 && Double.compare(triangle.sideC, this.sideC) == 0)
                || (Double.compare(triangle.sideA, this.sideB) == 0 && Double.compare(triangle.sideB, this.sideC) == 0 && Double.compare(triangle.sideC, this.sideA) == 0)
                || (Double.compare(triangle.sideA, this.sideC) == 0 && Double.compare(triangle.sideB, this.sideB) == 0 && Double.compare(triangle.sideC, this.sideA) == 0)
                || (Double.compare(triangle.sideA, this.sideA) == 0 && Double.compare(triangle.sideB, this.sideC) == 0 && Double.compare(triangle.sideC, this.sideB) == 0)
                || (Double.compare(triangle.sideA, this.sideB) == 0 && Double.compare(triangle.sideB, this.sideA) == 0 && Double.compare(triangle.sideC, this.sideC) == 0)
                || (Double.compare(triangle.sideA, this.sideC) == 0 && Double.compare(triangle.sideB, this.sideA) == 0 && Double.compare(triangle.sideC, this.sideB) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
