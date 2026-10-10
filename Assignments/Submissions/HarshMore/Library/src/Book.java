class Book extends BorrowableItem {
    private String author;

    public Book(int itemId, String title, String author) {
        super(itemId, title);
        this.author = author;
    }

    @Override
    public void displayDetails() {
        // id + title + author
        System.out.println("Item ID : " + super.getItemId() + "\nBook Title : " + super.getTitle() + "\nBook Author : " + author);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}