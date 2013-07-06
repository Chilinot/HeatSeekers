/**
 *  Name:    Config.java
 *  Created: 00:25:30 - 6 jul 2013
 * 
 *  Author:  Lucas Arnström - LucasEmanuel @ Bukkit forums
 *  Contact: lucasarnstrom(at)gmail(dot)com
 *  
 *
 *  Copyright 2013 Lucas Arnström
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.
 *  
 *
 *
 *  Filedescription:
 *
 * 
 */

package me.lucasemanuel.heatseekers;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.plugin.java.JavaPlugin;

public class Config {
	public static void load(JavaPlugin plugin) {
		
		@SuppressWarnings("serial")
		HashMap<String, Object> defaults = new HashMap<String, Object>() {{
			put("auto-update", true);
			put("op-only", false);
			put("all-projectiles", false);
			put("craftingpermission", true);
			put("smart-percentage", 100);
		}};
		
		boolean save = false;
		
		for(Entry<String, Object> entry : defaults.entrySet()) {
			if(!plugin.getConfig().contains(entry.getKey())) {
				plugin.getConfig().set(entry.getKey(), entry.getValue());
				save = true;
			}
		}
		
		if(save) {
			plugin.saveConfig();
		}
	}
}
