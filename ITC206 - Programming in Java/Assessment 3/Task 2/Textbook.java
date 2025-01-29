abstract class Textbook {
    // Encapsulated fields
    private String title;
    private String author;
    private int pages;

    // No-args default constructor
    public Textbook() {
        this.title = "";
        this.author = "";
        this.pages = 0;
    }

    // Overloaded constructor
    public Textbook(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    // Getter and Setter methods for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter methods for author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter and Setter methods for pages
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    // Abstract toString method
    public abstract String toString();
}
