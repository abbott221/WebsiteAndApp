Brought to you by: The Unexpected Packet
MedZapp - Data Centralization and Client Communication
====================

MedZapp is a comprehensive healthcare database that effeciently handles who can access a patient's data and optionally allows the patient to connect anonamously with other people with similar conditions.

Database
-----
Contains the following tables:
- loginData
    username, password, uID (user ID number), anon (boolean), doctor (boolean)
- permissions
    uID, category (type of contition), pID (patient ID number)
- medicalHistory
    uID, category, name (name of condition), date, description
- messages
    postCount, threadID, uID, content (of the message)
- threads 
    threadID, uID, partnerID

Notes
-----
This is NOT ready for deployment. It currently does not utilize data sanitation or encryption of any kind (aside from ssl). These and other security measures will be incorperated later.

TODO
-----
- Properly update the rest of this page
- Find a sufficient and not messy way of doing multithreading
- Bring the board to a SurfaceView
- Use XML file for the board activity's set-up process
- Incorprate the database for log-ins, chats and stuff
- Do saved instance bundles
- stop sending ALL of the database info in every single request
