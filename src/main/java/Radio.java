import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Radio {

    private int minVolume = 0;
    private int maxVolume = 100;
    private int currentVolume = minVolume;

    private int firstStation = 0;
    private int lastStation = 9;
    private int currentStation = firstStation;

    public Radio(int size) {
        this.lastStation = firstStation - 1 + size;
    }

    public void setCurrentVolume(int newCurrentVolume) { //установка громкости и ограничение диапазона возможной громкости
        if (newCurrentVolume < minVolume) {
            return;
        }
        if (newCurrentVolume > maxVolume) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public void setCurrentStation(int newCurrentStation) { //установка станции и ограничение диапазона радио-станций
        if (newCurrentStation < firstStation) {
            return;
        }
        if (newCurrentStation > lastStation) {
            return;
        }
        currentStation = newCurrentStation;
    }

    public int increaseVolume() { //увеличение громкости
        if (currentVolume < maxVolume) {
            currentVolume = currentVolume + 1;
        } else {
            currentVolume = maxVolume;
        }
        return currentVolume;
    }

    public int degradeVolume() { //уменьшение громкости
        if (currentVolume > minVolume) {
            currentVolume = currentVolume - 1;
        } else {
            currentVolume = minVolume;
        }
        return currentVolume;
    }

    public int nextStation() { //переключение на одну радио-станцию вперед
        if (currentStation == lastStation) {
            currentStation = firstStation;
        } else {
            currentStation = currentStation + 1;
        }
        return currentStation;
    }

    public int prevStation() { //переключение на одну радио-станцию назад
        if (currentStation == firstStation) {
            currentStation = lastStation;
        } else {
            currentStation = currentStation - 1;
        }
        return currentStation;
    }
}