package demo4;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {
    public static void main(String[] args) {

    }
}

class Input implements Runnable
{
    private PipedInputStream pis;

    public Input(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {

    }
}

class Output implements Runnable
{
    private PipedOutputStream pos;

    public Output(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            pos.write("管道来了".getBytes());
            pos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
