package pl.edu.wat.wcy;

public class Placement {

    private int row;
    private int column;
    private int direction;
    private double functionValue;

    public Placement(int row, int column, double functionValue) {
        this.row = row;
        this.column = column;
        this.functionValue = functionValue;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getDirection() {
        return direction;
    }

    public double getFunctionValue() {
        return functionValue;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setFunctionValue(double functionValue) {
        this.functionValue = functionValue;
    }

    public void print() {
        System.out.println();
        System.out.println("Row: " + row);
        System.out.println("Column: " + column);
        System.out.println("Direction: " + direction);
        System.out.println("Function value: " + functionValue);
    }
}
