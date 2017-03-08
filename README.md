# ug-nosql-project
Projekt z NoSQL

TODO
- [ ] project page
- [ ] _example.nb.html

## dane

Przykładowy rekord. Ile danych? (w sztukach, w GB)

``` json
{
  "name" : "Adrian",
  "surname" : "Pieper"
}
```

## Czyszczenie danych

Zmiana nazw pól, wybór pól.

## Elasticsearch

Mapping -- przygotować i zapisać w Elasticsearch

### Import danych

```sh
time gunzip -c dane.json.gz
```

### Przykładowe zapytania

Czego szukam?

### Mapki

Zapytania mapkowe

```sh
curl localhost:9200/.... | jq .hits.hits[] | przerabiamy na GeoJson
``` 

## PostgresSQL

Schema -- przygotować i użyć w trakcie importu

### Import danych

## Mongodb

Pamiętać, aby DateTime było zaimportowane jako DateTime

### Import danych
