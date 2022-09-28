package com.tapsCabs.BookingReceiptModule;

import com.tapsCabs.pojos.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @apiNote Repository for saving the booking in Database
 */
interface IBookingDao extends JpaRepository<Booking, Integer> {
}
