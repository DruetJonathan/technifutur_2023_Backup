package be.technifutur.decouverte.thread.heritage;

import be.technifutur.decouverte.thread.Writer;

public class ThreadWriter extends Thread{
    private Writer writer;

    public ThreadWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void run(){
        writer.run();
    }
}
