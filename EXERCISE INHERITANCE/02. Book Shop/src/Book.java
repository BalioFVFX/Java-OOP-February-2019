import java.security.InvalidParameterException;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    private void setTitle(String title) {
        if(title.length() < 3){
            throw new InvalidParameterException("Title not valid!");
        }
        this.title = title;
    }

    private void setAuthor(String author) {
        if(author.split("\\s+").length > 1 && Character.isDigit(author.split("\\s+")[1].charAt(0))){
            throw new InvalidParameterException("Author not valid!");
        }
        this.author = author;
    }

    private void setPrice(double price) {
        if(price <= 0){
            throw new InvalidParameterException("Price not valid!");
        }
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return String.format("Type: %s%nTitle: %s%nAuthor: %s%nPrice: %s%n",
                this.getClass().getSimpleName(), this.getTitle(), this.getAuthor(), this.getPrice());
    }
}
