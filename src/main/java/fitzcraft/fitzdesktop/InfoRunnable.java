package fitzcraft.fitzdesktop;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class InfoRunnable extends BukkitRunnable {

    private final JavaPlugin FitzDesktop;

    public InfoRunnable(JavaPlugin FitzDesktop){
    this.FitzDesktop = FitzDesktop;
    }



    @Override
    public void run(){
    System.out.println("I am running!!");
    }

}
