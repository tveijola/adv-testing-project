# adv-testing-project
Practical part of the course project for Advanced Software Quality and Security course.

## Usage

    mvn graphwalker:test

A modified version of graphwalker-java is used to enable running on Windows. <br>
If the above does not work on your operating system, in pom.xml replace
    
    <dependency>
      <groupId>org.graphwalker</groupId>
      <artifactId>graphwalker-java</artifactId>
      <version>${project.version}</version>
      <scope>system</scope>
      <systemPath>/${project.basedir}/graphwalker-java-4.3.0.jar</systemPath>
    </dependency

with

    <dependency>
      <groupId>org.graphwalker</groupId>
      <artifactId>graphwalker-java</artifactId>
      <version>${project.version}</version>
    </dependency

and try the command again.