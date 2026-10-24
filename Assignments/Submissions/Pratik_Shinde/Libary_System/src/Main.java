public class Main {
    public static void main(String[] args) {
        try {
            Books book1 = new Books("Hello", "Pratik Shinde");
            book1.displayDetails();
//        System.out.println(book1.borrowItem());

            Magazine magazine1 = new Magazine("Learning");
            magazine1.displayDetails();
            System.out.println(magazine1.borrowItem());
//        System.out.println(magazine1.borrowItem());
            System.out.println(magazine1.returnItem());

            Reference_Book r1 = new Reference_Book("Learning new things", "Math");
            r1.displayDetails();
            r1.isBorrowed();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Operation completed");
        }
    }
}