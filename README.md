# DDD Foodwatch Example Project

See [DDD Community Home](https://confluence.baloisenet.com/atlassian/x/1AV5a).


### Prerequisites

 - Git.
 - Maven.
 - [JDK 14](https://jdk.java.net/java-se-ri/14)
 - Lombok
 
## Subdomains
- [food](./food)
- [recipe](./recipe)
- [shopping](./shopping)

## Build & run the example code

```
mvn clean package
java -jar recipe/target/foodwatch-recipe-0.0.1-SNAPSHOT.jar

```


## Use Cases

### Use Case 1 - User wants to create a shopping list from a recipe

Start here: <http://localhost:8080/create-shopping-list>