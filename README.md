<p align="center">
<a href="https://www.haagensen.me">
  <img
    src="https://cdn.modrinth.com/data/cached_images/b811a708d2a8f791cf233906b023325b01812d2e.png"
    alt="website"
    width="750"
    loading="lazy"
  />
</a>
<br>
<br>

# Locator Preferences

**Locator Preferences** is a lightweight Paper/Spigot plugin for Minecraft 1.21.6 and above, that lets each player control their personal locator-bar (waypoint) visibility range. No server-wide changes or permissions needed—every command affects only the player who runs it.

---

## Features

- 🔧 **Per-player range control**  
  Adjust how far away your locator-bar shows waypoints.  
- 🚫 **Disable**  
  Turn off your locator-bar transmit entirely, hiden you from other players.  
- 🔄 **Reset**  
  Restore the locator-bar to its default maximum range.   

---

<div style="display: flex; justify-content: center; gap: 10px; align-items: center;">
  <img src="https://cdn.modrinth.com/data/cached_images/43147f065e72d61203dc2bab33eaddd5c9129799.png" alt="command" width="400" />
  <img src="https://cdn.modrinth.com/data/cached_images/ed40bea3bc999216ae4033a8730e744ca5a5c81b.png" alt="command - range" width="400" />
</div>


---


## Commands

### `/locatorpreference range <value|infinite>`
Sets your locator-bar range to the specified number of blocks.  
- `<value>` is any positive number (e.g. `1000`, `5000`).  
- `infinite` is a shortcut for “reset to the default maximum” (`6.0E7`).  

**Examples**  
/locatorpreference range 500 <br>
/locatorpreference range infinite

### `/locatorpreference disable`

Disables your locator-bar by setting your range to 0.  

### `/locatorpreference reset`

Resets your locator-bar to its default maximum range (`6.0E7`).
