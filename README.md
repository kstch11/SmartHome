# Smart Home 

By **Selina Kadyrova**

## Diagramy

Detail [use-case]() and [class diagram]()

## Funkční požadavky

- F1. Entity se kterými pracujeme je dům, patro v domu, mistnosti, ruzná zařízení (devicy a sport), osoba, auto, kolo, domácí zvíře jiného než hospodářského typu, plus další entity. **Splněno**
- F2. Jednotlivá zařízení v domu mají API na ovládání. Zařízení mají stav, který lze měnit pomocí API na jeho ovládání. Akce z API jsou použitelné podle stavu zařízení. **Splněno**
- F3. Spotřebiče mají svojí spotřebu v aktivním stavu, idle stavu, vypnutém stavu. **Splněno**
- F4. Jednotlivá zařízení mají API na sběr dat o tomto zařízení. O zařízeních sbíráme data spotřeby elektřiny. **Splněno**
- F5. Jednotlivé osoby a zvířata mohou provádět aktivity(akce), které mají nějaký efekt na zařízení nebo jinou osobu. **Splněno**
- F6. Jednotlivá zařízení a osoby se v každém okamžiku vyskytují v jedné místnosti a náhodně generují eventy. **Splněno**
- F7. Eventy jsou přebírány a odbavovány vhodnou osobou (osobami). **Splněno**
- F8. Vygenerování reportů. **Splněno**
- F9. Při rozbití zařízení musí obyvatel domu prozkoumat dokumentaci k zařízení - najít záruční list, projít manuál na opravu a provést nápravnou akcí. **Splněno**
- F10. Rodina je aktivní a volný čas tráví zhruba v poměru (50% používání spotřebičů v domě a 50% sport. **Splněno**  

## Nefunkční požadavky

- NF1. Není požadována autentizace ani autorizace. **Splněno**
- NF2. Aplikace může běžet pouze v jedné JVM. **Splněno**
- NF3. Dobře schované metody a proměnné, které nemají být dostupné ostatním třídám. Vygenerovný javadoc by měl mít co nejméně public metod a proměnných. **Splněno**
- NF4. Reporty jsou generovány do textového souboru. **Splněno**
- NF5. Konfigurace domu, zařízení a obyvatel domu nahrávána z externího json souboru. **Splněno**

## Použité design patterny

- State machine 
  - package ```house.devices.states```
- Factory
  - package ```factories```
- Command
  - package ```house.commands```
- Builder
  - třída ```House.Builder```
- Observer
  - třídy ```TickSubscriber```, ```HouseHold```
- Composite
  - třídy ```House```, ```Floor```, ```Room```, ```HousePart```, ```HousePartBase```, ```HouseSpase```
- Singleton
  - třídy ```HouseContext```, ```DeviceFactory```, ```HouseholdFactory```, ```EventReport```
- Visitor
  - třídy ```Reportable```, ```HouseConfigurationReport```, ```UsageReport```

## Načítání dat a konfigurace domu

Načítání dat ze souboru ve třídach House1, House2. Javadoc a reporty se zapisují do složky resources.

## Druhy zařízení

- class Car
- class Computer
- class Cooker
- class Fridge
- class PetFeeder
- class PetToy
- class SmartBath
- class TV
- class VacuumCleaner
- class WashingMachine

## Druhy sportovního vybavení

- class Bicycle
- class Ski
- class Treadmill


