```
/api/v1/quiz

    GET /search

POST /adding
{
        "nameQuiz": "TEST",
        "startData": "2021-04-29T01:03:37.359655",
        "endData": "2021-04-29T01:03:37.359655",
        "pollQuestions": [
            {

                "textQuestion": "Test",
                "displayOrder": 4,
                "activity": false
            }
        ]
}

DELETE /{id}


PUT /{id}
    {
        "id": 100,
        "nameQuiz": "Update",
        "startData": "2021-04-29T01:03:37.281725",
        "endData": "2021-04-29T01:03:37.281725",
        "pollQuestions": [
            {
                "id": 1000,
                "textQuestion": "Update",
                "displayOrder": 1,
                "activity": true
            }
        ]
    }


GET /filter
           {
           "nameQuiz": "Basketball"
           }