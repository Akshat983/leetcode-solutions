class Robot {
    public int w, h, p;
    public int s = 0;
    public boolean m = false;

    public Robot(int width, int height) {
        this.w = width;
        this.h = height;
        this.p = 2 * (w + h - 2);
    }

    public void step(int n) {
        m = true;
        s = (s + n) % p;
        if (s == 0) s = p;
    }

    public int[] getPos() {
        if (s < w) 
            return new int[]{s, 0};
        if (s < w + h - 1) 
            return new int[]{w - 1, s - w + 1};
        if (s < 2 * w + h - 2) 
            return new int[]{w - 1 - (s - (w + h - 2)), h - 1};
        
        return new int[]{0, h - 1 - (s - (2 * w + h - 3))};
    }

    public String getDir() {
        if (!m || s == 0) return "East";
        if (s < w) return "East";
        if (s < w + h - 1) return "North";
        if (s < 2 * w + h - 2) return "West";
        return "South";
    }
}