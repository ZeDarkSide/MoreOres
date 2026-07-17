package net.darkside.moreore.item;

import net.darkside.moreore.util.ModTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum ModToolMaterials implements ToolMaterial {
    VENOM_TOOLS(2, 250, 5.0F, 4.0F, 22, ModTags.Items.VENOM_REPAIR),
    SHADOW_TOOLS(3, 1650, 7.0F, 4.0F, 8, ModTags.Items.SHADOW_REPAIR),
    EMBERSTONE_TOOLS(3, 1800, 8.0F, 3.0F, 10, ModTags.Items.EMBERSTONE_REPAIR);

    private final int miningLevel;
    private final int durability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final net.minecraft.registry.tag.TagKey<net.minecraft.item.Item> repairItems;

    ModToolMaterials(int miningLevel, int durability, float miningSpeed, float attackDamage, int enchantability,
                      net.minecraft.registry.tag.TagKey<net.minecraft.item.Item> repairItems) {
        this.miningLevel = miningLevel;
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairItems = repairItems;
    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return miningLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.fromTag(repairItems);
    }
}
