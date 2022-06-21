## Queries for testing

1. GET

   ```
   $ curl -X GET http://localhost:8080/rest/allFilms
   ```

2. POST

   ```
   $ curl -X POST -H "Content-Type: application/json" -d '{"title": "Test title", "episode": "9", "director": "Test director", "releaseDate": "2022-05-07"}' http://localhost:8080/rest/
   ```

3. DELETE

   ```
   $ curl -X DELETE http://localhost:8080/rest/1
   ```
