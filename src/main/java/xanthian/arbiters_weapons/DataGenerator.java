package xanthian.arbiters_weapons;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import xanthian.arbiters_weapons.datagen.ItemTagGenerator;
import xanthian.arbiters_weapons.datagen.RecipeGenerator;

public class DataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(RecipeGenerator::new);
        pack.addProvider(ItemTagGenerator::new);
    }
}