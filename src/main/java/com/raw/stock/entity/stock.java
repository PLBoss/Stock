package com.raw.stock.entity;


public class stock {

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    private String dateTime;


    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    private double open;

    private  double high;

    private  double low;

    private  double close;


    public stock(String date_time, double open, double high, double low, double close) {
        this.dateTime = date_time;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    @Override
    public String toString() {
        return "stock{" +
                "dateTime='" + dateTime + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                '}';
    }
}
