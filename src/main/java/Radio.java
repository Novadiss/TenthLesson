public class Radio {

    private int currentVolume;
    private int currentStation;

    public int getCurrentVolume() { //выяснение текущей громкости
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) { //установка громкости и ограничение диапазона возможной громкости
        if (newCurrentVolume < 0) {
            return;
        }
        if (newCurrentVolume > 100) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public int getCurrentStation() { //выяснение текущей радио-станции
        return currentStation;
    }

    public void setCurrentStation(int newCurrentStation) { //установка станции и ограничение диапазона радио-станций
        if (newCurrentStation < 0) {
            return;
        }
        if (newCurrentStation > 9) {
            return;
        }
        currentStation = newCurrentStation;
    }

    public int increaseVolume() { //увеличение громкости
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        } else {
            currentVolume = 100;
        }
        return currentVolume;
    }

    public int degradeVolume() { //уменьшение громкости
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        } else {
            currentVolume = 0;
        }
        return currentVolume;
    }

    public int nextStation() { //переключение на одну радио-станцию вперед
        if (currentStation == 9) {
            currentStation = 0;
        } else {
            currentStation = currentStation + 1;
        }
        return currentStation;
    }

    public int prevStation() { //переключение на одну радио-станцию назад
        if (currentStation == 0) {
            currentStation = 9;
        } else {
            currentStation = currentStation - 1;
        }
        return currentStation;
    }
}