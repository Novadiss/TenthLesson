import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void getCurrentVolume() { //Тест что показывает текущую громкость
        Radio volume = new Radio();

        volume.setCurrentVolume(17);

        int expected = 17;
        int actual = volume.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetVolumeAboveMax() { //Тест что громкость не превысит максимум
        Radio volume = new Radio();

        volume.setCurrentVolume(120);

        int expected = 0;
        int actual = volume.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetVolumeBelowMin() { //Тест что громкость не станет ниже минимума
        Radio volume = new Radio();

        volume.setCurrentVolume(-10);

        int expected = 0;
        int actual = volume.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseVolume() { //Тест уменьшения громкости
        Radio volume = new Radio();

        volume.setCurrentVolume(1);

        int expected = 2;
        int actual = volume.increaseVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotDegradeBelowMinVolume() { //Тест что уменьшение громкости не опустится ниже минимума
        Radio volume = new Radio();

        volume.setCurrentVolume(0);

        int expected = 0;
        int actual = volume.degradeVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDegradeVolume() { //Тест увеличения громкости
        Radio volume = new Radio();

        volume.setCurrentVolume(90);

        int expected = 89;
        int actual = volume.degradeVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotIncreaseAboveMaxVolume() { //Тест что увеличение громкости не превысит максимум
        Radio volume = new Radio();

        volume.setCurrentVolume(100);

        int expected = 100;
        int actual = volume.increaseVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAndSetCurrentStation() { //Тест что показывает текущую станцию и что её можно задать
        Radio station = new Radio();

        station.setCurrentStation(7);

        int expected = 7;
        int actual = station.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetStationAboveMax() { //Тест что станция выше максимума выбрать нельзя
        Radio station = new Radio();

        station.setCurrentStation(15);

        int expected = 0;
        int actual = station.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetStationBelowMin() { //Тест что станция ниже минимума выбрать нельзя
        Radio station = new Radio();

        station.setCurrentStation(-10);

        int expected = 0;
        int actual = station.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNextStation() { //Тест переключения на следующую станцию
        Radio station = new Radio();

        station.setCurrentStation(7);

        int expected = 8;
        int actual = station.nextStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNextStationAfterLost() { //Тест переключения на первую станцию после последней
        Radio station = new Radio();

        station.setCurrentStation(9);

        int expected = 0;
        int actual = station.nextStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPrevStation() { //Тест переключения на предыдущую станцию
        Radio station = new Radio();

        station.setCurrentStation(5);

        int expected = 4;
        int actual = station.prevStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPrevStationBeforeFirst() { //Тест переключения на предыдущую станцию перед первой
        Radio station = new Radio();

        station.setCurrentStation(0);

        int expected = 9;
        int actual = station.prevStation();

        Assertions.assertEquals(expected, actual);
    }
}
