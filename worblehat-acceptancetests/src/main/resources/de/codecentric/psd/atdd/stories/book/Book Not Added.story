Narrative:
In order to keep a clean database of books
As a librarian
I want to have my entries validated

Scenario:

Given an empty library

When a librarian adds a book with title <title>, author <author>, edition <edition>, year <year> and isbn <isbn>
Then the page contains error message <message>
And The library contains no books

Examples:
 
| isbn       | author           | title     |edition    | year  | message               |
| 0XXXXXXXX5 | Terry Pratchett  | Sourcery  | 1         | 1989  | ISBN is not valid, please check again     |
| 0552131075 | Terry Pratchett  | Sourcery  | X         | 1989  | Edition is not valid, it has to be a numeric value  |

