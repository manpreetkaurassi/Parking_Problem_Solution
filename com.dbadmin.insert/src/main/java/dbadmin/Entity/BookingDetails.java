package dbadmin.Entity;

import java.sql.Date;

public class BookingDetails {
	
	private int booking_id;
	private int parking_id;
	private String booking_time;
	private String booking_date;


	@Override
	public String toString() {
		return "BookingDetails []";
	}

	public int getBooking_id() {
		return booking_id;
	}

	public BookingDetails() {
		super();
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getParking_id() {
		return parking_id;
	}

	public void setParking_id(int parking_id) {
		this.parking_id = parking_id;
	}

	public String getBooking_time() {
		return booking_time;
	}

	public void setBooking_time(String booking_time) {
		this.booking_time = booking_time;
	}

	public String getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}

	
	

}
