package com.amatta;

public class Auction {
    // 경매소 최저가
    private Integer lowestPrice;

    // 손익분기점
    private Integer breakEventPoint;

    // 선점입찰가
    private Integer occupation;

    // 수익금
    private Integer benefit;

    // 분배금
    private Integer dividend;


    public Auction(Integer memberCount, Integer lowestPrice) {
        this.lowestPrice = lowestPrice;
        double sell = (double)(lowestPrice) * 95 / 100;
        double memberBenefit = sell / memberCount;
        double breakEventPoint = memberBenefit * (memberCount - 1);
        double occupation = breakEventPoint * 10 / 11;

        this.breakEventPoint = (int) Math.floor(breakEventPoint);
        this.occupation = (int) Math.floor(occupation);
        this.benefit = (int) Math.floor(sell - this.occupation);
        this.dividend = (int) Math.floor(occupation / (memberCount - 1));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("손익분기점: %sG\r\n", this.breakEventPoint));
        sb.append(String.format("선점입찰가: %sG\r\n", this.occupation));
        sb.append(String.format("수익금: %sG\r\n", this.benefit));
        sb.append(String.format("분배금: %sG", this.dividend));
        return sb.toString();
    }
}
