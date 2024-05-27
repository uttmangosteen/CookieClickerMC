package io.github.uttmangosteen.cookieclickermc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.UUID;

import static io.github.uttmangosteen.cookieclickermc.Global.*;

public class Event implements Listener {public Event(Plugin plugin){Bukkit.getPluginManager().registerEvents(this, plugin);}

    PersistentDataContainer cCData;
    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        ItemStack useItem = event.getItem();
        if (useItem == null) return;
        PersistentDataContainer nbtData = useItem.getItemMeta().getPersistentDataContainer();
        if (!nbtData.has(namespacedKey)) return;
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

    }

    private static final BigInteger[] buildingOriginalCPS = {BigInteger.valueOf(1), BigInteger.valueOf(10), BigInteger.valueOf(80), BigInteger.valueOf(470), BigInteger.valueOf(2600), BigInteger.valueOf(14000), BigInteger.valueOf(78000), BigInteger.valueOf(440000), BigInteger.valueOf(2600000), BigInteger.valueOf(16000000), BigInteger.valueOf(100000000), BigInteger.valueOf(650000000), BigInteger.valueOf(4300000000L), BigInteger.valueOf(29000000000L), BigInteger.valueOf(21000000000000L), BigInteger.valueOf(150000000000000L), BigInteger.valueOf(1100000000000000000L)};
    private static final int[] powerCPC = {10, 20, 40, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80};
    private static final long[] powerThousandFingers = {0, 0, 0, 0, 1, 5, 50, 1000, 20000, 400000, 8000000, 160000000, 3200000000L, 64000000000L, 1280000000000L};
    @EventHandler
    public void inventoryClickEvent(InventoryClickEvent event) {
        ItemStack clickedItem = event.getCurrentItem();
        if (clickedItem == null || !event.getView().getTitle().contains("§c§c§m§c")) return;
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        PlayData playData = Global.playData.get(player.getUniqueId());
        int originalItemID;
        switch (clickedItem.getItemMeta().getDisplayName()) {

            case "§e§lクリックで作る":
                playData.stock = playData.stock.add(playData.CPC);
                GUI.createInventory(player);
                return;
            case "§e§lLOAD":
                player.closeInventory();
                player.sendMessage("§f§l[§d§lCo§f§lok§a§lie§e§lClicker§f§l]§b§lロード");
                GUI.createInventory(player);
                return;
            case "§e§lSAVE":
                player.closeInventory();
                player.sendMessage("§f§l[§d§lCo§f§lok§a§lie§e§lClicker§f§l]§a§lセーブ");
                return;

            case "§e§lカーソル": originalItemID = 0; break;
            case "§e§lグランマ": originalItemID = 1; break;
            case "§e§l農場": originalItemID = 2; break;
            case "§e§l採掘場": originalItemID = 3; break;
            case "§e§l工場": originalItemID = 4; break;
            case "§e§l銀行": originalItemID = 5; break;
            case "§e§l神殿": originalItemID = 6; break;
            case "§e§l魔法使いの塔": originalItemID = 7; break;
            case "§e§l宇宙船": originalItemID = 8; break;
            case "§e§l錬金術室": originalItemID = 9; break;
            case "§e§lポータル": originalItemID = 10; break;
            case "§e§lタイムマシン": originalItemID = 11; break;
            case "§e§l反物質凝縮器": originalItemID = 12; break;
            case "§e§lプリズム": originalItemID = 13; break;
            case "§e§lチャンスメーカー": originalItemID = 14; break;
            case "§e§l自己無限生成エンジン": originalItemID = 15; break;
            case "§e§lJavaコンソール": originalItemID = 16; break;

            case "§e§lカーソルアップグレード": originalItemID = 100; break;
            case "§e§lグランマアップグレード": originalItemID = 101; break;
            case "§e§l農場アップグレード": originalItemID = 102; break;
            case "§e§l採掘場アップグレード": originalItemID = 103; break;
            case "§e§l工場アップグレード": originalItemID = 104; break;
            case "§e§l銀行アップグレード": originalItemID = 105; break;
            case "§e§l神殿アップグレード": originalItemID = 106; break;
            case "§e§l魔法使いの塔アップグレード": originalItemID = 107; break;
            case "§e§l宇宙船アップグレード": originalItemID = 108; break;
            case "§e§l錬金術室アップグレード": originalItemID = 109; break;
            case "§e§lポータルアップグレード": originalItemID = 110; break;
            case "§e§lタイムマシンアップグレード": originalItemID = 111; break;
            case "§e§l反物質凝縮器アップグレード": originalItemID = 112; break;
            case "§e§lプリズムアップグレード": originalItemID = 113; break;
            case "§e§lチャンスメーカーアップグレード": originalItemID = 114; break;
            case "§e§l自己無限生成エンジンアップグレード": originalItemID = 115; break;
            case "§e§lJavaコンソールアップグレード": originalItemID = 116; break;

            default: return;
        }
        if (originalItemID < 100) {
            //施設購入時の処理
            if (playData.stock.compareTo(playData.buildingPrice[originalItemID]) < 0) return;
            playData.stock = playData.stock.subtract(playData.buildingPrice[originalItemID]);
            playData.buildingAmount[originalItemID]++;
            playData.buildingCPS[originalItemID] = buildingOriginalCPS[originalItemID].multiply(BigInteger.valueOf(playData.buildingAmount[originalItemID])).multiply(BigInteger.TWO.pow(playData.upGradeAmount[originalItemID]));
            playData.buildingPrice[originalItemID] = playData.buildingPrice[originalItemID].multiply(BigInteger.valueOf(11)).divide(BigInteger.TEN);
        } else {
            //アップグレード購入時の処理
            originalItemID = originalItemID - 100;
            if (originalItemID == 0) {
                if(playData.stock.compareTo(upGradeCursorPrice[playData.upGradeAmount[0]]) < 0) return;
                playData.stock = playData.stock.subtract(upGradeCursorPrice[playData.upGradeAmount[0]]);
            } else {
                if (playData.stock.compareTo(buildingOriginalPrice[originalItemID].multiply(upGradeOriginalPrice[playData.upGradeAmount[originalItemID]])) < 0) return;
                playData.stock = playData.stock.subtract(buildingOriginalPrice[originalItemID].multiply(upGradeOriginalPrice[playData.upGradeAmount[originalItemID]]));
                playData.buildingCPS[originalItemID] = playData.buildingCPS[originalItemID].multiply(BigInteger.TWO);
            }
            playData.upGradeAmount[originalItemID]++;
        }
        playData.CPC = BigInteger.valueOf(powerCPC[playData.upGradeAmount[0]]).add(BigInteger.valueOf(Arrays.stream(playData.buildingAmount).sum() - playData.buildingAmount[0]).multiply(BigInteger.valueOf(powerThousandFingers[playData.upGradeAmount[0]])));
        playData.buildingCPS[0] = playData.CPC.multiply(BigInteger.valueOf(playData.buildingAmount[0])).divide(BigInteger.TEN);
        playData.CPS = Arrays.stream(playData.buildingCPS).reduce(BigInteger.ZERO, BigInteger::add);
        GUI.createInventory(player);
    }
}