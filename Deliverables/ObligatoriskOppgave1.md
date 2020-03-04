# __Obligatorisk oppgave 1__

## Deloppgave 1: Organiser teamet

### Kompetanseoppsummering

__Thomas:__

> Går 2 året på Datateknologi og har jobbet en god del med .Net og .Net Core.

__Jens:__

> Går 2. året datateknologi. Har jobbet med java, python og haskell gjennom fagene i studiet. Føler meg ganske trygg på java syntax, og har vært så vidt innom git før.

__Yafet:__

> Startet Datateknologi og er på 2. året. Har for det meste oversikt over Java, Python og Haskell blant annet. Har vært borti github og gitlab og har litt forståelse for git.

__Kasper:__

> Har tidligere erfaring med java og en rekke andre kodespråk. Lagd en rekke egne prosjekter og spill på fritiden. Følger vanlig studieløp under informatikk: Datateknologi og er på 2. året nå.

### Team-roller

_(Alle jobber forløpig sammen på backend.)_  
__(Thomas) Teamleader:__

> Har mest erfaring med jobbing i prosjekt og genrelt innenfor programmering.

__(Kasper) Ui-ansvarlig:__

> Har god erfaring med UI-design og -oppsett fra tidligere prosjekter.

__(Jens) Kundekontakt:__
> God til å kommunisere med andre og ha oversikt over større prosjekter og hvordan de fungerer.

__(Yafet) Networking:__
> Virket interresant å vite hvordan det fungerer å implementere multiplayer og har derfor god motivasjon til å fullføre oppgaven.

---

## Deloppgave 2: Få oversikt over forventet produkt

__Overordnet mål:__
Lage et spillbart program med funksjoner og regler som angitt i regelboken for klassisk RoboRally.

__Krav til det fullstendige systemet:__

- vise spillebrett
- vise spiller
- vise flere spillere
- vinne spillet
- avslutte spillet
- kunne dele ut kort
- besøke et flagg
- kunne utføre lovlig trekk
- dele ut kort
- robot kan miste et liv
- spiller kan dø
- prioritering avgjør rekkefølge på robotenes - bevegelser i hver fase
- prioritering gjøres på nytt for hver fase
- robot kan få skade
- robot kan få reparert skade
- velge spillebrett
- robot fyrer av laser
- plassere flagg
- ta backup
- når nest siste spiller er ferdig skal timeren på 30 - sek settes igang
- spiller kan programmere roboten
- godkjenne program for runden
- robot dør hvis den havner i hull
- robot dør hvis den havner utenfor brettet
- robot dør hvis den får 10 i skade
- antall kort justeres utfra mengden skade roboten har
- robotens død fjerner optionskort
- spille en runde
- vegger stopper bevegelse hos robot
- vegger stopper lasere
- vegger ligger mellom to brikker
- robot stopper laser
- en robot kan dytte en annen
- spiller annonserer powerdown
- robot er i powerdown
- aktivere robot fra powerdown
- samlebånd beveger robot
- gjennomføre en fase
- tannhjul roterer robot
- samlebånd kan rotere robot
- få et optionskort
- bruke optionskort
- velge brett før spillet begynner

(kravene er bassert på regelboken for klassisk RoboRally.
Vi ønsker å emulere det originale brettspillet best mulig.)

__Prioriteringsliste til første iterasjon:__

1. Lage brett
2. Vise brett
3. Plassering av brikker

---

## Deloppgave 3: Velg og tilpass en prosess for laget

__Prosjektmetodikk:__ Test-driven development + Kanban, parprogrammering.

__Viktige aspekter ved prosessen:__

- Sette opp faste tider i uken til ekstra møter utenom den obligatoriske gruppetimen.
- Kommunisere godt med resten av gruppen når man gjør noe nytt slik at det blir enkelt å følge opp det arbeidet som blir gjort.
- Bruke førstkommende møte i uka til prosjekteringsaktiviteter for å finne ut av hva som må gjøres i løpet av uka (+-).
- Parprogrammere. (Bruker liveshare på visual studio code slik at vi kan bruke flere pc’er på samme kode samtidig).

__Team planlegging:__

- Minst to faste møter i uken. Eventuelt ekstra møter om nødvendig eller møter over skype/discord.
- Bruke slack/discord for å snakke og kommunisere mellom møtene. Viktig å sende felles informasjon i gruppechat.
- Fordele arbeid likt og sørge for at alle får med seg de endringene som blir gjort.
- Kommunisere endringer som blir gjort.
- Lager mappe i git/slack til felles dokumenter og diagram etc.

---

## Deloppgave 4: kode

### Brukerhistorier

__Brukerhistorie (Vise et brett):__  
> Som spiller trenger jeg å se brettet for å få til å programmere roboten
>
>__Akseptansekriterier:__
>
>- Brettet skal vises som 12 x 12 (tiles)
>- Hver tile har basisutseende (str: 70px)
>
>__Arbeidsoppgaver:__
>
>- Designe basisbrikke
>- Implementere brett-klasse
>- Modellere/designe struktur i koden
>- Implementere Tile

__Brukerhistorie (Plasserer robot/brikke på brett):__  
> Som spiller må jeg kunne se en bevegelig brikke for å kunne utføre et trekk
>
>__Akseptansekriterier:__  
>Roboten
>
>- skal vises på en gitt start-tile
>- skal ha et unikt utseende
>- må ha en retning
>- må kunne beveges i alle kardinale retninger.
>- må kunne rotere i kardinale retninger.
>
>__Arbeidsoppgaver:__
>
>- Designe en robot
>- Implementere en robot

---

## Møtereferat

### __fredag__ | 31.01.20

Satt opp prosjektet på alle sine pc'er og begynte på oblig1. Planla møter for neste uke.

### __mandag__ | 03.01.20

Installerte java 13, koordierte Visual Studio Code på alle sine pcer for å bruke liveshare til å parprogrammere. Satte opp prosjektstruktur og fullførte del 3 på oblig1.

### __onsdag__ | 05.01.20

Begynte og fullførte kode for å vise ett brett. Designet robot til implementering.

### __fredag__ | 07.02.20

Implementerte robot. La til codacy. Endret implementering av hvordan bildene blir håndtert. Ryddet opp i filer og fullførte oblig1.

---

## UML-diagram

![alt text](..\deliverablesAssets\diagrams\classDiagramOblig1.png "Class digram Oblig1")

---

## Oppsummering

Fungerte bra:

- liveShare
- Kommunikasjon
- Oppgavefordeling
- Samarbeid
- Alle innvolveres

Fugerte ikke helt som ferventet:

- Fikk ikke fokusert helt på tdd.
- Holde commits til en topic av gangen.  

__tdd:__ Vi begynte bra, men fikk dårligere tid mot slutten, som gjorde at tdd ble for tidskrevende siden ingen av oss har jobbet slik før. Fikk også problemer med å teste på grunn av at LIBgdx må ha en aktiv instans av spillet for å kunne teste metodene implementert av LIBgdx. Måtte seperere LIBgdx sine funksjoner fra våre klasser, slik at vi i det hele tatt kunne teste. Har fikset dette nå, så satser på å fortsette med tdd i neste oblig.

__commits__: Alle har jobbet litt med alt, og på grunn av liveShare som kun kjøres fra en pc(thomas), så har alle commits gått gjennom hans pc. Som følge av dette ble det noen ganger flere topics i samme commit.

__liveShare:__ Åpnet for muligheten til at alle kunne sitte å jobba på samme koda i realtime når vi var på møter. Dette økte effektiviteten på prosjektarbeidet i møtene.
