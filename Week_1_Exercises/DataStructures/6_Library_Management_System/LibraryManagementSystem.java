package CTS_Weekly_Exercies.Week1_DSA.Library_Management_system;

public class LibraryManagementSystem {
    private Book[] books;

    public LibraryManagementSystem(Book[] books) {
        this.books = books;
    }
   //Linear Search
    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
    //Binary Search
    public Book binarySearchByTitle(String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (books[mid].getTitle().equals(title)) {
                return books[mid];
            } else if (books[mid].getTitle().compareTo(title) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}