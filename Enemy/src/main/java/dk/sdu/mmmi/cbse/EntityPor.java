package dk.sdu.mmmi.cbse;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class EntityPor implements IEntityProcessingService {
    public void process(GameData gameData, World world) {
        System.out.println("Hello, I am a split package from Enemy");
    }

}
