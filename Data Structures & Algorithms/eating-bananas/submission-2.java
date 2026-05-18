class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int lowSpeed = 1;
        int maxSpeed = piles[piles.length-1];
        int k=0;

        while(lowSpeed <= maxSpeed) {
            int midSpeed = lowSpeed + (maxSpeed - lowSpeed)/2;

            long time = 0;
            for(int i=0; i<piles.length; i++) {
                time += piles[i] / midSpeed;
                if(piles[i] % midSpeed != 0)
                    time++;
            }

            if(time <= h) {
                k = midSpeed;
                maxSpeed = midSpeed - 1;
            }
            else
                lowSpeed = midSpeed + 1;
        }
        return k;
    }
}
