package com.coliwogg.oresandmetals.objects.items;

import com.coliwogg.oresandmetals.entity.IronArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

public class IronArrow extends ArrowItem {

    public final float damage;

    private RegistryObject<Item> reference;

    public IronArrow(Properties properties, float damageIn) {
        super(properties);
        this.damage = damageIn;
    }

    public IronArrow setItemReference(RegistryObject<Item> referenceIn) {
        this.reference = referenceIn;
        return this;
    }

    @Override
    public IronArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        IronArrowEntity arrowEntity = new IronArrowEntity(reference.get(), shooter, worldIn);
        arrowEntity.setDamage(this.damage);
        return arrowEntity;
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : this instanceof ArrowItem;
    }
}
