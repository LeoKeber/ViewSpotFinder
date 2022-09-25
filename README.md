# ViewSpotFinder
Should find view spots

Es existieren die zwei Ordner "main" und "test". 
In dem Ordner "main" liegen fünf Klassen vor. Die Klassen Element, Node sowie ViewSpot werden hierbei in der Klasse Finder verwendet. Die Klasse Finder hat die Methode findViewPoints(), der ein JSONObjekt sowie ein Integerwert n übergeben wird. Aus diesen Parametern heraus sucht sie alle Viewspots aus dem Mesh. Zur Klasse Main später mehr.
In dem Ordner "test" ist die Klasse FinderTest zu finden, die bezüglich der Anforderungen der Aufgabenstellung auf Korrektheit der Ausgabe und Execution-Time testet.

Das Programm hat ein einfaches Command Line Interface (kann also z.B. über die übliche Eingabeaufforderung aufgerufen werden) nach folgendem Schema: 
java -jar ViewSpotFinder.jar <mesh file> <number of view spots>
Falls die Eingabeaufforderung nicht bereits das Verzeichnis der Jar-Datei ausgewählt hat, so muss unter Umständen anstelle von ViewSpotFinder der Pfad der Programmdatei angegeben werden. 
Das Ergebnis einer Anfrage ist im gewünschten Format im Standard-Output zu sehen.
  
Die Hauptklasse heißt hier Main. Sie beinhaltet lediglich eine Mainmethode, die als Argumente (insofern sie korrekt übergeben werden) den Pfad zu dem JSONObjekt sowie einen Integerwert n entgegennimmt.

Hier ein Beispiel für eine Ausführung in der Standard-Eingabeaufforderung: (so sah es bei mir aus)

C:\Users\Leo\Desktop>java -jar ViewSpotFinder.jar C:\Users\Leo\Documents\Xibix\mesh[1][1][1][1][1][1].json 9

Anmerkung: Ich habe mir hierfür zuerst, der Einfachheit halber, die jar-Datei auf den Desktop gezogen und den Befehl "cd Desktop" getätigt.
