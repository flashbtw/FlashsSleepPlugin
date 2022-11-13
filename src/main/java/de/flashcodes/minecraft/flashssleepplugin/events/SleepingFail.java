package de.flashcodes.minecraft.flashssleepplugin.events;

import de.flashcodes.minecraft.flashssleepplugin.FlashsSleepPlugin;
import de.flashcodes.minecraft.flashssleepplugin.config.staticvar.ConfigPaths;
import io.github.flashbtw.enums.ConfigActions;
import io.papermc.paper.event.player.PlayerBedFailEnterEvent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class SleepingFail implements Listener {

    @EventHandler
    public static void onBedEnterFail (PlayerBedFailEnterEvent pbfe) {
        Player p = pbfe.getPlayer();

        switch (pbfe.getFailReason()) {
            case TOO_FAR_AWAY:
                sendNotification(p, FlashsSleepPlugin.cfg.getString(ConfigActions.GET_VALUE, ConfigPaths.TOO_FAR_AWAY));
                pbfe.setCancelled(true);
                return;
            case NOT_POSSIBLE_NOW:
                sendNotification(p, FlashsSleepPlugin.cfg.getString(ConfigActions.GET_VALUE, ConfigPaths.STILL_DAY));
                pbfe.setCancelled(true);
                return;
            case NOT_SAFE:
                sendNotification(p, FlashsSleepPlugin.cfg.getString(ConfigActions.GET_VALUE, ConfigPaths.NOT_SAFE));
                pbfe.setCancelled(true);
                return;
            case OBSTRUCTED:
                sendNotification(p, FlashsSleepPlugin.cfg.getString(ConfigActions.GET_VALUE, ConfigPaths.OBSTRUCTED));
                pbfe.setCancelled(true);
                return;
            case OTHER_PROBLEM:
                sendNotification(p, FlashsSleepPlugin.cfg.getString(ConfigActions.GET_VALUE, ConfigPaths.OTHER_PROBLEM));
                pbfe.setCancelled(true);
        }
    }

    private static void sendNotification(Player p, String message) {
        MiniMessage mm = MiniMessage.miniMessage();
        p.sendActionBar(mm.deserialize(message));
    }
}
