package com.coliwogg.oresandmetals.init;

import com.coliwogg.oresandmetals.OresandMetals;
import com.coliwogg.oresandmetals.OresandMetals.OresandMetalsItemGroup;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(OresandMetals.MODID)
@Mod.EventBusSubscriber(modid=OresandMetals.MODID, bus=Bus.MOD)
public class ItemInit {
	
	public static final Item BRONZE_INGOT = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new Item(new Item.Properties().group(OresandMetalsItemGroup.instance)).setRegistryName("bronze_ingot"));
	}
}
