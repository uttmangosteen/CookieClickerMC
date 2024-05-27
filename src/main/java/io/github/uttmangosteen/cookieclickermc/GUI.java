package io.github.uttmangosteen.cookieclickermc;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.math.BigInteger;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

import static io.github.uttmangosteen.cookieclickermc.Global.*;
import static io.github.uttmangosteen.cookieclickermc.Utils.bigIntegerFormat;
import static io.github.uttmangosteen.cookieclickermc.Utils.createItem;

public class GUI {

    private static final ItemStack itemSpace = createItem(Material.GREEN_STAINED_GLASS_PANE, 0, " ", null);
    private static final ItemStack itemSeparate = createItem(Material.LIME_STAINED_GLASS_PANE, 0, " ", null);
    private static final ItemStack itemSave = createItem(Material.WRITABLE_BOOK, 0, "§e§lSAVE", List.of("§f§lクリックでデータ保存"));
    private static final ItemStack itemLoad = createItem(Material.BOOK, 0, "§e§lLOAD", List.of("§f§lクリックでデータ呼び出し"));
    private static final ItemStack[][] itemUpGrade = {{
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§a§l100.0クッキー", "§7§lクリックとカーソルが§f§l2倍§7§l効率的になる", "§7§o「強化人差し指」")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§a§l500.0クッキー", "§7§lクリックとカーソルが§f§l2倍§7§l効率的になる", "§7§o「手根管症候群防止クリーム」")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§a§l1万クッキー", "§7§lクリックとカーソルが§f§l2倍§7§l効率的になる", "§7§o「二刀流」")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§a§l10万クッキー", "§7§lクリックとカーソルが§f§lクリックの効果+(カーソル以外の施設の数×0.1)§7§lになる", "§7§o「千手観音」")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§a§l1000万クッキー", "§7§l千手観音の効果を§f§l5倍§7§lにする", "§7§o「万手観音」")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§a§l1億クッキー", "§7§l千手観音の効果を§f§l10倍§7§lにする", "§7§o「億手観音」")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§a§l10億クッキー", "§7§l千手観音の効果を§f§l20倍§7§lにする", "§7§o「兆手観音」")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§a§l100億クッキー", "§7§l千手観音の効果を§f§l20倍§7§lにする", "§7§o「京手観音」")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§a§l10兆クッキー", "§7§l千手観音の効果を§f§l20倍§7§lにする", "§7§o「垓手観音」")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§a§l100兆クッキー", "§7§l千手観音の効果を§f§l20倍§7§lにする", "§7§o「秭手観音」")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§a§l1000兆クッキー", "§7§l千手観音の効果を§f§l20倍§7§lにする", "§7§o「穣手観音」")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§a§l100京クッキー", "§7§l千手観音の効果を§f§l20倍§7§lにする", "§7§o「溝手観音」")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§a§l100垓クッキー", "§7§l千手観音の効果を§f§l20倍§7§lにする", "§7§o「澗手観音」")),
            createItem(Material.ARROW, 0, "§e§lカーソルアップグレード", List.of("§a§l10秭クッキー", "§7§l千手観音の効果を§f§l20倍§7§lにする", "§7§o「正手観音」"))
    }, {
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§a§l1000.0クッキー", "§7§lグランマが§f§l2倍§7§l効率的になる", "§7§o「グランマからの返信」")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§a§l5000.0クッキー", "§7§lグランマが§f§l2倍§7§l効率的になる", "§7§o「金属製のし棒」")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§a§l5万クッキー", "§7§lグランマが§f§l2倍§7§l効率的になる", "§7§o「なめらかな総入れ歯」")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§a§l500万クッキー", "§7§lグランマが§f§l2倍§7§l効率的になる", "§7§o「プルーンジュース」")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§a§l5億クッキー", "§7§lグランマが§f§l2倍§7§l効率的になる", "§7§o「2倍分厚いメガネ」")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§a§l500億クッキー", "§7§lグランマが§f§l2倍§7§l効率的になる", "§7§o「老化剤」")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§a§l50兆クッキー", "§7§lグランマが§f§l2倍§7§l効率的になる", "§7§o「エクストリーム歩行器」")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§a§l5京クッキー", "§7§lグランマが§f§l2倍§7§l効率的になる", "§7§o「制約を越えた者」")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§a§l5000京クッキー", "§7§lグランマが§f§l2倍§7§l効率的になる", "§7§o「逆認知症」")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§a§l500垓クッキー", "§7§lグランマが§f§l2倍§7§l効率的になる", "§7§o「色落ち防止ヘアカラー」")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§a§l500秭クッキー", "§7§lグランマが§f§l2倍§7§l効率的になる", "§7§o「エチケット」")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§a§l500穰クッキー", "§7§lグランマが§f§l2倍§7§l効率的になる", "§7§o「変性発生」")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§a§l500溝クッキー", "§7§lグランマが§f§l2倍§7§l効率的になる", "§7§o「雑談」")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマアップグレード", List.of("§a§l500澗クッキー", "§7§lグランマが§f§l2倍§7§l効率的になる", "§7§o「台所の戸棚」"))
    }, {
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§a§l1万1000クッキー", "§7§l農場が§f§l2倍§7§l効率的になる", "§7§o「安いクワ」")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§a§l5万5000クッキー", "§7§l農場が§f§l2倍§7§l効率的になる", "§7§o「化学肥料」")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§a§l55万クッキー", "§7§l農場が§f§l2倍§7§l効率的になる", "§7§o「クッキーの木」")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§a§l5500万クッキー", "§7§l農場が§f§l2倍§7§l効率的になる", "§7§o「遺伝子組み換えクッキー」")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§a§l55億クッキー", "§7§l農場が§f§l2倍§7§l効率的になる", "§7§o「ショウガダンゴカカシ」")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§a§l5500億クッキー", "§7§l農場が§f§l2倍§7§l効率的になる", "§7§o「パルススプリンクラー」")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§a§l550兆クッキー", "§7§l農場が§f§l2倍§7§l効率的になる", "§7§o「ファッジ菌」")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§a§l55京クッキー", "§7§l農場が§f§l2倍§7§l効率的になる", "§7§o「小麦トリフィド」")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§a§l5垓5000京クッキー", "§7§l農場が§f§l2倍§7§l効率的になる", "§7§o「人道的農薬」")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§a§l5500垓クッキー", "§7§l農場が§f§l2倍§7§l効率的になる", "§7§o「バーンスター」")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§a§l5500秭クッキー", "§7§l農場が§f§l2倍§7§l効率的になる", "§7§o「リントヴルム」")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§a§l5500穰クッキー", "§7§l農場が§f§l2倍§7§l効率的になる", "§7§o「世界種子貯蔵庫」")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§a§l5500溝クッキー", "§7§l農場が§f§l2倍§7§l効率的になる", "§7§o「逆菜食主義」")),
            createItem(Material.WOODEN_HOE, 0, "§e§l農場アップグレード", List.of("§a§l5500澗クッキー", "§7§l農場が§f§l2倍§7§l効率的になる", "§7§o「クッキーマルチ」"))
    }, {
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§a§l12万クッキー", "§7§l採掘場が§f§l2倍§7§l効率的になる", "§7§o「砂糖ガス」")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§a§l60万クッキー", "§7§l採掘場が§f§l2倍§7§l効率的になる", "§7§o「メガドリル」")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§a§l600万クッキー", "§7§l採掘場が§f§l2倍§7§l効率的になる", "§7§o「ウルトラドリル」")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§a§l6億クッキー", "§7§l採掘場が§f§l2倍§7§l効率的になる", "§7§o「アルテマドリル」")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§a§l600億クッキー", "§7§l採掘場が§f§l2倍§7§l効率的になる", "§7§o「水爆採掘」")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§a§l6兆クッキー", "§7§l採掘場が§f§l2倍§7§l効率的になる", "§7§o「中心炉」")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§a§l6000兆クッキー", "§7§l採掘場が§f§l2倍§7§l効率的になる", "§7§o「惑星割り」")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§a§l600京クッキー", "§7§l採掘場が§f§l2倍§7§l効率的になる", "§7§o「キャノーラ油井」")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§a§l60垓クッキー", "§7§l採掘場が§f§l2倍§7§l効率的になる", "§7§o「モグラ人間」")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§a§l6秭クッキー", "§7§l採掘場が§f§l2倍§7§l効率的になる", "§7§o「坑道のカナリア」")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§a§l6穰クッキー", "§7§l採掘場が§f§l2倍§7§l効率的になる", "§7§o「うんざりする掘り直し」")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§a§l6溝クッキー", "§7§l採掘場が§f§l2倍§7§l効率的になる", "§7§o「空気採鉱」")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§a§l6澗クッキー", "§7§l採掘場が§f§l2倍§7§l効率的になる", "§7§o「キャラメル合金」")),
            createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場アップグレード", List.of("§a§l6正クッキー", "§7§l採掘場が§f§l2倍§7§l効率的になる", "§7§o「美味しい鉱物学」"))
    }, {
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§a§l130万クッキー", "§7§l工場が§f§l2倍§7§l効率的になる", "§7§o「より丈夫なベルトコンベアー」")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§a§l650万クッキー", "§7§l工場が§f§l2倍§7§l効率的になる", "§7§o「児童労働」")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§a§l6500万クッキー", "§7§l工場が§f§l2倍§7§l効率的になる", "§7§o「搾取工場」")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§a§l65億クッキー", "§7§l工場が§f§l2倍§7§l効率的になる", "§7§o「ラジウム反応装置」")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§a§l6500億クッキー", "§7§l工場が§f§l2倍§7§l効率的になる", "§7§o「再教育制度」")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§a§l65兆クッキー", "§7§l工場が§f§l2倍§7§l効率的になる", "§7§o「深焼き製法」")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§a§l6京5000兆クッキー", "§7§l工場が§f§l2倍§7§l効率的になる", "§7§o「サイボーグ工員」")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§a§l6500京クッキー", "§7§l工場が§f§l2倍§7§l効率的になる", "§7§o「1日78時間労働」")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§a§l650垓クッキー", "§7§l工場が§f§l2倍§7§l効率的になる", "§7§o「機械学習」")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§a§l65秭クッキー", "§7§l工場が§f§l2倍§7§l効率的になる", "§7§o「ブラウニーポイント制度」")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§a§l65穰クッキー", "§7§l工場が§f§l2倍§7§l効率的になる", "§7§o「ボランティアのインターン」")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§a§l65溝クッキー", "§7§l工場が§f§l2倍§7§l効率的になる", "§7§o「行動のリフレーミング」")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§a§l65澗クッキー", "§7§l工場が§f§l2倍§7§l効率的になる", "§7§o「無限エンジン」")),
            createItem(Material.STONECUTTER, 0, "§e§l工場アップグレード", List.of("§a§l65正クッキー", "§7§l工場が§f§l2倍§7§l効率的になる", "§7§o「N次元の製造ライン」"))
    }, {
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§a§l1400万クッキー", "§7§l銀行が§f§l2倍§7§l効率的になる", "§7§o「のっぽの窓口係」")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§a§l7000万クッキー", "§7§l銀行が§f§l2倍§7§l効率的になる", "§7§o「ハサミで切れないクレジットカード」")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§a§l7億クッキー", "§7§l銀行が§f§l2倍§7§l効率的になる", "§7§o「耐酸性金庫」")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§a§l700億クッキー", "§7§l銀行が§f§l2倍§7§l効率的になる", "§7§o「チョコレートコイン」")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§a§l7兆クッキー", "§7§l銀行が§f§l2倍§7§l効率的になる", "§7§o「指数関数的利息」")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§a§l700兆クッキー", "§7§l銀行が§f§l2倍§7§l効率的になる", "§7§o「金融禅」")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§a§l70京クッキー", "§7§l銀行が§f§l2倍§7§l効率的になる", "§7§o「サイフ道」")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§a§l7垓クッキー", "§7§l銀行が§f§l2倍§7§l効率的になる", "§7§o「マネーの原理」")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§a§l7000垓クッキー", "§7§l銀行が§f§l2倍§7§l効率的になる", "§7§o「食用貨幣」")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§a§l700秭クッキー", "§7§l銀行が§f§l2倍§7§l効率的になる", "§7§o「グランド・スーパーサイクル」")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§a§l700穰クッキー", "§7§l銀行が§f§l2倍§7§l効率的になる", "§7§o「金儲けの秘訣」")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§a§l700溝クッキー", "§7§l銀行が§f§l2倍§7§l効率的になる", "§7§o「利他的ループ」")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§a§l700澗クッキー", "§7§l銀行が§f§l2倍§7§l効率的になる", "§7§o「所得申告の減額」")),
            createItem(Material.LECTERN, 0, "§e§l銀行アップグレード", List.of("§a§l700正クッキー", "§7§l銀行が§f§l2倍§7§l効率的になる", "§7§o「クッキーポイント」"))
    }, {
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§a§l2億クッキー", "§7§l神殿が§f§l2倍§7§l効率的になる", "§7§o「黄金の偶像」")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§a§l10億クッキー", "§7§l神殿が§f§l2倍§7§l効率的になる", "§7§o「いけにえ」")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§a§l100億クッキー", "§7§l神殿が§f§l2倍§7§l効率的になる", "§7§o「おいしい恩恵」")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§a§l1兆クッキー", "§7§l神殿が§f§l2倍§7§l効率的になる", "§7§o「太陽祀り」")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§a§l100兆クッキー", "§7§l神殿が§f§l2倍§7§l効率的になる", "§7§o「増築された万神殿」")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§a§l1京クッキー", "§7§l神殿が§f§l2倍§7§l効率的になる", "§7§o「天にまします大いなる焼き主」")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§a§l1000京クッキー", "§7§l神殿が§f§l2倍§7§l効率的になる", "§7§o「創造神話」")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§a§l100垓クッキー", "§7§l神殿が§f§l2倍§7§l効率的になる", "§7§o「神権政治」")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§a§l10秭クッキー", "§7§l神殿が§f§l2倍§7§l効率的になる", "§7§o「見たことねぇラップ祈祷」")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§a§l1穰クッキー", "§7§l神殿が§f§l2倍§7§l効率的になる", "§7§o「詩篇の朗読」")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§a§l1溝クッキー", "§7§l神殿が§f§l2倍§7§l効率的になる", "§7§o「神々の戦争」")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§a§l1澗クッキー", "§7§l神殿が§f§l2倍§7§l効率的になる", "§7§o「奇抜なアイデア」")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§a§l1正クッキー", "§7§l神殿が§f§l2倍§7§l効率的になる", "§7§o「出現」")),
            createItem(Material.CANDLE, 0, "§e§l神殿アップグレード", List.of("§a§l1載クッキー", "§7§l神殿が§f§l2倍§7§l効率的になる", "§7§o「マイナス神論」"))
    }, {
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§a§l33億クッキー", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる", "§7§o「三角帽子」")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§a§l165億クッキー", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる", "§7§o「フサフサのあごひげ」")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§a§l1650億クッキー", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる", "§7§o「旧き魔道書」")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§a§l16兆5000億クッキー", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる", "§7§o「キッチンの呪い」")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§a§l1650兆クッキー", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる", "§7§o「魔法学校」")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§a§l16京5000兆クッキー", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる", "§7§o「暗黒の術式」")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§a§l1垓6500京クッキー", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる", "§7§o「クッキー操術」")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§a§l1650垓クッキー", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる", "§7§o「うさぎのトリック」")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§a§l165秭クッキー", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる", "§7§o「贅沢仕立ての杖」")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§a§l16穰5000秭クッキー", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる", "§7§o「不動如山の呪文詠唱」")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§a§l16溝5000穰クッキー", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる", "§7§o「電気」")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§a§l16澗5000溝クッキー", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる", "§7§o「呪文を唱える蜜蜂」")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§a§l16正5000澗クッキー", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる", "§7§o「魔法の地下室」")),
            createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔アップグレード", List.of("§a§l16載5000正クッキー", "§7§l魔法使いの塔が§f§l2倍§7§l効率的になる", "§7§o「魔術的現実主義」"))
    }, {
            createItem(Material.FIREWORK_ROCKET, 0, "§e§l宇宙船アップグレード", List.of("§a§l510億クッキー", "§7§l宇宙船が§f§l2倍§7§l効率的になる", "§7§o「バニラ星雲」")),
            createItem(Material.FIREWORK_ROCKET, 0, "§e§l宇宙船アップグレード", List.of("§a§l2550億クッキー", "§7§l宇宙船が§f§l2倍§7§l効率的になる", "§7§o「ワームホール」")),
            createItem(Material.FIREWORK_ROCKET, 0, "§e§l宇宙船アップグレード", List.of("§a§l2兆5500億クッキー", "§7§l宇宙船が§f§l2倍§7§l効率的になる", "§7§o「頻回発射」")),
            createItem(Material.FIREWORK_ROCKET, 0, "§e§l宇宙船アップグレード", List.of("§a§l255兆クッキー", "§7§l宇宙船が§f§l2倍§7§l効率的になる", "§7§o「ワープ航法」")),
            createItem(Material.FIREWORK_ROCKET, 0, "§e§l宇宙船アップグレード", List.of("§a§l2京5500兆クッキー", "§7§l宇宙船が§f§l2倍§7§l効率的になる", "§7§o「チョコレートモノリス」")),
            createItem(Material.FIREWORK_ROCKET, 0, "§e§l宇宙船アップグレード", List.of("§a§l255京クッキー", "§7§l宇宙船が§f§l2倍§7§l効率的になる", "§7§o「世代宇宙船」")),
            createItem(Material.FIREWORK_ROCKET, 0, "§e§l宇宙船アップグレード", List.of("§a§l25垓5000京クッキー", "§7§l宇宙船が§f§l2倍§7§l効率的になる", "§7§o「ダイソン球」")),
            createItem(Material.FIREWORK_ROCKET, 0, "§e§l宇宙船アップグレード", List.of("§a§l2秭5500垓クッキー", "§7§l宇宙船が§f§l2倍§7§l効率的になる", "§7§o「最後のフロンティア」")),
            createItem(Material.FIREWORK_ROCKET, 0, "§e§l宇宙船アップグレード", List.of("§a§l2550秭クッキー", "§7§l宇宙船が§f§l2倍§7§l効率的になる", "§7§o「自動操縦」")),
            createItem(Material.FIREWORK_ROCKET, 0, "§e§l宇宙船アップグレード", List.of("§a§l255穰クッキー", "§7§l宇宙船が§f§l2倍§7§l効率的になる", "§7§o「宇宙の果てのレストラン」")),
            createItem(Material.FIREWORK_ROCKET, 0, "§e§l宇宙船アップグレード", List.of("§a§l255溝クッキー", "§7§l宇宙船が§f§l2倍§7§l効率的になる", "§7§o「共通言語」")),
            createItem(Material.FIREWORK_ROCKET, 0, "§e§l宇宙船アップグレード", List.of("§a§l255澗クッキー", "§7§l宇宙船が§f§l2倍§7§l効率的になる", "§7§o「環状体の宇宙」")),
            createItem(Material.FIREWORK_ROCKET, 0, "§e§l宇宙船アップグレード", List.of("§a§l255正クッキー", "§7§l宇宙船が§f§l2倍§7§l効率的になる", "§7§o「最も重要な指令」")),
            createItem(Material.FIREWORK_ROCKET, 0, "§e§l宇宙船アップグレード", List.of("§a§l255載クッキー", "§7§l宇宙船が§f§l2倍§7§l効率的になる", "§7§o「宇宙前景放射」"))
    }, {
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§a§l7500億クッキー", "§7§l錬金術室が§f§l2倍§7§l効率的になる", "§7§o「アンチモン」")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§a§l3兆7500億クッキー", "§7§l錬金術室が§f§l2倍§7§l効率的になる", "§7§o「生地のエッセンス」")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§a§l37兆5000億クッキー", "§7§l錬金術室が§f§l2倍§7§l効率的になる", "§7§o「本物のチョコレート」")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§a§l3750兆クッキー", "§7§l錬金術室が§f§l2倍§7§l効率的になる", "§7§o「アンブロシア」")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§a§l37京5000兆クッキー", "§7§l錬金術室が§f§l2倍§7§l効率的になる", "§7§o「生地の水」")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§a§l3750京クッキー", "§7§l錬金術室が§f§l2倍§7§l効率的になる", "§7§o「根源のるつぼ」")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§a§l375垓クッキー", "§7§l錬金術室が§f§l2倍§7§l効率的になる", "§7§o「原子流転説」")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§a§l37秭5000垓クッキー", "§7§l錬金術室が§f§l2倍§7§l効率的になる", "§7§o「ギンガトビバッタ」")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§a§l3穰7500秭クッキー", "§7§l錬金術室が§f§l2倍§7§l効率的になる", "§7§o「化学の到来」")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§a§l3750穰クッキー", "§7§l錬金術室が§f§l2倍§7§l効率的になる", "§7§o「考え直した結果」")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§a§l3750溝クッキー", "§7§l錬金術室が§f§l2倍§7§l効率的になる", "§7§o「市民意識の改善」")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§a§l3750澗クッキー", "§7§l錬金術室が§f§l2倍§7§l効率的になる", "§7§o「錬金術の調停」")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§a§l3750正クッキー", "§7§l錬金術室が§f§l2倍§7§l効率的になる", "§7§o「色彩のサイクル」")),
            createItem(Material.BREWING_STAND, 0, "§e§l錬金術室アップグレード", List.of("§a§l3750載クッキー", "§7§l錬金術室が§f§l2倍§7§l効率的になる", "§7§o「神秘のガラス製品」"))
    }, {
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§a§l10兆クッキー", "§7§lポータルが§f§l2倍§7§l効率的になる", "§7§o「古代の豆板」")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§a§l50兆クッキー", "§7§lポータルが§f§l2倍§7§l効率的になる", "§7§o「狂気の麦星人労働者」")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§a§l500兆クッキー", "§7§lポータルが§f§l2倍§7§l効率的になる", "§7§o「魂の契約」")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§a§l5京クッキー", "§7§lポータルが§f§l2倍§7§l効率的になる", "§7§o「健全な踊り」")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§a§l500京クッキー", "§7§lポータルが§f§l2倍§7§l効率的になる", "§7§o「ブレーン移植」")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§a§l5垓クッキー", "§7§lポータルが§f§l2倍§7§l効率的になる", "§7§o「神サイズのポータル」")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§a§l5000垓クッキー", "§7§lポータルが§f§l2倍§7§l効率的になる", "§7§o「終末の日バックアップ計画」")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§a§l500秭クッキー", "§7§lポータルが§f§l2倍§7§l効率的になる", "§7§o「人をキレさせるシュプレヒコール」")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§a§l50穰クッキー", "§7§lポータルが§f§l2倍§7§l効率的になる", "§7§o「現実世界」")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§a§l5溝クッキー", "§7§lポータルが§f§l2倍§7§l効率的になる", "§7§o「異次元ゴミ投棄場」")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§a§l5澗クッキー", "§7§lポータルが§f§l2倍§7§l効率的になる", "§7§o「埋め込み式極小ポータル」")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§a§l5正クッキー", "§7§lポータルが§f§l2倍§7§l効率的になる", "§7§o「彼の降臨」")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§a§l5載クッキー", "§7§lポータルが§f§l2倍§7§l効率的になる", "§7§o「家庭用の裂け目」")),
            createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータルアップグレード", List.of("§a§l5極クッキー", "§7§lポータルが§f§l2倍§7§l効率的になる", "§7§o「ポータルガン」"))
    }, {
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§a§l140兆クッキー", "§7§lタイムマシンが§f§l2倍§7§l効率的になる", "§7§o「次元移転装置」")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§a§l700兆クッキー", "§7§lタイムマシンが§f§l2倍§7§l効率的になる", "§7§o「タイムパラドックスリゾルバー」")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§a§l7000兆クッキー", "§7§lタイムマシンが§f§l2倍§7§l効率的になる", "§7§o「量子的難問」")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§a§l70京クッキー", "§7§lタイムマシンが§f§l2倍§7§l効率的になる", "§7§o「因果律強要課程」")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§a§l7000京クッキー", "§7§lタイムマシンが§f§l2倍§7§l効率的になる", "§7§o「昨日と明日の投影機」")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§a§l70垓クッキー", "§7§lタイムマシンが§f§l2倍§7§l効率的になる", "§7§o「遠未来条例」")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§a§l7秭クッキー", "§7§lタイムマシンが§f§l2倍§7§l効率的になる", "§7§o「グレートループ仮説」")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§a§l7000秭クッキー", "§7§lタイムマシンが§f§l2倍§7§l効率的になる", "§7§o「クッキートピアンの夢想」")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§a§l700穰クッキー", "§7§lタイムマシンが§f§l2倍§7§l効率的になる", "§7§o「第二の秒」")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§a§l70溝クッキー", "§7§lタイムマシンが§f§l2倍§7§l効率的になる", "§7§o「増設用時計の手」")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§a§l70澗クッキー", "§7§lタイムマシンが§f§l2倍§7§l効率的になる", "§7§o「追憶」")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§a§l70正クッキー", "§7§lタイムマシンが§f§l2倍§7§l効率的になる", "§7§o「分裂した秒」")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§a§l70載クッキー", "§7§lタイムマシンが§f§l2倍§7§l効率的になる", "§7§o「忍耐の廃止」")),
            createItem(Material.CLOCK, 0, "§e§lタイムマシンアップグレード", List.of("§a§l70極クッキー", "§7§lタイムマシンが§f§l2倍§7§l効率的になる", "§7§o「耐時間性の椅子カバー」"))
    }, {
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§a§l1700兆クッキー", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる", "§7§o「シュガー粒子」")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§a§l8500兆クッキー", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる", "§7§o「弦理論」")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§a§l8京5000兆クッキー", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる", "§7§o「大型マカロン衝突型加速器」")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§a§l850京クッキー", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる", "§7§o「ビッグバンベイク」")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§a§l8垓5000京クッキー", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる", "§7§o「リバースサイクロトロン」")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§a§l850垓クッキー", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる", "§7§o「ナノ宇宙学」")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§a§l85秭クッキー", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる", "§7§o「パルス」")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§a§l8穰5000秭クッキー", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる", "§7§o「他にも基本的な超微粒子があるだろう、多分」")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§a§l8500穰クッキー", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる", "§7§o「量子櫛」")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§a§l850溝クッキー", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる", "§7§o「ベーキングノーベル賞」")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§a§l850澗クッキー", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる", "§7§o「明確な構造の分子」")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§a§l850正クッキー", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる", "§7§o「風味そのもの」")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§a§l850載クッキー", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる", "§7§o「おいしい引力」")),
            createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器アップグレード", List.of("§a§l850極クッキー", "§7§l反物質凝縮器が§f§l2倍§7§l効率的になる", "§7§o「従業員の小型化」"))
    }, {
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§a§l2京1000兆クッキー", "§7§lプリズムが§f§l2倍§7§l効率的になる", "§7§o「宝石研磨」")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§a§l10京5000兆クッキー", "§7§lプリズムが§f§l2倍§7§l効率的になる", "§7§o「第９の色」")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§a§l105京クッキー", "§7§lプリズムが§f§l2倍§7§l効率的になる", "§7§o「チョコレート光」")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§a§l1垓500京クッキー", "§7§lプリズムが§f§l2倍§7§l効率的になる", "§7§o「グレインボー」")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§a§l105垓クッキー", "§7§lプリズムが§f§l2倍§7§l効率的になる", "§7§o「超純粋宇宙光」")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§a§l1秭500垓クッキー", "§7§lプリズムが§f§l2倍§7§l効率的になる", "§7§o「燐光」")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§a§l1050秭クッキー", "§7§lプリズムが§f§l2倍§7§l効率的になる", "§7§o「光のサンクトラム」")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§a§l105穰クッキー", "§7§lプリズムが§f§l2倍§7§l効率的になる", "§7§o「陰影反転」")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§a§l10溝5000穰クッキー", "§7§lプリズムが§f§l2倍§7§l効率的になる", "§7§o「水晶の鏡」")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§a§l1澗500溝クッキー", "§7§lプリズムが§f§l2倍§7§l効率的になる", "§7§o「逆光理論」")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§a§l1正500澗クッキー", "§7§lプリズムが§f§l2倍§7§l効率的になる", "§7§o「光の調達方法」")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§a§l1載500正クッキー", "§7§lプリズムが§f§l2倍§7§l効率的になる", "§7§o「光速制限」")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§a§l1極500載クッキー", "§7§lプリズムが§f§l2倍§7§l効率的になる", "§7§o「オッカムのレーザ」ー")),
            createItem(Material.BEACON, 0, "§e§lプリズムアップグレード", List.of("§a§l1恒河沙500極クッキー", "§7§lプリズムが§f§l2倍§7§l効率的になる", "§7§o「ハイパーブラック塗料」"))
    }, {
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§a§l260京クッキー", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる", "§7§o「あなたのラッキークッキー」")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§a§l1300京クッキー", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる", "§7§o「全てが水の泡になる魔法のコイン」")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§a§l1垓3000京クッキー", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる", "§7§o「抽選勝利チケット」")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§a§l130垓クッキー", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる", "§7§o「四葉のクローバー畑」")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§a§l1秭3000垓クッキー", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる", "§7§o「トリックに関する虎の巻」")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§a§l130秭クッキー", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる", "§7§o「レプラコーンの村」")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§a§l13穰クッキー", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる", "§7§o「不可能性駆動装置」")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§a§l1溝3000穰クッキー", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる", "§7§o「反迷信学」")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§a§l1300溝クッキー", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる", "§7§o「うさぎの足」")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§a§l130澗クッキー", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる", "§7§o「改定確率論」")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§a§l130正クッキー", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる", "§7§o「0面サイコロ」")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§a§l130載クッキー", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる", "§7§o「ちょっとした決定論」")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§a§l130極クッキー", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる", "§7§o「いい流れ」")),
            createItem(Material.BELL, 0, "§e§lチャンスメーカーアップグレード", List.of("§a§l130恒河沙クッキー", "§7§lチャンスメーカーが§f§l2倍§7§l効率的になる", "§7§o「ポジティブの最大化」"))
    }, {
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§a§l3100京クッキー", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる", "§7§o「メタなベーカリー」")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§a§l1垓5500京クッキー", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる", "§7§o「マンデルブラウンシュウガー」")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§a§l15垓5000京クッキー", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる", "§7§o「自己相似事実」")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§a§l1550垓クッキー", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる", "§7§o「入れ子型の宇宙説」")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§a§l15秭5000垓クッキー", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる", "§7§o「メンガーのスポンジケーキ」")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§a§l1550秭クッキー", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる", "§7§o「とある一際陽気な雌牛」")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§a§l155穰クッキー", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる", "§7§o「チョコレートウロボロス」")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§a§l15溝5000穰クッキー", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる", "§7§o「ネステッド」")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§a§l1澗5500溝クッキー", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる", "§7§o「空間充填繊維」")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§a§l1550澗クッキー", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる", "§7§o「巡り続ける読本」")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§a§l1550正クッキー", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる", "§7§o「全ての集合の集合」")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§a§l1550載クッキー", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる", "§7§o「このアップグレード」")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§a§l1550極クッキー", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる", "§7§o「函」")),
            createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジンアップグレード", List.of("§a§l1550恒河沙クッキー", "§7§l自己無限生成エンジンが§f§l2倍§7§l効率的になる", "§7§o「マルチスケール・プロファイリング」"))
    }, {
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§a§l71垓団l子", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる", "§7§o「猿でも分かるJavaコンソール」")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§a§l355垓クッキー", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる", "§7§o「64ビット配列」")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§a§l3550垓クッキー", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる", "§7§o「スタック・オーバーフロー」")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§a§l35秭5000垓クッキー", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる", "§7§o「企業向けコンパイラ」")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§a§l3550秭クッキー", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる", "§7§o「糖衣構文」")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§a§l35穰5000秭クッキー", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる", "§7§o「一杯のおいしいコーヒー」")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§a§l3溝5500穰クッキー", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる", "§7§o「その場でベーキング」")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§a§l3550溝クッキー", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる", "§7§o「クッキー++;」")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§a§l355澗クッキー", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる", "§7§o「ソフトウェア更新」")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§a§l35正5000澗クッキー", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる", "§7§o「Timer.perSecond();」")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§a§l35載5000正クッキー", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる", "§7§o「onClick(InventoryClickEvent event)」")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§a§l35極5000載クッキー", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる", "§7§o「あなたの一番のファン」")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§a§l35恒河沙5000極クッキー", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる", "§7§o「ハッカーの陰」")),
            createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソールアップグレード", List.of("§a§l35阿僧祇5000恒河沙クッキー", "§7§lJavaコンソールが§f§l2倍§7§l効率的になる", "§7§o「PHP捕獲用バット」"))
    }};

    public static void createInventory(Player player) {
        UUID uuid = player.getUniqueId();
        PlayData playData = Global.playData.get(uuid);
        Inventory inv = Bukkit.createInventory(null, 54, "§c§c§m§c§a§l現在の在庫 §2§l" + bigIntegerFormat(playData.stock) + "クッキー");

        TreeMap<BigInteger, ItemStack> upGrade = new TreeMap<>();
        if (playData.upGradeAmount[0] != 14 && playData.buildingAmount[0] >= unLockUpGradeCursorPrice[playData.upGradeAmount[0]]) upGrade.put(upGradeCursorPrice[playData.upGradeAmount[0]], itemUpGrade[0][playData.upGradeAmount[0]]);
        for (int i = 1; i <= 16; i++) {
            if (playData.upGradeAmount[i] == 14 || playData.buildingAmount[i] < unLockUpGradePrice[playData.upGradeAmount[i]]) continue;
            upGrade.put(buildingOriginalPrice[i].multiply(upGradeOriginalPrice[playData.upGradeAmount[i]]), itemUpGrade[i][playData.upGradeAmount[i]]);
        }
        ItemStack[] containUpGrade = upGrade.values().toArray(new ItemStack[17]);

        inv.setContents(new ItemStack[] {
            createItem(Material.ARROW, 0, "§e§lカーソル", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[0]) + "クッキー", "§f§l" + playData.buildingAmount[0] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[0]) + "§7§lクッキー生産", "§7§o「10秒毎に自動クリック」")),
            createItem(Material.PLAYER_HEAD, 0, "§e§lグランマ", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[1]) + "クッキー", "§f§l" + playData.buildingAmount[1] + "§7§lグランマが毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[1]) + "§7§lクッキー生産", "§7§o「クッキーを作ってくれる素敵なおばあちゃん」")),
            playData.buildingAmount[1] == 0 ? itemSpace : createItem(Material.WOODEN_HOE, 0, "§e§l農場", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[2]) + "クッキー", "§f§l" + playData.buildingAmount[2] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[2]) + "§7§lクッキー生産", "§7§o「クッキーの種からクッキーを育てます」")),
            playData.buildingAmount[2] == 0 ? itemSpace : createItem(Material.WOODEN_PICKAXE, 0, "§e§l採掘場", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[3]) + "クッキー", "§f§l" + playData.buildingAmount[3] + "§7§l採掘場が毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[3]) + "§7§lクッキー生産", "§7§o「クッキーの生地と串を掘り出します」")),
            playData.buildingAmount[3] == 0 ? itemSpace : createItem(Material.STONECUTTER, 0, "§e§l工場", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[4]) + "クッキー", "§f§l" + playData.buildingAmount[4] + "§7§l工場が毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[4]) + "§7§lクッキー生産", "§7§o「大量のクッキーを生産します」")),
            playData.buildingAmount[4] == 0 ? itemSpace : createItem(Material.LECTERN, 0, "§e§l銀行", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[5]) + "クッキー", "§f§l" + playData.buildingAmount[5] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[5]) + "§7§lクッキー生産", "§7§o「利子からクッキーを生み出します」")),
            playData.buildingAmount[5] == 0 ? itemSpace : createItem(Material.CANDLE, 0, "§e§l神殿", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[6]) + "クッキー", "§f§l" + playData.buildingAmount[6] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[6]) + "§7§lクッキー生産", "§7§o「貴重な古代クッキーの宝庫」")),
            playData.buildingAmount[6] == 0 ? itemSpace : createItem(Material.ENCHANTING_TABLE, 0, "§e§l魔法使いの塔", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[7]) + "クッキー", "§f§l" + playData.buildingAmount[7] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[7]) + "§7§lクッキー生産", "§7§o「魔法の呪文でクッキーを召喚します」")),
            playData.buildingAmount[7] == 0 ? itemSpace : createItem(Material.FIREWORK_ROCKET, 0, "§e§l宇宙船", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[8]) + "クッキー", "§f§l" + playData.buildingAmount[8] + "§7§l宇宙船が毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[8]) + "§7§lクッキー生産", "§7§o「異世界から新鮮なクッキーを輸送します」")),
            playData.buildingAmount[8] == 0 ? itemSpace : createItem(Material.BREWING_STAND, 0, "§e§l錬金術室", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[9]) + "クッキー", "§f§l" + playData.buildingAmount[9] + "§7§l錬金術ラボが毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[9]) + "§7§lクッキー生産", "§7§o「金をクッキーに変化させます」")),
            playData.buildingAmount[9] == 0 ? itemSpace : createItem(Material.END_PORTAL_FRAME, 0, "§e§lポータル", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[10]) + "クッキー", "§f§l" + playData.buildingAmount[10] + "§7§lポータルが毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[10]) + "§7§lクッキー生産", "§7§o「クッキー界に繋がる扉を開きます」")),
            playData.buildingAmount[10] == 0 ? itemSpace : createItem(Material.CLOCK, 0, "§e§lタイムマシン", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[11]) + "クッキー", "§f§l" + playData.buildingAmount[11] + "§7§lタイムマシンが毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[11]) + "§7§lクッキー生産", "§7§o「食べられる前のクッキーを過去から取り寄せます」")),
            playData.buildingAmount[11] == 0 ? itemSpace : createItem(Material.END_CRYSTAL, 0, "§e§l反物質凝縮器", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[12]) + "クッキー", "§f§l" + playData.buildingAmount[12] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[12]) + "§7§lクッキー生産", "§7§o「宇宙の反物質を圧縮しクッキーに変換します」")),
            playData.buildingAmount[12] == 0 ? itemSpace : createItem(Material.BEACON, 0, "§e§lプリズム", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[13]) + "クッキー", "§f§l" + playData.buildingAmount[13] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[13]) + "§7§lクッキー生産", "§7§o「光をクッキーに変換します」")),
            playData.buildingAmount[13] == 0 ? itemSpace : createItem(Material.BELL, 0, "§e§lチャンスメーカー", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[14]) + "クッキー", "§f§l" + playData.buildingAmount[14] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[14]) + "§7§lクッキー生産", "§7§o「無からクッキーが生まれる可能性を作ります」")),
            playData.buildingAmount[14] == 0 ? itemSpace : createItem(Material.SPAWNER, 0, "§e§l自己無限生成エンジン", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[15]) + "クッキー", "§f§l" + playData.buildingAmount[15] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[15]) + "§7§lクッキー生産", "§7§o「クッキーからさらに多くのクッキーを生成します」")),
            playData.buildingAmount[15] == 0 ? itemSpace : createItem(Material.COMMAND_BLOCK, 0, "§e§lJavaコンソール", List.of("§a§l" + bigIntegerFormat(playData.buildingPrice[16]) + "クッキー", "§f§l" + playData.buildingAmount[16] + "§7§lカーソルが毎秒§f§l" + bigIntegerFormat(playData.buildingCPS[16]) + "§7§lクッキー生産", "§7§o「このゲームを記述していることに他ならない" , "§7§oコードからクッキーを生み出します」")),
            createItem(Material.CHEST, 0, "§e§l現在の生産数", List.of("§f§l" + bigIntegerFormat(playData.CPS) + "§7§lクッキー／秒")),
            itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSpace, itemLoad, itemSpace, itemSeparate,
            createItem(Material.COOKIE, 0, "§e§lクリックで作る", List.of("§f§l" + bigIntegerFormat(playData.CPC) + "§7§lクッキー／クリック")),
            itemSeparate, itemSpace, itemSave, itemSpace, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate, itemSeparate,
            containUpGrade[8] == null ? itemSpace : containUpGrade[8],
            containUpGrade[7] == null ? itemSpace : containUpGrade[7],
            containUpGrade[6] == null ? itemSpace : containUpGrade[6],
            containUpGrade[5] == null ? itemSpace : containUpGrade[5],
            containUpGrade[4] == null ? itemSpace : containUpGrade[4],
            containUpGrade[3] == null ? itemSpace : containUpGrade[3],
            containUpGrade[2] == null ? itemSpace : containUpGrade[2],
            containUpGrade[1] == null ? itemSpace : containUpGrade[1],
            containUpGrade[0] == null ? itemSpace : containUpGrade[0]
        });
        player.openInventory(inv);
    }
}
