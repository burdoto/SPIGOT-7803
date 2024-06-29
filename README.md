# Minimal reproduction Plugin for [SPIGOT-7803](https://hub.spigotmc.org/jira/browse/SPIGOT-7803)
Affects Minecraft 1.20.1, but `api-version=1.18` is known to also be faulty

## How to use
- Run `run.sh` to build plugin & start test server with default configuration
- - Every InventoryClickEvent will broadcast minimal debug information
- Join the server
- Put yourself into creative mode
- Place a normal anvil
- - Rename something
- - It works with a normal anvil
- Use command `/openanvil` to open a virtual anvil inventory
- - Renaming will now yield `null` for `InventoryClickEvent#getCurrentItem()` when targetting the anvil result slot
