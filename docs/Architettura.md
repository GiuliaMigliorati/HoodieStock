# ARCHITETTURA

Il progetto è stato sviluppato secondo lo stile architetturale Model View Controller. In particolare:

## 1.	Model
Il progetto si basa su un solo tipo di oggetto, ossia la felpa contenuta nel magazzino. Nel model quindi viene descritto tramite i suoi campi id, modello, taglia e colore

## 2.	View
L’interfaccia grafica viene implementata tramite Swing. Si compone principalmente di 3 classi: 
- ViewBenvenuto implementa la schermata iniziale che accoglie l’utente all’avvio del software
- ViewMenu implementa la seconda schermata che mostra all’utente tutte le azioni che può svolgere per gestire il proprio magazzino
- ViewFiltro implementa la schermata che permette all’utente di filtrare tutte le felpe presenti in magazzino per taglia, colore e modello 

## 3.	Controller
La business logic mette in comunicazione il model con la view. Viene implementata tramite tre classi: DataBase, ControllerViewMenu e ControllerViewFiltro. Gestiscono rispettivamente le azioni che vanno eseguite direttamente sul database, le azioni che possono essere scelte dall’utente nel menu e l’azione di filtraggio delle felpe presenti in magazzino


# Architectural views
Seguendo il modello 4+1, l’architettura del sistema può essere descritta da 4 differenti viste più un modello contente i casi d’uso:

1.	Logical view: mostra i componenti del sistema, ossia le classi e la loro interazione. È rappresentato dal Class Diagram (*)  
2.	Process view: mostra il flusso di lavoro del sistema, concentrandosi sulla sua natura dinamica. Viene rappresentato attraverso l’ Activity Diagram (*)  
3.	Deployment view: descrive la mappatura del software sull'hardware, evidenziando l'aspetto distribuito del sistema. In questo caso è quindi inutile, visto che il software risiede su un solo computer  
4.	Implementation view: fornisce la rappresentazione e l'organizzazione statica dei blocchi di cui è composto il sistema. È rappresentato dal Component diagram (*)  
5.	Use case view: descrive i requisiti funzionali del sistema e specifica gli attori che vengono coinvolti in ogni caso d’uso. È rappresentato dal Usecase diagram (*)  

(*) = tutti i diagrammi uml sopra citati sono disponibili nell’apposita sottocartella in docs
