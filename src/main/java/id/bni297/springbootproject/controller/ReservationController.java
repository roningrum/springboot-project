package id.bni297.springbootproject.controller;

import id.bni297.springbootproject.model.Reservation;
import id.bni297.springbootproject.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public  Reservation createReservation(@RequestBody Reservation reservation){
        return reservationService.createReservation(reservation);
    }

    @GetMapping
    public List<Reservation> getAllReservation(){
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id){
        return reservationService.getReservationById(id).orElse(null);
    }

    @GetMapping("/findReservation")
    public List<Reservation> findReservationName(@RequestParam("name") String name){
        return reservationService.getReservationName(name);
    }
}
