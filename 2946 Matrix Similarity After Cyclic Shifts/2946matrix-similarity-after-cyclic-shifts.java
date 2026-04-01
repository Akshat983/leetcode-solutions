class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int[][] matcpy = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++) {
            matcpy[i] = Arrays.copyOf(mat[i], mat[0].length);
        }
        k = k % mat[0].length;
        for(int i = 0; i < mat.length; i++) {
            int[] abc = new int[mat[0].length];
            for(int j = 0; j < mat[0].length; j++) {
                if(i%2 == 0) {
                    int ka = j-k;
                    if(ka >= 0) {
                        abc[ka] = mat[i][j];
                    }
                    else {
                        abc[mat[0].length+ka] = mat[i][j];
                    }
                }
                else {
                    int ka = j+k;
                    if(ka < mat[0].length) {
                        abc[ka] = mat[i][j];
                    }
                    else {
                        abc[ka-mat[0].length] = mat[i][j];
                    }
                }
            }
            mat[i] = Arrays.copyOf(abc, abc.length);

        }

        for(int i = 0; i < mat.length; i ++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(matcpy[i][j] != mat[i][j]) return false;
            }
        }
        return true;
    }
}