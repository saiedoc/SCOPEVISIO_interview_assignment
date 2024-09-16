# Scopevisio Versicherungspraemie Berechnung

## Inhaltsverzeichnis

- [Übersicht](#übersicht)
- [Endpunkte](#endpunkte)
    - [Versicherungseintrag speichern](#versicherungseintrag-speichern)
    - [Versicherungspremium berechnen](#versicherungspremium-berechnen)
- [Projektstruktur](#projektstruktur)
- [Abhängigkeiten](#abhängigkeiten)
- [Datenbankkonfiguration](#datenbankkonfiguration)
- [Anwendung ausführen](#anwendung-ausführen)
- [Tests ausführen](#tests-ausführen)

## Übersicht

Dieses Projekt ist eine Spring Boot-Anwendung, die RESTful-Endpunkte zum Verwalten und Berechnen von Versicherungspremien basierend auf Benutzereingaben bereitstellt. Es verwendet SQLite als Datenbank und umfasst Dienste zum Speichern von Versicherungseinträgen und zur Berechnung von Prämien.

## Endpunkte

### Versicherungseintrag speichern

**POST** `/versicherungpraemie/eintrag-speichern`

**Anfragetext:**

```json
{
  "Kilometerleistung": integer_value,
  "Postleitezahl": string_value,
  "Fahrzeugtyp": string_value
}
```

**Antwort:**

```json
{
  "id": long_value,
  "Postleitzahl": string_value,
  "Fahrzeugtyp": string_value,
  "Kilometerleistung": integer_value
}
```

**Beschreibung:**

Fügt einen neuen Versicherungseintrag in die Datenbank ein.

### Versicherungspremium berechnen

**GET** `/versicherungpraemie/berechne-versicherungpraemie`

**Anfragetext:**

```json
{
  "Kilometerleistung": integer_value,
  "Postleitezahl": string_value,
  "Fahrzeugtyp": string_value
}
```

**Antwort:**

```json
{
  "versicherungpraemie": double_value
}
```

**Beschreibung:**

Berechnet die Versicherungspremium basierend auf den bereitgestellten Details.

## Projektstruktur


```plaintext
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── interview
│   │   │           └── scopevisio
│   │   │               ├── Regionalzuordnung
│   │   │               ├── util
│   │   │               │   └── Dataextraction
│   │   │               └── Versicherungpraemie
│   │   └── resources
│   │       ├── static
│   │       └── templates
│   └── test
│       └── java
│           └── com
│               └── interview
│                   └── scopevisio
│                       └── Versicherungpraemie
└── target
    ├── classes
    │   └── com
    │       └── interview
    │           └── scopevisio
    │               ├── Regionalzuordnung
    │               ├── util
    │               │   └── Dataextraction
    │               └── Versicherungpraemie
    ├── generated-sources
    │   └── annotations
    ├── generated-test-sources
    │   └── test-annotations
    └── test-classes
        └── com
            └── interview
                └── scopevisio
                    └── Versicherungpraemie
```
## Abhängigkeiten

Das Projekt verwendet folgende Abhängigkeiten:

- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- SQLite JDBC
- Hibernate Community Dialects
- OpenCSV
- Spring Boot Starter Test (für Tests)

## Datenbankkonfiguration

- **Driver-Class-Name:** `org.sqlite.JDBC`
- **URL:** `jdbc:sqlite:versicherung.db`

## Anwendung ausführen

1. Klonen Sie das Repository:

   ```sh
   git clone https://github.com/saiedoc/SCOPEVISIO_interview_assignment.git
   cd SCOPEVISIO_interview_assignment
   ```

2. Bauen Sie das Projekt:

   ```sh
   mvn clean install
   ```

3. Führen Sie die Anwendung aus:

   ```sh
   mvn spring-boot:run
   ```

Die Anwendung wird gestartet und hört auf dem Standardport 8080. Sie können die Endpunkte mit Tools wie Postman oder curl testen oder einfach rest-endpoints.http in test directory ausführen.

## Tests ausführen

Um die Tests auszuführen, verwenden Sie den folgenden Maven-Befehl:

```sh
mvn test
```

