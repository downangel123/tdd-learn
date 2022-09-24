package com.odde.tdd;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmailNotificationTest {

    @Test
    void testEmail() {
        //Arrange
        MockEmailService re = new MockEmailService();
        EmailNotification notification = new EmailNotification(re);
        //Act
        notification.welcome("312310384@qq.com");
        //Assert
        re.verify();
    }

    @Test
    void testMokito() {
        MockEmailService re = mock(MockEmailService.class);
        EmailNotification notification = new EmailNotification(re);
        //Act
        notification.welcome("312310384@qq.com");
        verify(re).send(any());

        ArgumentCaptor<Email> captor = ArgumentCaptor.forClass(Email.class);
        verify(re).send(captor.capture());

        Email mail = captor.getValue();
        assertEquals("zbcjackson@odd-e.com",mail.getFrom());
        assertEquals("312310384@qq.com",mail.getTo());
        assertEquals("Welcome",mail.getTitle());
        assertEquals("Hello",mail.getContent());
    }

    public static class MockEmailService extends MailService {

        private Email email;

        public void send(Email mail) {
            super.send(mail);
            this.email = mail;
        }

        public Email getEmail() {
            return email;
        }

        public void verify(){
            assertEquals("zbcjackson@odd-e.com",this.getEmail().getFrom());
            assertEquals("312310384@qq.com",this.getEmail().getTo());
            assertEquals("Welcome",this.getEmail().getTitle());
            assertEquals("Hello",this.getEmail().getContent());
        }
    }


}
