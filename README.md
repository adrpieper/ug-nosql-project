# NoSql
[Zadanie 1](https://adrpieper.github.io/ug-nosql-project/)

TODO
- [ ] Zadanie Geo

| Nazwa | Wartosć    |
|-----------------------|------------|
| Procesor | Core(TM) i3-4005U CPU 1,7 GHz 1,7 GHz |
| RAM | 6 GB |
| Dysk | SSD |
| System operacyjny | Windows 8 64-bit |
| Wersje użytych baz danych | |
| Wersje bibliotek | |

## Dane

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
