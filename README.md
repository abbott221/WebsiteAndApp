Intro
-----
This repository has very poor documentation and this README is not updated very frequently, but here's a general roadmap of what folder of code does what
- App
  - res : "resources" such as XML files that describe the layout of various screens and png files that are displayed on them
  - src : "source" this is where all the Java files are stored
    - com.MichaelAbbott.myCustomView      : an early version of the game that doesn't use images
    - com.MichaelAbbott.myViewAsSurface5  : the first implementation of the game that uses images
    - com.MichaelAbbott.myViewAsSurface6  : the second implementation of the game that uses images, this is the one currently being worked on
    - com.MichaelAbbott.myfirstapp        : the screens created that aren't involved in the game
    - com.MichaelAbbott.standards         : a few early interfaces that I made which aren't really that useful
- Website : yes there is a website involved, but will be used to support the multiplayer database in the future


TODO
-----
- Properly update the rest of this page
- Find a sufficient and not messy way of doing multithreading
- Bring the board to a SurfaceView
- Use XML file for the board activity's set-up process
- Incorprate the database for log-ins, chats and stuff
- Do saved instance bundles
- stop sending ALL of the database info in every single request
