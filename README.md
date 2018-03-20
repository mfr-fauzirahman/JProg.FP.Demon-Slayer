# JProg.FP.Demon-Slayer

A text-based RPG game based on JAVA.

Agung Cahya Gumilar, Muhammad Fauzi Rahman, Siti Bati'ah Balqis.

Computer Science Dept., Universitas Pendidikan Indonesia.

Based from RyiSnow's text-based JAVA game which can be accessed here:
http://ryisnow.net/2017/04/30/a-beginners-text-adventure-game-creation-in-java/

Modified to increase playability and challenges with the following changes: 
- Modified story and theme (also a little bit sense of humor in the good ending).
- Added a rare weapon "Lost Sword".
- Added unique weapon "Soul Eater" which originated from RF Online's Sword Relic.
- Added bad ending (triggered by using Soul Eater until player's HP reach 0).
- Monster now 3 (Demon, Huge demon, Bandit).
- Dungeon now summon Demon or Huge demon on every player visits.
- Forest now gives a tier 2 weapon, then summons Bandit or gives you a chance to acquire tier-3 "Lost Sword" weapon directly.
- River now heals for full HP.
- Demon can drop tier-4 legendary Soul Eater weapon (chance-based).
- Huge demon can drop Demon's heart (key item for good ending).
- Bandit can drop a tier-3 weapon.
- Max HP and current HP is now defined randomly everytime the game starts.
- Recalculated DMG & HP formula (also Soul Eater can consumes the player's HP).
- Customized battle initiation (each enemy have their own rate to enable 'Run' command).
- Customized battle method (every battle step have a chance to disable 'Run' command).

Issues:
- The game (may) not have all exceptions handled.
- The games (may) seems unfair (because of its randomness).
- You cannot trust the character and his/her weapon at all.

Configuring the game:
- Change each IF parameter of 'getItem' variable in World.win() method to change the trigger chance of each events.
- 3 type of events (Soul Eater drop chance, Demon's heart drop chance, Lost Sword drop chance).
