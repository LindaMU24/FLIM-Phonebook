# data.Phonebook
Detta är ett grupparbete i Java. Gruppen består av: Fredrik, Ivana, Madeleine och Linda.
Vi har skapat en telefonbok med OOP principer, CRUD-operationer, arv och persistent data(FileStream). 
Vi startade med att bygga vårt UML-Diagram och sedan lägga alla uppgifter på vår tavla i Trello. Uppgifterna fördelades mellan oss och tillsammans har vi byggt upp ett välfungerande projekt enligt den önskade specifikationen.
Det var roligt att tillsammans se projektet växa fram.  
[Länk till UML](https://lucid.app/lucidchart/a1aa6bfc-1d9e-4386-9286-4df3b0e6ef5e/edit?viewport_loc=-404%2C-2490%2C2126%2C2117%2CHWEp-vi-RSFO&invitationId=inv_01298ea9-cdba-4e11-a41b-802344375f28)


## Kravspecifikationerna för uppgiften var:  
Create   - att lägga till nya profiler i telefonboken  
Read     - att söka efter profiler i telefonboken givet olika sökningar  
Update  - att kunna uppdatera en profils kontaktuppgifter  
Delete   - att kunna ta bort en profil

## Olika användare
Default så är alla användare i systemet en gäst användare, men då inte alla ska kunna ta bort en användare så behöver användaren logga in som en administratör för att kunna ta bort andras profiler. Detta gäller även för uppdateringen av användarens kontaktinformation.  
Kontaktinformation  
Varje profil i telefonboken ska ha egenskaperna:  
•	förnamn  
•	efternamn  
•	ålder  
•	adress (med stad, postkod, gatunamn, portnummer)  
•	telefonnummer (en profil kan ha flera telefonnummer)    
Sökbarhet  
1.	Sökning på efternamn - ger profilen som först matchar med sökningen.  
2.	Sökning på adress - ger alla profiler på samma gatunamn.  
3.	Sökning på förnamn - ger alla profiler med det sökta förnamnet.  
4.	Frisökning - ger alla profiler med någon relaterbar kontaktinformation.  
Frisökning avser att söka över samtliga egenskaper. Exempelvis så kan sökningen Erik ge svar på förnamnet Erik, efternamn Eriksson samt adressen Eriksberg.  


## Krav för uppgiften
Ett konsolprogram som kan användas av två olika användarprofiler. Gästanvändare och administratör. De två användarprofilerna ska kunna utföra följande:  
Gästanvändare  
•	Förmåga att söka efter profiler givet beskrivningen av sökbarhet.  
•	Förmåga att avsluta programmet genom att skriva “quit” i konsolen.  
 
Administratör  
•	Förmåga att lägga till kontaktinformation om en profil med egenskaperna som beskrivs under kontaktinformation.  
•	Förmåga att ta bort kontaktinformation för någon tillagd profil.  
•	Förmåga att uppdatera kontaktinformation för någon tillagd profil.  
•	Samma övriga rättigheter som en gästanvändare.  
 För ett högre betyg så ska programmet “komma ihåg” profiler som har sparats, uppdaterats eller tagits bort av administratörer.  
