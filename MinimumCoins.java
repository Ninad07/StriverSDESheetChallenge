public class Solution
{
public static int findMinimumCoins(int amount)
    {
        int coins = 0;
        while(amount > 0) {
            if(amount >= 1000) {
                coins += amount / 1000;
                amount %= 1000;
            } else if(amount >= 500) {
                coins += amount / 500;
                amount %= 500;
            } else if(amount >= 100) {
                coins += amount / 100;
                amount %= 100;
            } else if(amount >= 50) {
                coins += amount / 50;
                amount %= 50;
            } else if(amount >= 20) {
                coins += amount / 20;
                amount %= 20;
            } else if(amount >= 10) {
                coins += amount / 10;
                amount %= 10;
            } else if(amount >= 5) {
                coins += amount / 5;
                amount %= 5;
            } else if(amount >= 2) {
                coins += amount / 2;
                amount %= 2;
            } else {
                coins++;
                amount--;
            }
        }
    
        return coins;
    }
}
