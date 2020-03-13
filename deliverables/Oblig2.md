# Obligatorisk oppgave 2

## Deloppgave 1: Prosjekt og prosjektstruktur

- Foreløpig fungerer rollene bra.

- **Teamleader** innebærer å ha en overordnet kontroll over hva som skjer i prosjektet til enhver tid og hvem som jobber med hva.  
  **Ui-ansvarlig** har hovedkontroll på hva som skjer når det kommer til implemenstasjon av ui og design av ui. (Hvordan ting ska se ut)  
  **Kundekontakt** må ha oversikt over hvilke designvalg som blir tatt og hvorfor når det kommer til impllementasjon og utvikling av programmet. Må vite hvordan og hvorfor koden fungerer. Må også ha god kontroll over hva leveransen (spillreglene) innebærer.  
  **Networking** har hovedansvar for å få spillet til å kunne kjøre på forskjellige pcer slik at flere kan spille samtidig.
  
- Teamet har fungert veldig godt til nå. De valgene vi har gjort team-messig gjør at vi jobber godt sammen og for mye gjort.

- Gruppen har god kommunikasjon og har god flyt som tillater alle å få komme med innspill og meninger. Det har ikke forekommet noen problemer når det kommer til dynamikken i gruppen.

- Gruppen kommuniserer godt, noe som gjør det enkelt å jobbe i og mellom møter. I møtene blir kunnskap delt mellom team-medlemmer ved at vi praktisk viser hvordan ting gjøres på LiveShare. Bruker også tegninger og modeller for å formidle sine egne tanker til resten av gruppen i møtene. Det som ikke blir kommunisert i møter (og deretter skrives ned i referat) blir tatt i slacken slik at alle får med seg det som blir kommunisert.

- Jobbing og kommunikasjon har fungert ganske som forventet. Vi har derimot ikke brukt veldig mye tdd ettersom vi synes det var lettere å skrive kode og deretter teste manuelt ved å kjøre spillet. Tdd er fortsatt noe vi kan se for oss at vi kommer til å bruke videre i prosjektet.

- Mye av koden blir jobbet med i møtene vi har. Vi bruker liveshare som gjør at alle kan jobbe med samme kode samtidig på sine egne pcer. Det er da hosten(teamleader) som vil ha all koden på sin maskin og de fleste commits angående kode vil da komme fra samme person.

- Forbedringpunkter: Være mer bestemte på hvilken metode vi velger å jobbe på. Har ikke vært et problem siden vi alle har vært enige og kommunisert bra hele veien, selv om arbeidsmetodikken ikke har vært helt som planlagt fra start.

## Deloppgave 2: krav

- Prioriterer oppgavene utifra hva som vi føler driver spillet videre mot et MVP.

  - Dette innbærer logikk som vegger og spawn til roboter.
  
### Brukerhistorier

**Brukerhistorie (Beveglse av robot):**

> Som spiller trenger jeg at roboten kan beveges slik at jeg kan programmere den med programkort.
>
> **Akseptansekriterier:**  
> Roboten
>
> - må kunne gå fremover.
> - må kunne gå bakover
> - må kunne rotere
> - må respawne når den detter utenfor mappet.
>
> **Arbeidoppgaver:**
>
> - Gi roboten en move funksjon som kan brukes fra andre klasser
> - Gi roboten en rotate funksjon som kan brukes fra andre klasser
> - Lage en spawn tile slik at roboten starter et sted

**Brukerhistorie (Vegger)**:

> Som spiller trenger jeg at roboten ikke kan bevege seg gjennom vegger slik at spillet inneholder rett spillmekanikk.
>
> **Akseptansekriterier:**  
> Roboten
>
> - Må ikke kunne gå gjennom vegger
>
> **Arbeidsoppgaver:**
>
> - Lage en tile Walls
> - Implementere Walls til å hindre movement til robot.

## Deloppgave 3: kode

Programmet startes ved å kjøre main. Da vil det dannes en ny innstans av game(), som lager brettet og tilhørende objekter.
Testene sjekker at brettet blir laget korrekt(Ingen endring siden forrige Oblig) og at Roboten beveger seg som den skal. Dvs. at den går riktig utifra hvor mange ruten den har fått beskjed om å bevege seg og at roboten ikke kan gå gjennom vegger. I tilegg sjekkes det at den roteres riktig.
Tester at spiller visuelt ser korrekt ut ved å kjøre gjennom manuelt. Dette er å sjekke at bildet av roboten viser riktig utifra hva roboten faktisk gjør, og at veggene blokkerer i riktig retning. Sjekker dette ved å styre roboten på alle mulige måter og prøve å bevege roboten gjennom de forskjellige typene vegger (både fra en Wall-tile og fra en Floor-tile inn i en Wall-tile).

Endret litt av strukturen i prosjektet. Begynte med å gi roboten kontroll over bevegelsene. Gikk over til å legge alt bevegelseslogikk inn i game-relaterte klasser. Dette gjør at roboten slipper å ha kontroll over hva som er lovlige trekk og isteden utføres dette i game-klasser som tar for seg alle spillregler. Roboten er nå et Imovable objekt, slik at det er enkelt å eventuellt implementere andre bevegelsesrelaterte objekter senere. 

Roboten kan kun beveges med følgende taster:

- W: Går ett skritt frem i retningen den ser.
- S: Går ett skritt i motsatt retning av der den ser.
- D: Roterer med klokken
- A: Roterer mot klokken

Prosjektet kjører uten problemer slik som forventet ved siste kjøring før levering.

## Møtereferat

### **Fredag** | 14-02  (Kasper, Thomas, Yafet)

Diskuterte veien videre etter Innlevering av Oblig1. Ryddet opp litt småting i kode, og gjorde klar til å fortsette med prosjektet.

### **Fredag** | 21-02 (Kasper, Thomas, Jens)

Disktuerte hvordan å angripe Oblig2. Finne implementasjonsmetode og prioritere implementasjon av funksjonaliteten til spill. Begynner med å utvide implementasjonen av hvordan roboten beveger seg slik at den lettere kan ta inn implementasjon av programkort senere.

### **Tirsdag** | 25-02 (Kasper, Thomas, Jens)

Har jobbet med Robotens bevegelsemetode og tester for å sjekke dette siden sist møte. Diskuterte endringene og fikk alt til å ligge på masterbranchen. Refakturerte koden sammen på møtet. Diskuterte mål for neste innlevering. Fant ut at vi trenger en player klasse som kan ha kontroll på kort, robot, spawns/checkpoint e.l.

Mål: Implementere: Korrekt robot-bevegelseslogikk. Dytting av roboter. Vegger. Spawn og respawn. Player-klasse. 

### **Onsdag** | 26-02 (Kasper, Thomas, Jens)

Diskuterte retningsystemet. Er nå basert på at retningene nord, øst, sør, vest er gitt som 0,1,2,3 tilsvarende. Dette er basert på at vi bruker utregning for å beregne retningsfunksjoner som trenger integers. Vill heller lage enums NORTH, EAST, SOUTH, WEST som inneholder verdiene 0,1,2,3.  Utivdet move i roboten slik at man kan dytte andre roboter i samme retning som din robot beveger seg i. 

### **Fredag** | 28-02 (Kasper, Jens)

Endret måten brett blir laget på slik at man kan sende inn et brett for å kunne bruke at annet brett til testing enn det vi bruker i selve spillet. Lagde tester for å sjekke at roboten ikke kan gå gjennom vegger. Skrev ferdig dokumentasjon til Oblig2.

## UML-diagram

![alt text](..\deliverablesAssets\diagrams\classDiagramOblig2.png "Class digram Oblig2")