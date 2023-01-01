# Welcome to the Javacruitment

Technical interview consists of two main parts: the first one (which you'll have to perform yourself) is setting up your environment. Make sure that:

- The project has been imported into your IDE, and it compiles and runs fine.
- You're able to run Docker containers on your computer.
- You have some necessary tools: a REST client (e.g. Postman, Swagger, curl, wget) and a database client.
- You're familiar with the project structure.

The second part is a live coding during which you'll be provided with a list of tasks we'd like you to implement. During that part you're allowed to use the internet freely.

# Running the application

- This project expects a PostgreSQL database listening on port 5432. We prepared a docker-compose.yml that you should use for that purpose. To run it, simply execute:
`docker-compose up`
- Using your favorite IDE, execute the main class: `com.javacruitment.JavacruitmentApplication`
- Alternatively, you can run the following command from the terminal: `./gradlew bootRun`
- After successfully deploying the application, open your browser and go to `http://localhost:8080/`

# Troubleshooting

- Please make sure you have installed and properly configured Lombok ("Enable Annotation Processing" option in IntelliJ IDEA). In case of any issues please see: https://www.baeldung.com/lombok-ide
- If you're using Windows, we advise you to get VirtualBox with Linux in order to run Docker natively.

# Tasks

1. Create a REST method that will allow you to create new users. Remember to handle conflicts property (some columns are unique). Don't forget about necessary headers and response codes.
2. Enhance the user creation process by checking whether a login belongs to a blacklist. This blacklist should be stored in application's settings (yaml/properties) and contain some reserved words: "admin", "administrator", "root". An attempt to create user with one of those usernames should be rejected. Please write some unit tests.
3. Create a REST method that will expose the list of users whose username contains given text. You're allowed to use SQL LIKE. 
4. Create a Dockerfile that will let you run your application inside a container. Keep it simple - assume that a JAR file is given; just copy it to the container, expose necessary ports and run it. Integrate your container with the existing Docker Compose (Swarm) script.

General advice:
- Make sure your application handles business exceptions properly and turns them into proper HTTP status codes with nice messages. Unless the application has crashed, there should be no HTTP 500s and RuntimeExceptions flying around.
- Think about performance. Did you choose the right collection type for the job? Is that database query necessary at all? Do you really need to call that heavy method on every invocation?
- Pay attention to the details. Your code will go through a peer review process during which we'll evaluate not only correctness, but also the quality of your solution. So remember about proper naming, code formatting, immutability, readability etc.
