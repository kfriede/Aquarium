# Aquarium - IP Remote Control for Sharp Aquos TV's
Sharp Aquos TV's provide the ability to be controlled via IP.  This utility allows you to send commands to one or many IP controlled Sharp TV via a computer.  

## TV Setup
- Connect TV to network either via ethernet cable or WiFi.  A static IP address is highly recommended.  Settings can be found via "Internet Options" menu item.
- Turn ON Aquos Remote functionality found in the "Internet Options" menu item.  Set this to "enable".
- (Optional) Set a username and password for IP control from the Aquos Remote menu.
- (Recommended) Set "Quick Power", located in "Intial Setup" menu to ON.

## Setting up nodes.json
Aquarium is dependent on a JSON formatted file which contains information of the TV's (nodes) of which to send commands to.  An example of the format required is located in `nodes.json`.  

Aquarium will look for a `nodes.json` file in the directory adjacent to the `.jar` and automatically load it in.  If this file is not found, you can load an appropriate file manually through the File menu.  

## Compiling from Source
In the project directory, run:
`mvn clean compile assembly:single`.  An executable .jar file can then be found in the "target" directory.  

## Common Messages:
- `OK`: TV accepted command
- `ERR`: TV rejected command
- `connection timeout`: The TV cannot be reached.  Either the TV is not on the network or the computer being used cannot create a route to the TV's IP.  
- `connection refused`: "Aquos Remote" functionality on TV is off.  Turn on to fix. 
- `username:ERR`: TV firmware is too old to support remote functionality.  Upgrade your firmware.
