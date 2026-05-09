package mindustry.world.meta;

import arc.func.*;
import mindustry.*;
import mindustry.content.*;

public class BuildVisibility{
    public static final BuildVisibility

    hidden = new BuildVisibility(() -> false),
    shown = new BuildVisibility(() -> true),
    debugOnly = new BuildVisibility(() -> false),
    editorOnly = new BuildVisibility(() -> Vars.world.state.rules.editor),
    coreZoneOnly = new BuildVisibility(() -> Vars.indexer.isBlockPresent(Blocks.coreZone) || !Vars.world.state.isGame()),
    worldProcessorOnly = new BuildVisibility(() -> Vars.world.state.rules.editor || Vars.world.state.rules.allowEditWorldProcessors),
    sandboxOnly = new BuildVisibility(() -> Vars.world.state == null || Vars.world.state.rules.infiniteResources),
    campaignOnly = new BuildVisibility(() -> Vars.world.state == null || Vars.world.state.isCampaign() || !Vars.world.state.isGame()),
    legacyLaunchPadOnly = new BuildVisibility(() -> (Vars.world.state == null || Vars.world.state.isCampaign() && Vars.world.state.getPlanet().campaignRules.legacyLaunchPads) && Blocks.advancedLaunchPad != null && Blocks.advancedLaunchPad.unlocked()),
    notLegacyLaunchPadOnly = new BuildVisibility(() -> (Vars.world.state == null || !Vars.world.state.isGame() || Vars.world.state.rules.infiniteResources || Vars.world.state.isCampaign() && !Vars.world.state.getPlanet().campaignRules.legacyLaunchPads)),
    lightingOnly = new BuildVisibility(() -> Vars.world.state == null || Vars.world.state.rules.lighting || Vars.world.state.isCampaign() || !Vars.world.state.isGame() || Vars.world.state.rules.infiniteResources),
    fogOnly = new BuildVisibility(() -> Vars.world.state == null || Vars.world.state.rules.fog || Vars.world.state.rules.editor || !Vars.world.state.isGame());

    private final Boolp visible;

    public boolean visible(){
        return visible.get();
    }

    public BuildVisibility(Boolp visible){
        this.visible = visible;
    }
}
