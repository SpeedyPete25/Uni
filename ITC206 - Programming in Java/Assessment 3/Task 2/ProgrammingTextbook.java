class ProgrammingTextbook extends Textbook {
    // Encapsulated field
    private String language;

    // No-args default constructor
    public ProgrammingTextbook() {
        super();
        this.language = "";
    }

    // Overloaded constructor
    public ProgrammingTextbook(String title, String author, int pages, String language) {
        super(title, author, pages);
        this.language = language;
    }

    // Getter and Setter methods for language
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Title: " + getTitle() + ", Author: " + getAuthor() + ", Pages: " + getPages() + ", Language: " + language;
    }
}
