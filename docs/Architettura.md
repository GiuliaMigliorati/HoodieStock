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
