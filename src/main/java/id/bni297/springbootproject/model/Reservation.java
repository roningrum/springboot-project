package id.bni297.springbootproject.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class Reservation {
    private Long id;

    private String customerName;

    private LocalDateTime reservationTime;

    public Reservation(){}

    public Reservation(Long id, String customerName, LocalDateTime reservationTime){
        this.id = id;
        this.customerName = customerName;
        this.reservationTime = reservationTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id" +id+
                ", customerName='"+customerName+'\'' +
                ", reservationTime='"+ reservationTime+
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Reservation)) return false;
        Reservation that = (Reservation) obj;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
