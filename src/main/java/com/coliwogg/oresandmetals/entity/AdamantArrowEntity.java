package com.coliwogg.oresandmetals.entity;

import com.coliwogg.oresandmetals.init.EntityInit;
import com.coliwogg.oresandmetals.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class AdamantArrowEntity extends AbstractArrowEntity {

    private final Item referenceItem;

    public AdamantArrowEntity(EntityType<?> type, World world) {
        super((EntityType<? extends AbstractArrowEntity>) type, world);
        this.referenceItem = ItemInit.ADAMANT_ARROW.get();
    }

    public AdamantArrowEntity(Item referenceItemIn, LivingEntity shooter, World world) {
        super(EntityInit.ADAMANT_ARROW.get(), shooter, world);
        this.referenceItem = referenceItemIn;
    }

    @Override
    public ItemStack getArrowStack() {
        return new ItemStack(this.referenceItem);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
