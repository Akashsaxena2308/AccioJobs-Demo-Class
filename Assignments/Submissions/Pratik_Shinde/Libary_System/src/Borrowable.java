public interface Borrowable {
    String borrowItem() throws Invalid_input;
    String returnItem() throws Invalid_input;
    boolean isBorrowed();
}
