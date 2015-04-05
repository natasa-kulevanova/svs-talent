1. Vo finkcijata updatePublication vo PublicationMenu kade sto se obiduvam da dodelam isbn za knigata
koja sto treba da se update-ira -- ((Book) p).setIsbn(isbn); -- mi dava ClassCastException,
istoto i za magazinot vo istata funkcija -- ((Magazine) p).setIssn(issn); --
kako inaku bi ja setirala vrednosta za isbn kaj knigata i issn ka magazinot?

2. So Scanner ne mi gi zapisuvase tocnite vrednosti koi gi pisuvav kako vlezni argumenti za title kaj
publication, email kaj member i drug mesta, pa namesto toa iskoristiv InputStreamReader i 
BufferedReader. Gi probav site mozni kombinacii so Scanner i ne mozev da go resam problemot. 
Kreirav i nov Scanner vo menijata, no citajki na internet doznav mnogu vazna rabota. Ako imame 2
Scanner-i na primer sc1 i sc2, i ako napravime sc2.close();, ova ne samo sto go zatvora Scannerot sc2, 
tuku i go zatvora 'System.in' input stream-ot. Zatoa na nekoi mesta kako vlezen argument go prosleduvam 
Scannerot imenuvan 'in' od LibraryApp klasata kade sto se naoga i main metodot, se so cel da imam eden 
Scanner vo aplikacijata.


