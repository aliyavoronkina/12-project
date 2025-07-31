public class Radio {
    private int currentStation;
    private int currentVolume;
    private final int maxStation;

    public Radio() {
        this.maxStation = 9;
    }

    public Radio(int stationCount) {
        if (stationCount <= 0) {
            throw new IllegalArgumentException("Количество станций должно быть положительным");
        }
        this.maxStation = stationCount - 1;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation < 0 || currentStation > maxStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void nextStation() {
        currentStation = currentStation == maxStation ? 0 : currentStation + 1;
    }

    public void prevStation() {
        currentStation = currentStation == 0 ? maxStation : currentStation - 1;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}