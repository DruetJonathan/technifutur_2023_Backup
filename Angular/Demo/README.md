# Liste des commandes

## Créer un projet :
```
    ng new nomProjet
```
- Selectionner yes pour routing
- Selectionner scss pour type de css

## Lancer le projet :
- Version longue
    ```
        ng serve --open
    ```
- Version flemme
    ```
        ng s --o
    ```
## Fermer serveur
```
    Ctrl + c+
```

## Récupération d'un projet sur Git
Attention, comme le node_modules n'est jamais poussé nous devons regénérer le dossier en faisait la commande ci-dessous
```
    npm install (npm i)
```
<hr/>

# Création section

## Créer un module
Il faut être dans le dossier de l'application.
- Version longue
```
    ng generate module(path)nomModule --routing(si on veut un routing)
```
- Version flemme
```
    ng g m (path)nomModule --routing
```
1. 🚩Le routing sert à la navigation( Il n'est pas obligatoire )

## Créer un composant
- Version longue
```
    ng generate component(path)nomComponent 
```
- Version flemme
```
    ng g c (path)nomComponent 
```

## Créer un pipe
- Version longue
```
    ng generate pipe (path)nomPipe
```
- Version flemme
```
    ng g p (path)nomPipe
```

## Créer une directive
- Version longue
```
    ng generate directive (path)nomDirective
```
- Version flemme
```
    ng g d (path)nomDirective
```
## Créer un service
- Version longue
```
    ng generate services (path)nomService
```
- Version flemme
```
    ng g s (path)nomService
```
## Créer un Guard
- Version longue
```
    ng generate guard (path)nomGuard
```
- Version flemme
```
    ng generate g (path)nomGuard
```
