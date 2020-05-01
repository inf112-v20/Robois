# Oblig 3

## Deloppgave 1: Team og prosjekt

## Deloppgave 2: Krav

## Deloppgave 3: Produktleveranse og kodekvalitet

Programmet startes ved å kjøre main. Da vil det dannes en ny innstans av game(), som lager brettet og tilhørende objekter.
Testene sjekker at brettet blir laget korrekt(Ingen endring siden forrige Oblig) og at Roboten beveger seg som den skal. Dvs. at den går riktig utifra hvor mange ruten den har fått beskjed om å bevege seg og at roboten ikke kan gå gjennom vegger. I tilegg sjekkes det at den roteres riktig.
Tester at spiller visuelt ser korrekt ut ved å kjøre gjennom manuelt. Dette er å sjekke at bildet av roboten viser riktig utifra hva roboten faktisk gjør, og at veggene blokkerer i riktig retning. Sjekker dette ved å styre roboten på alle mulige måter og prøve å bevege roboten gjennom de forskjellige typene vegger (både fra en Wall-tile og fra en Floor-tile inn i en Wall-tile).

## Møtereferat

### **Fredag** | 17-04 (Jens, Kasper, Thomas)

**Fra forrige gang:**
Kasper: Lagde ny enum som tar for seg rotasjon slik at dette ikke ligger i retning enumen.  
Thomas: Lagde ny klasse "gameRendering" til å ta for seg rendering, slik at dette ikke ligger i game-klassen.

**På møtet:**  
Thomas: Jobbet videre på branchen som inneholder den nye klassen "gameRendering" og jobbet videre med det. Er nå lettere
å endre størrelse på spillvinduet og brettet.
Alle: Begynte å se på design. Finne ut hvor ting skal være i spill vinduet og hva som skal være der.
Tegnet opp skisser for å visualisere dette.

**Til neste gang:**  
Se videre på hvordan vi skal visualisere forskjellige deler i spillvinduet, sli kat vi kan sette igang for å legge inn bildene i koden på neste møte.

---

### **Fredag** | 24-04 (Jens, Kasper, Thomas)

**På møtet:** 
Lagde Enum for programkort og en klasse som viser kortene som er låst inn. Alle kort får også en tilfeldig
prioriteringsverdi når de lages.  
Kan nå vise 5 valgte kort som skal kjøres gjennom i løpet av en runde.

**Til neste gang:**  
Jens: Få laget et ordentlig spillbrett.

---

### **Fredag** | 01-05 (Jens, Kasper, Thomas)

**Fra forrige gang:**  
Jens: Lagde spillbrettet "Risky Exchange" fra regelboken. Mangler muligheten for å legge til
spawn-område.

**På møtet:**  
Thomas & Kasper: Oppdaterte CSVReader / Board til å kunne lese alle board størrelser. Rendring av board er nå dynamisk, 
slik at den holder seg inne i max-width og max-height, uansett størrelse og dimensjoner. Kan derfor nå legge til
spawn-område.  
Jens: Begynte å implementere de resterende "tiles" som skal aktiveres under en fase. Pushers og 
Gears fungerer nå som de skal. Pushers fungerer som vegg i tilegg til å dytte robot i retningen den peker
på runden pusheren er aktivert. Gears roterer roboten i retnigen pilene hviser.

**Til neste gang:**  
Jens: Legge inn riktig tiles til spawn-området. Legge til noen Pushers på brettet.

---

## Manuelle tester

### Robot Conveyor Belt Movement

For å teste dette, så plasserer vi en robot manuelt på et conveyor belt og bruker "mellomroms-tasten" til å kjøre en phaseChange.
Vi kan dermed se at alt fungerer som det skal.

Note: Må oppdatere b1 for å teste alle versjoner.
1. Plassere robot på cbelt
2. Bruk mellomroms-tasten for å se steg for steg hva som skjer med roboten (rett frem og i hjørner).
3. Samme som i 1 og 2, men på fast conveyor belt

### Robot push movement

For å teste push på robotene så plasserer vi ekstra spawnpoints i b1.csv filen og plasserer alle robotene på en linje, alle blir da pushet rekursivt oppover, og hvis de går out-of-bounds så returnerer de til spawn-pointet sitt.

1. Bruker høyre eller venstre piltast til å rotere robot1
2. Snur robot2 slik at den ser mot robot 1.
3. Fortsetter å rotere robot1 slik at den ikke beveger seg vekk.
4. Beveger robot2 frem i feltet til robot1 og ser at begge robotene bevegr seg et felt frem.

### Visualisering av alle tiles

For å teste at alle tiles vises korrekt må man først gå inn i game og endre create() metoden. Der bytter man ut new Board("b1.csv") med new Board("b0.csv"). Deretter kjøres main for å se at brettet med alle tiles vises korrekt.

Vi kan da gå gjennom tilelocation.json i "assets/sprites" for å se om alle verdiene passer.

---

## UML-diagram

![alt text](..\deliverablesAssets\diagrams\classDiagramOblig3.png "Class digram Oblig3")

---

## Presentasjon av prosjekt - Robois

Kort om prosjektmetodikk: hvordan jobber dere?

- Jobber på møter 2-3 ganger i uken (Mandag, onsdag, fredag)
  - Mandager brukes ofte til å planlegge for resten av uken (eller 2 uker fremover) (Vis til TODO - prosjekt).
  - Bruker LiveShare for å jobbe med kode (Utdyp).  
    - Commits fra kode i møter kommer fra Teamleader.

Hva har fungert best frem til nå?

- LiveShare
- Kommunikasjon og flyt i gruppen

Hva har dere lært mest av frem til nå?

- Hvordan strukturere prosjektet.
  - Navngivning av tester
  - Mappestruktur av klasser osv.
- Gruppearbeid trenger mye mer planlegging enn forventet.

Hva er viktigst å jobbe med fremover?

- Implementere tiles: Hull, robot-kollisjon