# TestiranjeStraniceFERITa
Projekt iz kolegija Metode tehnike i testiranja programske podrške

U ovom projektu se testira web stranica FERITa, fakulteta u Osijeku, url: https://www.ferit.unios.hr/2021/

Testovi su napisanu u JAVI koristeći ItelliJ IDEA.
Napisano je 5 test slučajeva:

1. Provjera početne stranice web stranice FERITa. Napravio sam posebnu klasu imena FeritHomePage koja sadrži potrebne atribute i metode kako bi provjerili je li se 
početna stranica FERITa uspješno učitala. Stranica je uspješno učitana ako se pronađe tekst "Linkovi:". Ovo je prvi test sa najvećim prioritetom. 

2. Provjera prijave sa AAIEDU podacima. Sa AAIEDU podacima bi se trebali moći prijaviti svi studenti fakulteta. Ovaj test provjerava odlazak sa FERITove stranice na 
AAIEDU prijavu. Napravljena je posebna klasa FeritLoginPage gdje se nalaze atribute i metode potrebne za prijavu. U klasi FeritTest gdje se nalaze svi testni slučajevi,
potrebno je promjeniti parametre za metode enterUserMail() i enterPassword() na mail i lozinku studenta ako se želi uspješno prijaviti, u suprotnom test će biti uspješan
ali će prijava biti odbijena.
 
3. Treći testni slučaj je provjera digitalnog rasporeda koji se nalazi na stranici. Opet je napravljena posebna klasa FeritClassSchedule koja sadrži atribute i metode potrebne
za odlazak na raspored, i odabir rasporeda za 1. godinu diplomskog studija, smjer DRC. Ako je raspored uspješno otvoren i ako se pronađe tekst gdje piše da se radi o
smjeru DRC 1. godina, test je uspješan.

4. Četvrti testni slučaj je provjera kako radi pretraga stranice. U klasi FeritHomePage je napravljena metoda za pretraživanje stringa koji je predan kao parametar. Parametar se
može promijeniti u klasi FeritTests, defaultni string koji se pretražuje je "corona". Ako je pretraga uspjela, test je uspješan. 

5. Posljednji test je provjera vodi li youtube ikona na FERITovoj stranici na ispravan youtube kanal. Napravljena je klasa FeritYTChannel sa atributima i metoda potrebnim za 
provjeru. Test klikne na YT ikonu na FERITovoj stranici, te provjerava ime kanala. Ako je ime kanala TvUnios, test je uspješan. Prilikom izvođenja ovog testa, mora se kliknuti
na "Slažem se" ili "I agree" kada Youtube pita za prihvaćanje kolačića. 

Projekt koristi WebDriverManager te zbog toga nije potrebno ručno skidati driver za browser koji se koristi. U projektu je napravljeno da se koristi Firefox browser ali moze
se koristiti bilo koji drugi uz male promjene metoda setupClass() i setup():

Chrome:
@BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get(testURL);
    }

Opera:
@BeforeAll
    static void setupClass() {
        WebDriverManager.operadriver().setup();
    }

    @BeforeMethod
    public void setup(){
        driver = new OperaDriver();
        driver.get(testURL);
    }

Projekt se pokreće sa naredbom 'Run FeritTests' u IDE-u koji se koristi.