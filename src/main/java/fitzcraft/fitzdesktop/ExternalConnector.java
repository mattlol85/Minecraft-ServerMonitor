package fitzcraft.fitzdesktop;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.net.*;
import java.io.*;

public class ExternalConnector extends BukkitRunnable {
    private final JavaPlugin plugin;
    private String domainName;
    private String hostName;
    private int port = 9876;

    public ExternalConnector(JavaPlugin FitzDesktop) throws InterruptedException, IOException, ClassNotFoundException {

        this.plugin = FitzDesktop;
        run();
    }

    // Methods

    /**
     * Establish connection to Desktop Client
     *
     * @TODO Needs to be more modular
     */
    public void setup() throws IOException,ClassNotFoundException, InterruptedException{
        InetAddress host = InetAddress.getLocalHost();
        Socket socket;
        ObjectOutputStream oos;
        ObjectInputStream ois;

        for(int i=0; i < 5;i++){
            //Establish Socket
            socket = new Socket(host.getHostName(), port);
            // Write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
            if(i==4)oos.writeObject("exit");
            else oos.writeObject(Bukkit.getServer().getWorld("world").getPlayers().size() + " " + i);
            //Read the server response message
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println(message);
            // Close resources
            ois.close();
            oos.close();
            Thread.sleep(100);
        }
    }
    // Ran in thread
    @Override
    public void run(){

    System.out.println(Thread.currentThread().getId());
        try {
            setup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
