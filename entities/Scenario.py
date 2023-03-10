import threading


class Scenario:

    def __init__(self):
        self.stations = {}

    def runSimulation(self):
        for stationName, station in self.stations.items():
            threading.Thread(target=station.runStrategy()).start()

    def addStation(self, name, station):
        self.stations[name] = station

    def getStations(self):
        return self.stations
