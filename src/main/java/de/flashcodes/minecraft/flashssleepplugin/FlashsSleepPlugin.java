package de.flashcodes.minecraft.flashssleepplugin;

import de.flashcodes.minecraft.flashssleepplugin.config.ConfigManager;
import de.flashcodes.minecraft.flashssleepplugin.events.BedEnter;
import de.flashcodes.minecraft.flashssleepplugin.events.SleepingFail;
import org.bukkit.Bukkit;
import org.bukkit.block.Bed;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class FlashsSleepPlugin extends JavaPlugin {

    public static Logger log;
    public static ConfigManager cfg;
    public static Plugin plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        log.info("Setting necessary static variables");
        setLogger(this.getLogger());
        setPlugin(this);
        log.info("Loading Events..");
        Bukkit.getPluginManager().registerEvents(new SleepingFail(), this);
        Bukkit.getPluginManager().registerEvents(new BedEnter(), this);
        log.info("Loaded Events!");
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private static void setLogger(Logger logger) {
        log = logger;
    }
    private static void setPlugin(Plugin pl) {
        cfg = new ConfigManager(pl);
        plugin = pl;
    }
}
