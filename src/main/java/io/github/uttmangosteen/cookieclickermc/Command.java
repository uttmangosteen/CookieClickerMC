package io.github.uttmangosteen.cookieclickermc;

import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.UUID;

import static io.github.uttmangosteen.cookieclickermc.Global.namespacedKey;
import static io.github.uttmangosteen.cookieclickermc.Utils.createItem;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("§f§l[§d§lCo§f§lok§a§lie§e§lClicker§f§l]§cプレイヤーでないと実行できません");
            return true;
        }
        Player player = (Player) sender;
        UUID uuid = player.getUniqueId();
        if (args.length == 0){
            if (player.getInventory().getItemInMainHand().getItemMeta() == null || !(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(namespacedKey))) return true;



            return true;
        }

        switch (args[0]) {

            case "item":
                ItemStack saveDataItem = createItem(Material.matchMaterial(Global.config.getString("clickItem.itemId", "COOKIE")), Global.config.getInt("clickItem.customModelData", 0), Global.config.getString("saveDataItem.displayName", "§e§lクッキークリッカーを始める"), Global.config.getStringList("saveDataItem.lore"));
                saveDataItem.getItemMeta().getPersistentDataContainer().set(namespacedKey, PersistentDataType.STRING, "0|[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]|[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]");
                player.getInventory().addItem(saveDataItem);
                return true;

            case "open":
                if (!Global.playData.containsKey(uuid)) Global.playData.put(uuid, new PlayData(
                        BigInteger.ZERO,
                        new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        BigInteger.ZERO, BigInteger.TEN,
                        new BigInteger[]{BigInteger.valueOf(150), BigInteger.valueOf(1000), BigInteger.valueOf(11000), BigInteger.valueOf(120000), BigInteger.valueOf(1300000), BigInteger.valueOf(14000000), BigInteger.valueOf(200000000), BigInteger.valueOf(3300000000L), BigInteger.valueOf(51000000000L), BigInteger.valueOf(750000000000L), BigInteger.valueOf(10000000000000L), BigInteger.valueOf(140000000000000L), BigInteger.valueOf(1700000000000000L), BigInteger.valueOf(21000000000000000L), BigInteger.valueOf(2600000000000000000L), BigInteger.valueOf(1000000000000000000L).multiply(BigInteger.valueOf(31)), BigInteger.valueOf(1000000000000000000L).multiply(BigInteger.valueOf(7100))},
                        new BigInteger[]{BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ZERO}));
                GUI.createInventory(player);
                return true;

            case "help":
                player.sendMessage("/cc\nメインメニューを開く");
                return true;

                //いつか消す
            case "test":
                PlayData playData = Global.playData.get(uuid);
                playData.stock = playData.stock.multiply(BigInteger.TEN);
                return true;

        }
        return false;
    }
}
