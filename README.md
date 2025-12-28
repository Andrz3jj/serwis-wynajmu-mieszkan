# System Wynajmu Mieszkań

## Opis projektu
Projekt **System Wynajmu Mieszkań** to konsolowa aplikacja napisana w języku Java, która pozwala na zarządzanie ofertami wynajmu mieszkań. System umożliwia dodawanie właścicieli i klientów, przeglądanie dostępnych mieszkań, dokonywanie rezerwacji oraz przeglądanie historii rezerwacji.  

Celem projektu było stworzenie prostego systemu symulującego proces wynajmu mieszkań, uwzględniającego różne role użytkowników i podstawową logikę rezerwacji.

## Funkcjonalności
System posiada dwa typy użytkowników:

1. **Właściciel (OWNER)**:
   - Przeglądanie własnych ofert wynajmu
   - Dodawanie nowych ofert wynajmu
   - Przeglądanie historii rezerwacji swoich mieszkań
   - Dodawanie nowych właścicieli
   - Usuwanie mieszkań (jeśli nie mają aktywnych rezerwacji)

2. **Klient (CLIENT)**:
   - Przeglądanie dostępnych mieszkań
   - Dokonywanie rezerwacji mieszkań
   - Przeglądanie historii własnych rezerwacji
   - Dodawanie nowych klientów
   - Wyszukiwanie mieszkań według ceny

System obsługuje również różne metody płatności: **gotówka, BLIK, karta**.

## Sposób działania
1. Po uruchomieniu aplikacji użytkownik wybiera swoją rolę (Właściciel, Klient lub zamknięcie programu).
2. W zależności od wybranej roli, system wyświetla odpowiednie menu opcji.
3. Właściciel może zarządzać swoimi mieszkaniami i przeglądać rezerwacje, natomiast klient może przeglądać dostępne mieszkania i dokonywać rezerwacji.
4. System sprawdza poprawność danych wejściowych oraz terminy rezerwacji, aby uniknąć konfliktów.

## Struktura projektu
Projekt jest podzielony na pakiety:
- `src.pl.app` – klasa główna `Main`, obsługująca interakcję z użytkownikiem
- `src.pl.model` – klasy modelowe (`Apartament`, `User`, `Owner`, `Client`, `Reservation`, `RentalService`)
- `src.pl.model.enums` – enumeracje (`UserRole`, `TypeOfApartament`, `StatusApartament`, `ApartamentStatus`, `PaymentType`)

### Kluczowe klasy
- **Main** – punkt wejścia aplikacji, menu konsolowe.
- **RentalService** – logika biznesowa, zarządzanie mieszkań, rezerwacjami, właścicielami i klientami.
- **Apartament** – reprezentuje mieszkanie z adresem, typem, ceną i statusem.
- **User / Owner / Client** – reprezentacja użytkowników systemu.
- **Reservation** – reprezentacja rezerwacji mieszkania, powiązana z klientem, określonym terminem i płatnością.

## Przykładowe użycie
Po uruchomieniu aplikacji użytkownik wybiera rolę właściciela lub klienta.
Właściciel może dodawać i przeglądać mieszkania oraz sprawdzać historię rezerwacji. 
Klient przegląda dostępne oferty, wyszukuje mieszkania według ceny i dokonuje rezerwacji, podając termin oraz metodę płatności. 
System weryfikuje poprawność danych i aktualizuje status mieszkania.

## Logowanie
System nie posiada mechanizmu logowania, ale użytkownicy są wybierani z listy klientów lub właścicieli podczas interakcji w konsoli.

## Instrukcja uruchomienia
1. Sklonuj repozytorium,
2. Otwórz projekt w IDE (np. IntelliJ, Eclipse),
3. Uruchom klasę `Main`,
4. Postępuj zgodnie z instrukcjami w konsoli
