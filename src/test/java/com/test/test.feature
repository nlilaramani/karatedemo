Feature: Test API
    Scenario: Fetch all products
        Given url 'http://localhost:8000/products'
        Given header Authorization = 'Basic YWRtaW46YWRtaW4='
        When method GET
        Then status 200
        * print 'response', response

