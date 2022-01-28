package BillApplication;

public class HotelManagement {
    public static void main(String[] args)
    {
        MyHotel mh = new MyHotel();
        mh.getUserDetails();
        mh.displayMenu();
        mh.getUserInput();
        mh.print();
    }
}
