package org.example;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class TestMod extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!"openanvil".equals(label))
            return false;

        var human = (HumanEntity) sender;
        var anvil = Bukkit.createInventory(null, InventoryType.ANVIL, "Hello World");
        var tag = new ItemStack(Material.NAME_TAG, 1);
        anvil.setItem(0, tag);
        human.openInventory(anvil);

        return true;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getRawSlot() != 2 || event.getInventory().getType() != InventoryType.ANVIL)
            return;

        var item = event.getCurrentItem();
        Bukkit.broadcastMessage("Item is " + item);
        try {
            Bukkit.broadcastMessage("Name is " + item.getItemMeta().getDisplayName());
        } catch (NullPointerException npe) {
            Bukkit.broadcastMessage("Item or Meta was null");
        }
    }
}