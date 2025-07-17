package com.anujl.blacknwhite.service;

import com.anujl.blacknwhite.dto.EmailDetails;

public interface EmailService {

    // Method to send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method to send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
