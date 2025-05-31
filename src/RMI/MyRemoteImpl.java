package RMI;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    MyRemoteImpl() throws RemoteException {}

    public String sayHello() {
        return "Hello from RMI Server!";
    }

    public static void main(String[] args) throws Exception {
        MyRemoteImpl obj = new MyRemoteImpl();
        LocateRegistry.createRegistry(1099); // Start RMI registry
        Naming.rebind("HelloServer", obj);
        System.out.println("RMI Server is running...");
    }
}
