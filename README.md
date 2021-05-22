# dio-cities-api
Projeto de conclusão do bootcamp Everis Quality Assurance Beginner.

## API dio-cities-api
O projeto consiste de uma api simples de consulta desenvolvida em *Java*, que tem como objetivo recuperar dados de uma banco de dados *Postgresql*, contendo informações sobre países, estados e cidades, e expor esses dados via JSON.

A API foi hospedada na plataforma Heroku sob endereço http://dio-api-cities.herokuapp.com/

Como a api foi hospedada sob um plano gratuito a os recursos são limitados e disponibilidade fica comprometida, podendo estar indisponível durante alguns momentos do dia.

# Países [/countries/{id}]
Este é [recurso](http://www.w3.org/TR/di-gloss/#def-resource) para obtenção de dados sobre *países*. 

+ Parâmetro

    + id: numérico - Identificador único para um país, se especificado, apenas o país relativo ao id é retornado.

## GET
Para obter as informações é utilizado o [método de requisição HTTP](http://www.w3schools.com/tags/ref_httpmethods.asp) `GET` para o recurso `/countries`.

Quando chamado sem utilização do Id retorno é uma lista paginada de países.

+ Response 200 (application/json)

    + Body

            {
                "content":[
                    {
                        "id":1,
                        "name":"Brazil",
                        "portugueseName":"Brasil",
                        "abbr":"BR",
                        "bacen":1058
                    }
                ],
                "pageable":{
                    "sort":{
                        "sorted":false,
                        "unsorted":true,
                        "empty":true
                    },
                    "pageNumber":0,
                    "pageSize":1,
                    "offset":0,
                    "paged":true,
                    "unpaged":false
                },
                "last":false,
                "totalPages":255,
                "totalElements":255,
                "sort":{
                    "sorted":false,
                    "unsorted":true,
                    "empty":true
                },
                "first":true,
                "size":1,
                "number":0,
                "numberOfElements":1,
                "empty":false
            }
Quando utilizado Id é retornado apenas um registro de país.

+ Response 200 (application/json)

            {
                "id":1,
                "name":"Brazil",
                "portugueseName":"Brasil",
                "abbr":"BR",
                "bacen":1058
            }

# Estados [/states/{id}]
Este é [recurso](http://www.w3.org/TR/di-gloss/#def-resource) para obtenção de dados sobre *estados*, atualmente apenas estados brasileiros. 

+ Parâmetro

    + id: numérico - Identificador único para um estado, se especificado, apenas o estado relativo ao id é retornado.

## GET
Para obter as informações é utilizado o [método de requisição HTTP](http://www.w3schools.com/tags/ref_httpmethods.asp) `GET` para o recurso `/states`.

Quando chamado sem utilização do Id retorno é uma lista paginada de estados.

+ Response 200 (application/json)

    + Body

            {
                "content":[
                    {
                        "id":1,
                        "name":"Acre",
                        "fu":"AC",
                        "ibge":12,
                        "countryId":1,
                        "areaCode":[68]
                    }
                ],
                "pageable":{
                    "sort":{
                        "sorted":false,
                        "unsorted":true,
                        "empty":true
                    },
                    "pageNumber":0,
                    "pageSize":1,
                    "offset":0,
                    "paged":true,
                    "unpaged":false
                },
                "last":false,
                "totalPages":28,
                "totalElements":28,
                "sort":{
                    "sorted":false,
                    "unsorted":true,
                    "empty":true
                },
                "first":true,
                "size":1,
                "number":0,
                "numberOfElements":1,
                "empty":false
            }
Quando utilizado Id é retornado apenas um único registro de estado.

+ Response 200 (application/json)

            {
                "id":1,
                "name":"Acre",
                "fu":"AC",
                "ibge":12,
                "countryId":1,
                "areaCode":[68]
            }

# Cidades [/cities/{id}]
Este é [recurso](http://www.w3.org/TR/di-gloss/#def-resource) para obtenção de dados sobre *cidades*. 

+ Parâmetro

    + id: numérico - Identificador único para uma cidade, se especificado, apenas a cidade relativa ao id é retornada.

## GET
Para obter as informações é utilizado o [método de requisição HTTP](http://www.w3schools.com/tags/ref_httpmethods.asp) `GET` para o recurso `/cities`.

Quando chamado sem utilização do Id retorno é uma lista paginada de cidades.

+ Response 200 (application/json)

    + Body

            {
                "content":[
                    {
                        "id":1,
                        "name":"Afonso Cláudio",
                        "fu":"8"
                        "ibge":3200102,
                        "coordinate":"(-20.0778007507324,-41.1260986328125)","latitude":-20.0778007507324,
                        "longitude":-41.1260986328125,
                        "codTom":5601
                    }
                ],
                "pageable":{
                    "sort":{
                        "sorted":false,
                        "unsorted":true,
                        "empty":true
                    },
                    "pageNumber":0,
                    "pageSize":1,
                    "offset":0,
                    "paged":true,
                    "unpaged":false
                },
                "last":false,
                "totalPages":5595,
                "totalElements":5595,
                "sort":{
                    "sorted":false,
                    "unsorted":true,
                    "empty":true
                },
                "first":true,
                "size":1,
                "number":0,
                "numberOfElements":1,
                "empty":false
            }
Quando utilizado Id é retornado apenas um registro de cidade.

+ Response 200 (application/json)

            {
                "id":1,
                "name":"Afonso Cláudio",
                "fu":"8",
                "ibge":3200102,
                "coordinate":"(-20.0778007507324,-41.1260986328125)",
                "latitude":-20.0778007507324,
                "longitude":-41.1260986328125,
                "codTom":5601
            }

# Distância entre duas cidades [/distance?from={id}&to{id}]
Este [recurso](http://www.w3.org/TR/di-gloss/#def-resource) retorna a distância, em metros, entre duas *cidades*.

+ Parâmetro
    + from: numérico - Identificador único para uma cidade.
    +   to: numérico - Identificador único para a segunda cidade.

## GET
Para obter a distância entre as cidade, é utilizado o [método de requisição HTTP](http://www.w3schools.com/tags/ref_httpmethods.asp) `GET` para o recurso `/distance`.

A distância entre as cidades é medidas em metros, o valor de retorno é um double, a distância é relativa a uma linha reta traçada a partir do centro da primeira cidade, até o centro da segunda cidade, também não é levada em consideração a geografia do terreno.

+ Response 200 (application/json)

            170915.4296227393