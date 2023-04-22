package io.github.uttmangosteen.cookieclickermc;

import java.math.BigInteger;

public class PlayerData {
    public BigInteger stock, CPS, CPC;
    public BigInteger[] priceBuilding, CPSBuilding;
    public int[] amountBuilding, powerBuilding;
    public PlayerData(BigInteger stock, BigInteger CPS, BigInteger CPC, BigInteger[] priceBuilding, BigInteger[] CPSBuilding, int[] amountBuilding, int[] powerBuilding) {
        this.stock = stock;
        this.CPS = CPS;
        this.CPC = CPC;
        this.priceBuilding = priceBuilding;
        this.CPSBuilding = CPSBuilding;
        this.amountBuilding = amountBuilding;
        this.powerBuilding = powerBuilding;
    }
}