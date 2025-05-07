package io.github.finaltriswitch.untils;

public class Utils {
    public static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }

    public static boolean isColliding(float x1, float y1, float w1, float h1, float x2, float y2, float w2, float h2) {
        return x1 < x2 + w2 && x1 + w1 > x2 && y1 < y2 + h2 && y1 + h1 > y2;
    }
}
