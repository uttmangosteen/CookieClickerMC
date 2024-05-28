package io.github.uttmangosteen.cookieclickermc;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static io.github.uttmangosteen.cookieclickermc.Global.*;

public class Utils {

    private static final String[] digitName = {"", "万", "億", "兆", "京", "垓", "秭", "穰", "溝", "澗", "正", "載", "極", "恒河沙", "阿僧祇", "那由他", "不可思議", "無量大数"};
    public static String bigIntegerFormat(BigInteger number) {
        StringBuilder viewString = new StringBuilder();
        String bigNumber = number.toString();
        int digitAmount = bigNumber.length() - 1;
        if (digitAmount == 0) {
            return viewString.append("0.").append(bigNumber).toString();
        } else if (digitAmount <= 4) {
            return viewString.append(bigNumber, 0, digitAmount + 1).insert(digitAmount, ".").toString();
        } else if (digitAmount <= 72) {
            viewString.append(bigNumber, 0, (digitAmount - 1) % 4 + 1).append(digitName[(digitAmount - 1) / 4]);
            int small4Digit = Integer.parseInt(bigNumber.substring((digitAmount - 1) % 4 + 1, (digitAmount - 1) % 4 + 5));
            if (small4Digit != 0) viewString.append(small4Digit).append(digitName[(digitAmount - 1) / 4 - 1]);
            return viewString.toString();
        } else {
            return viewString.append(bigNumber, 0, 5).insert(1, ".").append("E+").append(digitAmount - 1).toString();
        }
    }

    public static ItemStack createItem(Material material, int customModelData, String displayName, List<String> lore){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(customModelData);
        meta.setDisplayName(displayName);
        meta.addItemFlags(ItemFlag.values());
        if (lore != null) meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static String playDataToPDCData(PlayData playData){
        System.out.println(playData.stock.toString() + "|" + Arrays.toString(playData.buildingAmount) + "|" + Arrays.toString(playData.upGradeAmount));
        return playData.stock.toString() + "|" + Arrays.toString(playData.buildingAmount) + "|" + Arrays.toString(playData.upGradeAmount);
    }

    public static PlayData pDCDataToPlayData(String PDCdata){
        String[] playData = PDCdata.split("\\|");

        String[] stringBuildingAmount = playData[1].replace('[', ' ').replace(']', ' ').split(",");
        String[] stringUpGradeAmount = playData[2].replace('[', ' ').replace(']', ' ').split(",");

        BigInteger stock = new BigInteger(playData[0]);
        int[] buildingAmount = new int[16];
        int[] upGradeAmount = new int[16];
        BigInteger[] buildingPrice = new BigInteger[16];
        BigInteger[] buildingCPS = new BigInteger[16];
        for (int i = 0; i < 16; i++) {
            buildingAmount[i] = Integer.parseInt(stringBuildingAmount[i]);
            upGradeAmount[i] = Integer.parseInt(stringUpGradeAmount[i]);
        }
        BigInteger CPS = Arrays.stream(buildingCPS).reduce(BigInteger.ZERO, BigInteger::add);
        BigInteger CPC = BigInteger.valueOf(powerCPC[upGradeAmount[0]]).add(BigInteger.valueOf(Arrays.stream(buildingAmount).sum() - buildingAmount[0]).multiply(BigInteger.valueOf(powerThousandFingers[upGradeAmount[0]])));
        for (int i = 0; i < 16; i++) {
            for(int j = 0; j < buildingAmount[i]; j++){
                buildingPrice[i] = buildingBasePrice[i].multiply(BigInteger.valueOf(11)).divide(BigInteger.TEN);
                if(i == 0){
                    buildingCPS[0] = CPC.multiply(BigInteger.valueOf(buildingAmount[0])).divide(BigInteger.TEN);
                    continue;
                }
                buildingCPS[i] = buildingBaseCPS[i].multiply(BigInteger.valueOf(buildingAmount[i])).multiply(BigInteger.TWO.pow(upGradeAmount[i]));
            }
        }
        return new PlayData(stock, buildingAmount, upGradeAmount, CPS, CPC, buildingPrice, buildingCPS);
    }


}
