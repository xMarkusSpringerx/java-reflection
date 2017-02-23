# Java Software Metriken

Im Java-Umfeld existieren unzählige Softwarebibliotheken, deren Qualität sehr stark variiert. Um sich einen ersten Überblick über deren Codequalität zu verschaffen, kann man Softwaremetriken zu Rate ziehen. Im Rahmen dieser Übung sollen Sie daher ein einfaches Werkzeug entwickeln, mit dem man für eine beliebige Java-basierte Bibliothek, die in Form von Java-Archiven vorliegt, eine Reihe von Kennzahlen ermitteln kann

a) Entwickeln Sie ein Java-Programm, das in einem ersten Schritt alle Klassen aus mehreren zusam- mengehörigen Java-Archiven extrahiert und für jede Klasse die Ihnen relevant erscheinenden Kennzahlen in einer internen Datenstruktur speichert. Sie haben dabei weitgehend freie Hand, sollten aber zumindest folgende Parameter berücksichtigen:
-  die Anzahl der Methoden, getrennt nach ihrem Sichtbarkeitsattribut,
- die Anzahl der implementierten Schnittstellen,
-  die Tiefe der Ableitungshierarchie,
-  die durchschnittliche Anzahl von Parametern pro Methode.

Wählen Sie eine Datenstruktur, die gewährleistet, dass einerseits schnell auf die Metriken einer Klasse zugegriffen werden kann und andererseits die Kennzahlen aller Klassen eines Pakets effi- zient kumuliert werden können. Für das Ermitteln aller Klassen eines Pakets (und dessen Unter- pakete) soll nur der dafür relevante Teil der Datenstruktur durchsucht werden müssen.

b) Schaffen Sie im nächsten Schritt Möglichkeiten, statistische Kennzahlen zu ermitteln. Zumindest folgende Funktionalität ist vorzusehen:
-  Ermittlung der Kennzahlen für eine Klasse.
- Ermittlung der Kennzahlen für ein Paket (inklusive der Unterpakete). Kumulieren Sie dafür die oben angeführten Kennzahlen (ermitteln Sie Minimal-, Maximal- und Durchschnitts- werte). Geben Sie auch die Anzahl der Klassen und Unterpakete an.
- Ermittlung aller Klassen/Unterpakete eines Pakets.
c) Erstellen Sie ein Kommandozeilenprogramm, das eine Liste von Java-Archiven akzeptiert, Soft- waremetriken mit den in a) und b) geschaffenen Funktionen berechnet und diese auf der Konsole ausgibt. Strukturieren Sie die Kennzahlen hierarchisch und achten Sie auf eine übersichtliche Dar- stellung.
Testen Sie Ihre Implementierung ausführlich. Verwenden Sie dafür zunächst eine Java-Bibliothek, die nur wenige Klassen und Pakete enthält. Führen Sie anschließend Tests an einer umfangreichen Java-Bibliothek durch, die in mehreren Java-Archiven ausgeliefert wird und zumindest aus 2000 Klassen besteht. Sie könnten dafür beispielsweise das „Spring Framework“ heranziehen, das Sie über den nachfolgend angeführten Link herunterladen können: http://repo.spring.io/release/org/spring- framework/spring/4.2.5.RELEASE.
