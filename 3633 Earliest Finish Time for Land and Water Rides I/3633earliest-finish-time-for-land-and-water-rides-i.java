class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        int minLandFinish = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            minLandFinish = Math.min(minLandFinish, landStartTime[i] + landDuration[i]);
        }
        int minWaterFinish = Integer.MAX_VALUE;
        for (int j = 0; j < waterStartTime.length; j++) {
            minWaterFinish = Math.min(minWaterFinish, waterStartTime[j] + waterDuration[j]);
        }
        int ans = Integer.MAX_VALUE;
        // Land ->Water
        for (int j = 0; j < waterStartTime.length; j++) {
            int waterStart = Math.max(minLandFinish, waterStartTime[j]);
            int waterFinish = waterStart + waterDuration[j];
            ans = Math.min(ans, waterFinish);
        }
        // Water->land
        for (int i = 0; i < landStartTime.length; i++) {
            int landStart = Math.max(minWaterFinish, landStartTime[i]);
            int landFinish = landStart + landDuration[i];
            ans = Math.min(ans, landFinish);
        }

        return ans;
    }
}
