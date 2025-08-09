import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    // ============ Тесты конструкторов ============
    @Test
    void shouldCreateDefaultRadioWith10Stations() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldCreateCustomRadio() {
        Radio radio = new Radio(15);
        radio.setCurrentStation(14);
        assertEquals(14, radio.getCurrentStation());
    }

    @Test
    void shouldThrowExceptionForZeroStations() {
        assertThrows(IllegalArgumentException.class, () -> new Radio(0));
    }

    @Test
    void shouldThrowExceptionForNegativeStations() {
        assertThrows(IllegalArgumentException.class, () -> new Radio(-5));
    }

    // ============ Тесты станций (default) ============
    @Test
    void shouldSetValidStationDefault() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetNegativeStationDefault() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation()); // Проверка сохранения предыдущего значения
    }

    @Test
    void shouldNotSetTooBigStationDefault() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchNextFromMiddleDefault() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.nextStation();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void shouldWrapNextFromLastDefault() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchPrevFromMiddleDefault() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.prevStation();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void shouldWrapPrevFromFirstDefault() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    // ============ Тесты станций (custom) ============
    @Test
    void shouldSwitchNextFromMiddleCustom() {
        Radio radio = new Radio(15);
        radio.setCurrentStation(5);
        radio.nextStation();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void shouldWrapNextFromLastCustom() {
        Radio radio = new Radio(15);
        radio.setCurrentStation(14);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldWrapPrevFromFirstCustom() {
        Radio radio = new Radio(15);
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(14, radio.getCurrentStation());
    }

    // ============ Тесты громкости ============
    @Test
    void shouldIncreaseVolumeFromZero() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseAboveMaxVolume() {
        Radio radio = new Radio();
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume(); // Сначала увеличиваем до 1
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseBelowMinVolume() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}