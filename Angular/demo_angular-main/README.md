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

## Créer un module
- Version longue
    ```
        ng generate module (path)nomModule --routing(si on veut un routing)
    ```
- Version flemme
    ```
        ng g m (path)nomModule --routing(si y'a)
    ```

## Créer un composant
- Version longue
    ```
        ng generate component (path)nomComponent
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
        ng generate service (path)nomService
    ```
- Version flemme
    ```
        ng g s (path)nomService
    ```

<br>
<hr>
<br>
<br>

# Récupération d'un projet sur Git
Attention, comme le node_modules n'est jamais poussé sur git, vous devrez regénérer le dossier en faisant (il se base sur les dépendances renseignées dans le package.json) : 
```
    npm install (ou npm i)
```