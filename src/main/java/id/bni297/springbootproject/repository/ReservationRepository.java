package id.bni297.springbootproject.repository;

import id.bni297.springbootproject.model.Reservation;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    private final List<Reservation> reservations = new ArrayList<>();

    public Reservation save(Reservation reservation){
        reservation.setId((long) (reservations.size() + 1));
        reservation.setReservationTime(LocalDateTime.now());
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> findAll(){
        return reservations;
    }

    public Optional<Reservation> findById(Long id){
        return reservations.stream().filter(reservation ->reservation.getId().equals(id))
                .findFirst();
    }

    public List<Reservation> findNama(String nama){
        return reservations.stream().filter(reservation -> reservation.getCustomerName().equals(nama)).toList();
    }


}
