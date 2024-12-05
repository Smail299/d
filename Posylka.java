package com.example.fichaposylka;

import org.bukkit.Location;

public class Posylka {
    private final Location location;
    private final String rarity;
    private int durability;
    private final long spawnTime;

    public Posylka(Location location, String rarity) {
        this.location = location;
        this.rarity = rarity;
        this.spawnTime = System.currentTimeMillis();
        switch (rarity) {
            case "epic":
                this.durability = 3500;
                break;
            case "legendary":
                this.durability = 500;
                break;
            default:
                this.durability = 2500;
        }
    }

    public Location getLocation() {
        return location;
    }

    public String getRarity() {
        return rarity;
    }

    public int getDurability() {
        return durability;
    }

    public boolean isBreakable() {
        return System.currentTimeMillis() - spawnTime >= 300000; // 5 минут
    }

    public void reduceDurability() {
        durability--;
        // Здесь добавить код для проверки наград и прочности
    }

    public long getRemainingTime() {
        long remainingTime = 300000 - (System.currentTimeMillis() - spawnTime);
        return Math.max(remainingTime / 1000, 0);
    }
}
