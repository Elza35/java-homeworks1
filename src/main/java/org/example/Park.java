package org.example;

public class Park {
    private String parkName;
    private String location;
    private Attraction[] attractions;

    // Конструктор парка
    public Park(String parkName, String location) {
        this.parkName = parkName;
        this.location = location;
        this.attractions = new Attraction[0]; // начальный пустой массив
    }

    // ВНУТРЕННИЙ КЛАСС для аттракционов
    public class Attraction {
        private String attractionName;
        private String workTime;
        private double price;

        // Конструктор аттракциона
        public Attraction(String attractionName, String workTime, double price) {
            this.attractionName = attractionName;
            this.workTime = workTime;
            this.price = price;
        }

        // Геттеры
        public String getAttractionName() {
            return attractionName;
        }

        public String getWorkTime() {
            return workTime;
        }

        public double getPrice() {
            return price;
        }

        // Метод для вывода информации об аттракционе
        public void printAttractionInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + workTime);
            System.out.println("Стоимость: " + price + " руб.");
            System.out.println("Парк: " + parkName); // доступ к полю внешнего класса
            System.out.println("------------------------");
        }
    }

    // Метод для добавления аттракциона в парк
    public void addAttraction(String attractionName, String workTime, double price) {
        Attraction newAttraction = new Attraction(attractionName, workTime, price);

        // Увеличиваем массив аттракционов
        Attraction[] newAttractions = new Attraction[attractions.length + 1];
        for (int i = 0; i < attractions.length; i++) {
            newAttractions[i] = attractions[i];
        }
        newAttractions[attractions.length] = newAttraction;
        attractions = newAttractions;
    }

    // Метод для вывода информации о парке и всех аттракционах
    public void printParkInfo() {
        System.out.println("=== ИНФОРМАЦИЯ О ПАРКЕ ===");
        System.out.println("Название парка: " + parkName);
        System.out.println("Местоположение: " + location);
        System.out.println("Количество аттракционов: " + attractions.length);
        System.out.println("\n=== АТТРАКЦИОНЫ ===");

        if (attractions.length == 0) {
            System.out.println("В парке пока нет аттракционов");
        } else {
            for (Attraction attraction : attractions) {
                attraction.printAttractionInfo();
            }
        }
        System.out.println("=======================");
    }

    // Геттеры для парка
    public String getParkName() {
        return parkName;
    }

    public String getLocation() {
        return location;
    }

    public Attraction[] getAttractions() {
        return attractions;
    }
}