package Leet.Greedy.种花;

public class leet605 {
    /*
     * 种花
     * https://leetcode-cn.com/problems/can-place-flowers/
     */
     public boolean canPlaceFlowers(int[] flowerbed, int n) {
         if(flowerbed.length>2) {
         int last = flowerbed.length - 1;
         if(flowerbed[0]==0&&flowerbed[1]==0){n--;}
         if(flowerbed[flowerbed.length-2]==0&&flowerbed[flowerbed.length-1]==0){n--;}
         for (int i = 1; i < flowerbed.length-3; i++) {
             if(flowerbed[i]==0&&flowerbed[i+1]==0&&flowerbed[i+2]==0){
                 n--;
                 i+=1;
             }
         }
     }
         if(flowerbed.length==1&&flowerbed[0]==0 || flowerbed.length==2&&flowerbed[0]==0 && flowerbed[1]==0){n--;}
         if(n<=0) return true;
         return false;
     }
}
