import javax.swing.*;

public class Main {

    Shop shop = new Shop();

    public static void main(String[] args) {

        Main main = new Main();
        main.Menu();
    }

    void Menu() {
        String welcome = String.valueOf(JOptionPane.showConfirmDialog(null, "\nWelcome to the BookStore! Enter the system?"));
        String options;
        do {
            String[] menuOptions = {"Register new User", "Add a book", "See all books available", "Buy a book", "See sales", "Exit"};
            options = (String) JOptionPane.showInputDialog(
                    null, "Please choose what you want to do:",
                    null, //title
                    JOptionPane.QUESTION_MESSAGE, //picture
                    null, //icon
                    menuOptions, //the list
                    menuOptions[0]  //default choice
            );
            if (options.equals("Register new User")) {
                shop.addUser();

            } else if (options.equals("Add a book")) {
                shop.addBook();

            }else if (options.equals("See all books available")){
                shop.viewAllBooks();

            } else if (options.equals("Buy a book")) {
                String bookName = JOptionPane.showInputDialog("Buy a Book", "Please enter the name of the book: ");
                Book book = shop.findBook(bookName);
                if (book != null){
                    shop.buyBook(bookName);
                }

            } else if (options.equals("See sales")) {
                shop.viewSales();

            }
        } while (!options.equals("Exit"));






//             System.out.println("Please choose what you want to do: ");
//             System.out.println("1. Register new User");
//             System.out.println("2. Login");
//             System.out.println("\nEnter QUIT to exit the program" +
//                     "\n------------------------------------------");


    }
}
