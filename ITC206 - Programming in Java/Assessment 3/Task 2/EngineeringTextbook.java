class EngineeringTextbook extends Textbook {
    // Encapsulated field
    private String subject;

    // No-args default constructor
    public EngineeringTextbook() {
        super();
        this.subject = "";
    }

    // Overloaded constructor
    public EngineeringTextbook(String title, String author, int pages, String subject) {
        super(title, author, pages);
        this.subject = subject;
    }

    // Getter and Setter methods for subject
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Title: " + getTitle() + ", Author: " + getAuthor() + ", Pages: " + getPages() + ", Subject: " + subject;
    }
}
