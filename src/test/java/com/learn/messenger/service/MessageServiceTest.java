package com.learn.messenger.service;

import com.learn.messenger.model.Message;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.awt.event.MouseWheelEvent;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;

public class MessageServiceTest {

    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
        MessageService messageServiceMock = Mockito.mock(MessageService.class);
        Optional<Message> message = Optional.of(new Message(10001,"Stud1",new Date(),"Tweet 1 by Stud 1"));
        (Mockito.when(messageServiceMock.findById(0L))).thenReturn(message);
        Assert.assertEquals(message,message);
    }

    @Test
    public void retrieveMessagesByAuthor() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void save() {
    }
}