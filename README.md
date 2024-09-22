## Modeldriven optimisation of business processes

---

This project aims to improve the modularization of business process activities by optimising processes with respect to the metrics cohesion and coupling.

The concept of modeldriven optimisation is used, to define a process model as a software artifact. This model is then used to implement mutation operators, objective functions and constraints to specify an optimisation problem.

The specification and solving of the problem is done via the MDEOptimiser. This tool provides functionality to specify model driven optimisation problems and can be used to solve them with genetic algorithms.

---

### Table of contents

1. Structure of the repository

2. Installation details

---

#### 1. Structure of the project

The folder 'bachelor-thesis' consists of 4 subfolders.

* bpmnmodelling.edit

* bpmnmodelling.editor

* bpmnmodelling.test

* bpmnmodelling

The last directory 'bpmnmodelling' contains the main project, the other 3 folders are automatically created via the model code generation of the EMF and can be ignored.

bpmnmodelling contains in it's src folder the needed components to specify the optimization problem:

* workflow.ecore is the metamodel.

* Workflow_StudentGrant.xmi is the instance model of the given problem.

* workflow.henshin_diagram contains the implemented model transformations.

* The package model.workflow contains the source code for the implemented objective functions and constraints.

The directory mopt-files contains configurations for the MDEOptimiser, the results of the optimization processes and experiments can be found in mdeo-results, which contains all of the generated evaluation data.

Addtional workflows have been added to test the optimization process, namely example_A to example_C, but they are not used in the evaluation.

---

#### 2. Installation details

Für die Ausführung des vorgestellten Projekts müssen die folgenden Voraussetzungen erfüllt sein:

* Ein Linux-Betriebssystem, im Rahmen dieser Arbeit wird die Standardversion des Windows-Subsystem  for Linux (WSL) verwendet.

* Java 11

* Eclipse 2019-03:
  
  https://www.eclipse.org/downloads/packages/release/photon/r/eclipse-ide-java-and-dsl-developers

* Henshin:
  
  http://download.eclipse.org/modeling/emft/henshin/updates/nightly

* MDEOptimiser:

       http://mde-optimiser.github.io/mdeo_repo/src/composite/release/

* Die im Repository beigelegte .jar-Datei, welche im dropin Ordner zu finden ist.

Es wird empfohlen das Projekt in einer Linux Umgebung auszuführen, da unter Windows Fehler bei der Ausführung des MDEOptimiser auftreten können.

Des Weiteren wird auf der offiziellen Seite des MDEOptimiser empfohlen Java 11 und Eclipse Photon in der Version 2019-03 zu verwenden, da der letzte Release der Software in dieser Umgebung getestet wurde.

Nach der Installation der Eclipse IDE können Henshin und der MDEOptimiser installiert werden:

**Installation des MDEOptimiser**

* Öffnen Sie Eclipse.

* Öffnen Sie den Wizard zum installieren neuer Software unter dem Reiter Help $>$ Install New Software.

* Kopieren Sie die angegebene URL für den MDEOptimiser.

* Fügen Sie die kopierte URL in das „Work with“ Textfeld ein.

* Nach der Eingabe sollte eine Liste verschiedener Softwares angezeigt werden.

* Setzen Sie einen Haken in das Feld des „MDEOptimiser“ Bundle.

* Wählen Sie „Next“ und folgen Sie den weiteren Installationsschritten.

* Nach der Installation muss Eclipse neu gestartet werden.

**Installation von Henshin**

* Die Installation erfolgt wie die Installation für den MDEOptimiser.

* Öffnen Sie erneut den Wizard über Help $>$ Install New Software.

* Kopieren Sie die angegebene URL für Henshin.

* Fügen Sie die URL in das „Work with“ Textfeld ein.

* Setzen Sie einen Haken bei dem angezeigten „Modeling“ Bundle.

* Klicken Sie auf „Next“ und folgen Sie den weiteren Installationsschritten.

* Nach der Installation muss Eclipse neu gestartet werden.

**Das Projekt als Plugin laden**

* Um den MDEOptimiser ausführen zu können, muss das Projekt als Plugin-Projekt geladen werden.

* Zunächst muss die bereitgestellte .jar-Datei in den „dropin“ Ordner der Eclipse Installation abgelegt werden. Der dropin Ordner befindet sich im eclipse Installationsverzeichnis.

* Nach diesem Schritt muss Eclipse neu gestartet werden.

* Mit einem Rechtsklick auf den Projektordner öffnet sich ein Reiter, aus dem „Load project as plugin“ ausgewählt werden kann.

* Falls die .henshin Datei einen Fehler wirft muss unter dem Reiter Project > Clean ausgewählt werden.

* Abschließend sollten keine Fehler mehr auftreten.

* Sollten die henshin oder henshin-diagram Dateien Fehler werfen, sollten diese einmal geschlossen und nach einem erneuten Ausführen von Project > Clean erneut geöffnet werden.

**Erstellen einer Run Configuration**

Um den MDEOptimiser auszuführen, muss eine Run Configuration erstellt werden.

* Wählen Sie unter dem Reiter Run $>$ Run Configuration aus.

* Wählen Sie in der linken Spalte „MDEOptimiser Search“ aus.

* Mit einem Rechtsklick kann unter „New Configuration“ eine neue Konfiguration erstellt werden.

* Im obersten Feld kann eine Name angegeben werden.

* Im „source“ Textfeld muss die gewünschte .mopt Konfigurationsdatei ausgewählt werden.

* Im Reiter „Classpath“ muss auf „Bootstrap Entries“ und schließlich „Apply“ geklickt werden, um sicherzustellen, dass alle Dependencies im Classpath vorhanden sind.

* Der MDEOptimiser kann schließlich mit einem Klick auf „Run“ gestartet werden.

* Nach der Ausführung des Optimierungsprozesses muss das Projekt mit einem Rechtsklick auf den Projektordner $>$ Refresh aktualisiert werden.

* Dann wird ein Ordner „mdeo-results“ angezeigt, welcher die Ergebnisse beinhaltet.
