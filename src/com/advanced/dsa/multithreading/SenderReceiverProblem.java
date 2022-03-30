package com.advanced.dsa.multithreading;

class SendingReceiving{
    private String data;
    private boolean isTransPossible = true;
    void send(String data) throws InterruptedException {
        synchronized (this){
            if(!isTransPossible){
                wait();
            }
            isTransPossible=false;
            this.data = data;
            notifyAll();
        }
    }

    String receive() throws InterruptedException {
        synchronized (this){
            if(isTransPossible){
                wait();
            }
            isTransPossible=true;
            notifyAll();
            return data;
        }
    }
}

class Sender implements Runnable{
    private SendingReceiving sendingReceiving;

    public Sender(SendingReceiving load) {
        this.sendingReceiving = load;
    }

    @Override
    public void run() {
        String[] data = {"First","second","third","fourth","fifth","EOF"};
        for (String msg: data) {
            try {
                sendingReceiving.send(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Receiver implements Runnable{

    private SendingReceiving sendingReceiving;

    public Receiver(SendingReceiving load) {
        this.sendingReceiving = load;
    }

    @Override
    public void run() {
        try {
            /*for(String msg = sendingReceiving.receive();
                !"EOF".equals(msg);)
                    System.out.println(msg);*/
            while(true){
                String msg = sendingReceiving.receive();
                if(msg.equals("EOF"))
                    break;
                System.out.println(msg);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//1.Sender is sending apacket
//2. Receiver is receiving packet after sender has finished sending it
public class SenderReceiverProblem {
    public static void main(String[] args){
        SendingReceiving load = new SendingReceiving();
        Thread t1 = new Thread(new Sender(load));
        Thread t2 = new Thread(new Receiver(load));
        t1.start();
        t2.start();
    }
}
