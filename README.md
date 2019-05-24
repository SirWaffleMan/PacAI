# PacAI

## Building a level

All levels are encoded in PNG format. Each pixel represents a grid in the game. If you would like to design a level, you must follow these requirements:

#### Path

This is what allows Pac-man and the ghosts to move freely.

To adopt:
  Color: White (255,255,255)
  Dimension: 1x1 px
  
#### Wall / Obstacle

This restricts any entity to pass through.

To adopt:
  Color: Black (0,0,0)
  Dimension: 1x1 px
 
#### Pac-Man Spawn

The location where Pac-man will spawn.

To adopt:
  Color: N/A
  Dimesion: 2x1 px
  
#### Ghosts spawn

The location where the ghosts will spawn.

To adopt:
  Color: N/A
  Dimension: 8 x 5px
  
#### Pellet

The objective of each level is to consume all pellets. This increases score of Pac-man.

To adopt:
  Color: Yellow (255,255,0)
  Dimension: 1x1 px
  
#### Power Pellet

If Pac-man eats one of these pellets, it allows him to eat ghosts.

To adopt:
  Color: N/A
  Dimension: 1x1 px
