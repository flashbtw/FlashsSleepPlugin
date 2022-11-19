package de.flashcodes.minecraft.flashssleepplugin.events;

import de.flashcodes.minecraft.flashssleepplugin.FlashsSleepPlugin;
import io.papermc.paper.event.player.PlayerBedFailEnterEvent;
import io.papermc.paper.event.player.PlayerDeepSleepEvent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.scheduler.BukkitScheduler;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BedEnter implements Listener {

    @EventHandler
    public static void onPlayerBedEnter(@NotNull final PlayerBedEnterEvent pdse) {
        BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.runTaskLaterAsynchronously(FlashsSleepPlugin.plugin, () -> {
            List<Player> playerList = pdse.getPlayer().getWorld().getPlayers();
            final int playerListSize = playerList.size();
            int sleepingPlayers = 0;
            if (playerListSize > 1) {
                for (Player p : playerList) {
                    if (p.isSleeping()) {
                        sleepingPlayers++;
                    }
                }
            }
            pdse.getPlayer().sendActionBar(MiniMessage.miniMessage().deserialize("<rainbow>" + sleepingPlayers + " / " + playerListSize + " schnarchen</rainbow>"));
        }, 1L);
    }
}

