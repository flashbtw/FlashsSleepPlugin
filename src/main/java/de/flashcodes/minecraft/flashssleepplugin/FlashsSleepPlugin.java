package de.flashcodes.minecraft.flashssleepplugin;

import de.flashcodes.minecraft.flashssleepplugin.config.ConfigManager;
import de.flashcodes.minecraft.flashssleepplugin.events.SleepingFail;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class FlashsSleepPlugin extends JavaPlugin {

    public static Logger log;
    public static ConfigManager cfg;
    @Override
    public void onEnable() {
        // Plugin startup logic
        setLogger(this.getLogger());
        setPlugin(this);
        Bukkit.getPluginManager().registerEvents(new SleepingFail(), this);
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private static void setLogger(Logger logger) {
        log = logger;
    }
    private static void setPlugin(Plugin plugin) {
        cfg = new ConfigManager(plugin);
    }
}
