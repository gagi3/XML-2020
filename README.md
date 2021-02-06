# XML-2020
Informacioni sistem za pristup informacijama od javnog značaja. 

### Demo

https://youtu.be/QroqvgmKYQg

### Pokretanje

#### Zahtevi:

1. JDK 11 (https://www.oracle.com/java/technologies/javase-jdk11-downloads.html#license-lightbox)
2. Maven 3.6.3 (https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip)
3. Node.js i NPM (https://nodejs.org/download/release/v10.15.1/)
4. eXist-db 5.2.0 (https://bintray.com/existdb/releases/exist/5.2.0/view)
5. Apache Tomcat 9.0.41 (https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.41/)
6. Apache Jena Fuseki 3.17.0 (https://jena.apache.org/download/)
7. Kloniran repozitorijum na disk

Važno je dodati JDK, Maven, Node.js u Environment i Path varijable.

#### Pokretanje:

##### Tomcat, eXist-db i Jena Fuseki

###### eXist-db

Uputstvo za instalaciju i pokretanje: https://exist-db.org/exist/apps/doc/basic-installation
Dokumentacija: https://exist-db.org/exist/apps/doc/documentation

0. Pri instalaciji (ili prvom pokretanju), OBAVEZNO promeniti port na 8899, korisničko ime na "admin", a šifru ostaviti praznom.
1. Pokrenuti eXist-db dvoklikom na `client.bat`, `launcher.bat` ili `startup.bat`
2. Proveriti da li je eXist-db pokrenut u servisima (`services.msc` ili `Task Manager` na Windows-u)
3. U web pretraživaču, ukucati `localhost:8899` i pritisnuti Enter

###### Tomcat i Jena Fuseki

Dokumentacija za Jena Fuseki: https://jena.apache.org/documentation/fuseki2/fuseki-webapp.html#fuseki-web-application

0. Kopirati `fuseki.WAR` fajl iz `/apache-jena-fuseki-3.17.0` direktorijuma unutar `/apache-tomcat-9.0.14/webapps` direktorijuma
1. Otvoriti Command Prompt unutar `/apache-tomcat-9.0.14/bin` foldera
2. Ukucati `startup` i pritisnuti Enter (alternativno, pokrenuti dvoklikom na `startup.bat`)
3. Kada se pokretanje završi, otvoriti web pretraživač, ukucati `localhost:8080/fuseki` i pritisnuti Enter

##### Back end

Maven dokumentacija za instaliranje: https://maven.apache.org/install.html

0. Proveriti da li su podešene varijable komandama `java --version` i `mvn -v` unutar Command Prompt/Terminal/Powershell - ukoliko izbaci grešku, ponoviti postupak podešavanja varijabli
1. Otvoriti Command Prompt/Terminal/Powershell
2. Pozicionirati se u folder `/poverenik` (unutar kloniranog repozitorijuma)
3. Ukucati `mvn spring-boot:run` i pritisnuti Enter
4. Ponoviti postupak za aplikacije sluzbenik i mail (unutar foldera `/sluzbenik` i `/mail`)

Alternativno, ukoliko se koristi IDE (razvojno okruženje), potrebno je uvesti sve biblioteke (iz `/libs` direktorijuma za svaki projekat), instalirati Lombok plugin u razvojnom okruženju i omogućiti pretprocesiranje anotacija (annotation preprocessing).


###### Endpoints

Spisak aplikacija i njihovih portova:
1. Poverenik: `8081`
2. Službenik: `8082`
3. Mail: `8083`

Neki od osnovnih endpointa su `/create` za kreiranje, `/edit` za izmenu, ` ` za pretragu (sa parametrima), `/search?id=ID` za pretragu po ID, `/generate?id=ID` za generisanje XML dokumenta, `/convert-to-pdf` i `/convert-to-html` za konverziju dokumenata, `/extract-metadata` za ekstrakciju metapodataka i `/search-metadata` za pretragu nad podacima.

Ove operacije (ili veći deo njih) se mogu raditi nad `/gradjanin`, `/izjasnjenje-na-zalbu`, `/izvestaj`, `/korisnik`, `/obavestenje`, `/poverenik`, `/resenje`, `/sluzbenik`, `/zahtev`, `/zalba-cutanje`, `/zalba-odluka`.

Operacije registracije i logovanja su dostupne na `/api/user/register` i `/api/user/login`.

Generisanje izveštaja službenika je dostupno na `GET localhost:8082/izvestaj/generate?id=ID`, gde se pod ID podrazumeva ID službenika koji želi da generiše izveštaje.

Za više informacija, pogledati foldere `controller` u aplikacijama poverenika i službenika.

Primeri tela zahteva za kreiranje novih XML dokumenata se nalaze u folderu `/data/xml-request`.

Jedan primer: `GET localhost:8081/resenje?poverenikID=ID001`. Ovaj zahtev preuzima iz baze podataka poverenika sva rešenja koja sadrže ID001 kao ID poverenika, tačnije, sva rešenja koja je izdao poverenik sa ID001.

##### Front end

NPM/Node.js dokumentacija za instaliranje: https://docs.npmjs.com/downloading-and-installing-node-js-and-npm

0. Proveriti da li su podešene varijable komandom `npm --version` unutar Command Prompt/Terminal/Powershell - ukoliko izbaci grešku, ponoviti postupak podešavanja varijabli
1. Otvoriti Command Prompt/Terminal/Powershell
2. Pozicionirati se u folder `/front-poverenik` (unutar kloniranog repozitorijuma)
3. Ukucati `npm install` i pritisnuti Enter
4. Kada se izvršavanje komande završi, ukucati `npm start` i pritisnuti Enter
5. Ponoviti postupak za aplikaciju službenika (unutar foldera `/front-sluzbenik`)

Aplikacija poverenika je dostupna na `localhost:4200`.
