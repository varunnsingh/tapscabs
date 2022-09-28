package com.tapsCabs.BookingReceiptModule;

import com.tapsCabs.DTO.BookReceipt;
import net.sf.jasperreports.engine.JRException;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @apiNote service layer for receiving the booking and generating the receipt
 */
interface IBookingService {
    /**
     *
     * @param bookingModel
     * @throws IOException
     * @throws MessagingException
     * @throws JRException
     */

  void bookCab(BookReceipt bookingModel) throws IOException, MessagingException, JRException;
 }
