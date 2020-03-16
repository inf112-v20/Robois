# Oblig 3

(TODO)

## Brukerhistorier

(TODO)

## Møtereferat

### **Onsdag** | 04-03  (Jens, Kasper)

Implementerte Hull med tdd. Kan nå falle inn i hull på samme måte som når man faller utenfor mappet. Diskuterte respawn-mekanikk: Om vi kan velge respawn-retning eller ha en fast. Kom frem til at vi implementerer det senere. Fikset opp i markdown-filene slik at de har god kvalitet.

### **Fredag** | 06-03 (Jens, Kasper, Yafet, Thomas)

Implementerte At roboter kan dytte hverandre. For å gjøre dette oppdaterte vi move-funksjonene til å ta med game. Dette gjør at vi kan hente robotene på brettet når vi vil for å sjekke om en robot faktisk skal dytte en annen. Dette gjør at testing blir vanskelig siden vi ikke kan lage en instance av game når vi kjører testene. Tester derfor robot-dytting manuelt. 

### **??** | ??-?? (Kasper, Thomas)
(TODO)

### **Fredag** | 06-03 (Jens, Kasper, Thomas)

Thomas jobbet med å rendre alle tiles og brikker slik at vi kan implementere dem.  
Kasper jobbet med UI (design til start menu).  
Jens ryddet opp i testene og endret strukturen slik at hver tile har sin egen test-klasse istedenfor at alt ligger i Robot.

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
