Feature: Posts API
    Scenario: Fetch all posts
        Given url 'http://jsonplaceholder.typicode.com/posts'
        When method GET
        Then status 200
        * print 'response', response
