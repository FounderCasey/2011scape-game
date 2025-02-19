package gg.rsmod.plugins.content.npcs.definitions.demons

import gg.rsmod.game.model.combat.StyleType
import gg.rsmod.plugins.content.drops.DropTableFactory

val ids = intArrayOf(Npcs.IMP, Npcs.IMP_709)

val table = DropTableFactory
val imp = table.build {
    guaranteed {
        obj(Items.IMPIOUS_ASHES)
    }

    main {
        total(1024)
        obj(Items.BLACK_BEAD, slots = 40)
        obj(Items.RED_BEAD, slots = 40)
        obj(Items.WHITE_BEAD, slots = 40)
        obj(Items.YELLOW_BEAD, slots = 40)

        obj(Items.BRONZE_BOLTS, slots = 64)
        obj(Items.WIZARD_HAT, quantity = 1, slots = 64)

        obj(Items.EGG, slots = 47)
        obj(Items.RAW_CHICKEN, slots = 47)
        obj(Items.BURNT_BREAD, slots = 39)
        obj(Items.BURNT_MEAT, slots = 39)
        obj(Items.CABBAGE, slots = 16)
        obj(Items.BREAD_DOUGH, slots = 16)
        obj(Items.BREAD, slots = 8)
        obj(Items.COOKED_MEAT, slots = 8)


        obj(Items.HAMMER, slots = 47)
        obj(Items.TINDERBOX_590, slots = 64)
        obj(Items.SHEARS, slots = 39)
        obj(Items.BUCKET, slots = 32)
        obj(Items.BUCKET_OF_WATER, slots = 16)
        obj(Items.JUG, slots = 16)
        obj(Items.JUG_OF_WATER, slots = 16)
        obj(Items.EMPTY_POT, slots = 16)
        obj(Items.POT_OF_FLOUR, slots = 16)

        obj(Items.BALL_OF_WOOL, quantity = 1, slots = 47)
        obj(Items.MIND_TALISMAN, quantity = 1, slots = 55)
        obj(Items.ASHES, quantity = 1, slots = 48)
        obj(Items.CLAY, quantity = 1, slots = 32)
        obj(Items.CADAVA_BERRIES, quantity = 1, slots = 32)
        obj(Items.GRAIN, quantity = 1, slots = 24)
        obj(Items.CHEFS_HAT, quantity = 1, slots = 16)
    }
}

table.register(imp, *ids)

on_npc_pre_death(*ids) {
    val p = npc.damageMap.getMostDamage()!! as Player
    p.playSound(Sfx.IMP_DEATH)
}

on_npc_death(*ids) {
    table.getDrop(world, npc.damageMap.getMostDamage()!! as Player, npc.id, npc.tile)
}

ids.forEach {
    set_combat_def(it) {
        configs {
            attackSpeed = 4
            respawnDelay = 50
            attackStyle = StyleType.SLASH
        }
        stats {
            hitpoints = 80
            attack = 1
            strength = 1
            defence = 1
            magic = 1
            ranged = 1
        }
        bonuses {
            attackStab = -42
            attackCrush = -37
            defenceStab = -42
            defenceSlash = -42
            defenceCrush = -42
            defenceMagic = -42
            defenceRanged = -42
        }
        anims {
            attack = 169
            death = 172
            block = 170
        }
    }
}