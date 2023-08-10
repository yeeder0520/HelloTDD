package kata;

import java.text.DecimalFormat;

/**
 * @author YeeDer
 * @since 2023/8/10 PM 12:01
 **/
public class DecimalTimeConversion {

    public static final DecimalFormat MINUTES = new DecimalFormat("00");
    public static String toNormal(double time) {
        int integerPart = (int) time; // 獲取小數點前面的整數部分
        return integerPart + ":" + MINUTES.format(Math.round(time % 1 * 60)); //先取餘數 → 轉換分鐘數 → 四捨五入
    }

    public static double toIndustrial(String time) {
        String[] split = time.split(":");
        int integerPart = Integer.parseInt(split[0]);
        double fractionalPart = Double.parseDouble(split[1]);
        double originalValue = fractionalPart / 60;
        long roundedValue = Math.round(originalValue * 100); // 將小數移到整數部分並*100
        return integerPart + (double) roundedValue / 100;// 將結果轉回小數
    }

    public static double toIndustrial(int time) {
        double originalValue = (double) time / 60;
        long roundedValue = Math.round(originalValue * 100); // 將小數移到整數部分並*100
        return (double) roundedValue / 100;
    }
}
