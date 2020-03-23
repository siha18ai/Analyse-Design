# Running the project

`mvn wildfly:run`

Wait for the application to start

Open http://localhost:8080/ to view the application.

Default credentials are admin@vaadin.com/admin for admin access and
barista@vaadin.com/barista for normal user access.

# Running integration tests

Integration tests are implemented using TestBench. The tests take tens of minutes to run and are therefore included in a separate profile. To run the tests, execute

`mvn verify -Dit=wildfly`

and make sure you have a valid TestBench license installed. The value of the
`it` parameter determines which server to run the tests on with the valid
options being `wildfly` (Wildfly 10), `tomee` (TomEE Plume distribution) and `liberty`
(Websphere Liberty Profile). The servers will be downloaded and run automatically so
there is no need to install them manually.

# Running scalability tests

Scalability tests can be run as follows

1. Configure the number of concurrent users and a suitable ramp up time in the end of the `src/test/scala/*.scala` files, e.g.:
	```setUp(scn.inject( rampUsers(50) over (60 seconds)) ).protocols(httpProtocol)```

2. If you are not running on localhost, configure the baseUrl in the beginning of the `src/test/scala/*.scala` files, e.g.:
	```val baseUrl = "http://my.server.com"```

3. Make sure the server is running at the given URL. To run the local Wildfly server, use e.g.
	```mvn wildfly:run```

4. Start a test from the command line, e.g.:
	 ```mvn -Pscalability gatling:execute -Dgatling.simulationClass=com.gmail.simon.Barista```

5. Test results are stored into target folder, e.g.:
	```target/gatling/Barista-1487784042461/index.html```

# Developing the project

The project can be imported into the IDE of your choice as a Maven project

The views are created using Vaadin Designer. To edit the views visually,
you need to install the Vaadin Designer plug-in.

In Eclipse, open Marketplace, search for "vaadin" and install Vaadin
Designer 2.x

In IntelliJ, go to "Preferences" -> "Plugins" -> "Browse Repositories",
search for "Vaadin Designer 2" and install "Vaadin Designer"

# License
A paid Pro or Prime subscription is required for creating a new software project from this starter. After its creation, results can be used, developed and distributed freely, but licenses for the used commercial components are required during development. The starter or its parts cannot be redistributed as a code example or template.

For full terms, see LICENSE
