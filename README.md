# RestApi-SpringBoot-

--REST API Generates data from server or updates/delete data on server
--This code will execute on server and will interact with server database
---Client(browser) can send request to this restapi(in the form of url) --Rest api will accept the url and then it will either send the data back to the client in the form of json/xml---or it will update the server database using the data send by the clint in the form xml/json or delete the data in server database

--The request frm the clent goes th the Rest Controller--->Controller calls the Service class--->Service class call dao interface---This interface inherits jpa repository
---JpaRepository allows us to perform basic CRUD Operation without using any method declaration in the dao interface---To perform customised query--we can define method signature in the interface --no need to define body in implemented class---method signature must follow some syntax--like getByCity()---getBy is common--City must be the variable of the model class

---use @RestController  with controller class---@Service with service class-----This annotation tells spring framework to create object of those class in IOC Container

--use @something with the implemented class not with the parent interface(if you are using loose coupling

---database configuration should be defined in application.properties file

--There is a main class containing  p s v main(String[] args)-----use @SpringBootApplication---right click on this main file--run as java app--use postman to send request

--To create a springboot application--go to springboot initializer site--select dependencies---download jar file--import in Eclipse IDE--

