package io.github.uttmangosteen.cookieclickermc;

import java.math.BigInteger;

public class PlayerData {
    //CPS: cookie per second
    //CPC: cookie per click
    public BigInteger stock, CPS, CPC;
    public BigInteger[] buildingPrice, buildingCPS;
    public int[] buildingAmount, upGradeAmount;
    public PlayerData(BigInteger stock, BigInteger CPS, BigInteger CPC, BigInteger[] buildingPrice, BigInteger[] buildingCPS, int[] buildingAmount, int[] upGradeAmount) {
        this.stock = stock;
        this.CPS = CPS;
        this.CPC = CPC;
        this.buildingPrice = buildingPrice;
        this.buildingCPS = buildingCPS;
        this.buildingAmount = buildingAmount;
        this.upGradeAmount = upGradeAmount;
    }
}