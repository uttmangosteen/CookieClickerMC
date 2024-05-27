package io.github.uttmangosteen.cookieclickermc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Timer {
    public static void perSecond() {
        Bukkit.getScheduler().runTaskTimer(Main.plugin,()-> Bukkit.getScheduler().runTask(Main.plugin,()->{
            for(Player player : Bukkit.getOnlinePlayers()){
                UUID uuid = player.getUniqueId();
                PlayData playData = Global.playData.get(uuid);
                if(Global.playData.containsKey(uuid)) playData.stock = playData.stock.add(playData.CPS);
                if(player.getOpenInventory().getTitle().contains("§c§c§m§c")) GUI.createInventory(player);
            }
        }),0, 20);
    }
}
