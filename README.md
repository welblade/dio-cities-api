# dio-cities-api
Projeto de conclusão do bootcamp Everis Quality Assurance Beginner.

## API dio-cities-api
O projeto consiste de uma api simples de consulta desenvolvida em *Java*, que tem como objetivo recuperar dados de uma banco de dados *Postgresql*, contendo informações sobre países, estados e cidades, e expor esses dados via JSON.

A API foi hospedada na plataforma Heroku sob endereço http://dio-api-cities.herokuapp.com/

Como a api foi hospedada sob um plano gratuito a os recursos são limitados e disponibilidade fica comprometida, podendo estar indisponível durante alguns momentos do dia.

# Países [/countries/{id}]
Este é [recurso](http://www.w3.org/TR/di-gloss/#def-resource) para obtenção de dados sobre países. 

+ Parâmetro

    + id: numérico - Identificador único para um país, se especificado, apenas o país relativo ao id é retornado

## GET
Para obter as informações é utilisado o [método de requisição HTTP](http://www.w3schools.com/tags/ref_httpmethods.asp) `GET` para o recurso `/countries`.

Quando chamado sem utilização do Id retorno é uma lista paginada de paises

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