# Oblig 4

## Deloppgave 1: Team og prosjekt

### Hvordan fungerer rollene i teamet?

- Rollene har fungert bra, men etter at vi mistet ett medlem så har vi måtta fordele litt ekstra ansvar på oss som var igjen.

- Vi måtte endre på hvem som gjorde hva etter Yafet ikke skulle være med på gruppen lengere.

- Kasper har gjordt en god job som design ansvarlig, han har laget alt av grafiske assets.

- Jens har holdt styr på alle spillreglene og passet på at Markdown-filene våre var gode.

### Er det noen erfaringer enten team-messig eller mtp prosjektmetodikk som er verdt å nevne?

- Det er vanskelig og krever mye tid å holde seg til en måte å jobbe på dersom ingen har gjort det før. Vi begynte med tdd, men gjikk bort fra det ettersom prosjektet ble større og var vanskelig å teste automatisk.  
Bortsett fra det synes vi at vi har tatt gode valg og jobbet effektivt sammen.
- Vi har også brukt Kanban som har fungert veldig bra og klart å opprettholde gjennom hele prosjektet.

### Gjør et retrospektiv hvor dere vurderer prosjektet har gått

- Prosjektet har gått veldig bra. I begynnnelsen slet vi litt med å fordele oppgaver effektivt slik at alle alltid hadde noe å gjøre. Vi Synes det derfor var best å ha intensive møter der man jobbet og heller gjøre "research" utenom.  
Etterhvert ble vi bedre på å fordele arbeid slik at alle jobbet på sine branches og vi lett visste hva alle hold på med til enhver tid.  
Hadde vi begynt på nytt nå, så hadde vi nok kommet i gang på en mye mer effektiv måte mtp arbeidfordeling og at vi kunne jobbet remote i mye større grad (Ble mye bedre på dette etter nedstegning av UiB). Ellers hadde vi ikke gjort så mye annerledes.

### Project board

Alt ble gjort ferdig, men fikk ikke begynt noe særlig på Nice to Have.

![alt text](..\deliverablesAssets\projectBoardOblig4.png "Class digram Oblig3")

### Hvordan fungerer gruppedynamikken og kommunikasjonen nå i forhold til i starten? Hvordan påvirket karantene og nedstengning teamet og fremdriften?

- Gruppedynamikken og kommunikasjonen har alltid vært ganske god. Alle har hele tiden vært flinke på å skrive gode navn og commit-meldinger, som har gjort det enkelt å henge med på hvor de forskjellige medlemmene ligger an i prosjektet og hva som har blitt gjort.  

- Det som hovedsakelig endret seg etter nedstegningen var kommunikasjon på møtene. Vi tegnet mye og brukte figurer for å visualisere for hverandre, noe som ble påvirket en del. Vi prøvde å bruke paint og dele skjerm eller sende skjermbilder, noe som fungerte til en viss grad.  
På møtene har vi hele tiden brukt liveShare i vs code for å jobbe sammen, så dette endret seg ikke noe særlig av å jobbe remote uansett.

## Deloppgave 2: Krav

- Vi har implementert alle funksjonene for spillet som hører med i mvp.

**Brukerhistorie (HP)**:

>Som spiller trenger jeg HP slik at jeg vet hvor mye skade roboten min har tatt for å dele ut riktig antall kort og for at roboten kan dø.
>
>**Akseptansekriterier:**  
>
>- En robot starter med 10 HP
>- En robot dør dersom den mister 10 HP
>
>**Arbeidsoppgaver:**
>
>- Legge til HP i Player klassen.
>- Legge til funksjonenr i player klassen for å miste eller få HP.

**Brukerhistorie (Lives)**:

>Som spiller trenger jeg Life for at roboten kan tape spillet om den dør for mye.
>
>**Akseptansekriterier:**  
>
>- En robot starter med 3 Lives
>- En robot muster ett liv om den mister all Hp aller faller i hull/utenfor mappet
>- En robot taper spillet om den mister alle livene
>- En robot respawner med 8 HP om den mister et liv
>
>**Arbeidsoppgaver:**
>
>- Legge til lives i PLayer klassen.
>- Oppdatere respawn-funksjonen

**Brukerhistorie (Pusher)**:

>Som spiller trenger jeg at roboten kan bli dyttet av pushere slik at disse tilesene følger spillreglene.
>
>**Akseptansekriterier:**  
>
>- En robot blir dyttet av en pusher i den retningen pusheren peker hvis pusheren er aktiv og roboten står i samme tile.
>
>**Arbeidsoppgaver:**
>
>- Legge til en måte for pushere å dytte roboter på.

**Brukerhistorie (Gear)**:

>Som spiller trenger jeg at roboten kan bli rotert av gears slik at disse tilesene følger spillreglene.
>
>**Akseptansekriterier:**  
>
>- En robot blir rotert av en gear-tile i den retningen pilene på gear viser.
>
>**Arbeidsoppgaver:**
>
>- Implementere gear-klassen slik at den roterer en robot
>- Oppdatere gamePhase slik at den kjører gears i hver fase.

**Brukerhistorie (Lasers)**:

>Som spiller trenger jeg at roboten kan bli truffet av lasere slik at den kan miste HP og få mindre programkort.
>
>**Akseptansekriterier:**  
>
>- En robot tar 1 skade av single laser, dersom den står i skuddlinjen til laseren.
>- En robot tar 2 skade av double laser dersom den står i skuddlinjen til laseren.
>
>**Arbeidoppgaver:**
>
>- Implementere laserklassen med forskjellige dmg verdi
>- Oppdatere GamePhase til å Kjøre alle lasere etter at alle  bevegelser har skjedd.
>- Lage en funksjon i GamePhase som finner alle beams utfra lasere og damager roboter som står i en beam-tile.

**Brukerhistorie (Wrench)**:

>Som spiller trenger jeg at roboten kan bli reparert av wrenches om den står på en tile med wrench i slutten av en phase for at roboten skal kunne få HP.
>
>**Akseptansekriterier:**  
>
>- En robot får 1 HP av single wrench, dersom den står på wrench tile i slutten av en phase.
>- En robot får 2 HP av double wrench dersom den står på wrench tile i slutten av en phase.
>- Flytter backupen til roboten.
>
>**Arbeidoppgaver:**
>
>- Implementere wrench klassen med forskjellig repair verdi.
>- Legge til funksjon i Player som kalles for å repaire roboten.
>- Oppdatere GamePhase for å sjekke om du står på en wrench-tile.

**Brukerhistorie (Flag)**:

>Som spiller trenger å kunne plukke opp flag for å vinne spillet
>
>**Akseptansekriterier:**  
>
>- En robot plukker opp flagg 1 om den står på flagget i slutten av en phase.
>- En robot plukker opp flagg x om den allerede har flagg x-1.
>- En robot vinner spillet omd en plukker opp alle flaggene i et spill.
>
>**Arbeidsoppgaver:**
>
>- Implementere Flag-klassen
>- Legge til en måte å plukke opp flagg i GamePhase og sjekke om man har vunnet spillet.

**Brukerhistorie (ProgramCard)**:

>Som spiller trenger jeg programkort for å programmere roboten slik at jeg kan gjennomføre en runde
>**Akseptansekriterier:**  
>
>- Programkort kan velges i starten av en runde.
>- Programkort programmerer roboten slik som kortene viser
>
>**Arbeidsoppgaver:**
>
>- Implementere alle de forkskjellige programkortene
>- Implementere en måte å velge kort på.

- Har ikke gjort noen store endringer siden sist mtp hva som skal være med i MVP. Dvs at vi fortsatt følger det som har blitt gitt av kunden.  
Hovedkravene vi annser som en del av MVP er å implementere de tilesene som er blitt oppgitt. Kunne programmere en robot med programkort til å plukke opp flagg, ta skade, dø eller å vinne spillet.  
Eneste endring er at vi ikke skal ha multiplayer pga. nedstegning av universitetet og at vi mistet ett team-medlem som skulle ta seg av dette. Istedenfor har vi lagt inn bots. Disse gjør bare tilfeldige trekk, men gjør at spillet er spillbart med flere roboter.

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
Thomas & Kasper: Oppdaterte CSVReader / Board til å kunne lese alle board størrelser. Rendring av board er nå dynamisk, slik at den holder seg inne i max-width og max-height, uansett størrelse og dimensjoner. Kan derfor nå legge til
spawn-område.  
Jens: Begynte å implementere de resterende "tiles" som skal aktiveres under en fase. Pushers og Gears fungerer nå som de skal. Pushers fungerer som vegg i tilegg til å dytte robot i retningen den peker
på runden pusheren er aktivert. Gears roterer roboten i retnigen pilene hviser.

**Til neste gang:**  
Jens: Legge inn riktig tiles til spawn-området. Legge til noen Pushers på brettet.

---

### **Lørdag** | 02-05 (Jens, Kasper, Thomas)

**Fra forrige gang:**  
Siden vi tok møtet dagen etterpå, ble ingenting gjort i mellomtiden.

**På møtet:**  
Thomas & Kasper: Implementerte "Hand" klassen, hvor en spiller velger kortene sine, og har implementert bakgrunn til spillbrettet.
Lagde informationDisplay UI klassen som kan vise informasjon til spilleren gjennom tekst.  
Jens: Begynte å implemtere lasere. Disse oppfører seg nå som vegger, men gjør ikke skade enda.  
Implementerte flag. Flag kan nå plukkes opp, men bare i riktig rekkefølge. Når man plukker opp et flag
vil man endre respawn-location til der man plukket opp flagget.
Player-klassen har nå flere funksjoner for å behandle skade, spawn og flag.

---

### **Søndag** | 03-05 (Jens, Kasper, Thomas)

**Fra forrige gang:**  
Siden vi tok møtet dagen etterpå, ble ingenting gjort i mellomtiden.

**På møtet:**  
Thomas: Implementerte en inputAdapter for å styre muse-klikk. Implementerte velging av kort fra de 9 kortene du kunne velge mellom til kortene som roboten skal bruke. Endret på hvordan begge hendene ble rendret.  
Jens & Kasper: Implementerte lasere, slik at roboter kan ta skade av dem og at de stopper når de treffer noe. Roboter kan nå også dø av å ta 9 skade og respawner da på korrekt spawn-location med 9 hp igjen.  
Fasehåndteringen er delt inn i de forskjellige delene, slik at beveglse skjer før lasere skytes og flagg, repairs og backup skjer etter lasere er fyrt av.

---

### **Fredag** | 08-05 (Jens, Kasper, Thomas)

**Fra forrige gang:**  
Thomas: Startet implementasjon av game loopen. Før dette måtte vi bruke WASD for å styre roboten, nå ble det mulig å velge kortene, men denne implementasjonen ble ikke helt ferdig.
Jens: Implementerte måte å vinne og tape spillet på. La til EndGameScreen og StartGAmeScreen. Knapp i EndGameScreen for å gå tilbake til StartGameScreen.  
Viser nå all informasjon i displayet under Spillbrettet.  
Player har np liv i tilegg til hp. Man starter med 3 liv og dersom man mister alle livene, er man helt ute av spillet (Spillet avsluttes siden du er eneste spiller).

**På møtet:**  
Alle: Vi ullførte implementasjon av game loopen med en random AI, la også inn en knapp for å starte game loopen. Selve logikken var ikke så veldig vanskelig, men å legge inn et delay mellom hvert move så ble det mye vanskeligere.  
Fullførte designet på spillet, dvs, grafiske elementer rundt kort, endgame display, og start display.  
Implementerte laserene til robotene.

Kasper: Lagde flere UI-elementer.

---

## Tester

Automatiske tester ligger i `src/test/java/inf112.skeleton.app`

### Manuelle tester

Bruker [test controls](../README.md#test-controls) for å plassere roboten der vi vil ha den.  
**Før man tester:** Gå inn i `src/main/java/inf112.skeleton.app/Game.java` og sjekk at `filename: "b1.csv"`  

```java
39 | public void create() {
40 |     try {
41 |          board = new Board(filename);
```

Husk å skifte tilbake til `filename: "b_re.csv"` når man vil spille spillet.

#### Bevegelse tester

##### Robot Conveyor Belt Movement

For å teste dette, så plasserer vi en robot manuelt på et conveyor belt og bruker "mellomrom-tasten" til å kjøre en phaseChange.
Vi kan dermed se at roboten beveger seg sammen med conveoyr beltet.

1. Plassere robot på cbelt
2. Bruk mellomroms-tasten for å se steg for steg hva som skjer med roboten (rett frem og i hjørner).
3. Samme som i 1 og 2, men på fast conveyor belt

##### Gear test

Sjekk at gear-tiles roterer roboten i riktig retning

1. Styr roboten på grønn gear
2. Trykk **space** og se at roboten roterer 90 grader med klokka
3. Stryr roboten på oransje gear
4. Trykk **space** og se at roboten roterer 90 grader mot klokka

##### Pusher test

Sjekk at pushere dytter roboten ett felt i retning pusher peker når den er aktivert

1. Styr roboten på en pusher tile med nr 1, 3 og 5
2. Trykk **space** og se at pusher dytter roboten hvis det sto "Phase: 0" før Phase-start.
3. Gå tilbake til pusher tilen
4. Trykk **space** flere ganger og se at den bare dytter deg på oddetall phases.

- Gjør det samme for pusher tile med nr 2 og 4 og sjekk at den bare dytter i partall pahses.

##### Robot push movement

1. Bruker test kontrollene til å bevege din robot.
2. Styrer din robot inn i feltet til en av de andre robotene og ser at
den roboten du kræsjer med vil flytte seg et felt i samme retning.

3. Sjekker at dersom man dytter en robot utenfor brettet, returnerer den til sin spawn.

4. Sjekker det samme som i punkt 3, men for hull.
5. Sjekker at dersom man dytter en robot i en vegg, så beveger ingen seg.

##### Program Card test

Velg brett "b1t.csv" for å teste dette bedre på et tomt brett. (Følg instruksene under [Manuelle tester](#manuelle-tester) for å skifte brett)  
Sjekk at programkort programmerer roboten din korrekt. (Velg bare ett kort for hver sjekk)  
Trykk "**O**" for å få nye kort dersom det trengs.  
Dersom roboter dør, må du starte spillet på nytt og fortsette testen.

0. Trykk på blå pil (Uten programkort skal alle roboter bevege seg bortsett fra din)
1. Velg kort **MOVE 1** og utfør step **0.**
2. Velg kort **MOVE 2** og utfør step **0.**
3. Velg kort **MOVE 3** og utfør step **0.**
4. Velg kort **MOVE BACKWARDS** og utfør step **0.**
5. Velg kort **ROTATE LEFT** og utfør step **0.**
6. Velg kort **ROTATE RIGHT** og utfør step **0.**
7. Velg kort **U-TURN** og utfør step **0.**

- Sjekk at kortene gjør det de skal

#### Damage and repair tests

##### HP-test-Damage

Sjekk at roboten mister HP av å stå inni en laser når den skyter

1. Styr roboten foren en laser tile.
2. Trykk "space" for å starte en phase.
3. Se at HP synker med 1 dersom det er single laser og 2 i double laser.

##### HP-test-Repair

Sjekk at roboten får HP av å stå på flag eller repair site. (Max 10)

1. Styr roboten på en repair site(wrench).
2. Trykk "space" for å starte en phase.
3. Se at HP øker med 1 dersom det er single wrench og 2 på double wrench.
4. Se at man også får 1 HP av å stå på en Flag tile

- Kjør testen når man allerede har 10 hp for å se at du ikke kan få mer enn 10.
- Gjør det samme på double wrench tile for både 9 og 10 HP.

##### Life test

Sjekk at roboten liv av å bli ødelagt

- Sjekk at dersom man gjør [HP testen](#HP-test-Damage) helt til man ikke har mer HP
så vil man respawne på forrige backup, og miste 1 av 3 liv.

- Styr roboten utenfor brettet og se at man mister 1 liv.

- Se at dersom man mister alle 3 livene, så avsluttes spillet.

#### Win Game test

Sjekk at du vinner av å plukke opp alle flaggene i korrekt rekkefølge

1. Styr roboten på flagg 4 og trykk på **space**
2. Styr roboten på flagg 3 og trykk på **space**
3. Styr roboten på flagg 2 og trykk på **space**
4. Styr roboten på flagg 1 og trykk på **space**
5. Se at du ikke vinner spillet, og at du nå bare har 1 flagg
6. Plukk opp flaggene i motsatt rekkefølge (riktig rekkefølge) og se at "Flags: 0" øker med 1 for hvert flagg.

### Visualisering av alle tiles

For å teste at alle tiles vises korrekt må man først gå inn i game og endre brettet som skal kjøres på samme måte som forklart under [Manuelle tester](#manuelle-tester), til "b0.csv". Her skal alle tiles som brukes i spillet vises.  

Sjekker at det ser likt ut som på bildet:
![alt text](..\deliverablesAssets\b0.png "Class digram Oblig3")

---

## UML-diagram

![alt text](..\deliverablesAssets\diagrams\classDiagramOblig3.png "Class digram Oblig3")
