package Library;

public class Library {
    public static void main(String[] args) {
        book b = new book("Ab12", "java", "james");
        magzine m = new magzine("pq12", "mName", "15");
        referenceBook rf = new referenceBook("df12", "java reference", "programming");

        b.displayDetails();
        m.displayDetails();
        rf.displayDetails();

        System.out.println(b.borrow());
        System.out.println(b.borrow());

        System.out.println(b.returnItem());
        System.out.println(b.returnItem());
    }
}
