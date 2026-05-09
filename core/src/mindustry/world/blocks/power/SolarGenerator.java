package mindustry.world.blocks.power;

import arc.math.*;
import arc.struct.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class SolarGenerator extends PowerGenerator{

    public SolarGenerator(String name){
        super(name);
        //remove the BlockFlag.generator flag to make this a lower priority target than other generators.
        flags = EnumSet.of();
        envEnabled = Env.any;
    }

    @Override
    public void setStats(){
        super.setStats();
        stats.remove(generationType);
        stats.add(generationType, powerProduction * 60.0f, StatUnit.powerSecond);
    }

    public class SolarGeneratorBuild extends GeneratorBuild{
        @Override
        public void updateTile(){
            productionEfficiency = enabled ?
                world.state.rules.solarMultiplier * Mathf.maxZero(Attribute.light.env() +
                    (world.state.rules.lighting ?
                        1f - world.state.rules.ambientLight.a :
                        1f
                    )) : 0f;
        }
    }
}
