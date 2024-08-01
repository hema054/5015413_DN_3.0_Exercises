package CTS_Weekly_Exercies.Week1_DSA.Library_Management_system;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(1, "Book 1", "Author 1");
        Book book2 = new Book(2, "Book 2", "Author 2");
        Book book3 = new Book(3, "Book 3", "Author 3");

        Book[] books = {book1, book2, book3};

        LibraryManagementSystem lms = new LibraryManagementSystem(books);

        Book foundBook = lms.linearSearchByTitle("Book 2");
        if (foundBook!= null) {
            System.out.println("Found book: " + foundBook.getTitle());
        } else {
            System.out.println("Book not found");
        }

        foundBook = lms.binarySearchByTitle("Book 2");
        if (foundBook!= null) {
            System.out.println("Found book: " + foundBook.getTitle());
        } else {
            System.out.println("Book not found");
        }
    }
}
