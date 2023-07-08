package io.github.uttmangosteen.cookieclickermc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

import static io.github.uttmangosteen.cookieclickermc.Global.saveData;

public class Timer {
    public static void perSecond() {
        Bukkit.getScheduler().runTaskTimer(Main.plugin,()-> Bukkit.getScheduler().runTask(Main.plugin,()->{
            for(Player player : Bukkit.getOnlinePlayers()){
                UUID uuid = player.getUniqueId();
                PlayerData playerData = saveData.get(uuid);
                if(saveData.containsKey(uuid)) playerData.stock = playerData.stock.add(playerData.CPS);
                if(player.getOpenInventory().getTitle().contains("§c§c§m§c")) GUI.createInventory(player);
            }
        }),0, 20);
    }
}
