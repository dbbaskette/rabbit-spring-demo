package io.pivotal.bluebunny;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Receiver {
    private BlockingQueue<String> messages =  new ArrayBlockingQueue<String>(10);

    private Receiver() {
        return;
    }

    private static Receiver singleton;

    public static Receiver getReceiver() {
        if (Receiver.singleton == null) {
            Receiver.singleton = new Receiver();
        }
        return Receiver.singleton;
   }

    public void receiveMessage(String message) throws InterruptedException {
        System.out.println("Consumed message " + message);
        this.messages.put(message);
    }

    public List<String> getMessages() {
        List<String> messagesCopy = new ArrayList<String>();
        this.messages.drainTo(messagesCopy);
        return messagesCopy;
    }

}