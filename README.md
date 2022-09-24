# ViewSpotFinder
Should find view spots

Es existieren die zwei Ordner "main" und "test". 
In dem Ordner "main" liegen vier Klassen vor. Die Klassen Element, Node sowie ViewSpot werden hierbei in der Klasse Finder verwendet. Die Klasse Finder hat die Methode findViewPoints(), der ein JSONObjekt sowie ein Integerwert n übergeben wird. Aus diesen Parametern heraus sucht sie alle Viewspots aus dem Mesh.
In dem Ordner "test" ist die Klasse FinderTest zu finden, die bezüglich der Anforderungen der Aufgabenstellung auf Korrektheit der Ausgabe und Execution-Time testet.

Das Programm hat ein einfaches Command Line Interface (kann also z.B. über die übliche Eingabeaufforderung aufgerufen werden) nach folgendem Schema: 
java -jar ViewSpotFinder.jar <mesh file> <number of view spots>
Das Ergebnis einer Anfrage ist im gewünschten Format im Standard-Output zu sehen.
