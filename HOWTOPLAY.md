Overview
-----
It is a turn-based strategy game currently involving 2 players (I'm gonna take a stab at AI and/or putting it online later).

Each player starts with 1 "portal" (I'm working really hard to find terms here that don't sound incredibly nerdy, but there aren't any)
The goal of each player is to destroy the opponent's "portal"

This "portal" can "summon"/"teleport" "creatures"/"aliens" which can move and attack

You and your opponent's "portal" and "creatures"/"aliens" are currently indistinguishable (I should probably fix that)





Main Picture
-----
Red Circle:   Ignore these. They are left over from debugging. They were very helpful. I disabled them, but still need to make them invisible
Blue Circle:  Press this to end the current player's turn
Green Circle: This contains 2 progress bars. The top one is health, and the bottom one is energy. For portals, energy limits the number of "summons"/"teleports" per turn.  For "aliens," energy limits the number of tiles that an "alien" can move
Label 1:      This points to the "portal"
Label 2:      This points to the "alien"/"creature"

Features that are definitely not bugs:
- when the portal runs out of energy, a selected purple tile will just deselect itself
- when an alien runs out of energy, a selected yellow tile will just deselect itself

![alt text](https://raw.githubusercontent.com/abbott221/WebsiteAndApp/master/pictures_display/4_3_main.png "Main Picture")



"Alien" Picture / Tile selection
-----
When you press the tile that an "alien"/"creature" is standing on, it is highlighted (in blue)

Label 1:      Red Tiles indicate the occupant on that tile can be attacked (because it belongs to the opponent).
Label 2:      Blue Tiles indicate that a tile and its occupant has been selected by the user
Label 3:      Yellow Yiles indicate tiles that the selected occupant can move to

Features that are definitely not bugs:
- you can't attack your own "aliens"/"creatures"
- you can't control your opponent's portal or alien thingies
- each "creature" thing capable of attacking can only attack once per turn

![alt text](https://raw.githubusercontent.com/abbott221/WebsiteAndApp/master/pictures_display/4_3_occupant.png "Main Picture")



"Portal" Picture
-----
When you press the tile that belongs to your "portal", it is highlighted (in blue)

Label 1:      Purple Tiles indicate a tile where you can "summon"/"teleport" an "alien" to.
Label 2:      The blue tile indicates that its occupant is selected.

![alt text](https://raw.githubusercontent.com/abbott221/WebsiteAndApp/master/pictures_display/4_3_portal.png "Main Picture")


