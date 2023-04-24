package ru.home.java2.homework;

public class MyArrayDataException extends RuntimeException {
    private int row;
    private int column;

    public MyArrayDataException(int row, int column) {
        super("Invalid data in [row = " + row + ", column = " + column + "]");
        this.row = row;
        this.column = column;
    }
}
