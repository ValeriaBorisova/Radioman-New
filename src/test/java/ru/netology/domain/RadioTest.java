package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    Radio radio = new Radio();

    /* Установка количества радиостанций
     * --------------------------------------------------- */

    @Test
    void shouldSpecifyStationQuantityPositive() {
        Radio radio = new Radio((short) 120);
        radio.specifyStationsQuantity((short) 5);
        assertEquals(5, radio.stationsQuantity());
    }

    @Test
    void shouldSpecifyStationQuantityNegative() {
        Radio radio = new Radio((short) 120);
        radio.specifyStationsQuantity((short) 121);
        assertEquals(120, radio.stationsQuantity());
    }

    @Test
    void shouldSpecifyStationQuantityNegative2() {
        Radio radio = new Radio((short) 120);
        radio.specifyStationsQuantity((short) 0);
        assertEquals(120, radio.stationsQuantity());
    }

    /* Установка номера радиостанции при количестве радиостанций по умолчанию
     * --------------------------------------------------- */

    @Test
    void shouldSpecifyStationWithDefaultQuantityPositive() {
        radio.specifyStation((short) 5);
        assertEquals(5, radio.station());
    }

    @Test
    void shouldSpecifyStationWithDefaultQuantityNegative() {
        radio.specifyStation(11);
        assertEquals(0, radio.station());
    }

    @Test
    void shouldSpecifyStationWithDefaultQuantityNegative2() {
        radio.specifyStation(-1);
        assertEquals(0, radio.station());
    }

    /* Установка номера радиостанции при собственном количестве радиостанций
     * --------------------------------------------------- */

    @Test
    void shouldSpecifyStationWithCustomQuantityPositive() {
        Radio radio = new Radio((short) 120);
        radio.specifyStationsQuantity((short) 60);
        radio.specifyStation(30);
        assertEquals(30, radio.station());
    }

    @Test
    void shouldSpecifyStationWithCustomQuantityNegative() {
        Radio radio = new Radio((short) 120);
        radio.specifyStationsQuantity((short) 60);
        radio.specifyStation(61);
        assertEquals(0, radio.station());
    }

    @Test
    void shouldSpecifyStationWithCustomQuantityNegative2() {
        Radio radio = new Radio((short) 120);
        radio.specifyStationsQuantity((short) 60);
        radio.specifyStation(-1);
        assertEquals(0, radio.station());
    }

    /* Переключение радиостанций
     * --------------------------------------------------- */

    @Test
    void shouldSwitchStationUpToRoundDefault() {
        Radio radio = new Radio(9);
        radio.switchStationUp(); // 9~10
        radio.switchStationUp(); // 10~0
        assertEquals(0, radio.station());
    }

    @Test
    void shouldSwitchStationDownToRoundDefault() {
        Radio radio = new Radio(1);
        radio.switchStationDown(); // 1~0
        radio.switchStationDown(); // 0~10
        assertEquals(10, radio.station());
    }

    /* Регулировка громкости
     * --------------------------------------------------- */

    @Test
    void shouldIncreaseVolumeToThreshold() {
        Radio radio = new Radio((byte) 99);
        radio.increaseVolume(); // 99~100
        radio.increaseVolume(); // 100~100
        assertEquals(100, radio.volume());
    }

    @Test
    void shouldDecreaseVolumeToThreshold() {
        Radio radio = new Radio((byte) 1);
        radio.decreaseVolume(); // 1~0
        radio.decreaseVolume(); // 0~0
        assertEquals(0, radio.volume());
    }

    /* Тесты для полного покрытия
     * --------------------------------------------------- */

    @Test
    void shouldSetVolumeNegative() {
        Radio radio = new Radio((byte) 101);
        assertEquals(20, radio.volume());
    }

    @Test
    void shouldSetVolumeNegative2() {
        Radio radio = new Radio((byte) -1);
        assertEquals(20, radio.volume());
    }
}