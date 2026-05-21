public class grocerybiling {


    static class Item {
        private String name;
        private double price;
        private int quantity;

        public Item(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getSubtotal() {
            return price * quantity;
        }
    }


    static class Bill {
        private Item[] items;

        public Bill(Item[] items) {
            this.items = items;
        }

        public void generateReceipt() {
            StringBuilder receipt = new StringBuilder();
            double total = 0;

            receipt.append("------ Grocery Bill ------\n");
            receipt.append("Item\tPrice\tQty\tTotal\n");

            for (Item item : items) {
                double subtotal = item.getSubtotal();
                total += subtotal;
                receipt.append(item.getName()).append("\t")
                       .append(item.getPrice()).append("\t")
                       .append(item.getQuantity()).append("\t")
                       .append(subtotal).append("\n");
            }

            double tax = total * 0.05; // 5% GST
            double grandTotal = total + tax;

            receipt.append("Total: ").append(total).append("\n");
            receipt.append("Tax (5%): ").append(tax).append("\n");
            receipt.append("Grand Total: ").append(grandTotal).append("\n");

            System.out.println(receipt.toString());
        }
    }

    
    public static void main(String[] args) {
        Item[] items = {
            new Item("Rice", 50, 2),
            new Item("Milk", 30, 3),
            new Item("Bread", 25, 4)
        };

        Bill bill = new Bill(items);
        bill.generateReceipt();
    }
}
