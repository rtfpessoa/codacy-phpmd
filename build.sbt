import com.typesafe.sbt.packager.docker._

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

name := """codacy-engine-phpmd"""

version := "1.0-SNAPSHOT"

val languageVersion = "2.11.7"

scalaVersion := languageVersion

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.3.8" withSources(),
  "org.scala-lang.modules" %% "scala-xml" % "1.0.4" withSources()
)

enablePlugins(JavaAppPackaging)

enablePlugins(DockerPlugin)

version in Docker := "1.0"

val installAll =
  s"""
     |export COMPOSER_HOME=/opt/composer &&
     |mkdir -p $$COMPOSER_HOME &&
     |apk update &&
     |apk add bash curl php php-xml php-cli php-pdo php-curl php-json php-phar php-ctype php-openssl php-dom &&
     |curl -sS https://getcomposer.org/installer | php -- --install-dir=/bin --filename=composer &&
     |composer global require "sebastian/phpcpd=2.0.1" &&
     |composer global require "phpmd/phpmd=2.2.2" &&
     |chmod -R 777 /opt &&
     |ln -s /opt/composer/vendor/bin/phpmd /bin/phpmd
     """.stripMargin.replaceAll(System.lineSeparator(), " ")

mappings in Universal <++= (resourceDirectory in Compile) map { (resourceDir: File) =>
  val src = resourceDir / "docs"
  val dest = "/docs"

  for {
    path <- (src ***).get
    if !path.isDirectory
  } yield path -> path.toString.replaceFirst(src.toString, dest)
}

daemonUser in Docker := "docker"

dockerBaseImage := "frolvlad/alpine-oraclejdk8"

dockerCommands := dockerCommands.value.take(3) ++
  List(Cmd("RUN", installAll), Cmd("RUN", "mv /opt/docker/docs /docs")) ++
  List(Cmd("RUN", "adduser -u 2004 -D docker")) ++
  dockerCommands.value.drop(3)
