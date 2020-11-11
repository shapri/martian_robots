# martian_robots

Instructions
RUN: mvn clean package

RUN: java -jar target/martian_robots-1.0-SNAPSHOT.jar \\path\\to\\martian_robots\\src\\test\\resources\\instructions.txt

In the interest of simplicity:
 
 1. The number of robots on the planet is hard coded to three. An alternative approach would have been to create proptotypes on the fly.
 2. Instructions will be provided in a file
 3. The final status for each robot is printed to console
 