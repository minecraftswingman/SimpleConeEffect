package com.plugin.particles.particlesdesign;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public final class ConeClass extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    public double sec(double number) {
        return 1 / Math.cos(number);
    }


    @EventHandler
    public void CreateShape(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR) System.out.println("Right click");

        if (e.getAction() == Action.LEFT_CLICK_AIR) {
            System.out.println("Debug");
            Location loc = e.getPlayer().getLocation();

            double Radius;
            for (double t = 0; t <= 1; t += 0.1) {
                // layered circle
                for (double angle = 0; angle <= Math.PI*2; angle+= Math.PI/8)  {
                    double x = Math.cos(angle) * t;
                    double y = t;
                    double z = Math.sin(angle) * t;
                    loc.add(x, y, z);
                    e.getPlayer().spawnParticle(Particle.FLAME, loc, 1, 0, 0, 0, 0);
                    loc.subtract(x ,y, z);
                    // final circle
                    for (Radius = 1; Radius >= 0; Radius -= 0.1) {
                        double x2 = Math.cos(angle) * Radius;
                        double y2 = 1;
                        double z2 = Math.sin(angle) * Radius;
                        loc.add(x2, y2, z2);
                        e.getPlayer().spawnParticle(Particle.FLAME, loc, 1, 0, 0, 0, 0);
                        loc.subtract(x2, y2, z2);
                    }

                }
            }



        }

    }
}




