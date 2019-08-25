# Teletronics Test Application
This spring boot application calls the Github api internally using Rest Template and then render the json array response by removing undesired fields and keeps the desired fields like url,name,description etc.

## Basic Software Needed to run the app :
1. JDK 1.8 or later
2. Maven 3.5.4+
3. Git 2.20+
4. Docker 18.06.1
5. Jenkins with installed plugins like git,maven,pipeline etc.

## How to run the app :
1. Install the software mentioned above if not done.

2. In any folder of choice, open command prompt/git terminal.

3. Run the following commands :
  git clone https://github.com/Boburmirzo/teletronics.git
  
  This app can be run both as normal **spring boot** project or as **docker image**.
### Spring-Boot App Run:
1. Move to the teledemo folder i.e. root folder of the app where pom is placed.
2. Run command mvn clean install spring-boot:run

### Docker Image Run:
1. Run mvn clean package from the folder where project pom is placed.
2. It will create a .jar file in the target folder.
3. Create a docker image by running docker build command from the location where docker file is placed i.e. root directory :
   mvnw install dockerfile:build
4. Run docker container with below command :
   docker run -p 8080:8080 -itd Boburmirzo/teletronics

After all the dependencies are successfully downloaded, check the services output in postman as mentioned in the scenarios below :

### Scenario -1 (My Personal Repo)
**Sample Endpoint** : http://localhost:8080/projects/Boburmirzo/ GET :
**Sample Output** : [
    {
        "id": 22317212,
        "name": "datasciencecoursera",
        "fullName": "Boburmirzo/datasciencecoursera",
        "htmlUrl": "https://github.com/Boburmirzo/datasciencecoursera",
        "description": "This is a datascience course repository that is offered by coursera ."
    },
    ...]
### Scenario -2 (Test Repo)
**Sample Endpoint** : http://localhost:8080/projects/test/ GET :
**Sample Output** : [
    {
        "id": 12196274,
        "name": "HelloWorld",
        "fullName": "test/HelloWorld",
        "htmlUrl": "https://github.com/test/HelloWorld",
        "description": "Create hello world"
    },
    ...
    ]
### Jenkins Automated Run
If someone has Jenkins installed with relevant plugins like git,maven etc. and github credentials being configured, then one can use the **Jenkins pipeline script** mentioned in the root directory to do the following :
1. Clone the Repository from GITHUB
2. Build the project and run unit test cases automatically.
3. Push image to docker hub/registry.
4. Pull & Run image from docker hub/registry on local
