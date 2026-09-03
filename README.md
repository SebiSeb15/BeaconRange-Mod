# BeaconRangeMod
<p align="center">
  <a href="#BeaconRange-Mod"><img src="https://img.shields.io/badge/MC-26.1.1-brightgreen.svg" alt="Minecraft Version"/></a>
  <a href="#BeaconRange-Mod"><img src="https://img.shields.io/badge/MC-26.2-brightgreen.svg" alt="Minecraft Version"/></a>
</p>
BeaconRangeMod est un mod qui comme mo plugin Paper/Spigot, permet d’ajuster le rayon d’effet des balises (beacons) selon leur niveau (tier).

### Fonctionnalités
- Définir un rayon d’effet personnalisé pour chaque niveau de balise (Tier 1 à 4)
- Fichier de configuration persistant

### Configuration
Le fichier beaconrange.json qui se trouve dans le dosier config de votre instance/server contient les rayons par niveau:

```
{
  "level1": 30,
  "level2": 50,
  "level3": 70,
  "level4": 100
}
```

- Tier1..Tier4 correspondent aux niveaux de la balise.
- La valeur est le rayon d’effet en blocs.
