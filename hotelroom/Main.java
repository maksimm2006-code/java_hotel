package hotelroom;

import hotelroom.Hotel.Bill;
import hotelroom.Hotel.Client;
import hotelroom.Hotel.Hotel;
import hotelroom.Hotel.Room;
import hotelroom.service.BookService;


public class Main {
    public static void main(String[] args) {
        Bill loriBill = new Bill(11000);
        Client loriClient = new Client("Lori", "Cat", "78948239189", "maksimka2006@mail.ru", loriBill);

        Bill baxBill = new Bill(10000);
        Client baxClient = new Client("Bax", "Dog", "76840938348", "baxdog@mail.ru", baxBill);

        Room[] moskvaHotelRoom = new Room[] {new Room(1,1500,true), new Room(2,3000, true),
                new Room(3,4000, true)};
        Hotel moskvaHotel = new Hotel("Moskva", moskvaHotelRoom);

        Room[] piterHotelRoom = new Room[] {new Room(1,2000,true), new Room(2,3500, true),
                new Room(3, 4500,true)};

        BookService bookService =new BookService();
        bookService.book(loriClient, moskvaHotel,2);
    }
}
