package RMI;

import java.rmi.*;

public class MyClient {
    public static void main(String[] args) throws Exception {
        MyRemote stub = (MyRemote) Naming.lookup("rmi://localhost/HelloServer");
        System.out.println(stub.sayHello());
    }
}
