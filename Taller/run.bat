javac -d bin -cp .;lib/mysql-connector-j-9.2.0.jar ./src/PaqueteTaller/*.java ./src/PaqueteTaller/DAO/*.java ./src/PaqueteTaller/model/*.java ./src/PaqueteTaller/view/*.java 
java -cp "./bin;./lib/mysql-connector-j-9.2.0.jar" PaqueteTaller.App
 