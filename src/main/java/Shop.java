import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class Shop extends User {

    public ArrayList<Book> books;
    public ArrayList<User> users;
    double profit;

    public Shop() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setProfit(double profit) {
        this.profit += profit;
    }

    public double getProfit() {
        return profit;
    }

    public void addUser() {
        String name = JOptionPane.showInputDialog("Adding new user", "Please enter user's name: ");
        String email = JOptionPane.showInputDialog("Adding new user", "Please enter user's email: ");
        User user = new User(name, email);
        this.users.add(user);
        JOptionPane.showMessageDialog(null, "User " + user.getName() + " added successfully!");
    }

    public void addBook() {
        String bookName = JOptionPane.showInputDialog("Adding new BOOK", "Please enter book name: ");
        double price = Double.parseDouble(JOptionPane.showInputDialog("Adding new BOOK", "Please enter the price: "));
        int availableAmount = Integer.parseInt(JOptionPane.showInputDialog("Adding new BOOK", "Please enter the amount available: "));

       Book book = new Book(bookName, price, availableAmount);
        this.books.add(book);
        JOptionPane.showMessageDialog(null, availableAmount + " of " + book.getName() + " books added successfully!");

    }

    public void viewAllBooks() {
        JOptionPane.showMessageDialog(null, getBooks() + "\n", " Books available", 3);
    }


    public Book findBook(String bookName) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(bookName)){
                return book;
            }else{
                JOptionPane.showMessageDialog(null, "Sorry, this book is not available");
            }break;
        }return  null;
    }

    public void buyBook(String bookName) {
        for (Book book : books) {
           int bookAmountBought = Integer.parseInt(JOptionPane.showInputDialog("You want to buy " + bookName, " Please enter the amount: "));
           int amountLeft = book.getAmount() - bookAmountBought;
           book.setAmount(amountLeft);
           book.updateAmountSold(bookAmountBought);
           double earnedMoney = bookAmountBought * book.getPrice();
           setProfit(earnedMoney);
           JOptionPane.showMessageDialog(null, "You have bought " + bookAmountBought + " of " + bookName);
           break;
            }
        }


    public Book viewSales(){
        for (Book book: books){
            JOptionPane.showMessageDialog(null, "Total Profit: " + getProfit() +
                    "\n" + "Current sales are: " +
                    "\n" + book.getName() +". Price: " + book.getPrice() + ". Amount sold: " + book.getAmountSold());

        }
        JOptionPane.showMessageDialog(null, "GRAND TOTAL: " + getProfit());
        return null;

    }

}