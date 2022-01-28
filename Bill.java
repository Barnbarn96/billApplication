package BillApplication;


public class Bill {
    String itemName;
    int price, quantity, subTotal;

    Bill(String itemName, int price,int quantity, int subTotal)
    {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    //return string value instead of address
    @Override
    public String toString() {
        return itemName+"     "+price+"        "+quantity+"           "+subTotal;
    }
}
