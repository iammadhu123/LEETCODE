public class MostWater {
    public static int maxArea(int height[]){
        int maxWater = 0;
        int i = 0;
        int j = height.length-1;

        while (i<j) {
            int waterLevel = Math.min(height[i], height[j])*(j-i);
            maxWater = Math.max(maxWater, waterLevel);

            if (height[i]<height[j]) {
                i++;
            }else{
                j--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        System.out.println(maxArea(height));
    }
}
