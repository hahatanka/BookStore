public class Book {
   private final String name;
   public double price;
   public int amount;
   public int amountSold;

    public Book(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void updateAmountSold(int amountBought){
        this.amountSold += amountBought;
    }

    public int getAmountSold() {
        return amountSold;
    }

    @Override
    public String toString() {
        return "\n Book" +
                "name: " + name +
                ". Price: " + price +
                ". Available amount: " + amount;
    }
}

