package fitzcraft.fitzdesktop;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.io.IOException;

public final class FitzDesktop extends JavaPlugin {
    /*
                PLUGIN GOALS
     1) Start up TCP connection with Desktop Client
     2) Send playercount to Desktop Client
     3) Just try that first mate...
     */


    @Override
    public void onEnable() {
        // Plugin startup logic
        InfoRunnable inf = new InfoRunnable(this);
        registerEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }


    // METHODS

    public void registerEvents(){

    }
}
