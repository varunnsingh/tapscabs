package com.tapsCabs.BookingReceiptModule;


import com.tapsCabs.DTO.BookReceipt;
import com.tapsCabs.enums.TripEnums;
import com.tapsCabs.loginAndSecurity.IUserDao;
import com.tapsCabs.pojos.Booking;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Varun Kumar Singh
 * @version 1.0
 * @apiNote Impl of IBookingService
 */

@Service
 class BookingService implements IBookingService {

    final static Logger log = LoggerFactory.getLogger(BookingService.class);
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private IBookingDao bookingDao;
    @Autowired
    private IUserDao userDao;
    @Value("${fromEmail}")
    private String fromEmail;

    @Value("${filepath}")
   private String path;


    /**
     *
     * @param bookingModel
     * @throws IOException
     * @throws MessagingException
     * @throws JRException
     */
 @Override
 public void bookCab(BookReceipt bookingModel) throws IOException, MessagingException, JRException {
     log.info("making a booking receipt");
     if(bookingModel==null){
         log.warn("null booking information received from user");
     }
  Booking booking = new Booking.Builder(bookingModel.getPassengerNumber(),bookingModel.getPickUpAddress(),bookingModel.getDropAddress())
             .userId(bookingModel.getUserId())
             .passengerName(bookingModel.getPassengerName())
             .price(bookingModel.getPrice())
             .distance(bookingModel.getDistance())
             .tripStatus(String.valueOf(TripEnums.AWAITED))
             .pickupDateTime(bookingModel.getPickupDateTime())
             .tripType(bookingModel.getTripType())
             .cabType(bookingModel.getCabType())
             .paymentStatus(bookingModel.getPaymentStatus())
             .bookingDate(bookingModel.getBookingDate())
             .build();

       booking = bookingDao.save(booking);

       jasperInvoiceGenerator(booking);

      mailReceipt(booking);
 }

    /**
     *
     * @param booking
     * @throws FileNotFoundException
     * @throws JRException
     * @apiNote generates receipt pdf
     */

    private void jasperInvoiceGenerator(Booking booking) throws FileNotFoundException, JRException {
          List<Booking> l = new ArrayList<>();
         l.add(booking);
        JRBeanCollectionDataSource jrBean = new JRBeanCollectionDataSource(l);
        JasperReport compiledReport =JasperCompileManager.compileReport(new FileInputStream("src\\main\\resources\\invoice.jrxml"));
        Map<String,Object> map = new HashMap<>();
        JasperPrint report =JasperFillManager.fillReport(compiledReport,map,jrBean);
        JasperExportManager.exportReportToPdfFile(report, path+"_"+booking.getBookingId()+"-"+booking.getUserId()+".pdf");
 }

    /**
     *
     * @param booking
     * @throws MessagingException
     * @apiNote mails the receipt
     */


   private void mailReceipt(Booking booking) throws MessagingException {

        String from = fromEmail;
       String to= userDao.findById(booking.getUserId()).get().getEmail();

        String subject = "Booking Receipt"+booking.getBookingId();
        String attachment= path+"_"+booking.getBookingId()+"-"+booking.getUserId()+".pdf";

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText("Thank-you for booking with us");

        FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
        mailSender.send(mimeMessage);
        log.info("mailed the receipt to user");

    }

    }


