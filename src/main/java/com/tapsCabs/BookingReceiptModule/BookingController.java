package com.tapsCabs.BookingReceiptModule;


import com.tapsCabs.DTO.BookReceipt;
import net.sf.jasperreports.engine.JRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @apiNote Implementation of IBookingController
 */

@RestController
class BookingController implements IBookingController {

    final static Logger log = LoggerFactory.getLogger(BookingController.class);
    @Autowired
   private IBookingService bookingService;


    /**
     *
     * @param bookingModel
     * @return
     * @throws MessagingException
     * @throws IOException
     * @throws JRException
     */
   public ResponseEntity<String> bookCab(BookReceipt bookingModel) throws MessagingException, IOException, JRException {
       log.info("customer has requested for booking");
        bookingService.bookCab(bookingModel);
        return new ResponseEntity<>("Booking done, Receipt will be mailed to you", HttpStatus.OK);
    }



}
