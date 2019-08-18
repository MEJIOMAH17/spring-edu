package edu.jpoint.spring.springedu;

import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class Main {

    public static void main(String[] args)throws  Exception {
        MySuper mySuper = new MySuper(4);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(mySuper);
        objectOutputStream.flush();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object o = objectInputStream.readObject();
        System.out.println(o);

    }
    private static class MySuper implements Serializable{
        int i;
        private MySuper(int i){
            System.out.println(i);
            this.i=i;
        }

        @Override
        public String toString() {
            return "sdafasd"+i;
        }
    }
}
