public class Seat implements java.io.Serializable{
    private final int row;
    private final int column;
    private boolean available;

    private int customerID;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Seat(int row, int column, boolean available) {
        this.row = row;
        this.column = column;
        this.available = available;
    }

    public int getRow() {
        return row;
    }

//    public void setRow(int row) {
//        this.row = row;
//    }

    public int getColumn() {
        return column;
    }

//    public void setColumn(int column) {
//        this.column = column;
//    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
