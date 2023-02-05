# Mortgage
This is the backend logic for reading input data from a file and calculating the monthly payment for each customer.

The logic was migrated to another repository to make a Spring Boot app running on docker and AWS with complete instructions.

You can find that repository here: https://github.com/Emanuel-san/Mortage-web

## Run it!

If you want to test this logic using the JAR files then you have to run `mortgage-1.0-SNAPSHOT-jar-with-dependencies.jar`, else *apache-commons* won't be recognised.

For docker instructions on how to build an image and start a container see the [Mortgage-web](https://github.com/Emanuel-san/Mortage-web) repo instructions. Dockerfile is included with this repo.
