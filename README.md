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
- [order](./order)

## Build & run the example code

Normal maven build:
```
mvn clean package
```

In order to run the system you need to start the 4 applications separately:
```shell
java -jar order/target/*.jar      # listens on port 8080
java -jar food/target/*.jar       # listens on port 8081
java -jar recipe/target/*.jar     # listens on port 8082
java -jar shopping/target/*.jar   # listens on port 8083
```

## Use Cases

### Use Case 1 - User wants to create a shopping list from a recipe

Start here: <http://localhost:8080/create-shopping-list>