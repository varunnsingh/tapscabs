package com.tapsCabs.BookingReceiptModule;

import com.tapsCabs.DTO.BookReceipt;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @apiNote controller interface for receiving the booking and generating the receipt
 */
@RequestMapping("/book")
interface IBookingController {

    /**
     * @param bookingModel
     * @return
     * @throws MessagingException
     * @throws IOException
     * @throws JRException
     */
    @PostMapping("/cabservice")
    ResponseEntity<String> bookCab(@RequestBody BookReceipt bookingModel) throws MessagingException, IOException, JRException;
}
