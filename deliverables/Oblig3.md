# Oblig 3

## Deloppgave 1: Team og prosjekt

- Rollene i teamet fungerer fortsatt bra så langt. Har ikke hatt behov for å gjøre noen endringer mtp det.

- Vi merker at det krver mye tid og god kommunikasjon for å få et godt teamarbeid. Alt må diskuteres og bli gjort en enighet rundt. Vi har fikset det ganske bra, men brukte bare litt lenger tid i starten enn det som var forventet. Liveshare gjør det blant annet enda bedre å få et godt og effektivt samarbeid nå i disse koronatider.

- Igjen så har vi ikke brukt så mye tdd, noe som vi sa helt fra starten av at vi skulle prøve oss på. Dette er hovedsakelig fordi ingen av oss hadde jobbet på denne måten før, og synes derfor det var tidskrevende og lite effektivt å jobbe på denne måten. Allikevel føler vi at vi har fått testet det ut på deler av prosjektet, noe som har gitt oss litt erfaring innen denne måten å jobbe på. Ellers fungerer måten vi går frem i prosjektet veldig bra. Dette innebærer å åpne en ny branch når vi begynner på noe nytt, og oppdatere prosjektboardet og fester de aktuelle TODO-kortene til den branchen som er relevant. Dette har gitt god oversikt for oss på hva som har blitt gjort, hvem som har gjort hva, hva som holder på å bli gjort og hva som må gjøres.
Siden vi nå jobber hjemmefra, så har vi ikke alltid hvert så flinke til å møtes like hyppig og er ikke like nøye på tidene vi har avtalt å møtes.

- Vi må bli flinkere til å være klar på discord med fungerende utstyr til den tiden vi har avtalt.  
Bortsett fra det, har vi ikke hatt noe andre problemer med måten vi jobber med prosjektet på som vi klarer å se selv.

- Vi prioriterer fremover å få implementert funksjonalitet til alle tiles. Deretter lage faser slik at vi ser at alle tiles fungerer riktig med hverandre. Etter det vil vi begynne å se på programkort, skade og liv til robotene og få inn hele runder i spillet.  
På prosjektboardet kan du se hva vi holder på med nå, hva som skal bli gjrot i løpet av hver uke, og hva som er det neste som skal bli gjort i ukene som kommer.  
![alt text](..\deliverablesAssets\projectBoardOblig3.png "Class digram Oblig3")

- Gruppedynamikken og kommunikasjonen fungerer fortsatt like bra, selv om vi ikke kan møtes fysisk. Vi er gode med å dele og kommunisere hva som blir gjort og eller andre viktige deler av prosjektet. Som sagt er liveshare i VSCode ett godt verktøy som hjelper mye med at alle klarer å følge med på og bidra til hva som blir gjort av programmering. Vi slipper da unødvendig mange commits, eventuelle merge conflicts og at enekelte eventuelt overser kommentarer e.l. i git eller andre steder som gjør det vanskelig å forstå hva som har blitt gjort.

## Deloppgave 2: Krav

- Vi har nesten implementert alle funksjonene til tiles i spillet og deretter blir det å implementere selve rundene i spillet og utvide user interfacet. Siden forrige gang har vi lagt til at roboter kan dytte andre roboter. Vi kan nå også vise alle tiles på brettet og vi har implementert noe av funksjonaliteten til tilesene.

**Brukerhistorie (Implementere grafikk for tiles)**:

>Som spiller trenger jeg å se alle interaktive "tiles" på brettet slik at jeg kan styre roboten med hensyn til disse.
>
>**Akseptansekriterier:**  
>
>- Må kunne se alle tiles visuelt med sin korrekte grafikk.
>
>**Arbeidsoppgaver:**
>
>- Implementere en bedre måte å få informasjonene om tiles på, kanskje en JSON fil? (Dette vil gjøre det mye mer dynamisk å implementere nye tiles).
>- Gå gjennom alle tiles for å registrere de tilsvarende x-y koordinatene.
>- Lage en klasse for hver tile, for å gi dem informasjon som passer til den spesifikke tilen, f.eks. Conveyor Belt trenger informasjon om retning. Men dette trenger vi ikke å implementere helt enda, fordi vi vil bare se tilene i første omgang.

**Brukerhistorie (Dytte roboter)**:

>Som spiller trenger jeg å kunne dytte andre roboter med min robot slik at det ikke kan gå to roboter på samme plass og at spillet inneholder korrekte regler.
>
>**Akseptansekriterier:**  
>
>- En robot dyttes av en annen istedenfor at de går på samme sted.
>- En robot kan ikke dyttes gjennom vegger.
>
>**Arbeidsoppgaver:**
>
>- Lage logikk i GameMovement slik at robotene reagerer med hverandre rekursivt. Dvs. Hvis en robot treffer en annen, så skal den andre roboten bevege seg.

**Brukerhistorie (Conveyor belts)**:

>Som spiller trenger jeg at roboten kan bli flyttet av conveyor belts slik at disse tilesene følger spillreglene.
>
>**Akseptansekriterier:**  
>
>- En robot blir dyttet av ett conveyor belt i den retningen beltet viser
>- En robot blir dyttet og roterer i den retningen beltet viser dersom det er et hjørne.
>
>**Arbeidsoppgaver:**
>
>- Legge til en måte for conveyor belts å flytte roboter på.
>- Legge til en måte for conveyor belts å rotere roboter på.

- Har ikke gjort noen endringer siden sist mtp hva som skal være med i MVP. Dvs at vi fortsatt følger det som har blitt gitt av kunden.  
Hovedkravene vi annser som en del av MVP er å implementere de tilesene som er blitt oppgitt. Kunne programmere en robot med programkort til å plukke opp flagg, ta skade, dø eller å vinne spillet. I tilegg kunne spille flere stykker om gangen.

## Deloppgave 3: Produktleveranse og kodekvalitet

Programmet startes ved å kjøre main. Da vil det dannes en ny innstans av game(), som lager brettet og tilhørende objekter.
Testene sjekker at brettet blir laget korrekt(Ingen endring siden forrige Oblig) og at Roboten beveger seg som den skal. Dvs. at den går riktig utifra hvor mange ruten den har fått beskjed om å bevege seg og at roboten ikke kan gå gjennom vegger. I tilegg sjekkes det at den roteres riktig.
Tester at spiller visuelt ser korrekt ut ved å kjøre gjennom manuelt. Dette er å sjekke at bildet av roboten viser riktig utifra hva roboten faktisk gjør, og at veggene blokkerer i riktig retning. Sjekker dette ved å styre roboten på alle mulige måter og prøve å bevege roboten gjennom de forskjellige typene vegger (både fra en Wall-tile og fra en Floor-tile inn i en Wall-tile).

## Møtereferat

### **Onsdag** | 04-03  (Jens, Kasper)

Implementerte Hull med tdd. Kan nå falle inn i hull på samme måte som når man faller utenfor mappet. Diskuterte respawn-mekanikk: Om vi kan velge respawn-retning eller ha en fast. Kom frem til at vi implementerer det senere. Fikset opp i markdown-filene slik at de har god kvalitet.

---

### **Fredag** | 06-03 (Jens, Kasper, Yafet, Thomas)

Implementerte At roboter kan dytte hverandre. For å gjøre dette oppdaterte vi move-funksjonene til å ta med game. Dette gjør at vi kan hente robotene på brettet når vi vil for å sjekke om en robot faktisk skal dytte en annen. Dette gjør at testing blir vanskelig siden vi ikke kan lage en instance av game når vi kjører testene. Tester derfor robot-dytting manuelt.

---

### **??** | d-m (Kasper, Thomas)

(TODO)

---

### **Fredag** | 13-03 (Jens, Kasper, Thomas, Yafet)

Thomas jobbet med å rendre alle tiles og brikker slik at vi kan implementere dem.  
Kasper jobbet med UI (design til start menu).  
Jens ryddet opp i testene og endret strukturen slik at hver tile har sin egen test-klasse istedenfor at alt ligger i Robot. Yafet så på networking og begynte å se på løsninger for å få til dette.

---

### **Fredag** | 20-03 (Jens, Kasper, Thomas, Yafet)

**Fra forrige gang:**
Kasper så på programkort, men fikk problemer da vi ikke har noe prioriterings nummer å gå utifra ettersom reglene for roborally ikke ligger ute lenger.
Jens og Thomas begynte å se på hva som måtte implementeres først, nå som alle tiles kunne rendres.  

**På møtet:**  
Alle jobbet sammen i liveshare for å begynne og implementere resterende tiles. Diskuterte logikken om hvordan conveyor belts skal fungere i forhold til dytting av andre roboter på conveyor belts (hvilken rekkefølge conveoyr belts påvirker roboter osv). Fant ut at dette fort blir unødvendig avansert, og følger heller prioritering av robotene når rekkefølgen av dytting gjennomføres. Fikk implementert funksjonalitet til conveyor belts, bortsett fra rotasjon. Fant ut at vi trengte en måte å finne relativ retning til robot i forhold til conveyor belts, så tok litt lenger tid enn antatt.

**Til neste gang:**  
Få gjort ferdig rotasjon av conveyor belts, slik at vi kan gå videre til å implementere gjenverende tiles. Foreløpig jobber alle med dette siden det er såpass elementært i forhold til spillets gang at alle forstår hvordan det fungerer.

---

### **Fredag** | 27-03 (Jens, Kasper, Thomas, Yafet)

**Fra forrige gang:**  
Ingen jobbet noe særlig videre med prosjektet fra forrige gang, grunnet prioritering av andre obliger

**På møtet:**  
Alle jobbet sammen for å fikse conveyor belts, slik at de ble korrekt implementert og har all nødvendig funksjonalitet.  
Gikk over filene og skrev utfyllende javadocs.

**Til neste gang:**  
(Alle) Jobbe med oblig4, dvs. lage en ny plan for resten av oppgaven.
(Fordeler oppgaver neste møte) Fortsette implementasjon av tiles som enda ikke har funksjonalitet.

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