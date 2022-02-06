package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    public void shouldSetStationBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(4);
        radio.setCurrentStation(-1);
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldSetStationAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.setCurrentStation(10);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseStation() {
        Radio radio = new Radio(50);
        radio.setCurrentStation(48);
        radio.increaseStation();
        assertEquals(49, radio.getCurrentStation());

    }

    @Test
    public void shouldIncreaseStationAboveMax() {
        Radio radio = new Radio(50);
        radio.setCurrentStation(49);
        radio.increaseStation();
        assertEquals(0, radio.getCurrentStation());

    }

    @Test
    public void shouldReduceStationBelowMin() {
        Radio radio = new Radio(50);
        radio.setCurrentStation(0);
        radio.reduceStation();
        assertEquals(49, radio.getCurrentStation());

    }

    @Test
    public void shouldReduceStation() {
        Radio radio = new Radio(50);
        radio.setCurrentStation(1);
        radio.reduceStation();
        assertEquals(0, radio.getCurrentStation());

    }

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(5);
        radio.increaseVolume();
        assertEquals(6, radio.getCurrentVolume());
    }

    @Test
    public void shouldReduceVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.reduceVolume();
        assertEquals(99, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolumeWhenMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldReduceVolumeWhenMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.reduceVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetVolumeAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldChangeMaxStation() {
        Radio radio = new Radio(50);
        radio.setCurrentStation(49);
        radio.setAmountStation(48);
        radio.increaseStation();
        assertEquals(0, radio.getCurrentStation());

    }

    @Test
    public void shouldSetMaxStationZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.reduceStation();
        radio.setAmountStation(0);
        radio.reduceStation();
        assertEquals(8, radio.getCurrentStation());

    }

}
