package ru.netology.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Setter(AccessLevel.PRIVATE)

public class Radio {
    int station;
    short stationsQuantity = 10;
    byte volume = 20;

    /* Конструкторы
     * --------------------------------------------------- */

    public Radio(short stationsQuantity) {
        specifyStationsQuantity(stationsQuantity);
    }

    public Radio(int station) {
        specifyStation(station);
    }

    public Radio(byte volume) {
        if (volume > 100) {
            return;
        }
        if (volume < 0) {
            return;
        }
        volume(volume);
    }

    /* Установка параметров
     * --------------------------------------------------- */

    public void specifyStationsQuantity(short stationsQuantity) {
        if (stationsQuantity > 120) {
            return;
        }
        if (stationsQuantity < 1) {
            return;
        }
        stationsQuantity(stationsQuantity);
    }

    public void specifyStation(int station) {
        if (station > stationsQuantity) {
            return;
        }
        if (station < 0) {
            return;
        }
        station(station);
    }

    /* Оперирование станциями
     * --------------------------------------------------- */

    public void switchStationUp() {
        if (station == stationsQuantity) {
            station(0);
            return;
        }
        station(++station);
    }

    public void switchStationDown() {
        if (station == 0) {
            station(stationsQuantity);
            return;
        }
        station(--station);
    }

    /* Регулировка громкости
     * --------------------------------------------------- */

    public void increaseVolume() {
        if (volume == 100) {
            return;
        }
        volume(++volume);
    }

    public void decreaseVolume() {
        if (volume == 0) {
            return;
        }
        volume(--volume);
    }
}