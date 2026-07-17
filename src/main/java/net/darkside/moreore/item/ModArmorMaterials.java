package net.darkside.moreore.item;

/*
======================================================================
 HOW TO ADD A NEW ARMOR MATERIAL (net.minecraft.item.equipment.ArmorMaterial)
======================================================================
 ArmorMaterial is a record with these fields:

   ArmorMaterial(
       int durability,                          // base value, see multipliers below
       Map<EquipmentType, Integer> defense,      // defense points per piece
       int enchantmentValue,
       RegistryEntry<SoundEvent> equipSound,      // e.g. SoundEvents.ITEM_ARMOR_EQUIP_IRON
       float toughness,
       float knockbackResistance,
       TagKey<Item> repairIngredient,             // remember to populate this tag in ModItemTagProvider!
       RegistryKey<EquipmentAsset> assetId        // "how it looks worn" - see below
   )

 Durability multiplier per piece (base value above x this number):
   Helmet x11, Chestplate x16, Leggings x15, Boots x13

 Example (matches ModToolMaterials' VENOM_TOOLS/SHADOW_TOOLS naming pattern):

   public static final RegistryKey<EquipmentAsset> EXAMPLE_ASSET =
           RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(MoreOre.MOD_ID, "example"));

   public static final ArmorMaterial EXAMPLE_ARMOR = new ArmorMaterial(
           15, // durability multiplier
           Util.make(new EnumMap<>(EquipmentType.class), map -> {
               map.put(EquipmentType.HELMET, 2);
               map.put(EquipmentType.CHESTPLATE, 6);
               map.put(EquipmentType.LEGGINGS, 5);
               map.put(EquipmentType.BOOTS, 2);
           }),
           22,
           SoundEvents.ITEM_ARMOR_EQUIP_IRON,
           0.0F,
           0.0F,
           ModTags.Items.EXAMPLE_REPAIR,
           EXAMPLE_ASSET
   );

 Wiring an ArmorMaterial up into working armor also needs:
   1. ModItems.java     - registerItem("example_helmet", s -> new ArmorItem(EXAMPLE_ARMOR, EquipmentType.HELMET, s)), etc. for CHESTPLATE/LEGGINGS/BOOTS
   2. ItemGroups.java    - entries.add(...) for each new item
   3. ModItemTagProvider - populate the repair tag, plus vanilla ItemTags.HEAD_ARMOR/CHEST_ARMOR/LEG_ARMOR/FOOT_ARMOR
                           and ItemTags.*_ARMOR_ENCHANTABLE / ARMOR_ENCHANTABLE so enchants like Protection apply
   4. ModModelProvider   - itemModelGenerator.register(item, Models.GENERATED) for the item icon
   5. A datagen provider that writes assets/moreore/equipment/example.json, e.g.:

        EquipmentModel.builder().addHumanoidLayers(Identifier.of(MoreOre.MOD_ID, "example")).build()

      via DataProvider.writeAllToPath(writer, EquipmentModel.CODEC, resolver::resolveJson, map)
      (mirrors vanilla's net.minecraft.client.data.EquipmentAssetProvider), registered in
      MoreOreDataGenerator alongside the other providers.
   6. Textures (hand-authored, not datagen'd):
        assets/moreore/textures/item/example_helmet.png (and chestplate/leggings/boots, 16x16 icons)
        assets/moreore/textures/entity/equipment/humanoid/example.png (64x32, worn layer - helmet/chest/boots)
        assets/moreore/textures/entity/equipment/humanoid_leggings/example.png (64x32, worn layer - leggings)
======================================================================


======================================================================
 VANILLA ARMOR MATERIALS REFERENCE (net.minecraft.item.equipment.ArmorMaterials)
======================================================================
 Defense points per piece — Helmet / Chestplate / Leggings / Boots

LEATHER
  Defense:  1 / 3 / 2 / 1
  Durability base: 5
  Enchantability: 15
  Toughness: 0.0
  Knockback Resistance: 0.0

CHAINMAIL
  Defense:  2 / 5 / 4 / 1
  Durability base: 15
  Enchantability: 12
  Toughness: 0.0
  Knockback Resistance: 0.0

IRON
  Defense:  2 / 6 / 5 / 2
  Durability base: 15
  Enchantability: 9
  Toughness: 0.0
  Knockback Resistance: 0.0

GOLD
  Defense:  2 / 5 / 3 / 1
  Durability base: 7
  Enchantability: 25
  Toughness: 0.0
  Knockback Resistance: 0.0

DIAMOND
  Defense:  3 / 8 / 6 / 3
  Durability base: 33
  Enchantability: 10
  Toughness: 2.0
  Knockback Resistance: 0.0

NETHERITE
  Defense:  3 / 8 / 6 / 3
  Durability base: 37
  Enchantability: 15
  Toughness: 3.0
  Knockback Resistance: 0.1

TURTLE_SCUTE (helmet only)
  Defense:  2 / 6 / 5 / 2
  Durability base: 25
  Enchantability: 9
  Toughness: 0.0
  Knockback Resistance: 0.0

======================================================================
*/

public class ModArmorMaterials {
}
