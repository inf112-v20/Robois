# Oblig 3

(TODO)

## Brukerhistorier

(TODO)

## Møtereferat

### **Onsdag** | 04-03  (Jens, Kasper)

Implementerte Hull med tdd. Kan nå falle inn i hull på samme måte som når man faller utenfor mappet. Diskuterte respawn-mekanikk: Om vi kan velge respawn-retning eller ha en fast. Kom frem til at vi implementerer det senere. Fikset opp i markdown-filene slik at de har god kvalitet.

---

### **Fredag** | 06-03 (Jens, Kasper, Yafet, Thomas)

Implementerte At roboter kan dytte hverandre. For å gjøre dette oppdaterte vi move-funksjonene til å ta med game. Dette gjør at vi kan hente robotene på brettet når vi vil for å sjekke om en robot faktisk skal dytte en annen. Dette gjør at testing blir vanskelig siden vi ikke kan lage en instance av game når vi kjører testene. Tester derfor robot-dytting manuelt.

---

### **??** | ??-?? (Kasper, Thomas)

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
