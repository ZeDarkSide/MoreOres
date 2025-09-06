package net.darkside.moreore.util;

import net.darkside.moreore.MoreOre;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_VENOM_TOOLS = createTag("needs_venom_tools");
        public static final TagKey<Block> WRONG_NEEDS_VENOM_TOOLS = createTag("wrong_needs_venom_tools");
        public static final TagKey<Block> NEEDS_SHADOW_TOOLS = createTag("needs_shadow_tools");
        public static final TagKey<Block> WRONG_NEEDS_SHADOW_TOOLS = createTag("wrong_needs_shadow_tools");
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MoreOre.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> VENOM_REPAIR        = createTag("venom_repair");
        public static final TagKey<Item> SHADOW_REPAIR        = createTag("shadow_repair");
        public static final TagKey<Item> VENOM_TOOLS         = createTag("venom_tools");
        public static final TagKey<Item> SHADOW_TOOLS         = createTag("shadow_tools");
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MoreOre.MOD_ID, name));
        }
    }
}
