package hotelroom.service;

import hotelroom.Hotel.Client;
import hotelroom.Hotel.Room;
import hotelroom.Hotel.Hotel;
import hotelroom.Hotel.Bill;
public class BookService {

    public void book(Client client, Hotel hotel, int numberOfPerson) {
        Room[] rooms = hotel.getRooms();
        boolean isFreeRooms = false;
        for (Room r : rooms) {
            if(r.isFree()) {
                isFreeRooms = true;
            }
        }
        if(!isFreeRooms) {
            System.out.println("Нет подходящего номера для клиаента: " + client.getName());
        }

        bookRoom(client, numberOfPerson,rooms);

    }

    public void bookRoom(Client client, int numberOfPerson, Room[] rooms) {
        boolean success = false;
        String clientName = client.getName();
        for(Room room : rooms) {
            if(room.getNumberOfPerson() == numberOfPerson) {
                success = true;
                System.out.println("Нашелся подходящи номер для клиента: " + clientName);
                if(client.getBill().getAmount() >= room.getCost()) {
                    Bill clientBill = client.getBill();
                    clientBill.setAmount(clientBill.getAmount() - room.getCost());
                    System.out.println("Номер успешно забронирован клиантом: " + clientName);
                }else{
                    System.out.println("Недостаточно средств");
                }
            }

        }
        if(!success) {
            System.out.println("Нет подходящего номера для клианета: " + clientName);
        }
    }
}
