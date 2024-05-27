package io.github.uttmangosteen.cookieclickermc;

import java.math.BigInteger;

public class PlayData {
    //CPS: cookie per second
    //CPC: cookie per click
    public BigInteger stock, CPS, CPC;
    public BigInteger[] buildingPrice, buildingCPS;
    public int[] buildingAmount, upGradeAmount;
    public PlayData(BigInteger stock, int[] buildingAmount, int[] upGradeAmount, BigInteger CPS, BigInteger CPC, BigInteger[] buildingPrice, BigInteger[] buildingCPS) {
        this.stock = stock;
        this.CPS = CPS;
        this.CPC = CPC;
        this.buildingPrice = buildingPrice;
        this.buildingCPS = buildingCPS;
        this.buildingAmount = buildingAmount;
        this.upGradeAmount = upGradeAmount;
    }
}