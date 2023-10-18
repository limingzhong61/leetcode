package exam.old.hengsheng.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static HQStockSnapshot beforeX = null;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String head = in.next();

        System.out.println("data_timestamp,open_px,high_px,low_px,close_px,business_count,business_amount,business_balance");
        String ans_open_px = null, ans_clos_px = null;
        ArrayList<HQStockSnapshot> list = new ArrayList<>();

        while (in.hasNextInt()) {
            String s = in.next();
            String[] split = s.split(",");
            list.add(new HQStockSnapshot(split));
        }
        final int min_unit = 1_00_000;

        for (int startDataTimeStamp = 9_30_00_000; startDataTimeStamp <= 11_30_00_000; startDataTimeStamp += min_unit) {
            int endDataTimeStamp = startDataTimeStamp += min_unit;
            klineAggr1Minute(list, startDataTimeStamp, endDataTimeStamp);
        }


    }

    private static void klineAggr1Minute(ArrayList<HQStockSnapshot> list, int startDataTimeStamp, int endDataTimeStamp) {
        Double open_px = null;
        Double close_px = null;
        double high_px = Double.MIN_VALUE;
        double low_px = Double.MAX_VALUE;
        int maxDataTimeStamp = Integer.MIN_VALUE;
        HQStockSnapshot lastX = null;
        for (HQStockSnapshot x : list) {
            if (x.data_timestamp >= startDataTimeStamp && x.data_timestamp <= endDataTimeStamp) {
                if (open_px == null) {
                    open_px = x.last_px;
                }
                close_px = x.last_px;
                high_px = Math.max(x.last_px, high_px);
                low_px = Math.max(x.last_px, low_px);
                maxDataTimeStamp = Math.max(x.data_timestamp, maxDataTimeStamp);

                lastX = x;
            }
        }
        if(maxDataTimeStamp == Integer.MAX_VALUE) return;
        if (beforeX != null) {
            System.out.printf("%d,%.2f,%.2f,%.2f,%.2f,%d,%d,%.2f\n",
                    maxDataTimeStamp, open_px, high_px, low_px, close_px,
                    lastX.business_amount - beforeX.business_amount, lastX.business_amount - beforeX.business_amount,
                    lastX.business_balance - beforeX.business_balance);
        } else {

            System.out.printf("%d,%.2f,%.2f,%.2f,%.2f,%d,%d,%.2f\n",
                    maxDataTimeStamp, open_px, high_px, low_px, close_px,
                    lastX.business_amount, lastX.business_amount,
                    lastX.business_balance);
        }
        beforeX = lastX;
    }

    static void klineAggr1Minute(List<HQStockSnapshot> datas) {

    }
}


class HQStockSnapshot {
    String finance_mic, prod_code, trade_date, preclose_px, open_px,
            high_px, low_px, close_px;
    int data_timestamp;
    long business_amount;
    long business_count;
    double business_balance;
    Double last_px;

    HQStockSnapshot(String[] split) {
        int idx = 0;
        finance_mic = split[idx++];
        prod_code = split[idx++];
        trade_date = split[idx++];
        data_timestamp = Integer.parseInt(split[idx++]);
        preclose_px = split[idx++];
        open_px = split[idx++];
        last_px = Double.valueOf(split[idx++]);
        high_px = split[idx++];
        low_px = split[idx++];
        close_px = split[idx++];
        business_count = Long.parseLong(split[idx++]);
        business_amount = Long.parseLong(split[idx++]);
        business_balance = Double.parseDouble(split[idx++]);
    }
}