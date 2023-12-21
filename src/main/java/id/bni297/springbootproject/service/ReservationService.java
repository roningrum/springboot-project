package id.bni297.springbootproject.service;

import id.bni297.springbootproject.controller.ReservationController;
import id.bni297.springbootproject.model.Reservation;
import id.bni297.springbootproject.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id){
        return reservationRepository.findById(id);
    }

    public List<Reservation> getReservationName(String nama){return reservationRepository.findNama(nama);}
}
