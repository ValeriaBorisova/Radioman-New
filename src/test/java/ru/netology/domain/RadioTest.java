package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();

    @Test
    void shouldSelectorStationUpToRound() {
        radio.selectorStationUp(); // 0~1
        radio.selectorStationUp(); // 1~2
        radio.selectorStationUp(); // 2~3
        radio.selectorStationUp(); // 3~4
        radio.selectorStationUp(); // 4~5
        radio.selectorStationUp(); // 5~6
        radio.selectorStationUp(); // 6~7
        radio.selectorStationUp(); // 7~8
        radio.selectorStationUp(); // 8~9
        radio.selectorStationUp(); // 9~0
        assertEquals(0, radio.getStation());

    }

    @Test
    void shouldSwitchStationDownToRound() {
        radio.selectorStationDown(); // 0~9
        radio.selectorStationDown(); // 9~8
        assertEquals(8, radio.getStation());
    }

    @Test
    void shouldSpecifyStationPositive() {
        radio.setStation(5);
        assertEquals(5, radio.getStation());
    }

    @Test
    void shouldSpecifyStationNegative() {
        radio.setStation(20);
        assertEquals(0, radio.getStation());
    }

    @Test
    void shouldSpecifyStationNegative2() {
        radio.setStation(-20);
        assertEquals(0, radio.getStation());
    }

    @Test
    void shouldIncreaseVolume() {
        radio.increaseVolume(); // 3~4
        radio.increaseVolume(); // 4~5
        radio.increaseVolume(); // 5~6
        radio.increaseVolume(); // 6~7
        radio.increaseVolume(); // 7~8
        radio.increaseVolume(); // 8~9
        radio.increaseVolume(); // 9~10
        radio.increaseVolume(); // 10~10
        assertEquals(10, radio.getVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        radio.decreaseVolume(); // 3~2
        radio.decreaseVolume(); // 2~1
        radio.decreaseVolume(); // 1~0
        radio.decreaseVolume(); // 0~0
        assertEquals(1, radio.getVolume());
    }
}